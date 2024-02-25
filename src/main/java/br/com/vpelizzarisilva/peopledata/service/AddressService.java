package br.com.vpelizzarisilva.peopledata.service;

import br.com.vpelizzarisilva.peopledata.entitie.AddressEntity;
import br.com.vpelizzarisilva.peopledata.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void saveAddress(AddressEntity addressEntity) {
        addressRepository.save(addressEntity);
    }
}
