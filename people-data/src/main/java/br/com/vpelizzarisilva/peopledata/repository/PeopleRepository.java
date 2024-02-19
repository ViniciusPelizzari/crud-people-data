package br.com.vpelizzarisilva.peopledata.repository;

import br.com.vpelizzarisilva.peopledata.entitie.PeopleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PeopleRepository extends JpaRepository<PeopleEntity, String> {

    @Query("SELECT e FROM PeopleEntity e WHERE lower(e.firstNamePeople) LIKE lower(concat('%', :firstNamePeople, '%'))")
    List<PeopleEntity> findPeopleByFirstName(String firstNamePeople);

    @Query("SELECT e FROM PeopleEntity e WHERE lower(e.lastNamePeople) LIKE lower(concat('%', :lastNamePeople, '%'))")
    List<PeopleEntity> findPeopleByLastName(String lastNamePeople);
}
