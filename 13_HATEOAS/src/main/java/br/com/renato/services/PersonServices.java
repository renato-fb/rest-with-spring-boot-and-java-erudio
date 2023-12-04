package br.com.renato.services;

import java.util.List;
import java.util.logging.Logger;

import br.com.renato.controller.PersonController;
import br.com.renato.exception.RequiredObjectIsNullException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renato.mapper.DozerConverter;
import br.com.renato.model.Person;
import br.com.renato.data.vo.v1.PersonVO;
import br.com.renato.exception.ResourceNotFoundException;
import br.com.renato.repository.PersonRepository;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class PersonServices {

	private final Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<PersonVO> findAll() {

		logger.info("Finding all people!");

		List<PersonVO> personVO = DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);

		personVO
				.forEach(p -> p.add(
								linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()
						)
				);

		return personVO;
	}

	public PersonVO findById(Long id) {

		logger.info("Finding one person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		PersonVO personVO = DozerConverter.parseObject(entity, PersonVO.class);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVO;

	}

	public PersonVO create(PersonVO person) {

		if (person == null) throw new RequiredObjectIsNullException();
		logger.info("Creating one person!");
		var entity = DozerConverter.parseObject(person, Person.class);
        PersonVO personVO =  DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
	}

	public PersonVO update(PersonVO person) {

		if (person == null) throw new RequiredObjectIsNullException();

		logger.info("Updating one person!");

		var entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

        PersonVO personVO =  DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;


	}	
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
}
