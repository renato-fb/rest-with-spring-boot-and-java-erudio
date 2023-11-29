package br.com.renato.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.renato.mapper.DozerConverter;
import br.com.renato.model.Person;
import br.com.renato.data.vo.v1.PersonVO;
import br.com.renato.exception.ResourceNotFoundException;
import br.com.renato.repository.PersonRepository;

@Service
public class PersonServices {

	private final Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<PersonVO> findAll() {

		logger.info("Finding all people!");

		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {

		logger.info("Finding one person!");

		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}

	public PersonVO create(PersonVO person) {

		logger.info("Creating one person!");

		var entity = DozerConverter.parseObject(person, Person.class);
        return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
	}

	public PersonVO update(PersonVO person) {

		logger.info("Updating one person!");

		var entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

        return DozerConverter.parseObject(repository.save(entity), PersonVO.class);
	}	
	
	public void delete(Long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
}
