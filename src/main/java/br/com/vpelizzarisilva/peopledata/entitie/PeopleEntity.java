package br.com.vpelizzarisilva.peopledata.entitie;

import br.com.vpelizzarisilva.peopledata.util.CPFValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tbPeople")
public class PeopleEntity {

    @Id
    @NotBlank
    @Column(length = 11, unique = true)
    private String cpfPeople;

    @NotNull
    private boolean  statusPeople;

    @NotBlank
    @Column(length = 30)
    private String firstNamePeople;

    @Column(length = 100)
    private String lastNamePeople;

    @NotBlank
    @Column(length = 50)
    @Email(message = "Endereço de e-mail inválido")
    private String emailPeople;

    @Column(length = 150)
    private String observationPeople;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAddressPeople", referencedColumnName = "idAddress")
    private AddressEntity addressEntityPeople;

    public void setCpfPeople(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        if (CPFValidator.validarCPF(cpf)) {
            this.cpfPeople = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido");
        }
    }
}
