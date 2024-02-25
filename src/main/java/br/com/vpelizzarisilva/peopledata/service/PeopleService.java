package br.com.vpelizzarisilva.peopledata.service;

import br.com.vpelizzarisilva.peopledata.entitie.PeopleEntity;
import br.com.vpelizzarisilva.peopledata.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    @Transactional
    public void createPeople (PeopleEntity peopleEntity){
        peopleRepository.save(peopleEntity);
    }

    @Transactional
    public void deletePeople (PeopleEntity peopleEntity){
        peopleRepository.delete(peopleEntity);
    }

    @Transactional
    public void deletePeopleByCpfId(String cpfId) {
        peopleRepository.deleteById(cpfId);
    }

    @Transactional
    public PeopleEntity alterPeople(String cpfPeople, PeopleEntity peopleEntity) {
        PeopleEntity people = peopleRepository.findById(cpfPeople).orElse(null);
        if (people == null) {
            return null;
        }
        people.setStatusPeople(peopleEntity.isStatusPeople());
        people.setFirstNamePeople(peopleEntity.getFirstNamePeople());
        people.setLastNamePeople(peopleEntity.getLastNamePeople());
        people.setEmailPeople(peopleEntity.getEmailPeople());
        people.setObservationPeople(peopleEntity.getObservationPeople());
        people.setAddressEntityPeople(peopleEntity.getAddressEntityPeople());

        return peopleRepository.save(people);
    }

    public List<PeopleEntity> findAll() {
        return peopleRepository.findAll();
    }

    public Optional<PeopleEntity> findPeopleByCpfId(String cpfPeople) {
        return peopleRepository.findById(cpfPeople);
    }

    public List<PeopleEntity> findPeopleByFirstName(String firstNamePeople){
        return peopleRepository.findPeopleByFirstName(firstNamePeople);
    }

    public List<PeopleEntity> findPeopleByLastName(String lastNamePeople){
        return peopleRepository.findPeopleByLastName(lastNamePeople);
    }

    @Transactional(readOnly = true)
    public List<PeopleEntity> findAllActivePeople() {
        return peopleRepository.findByStatusPeople(true);
    }
}
