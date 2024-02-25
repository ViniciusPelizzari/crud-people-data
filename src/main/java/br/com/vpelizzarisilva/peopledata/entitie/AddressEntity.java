package br.com.vpelizzarisilva.peopledata.entitie;

import br.com.vpelizzarisilva.peopledata.util.CEPValidator;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "tbAddress")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAddress;

    @NotBlank
    @Column(length = 8)
    private String postalCodeAddress;

    @NotBlank
    @Column(length = 100)
    private String publicPlaceAddress;

    @Column(length = 100)
    private String complementAddress;

    @Column(length = 30)
    private String neighborhoodAddress;

    @NotBlank
    @Column(length = 100)
    private String cityAddress;

    @NotBlank
    @Column(length = 30)
    private String stateAddress;

    @NotNull
    @Column(length = 10)
    private int numberAddress;

    public void setPostalCodeAddress(String postalCodeAddress) {
        postalCodeAddress = postalCodeAddress.replaceAll("[^0-9]", "");
        if (CEPValidator.validarCEP(postalCodeAddress)) {
            this.postalCodeAddress = postalCodeAddress;
        } else {
            throw new IllegalArgumentException("CEP inválido");
        }
    }
}
