package br.com.vpelizzarisilva.peopledata.repository;

import br.com.vpelizzarisilva.peopledata.entitie.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
