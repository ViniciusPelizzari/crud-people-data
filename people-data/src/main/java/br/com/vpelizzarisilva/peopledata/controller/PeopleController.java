package br.com.vpelizzarisilva.peopledata.controller;

import br.com.vpelizzarisilva.peopledata.entitie.PeopleEntity;
import br.com.vpelizzarisilva.peopledata.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @PostMapping
    public String createPeople(@RequestBody PeopleEntity peopleEntity){
        peopleService.createPeople(peopleEntity);
        return "Successfully created person";
    }

    @DeleteMapping
    public String deletePeople(@RequestBody PeopleEntity cpfPeople){
        peopleService.deletePeople(cpfPeople);
        return "Successfully deleted person";
    }

    @DeleteMapping("/{cpf}")
    public String deletePeopleByCpfId(@RequestBody PeopleEntity cpfPeople){
        peopleService.deletePeople(cpfPeople);
        return "Successfully deleted person";
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<String> alterPeople(@PathVariable String idCpf, @RequestBody PeopleEntity peopleEntity){
        PeopleEntity newPeople = peopleService.alterPeople(idCpf, peopleEntity);
        if(newPeople != null){
            return new ResponseEntity<>("Atualização bem-sucedida", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Erro na atualização", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<PeopleEntity> people = peopleService.findAll();
        if (people == null || people.isEmpty()) {
            return new ResponseEntity<>("Sem retorno. Nenhum item encontrado!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(people, HttpStatus.OK);
        }
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<?> findPeopleByCpfId(@PathVariable String cpfPeople){
        Optional<PeopleEntity> people = peopleService.findPeopleByCpfId(cpfPeople);
        if (people.isEmpty()) {
            return new ResponseEntity<>("Sem retorno. Nenhum item encontrado!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(people, HttpStatus.OK);
        }
    }

    @GetMapping("name/{firstNamePeople}")
    public ResponseEntity<?> findPeopleByFirstName(@PathVariable String firstNamePeople){
        List<PeopleEntity> people = peopleService.findPeopleByFirstName(firstNamePeople);

        if (people == null || people.isEmpty()) {
            return new ResponseEntity<>("Sem retorno. Nenhum item encontrado!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(people, HttpStatus.OK);
        }
    }

    @GetMapping("name/{lastNamePeople}")
    public ResponseEntity<?> findPeopleByLastName(@PathVariable String lastNamePeople){
        List<PeopleEntity> people = peopleService.findPeopleByLastName(lastNamePeople);

        if (people == null || people.isEmpty()) {
            return new ResponseEntity<>("Sem retorno. Nenhum item encontrado!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(people, HttpStatus.OK);
        }
    }
}
