package br.com.vpelizzarisilva.peopledata.util;

public class CEPValidator {

    public static boolean validarCEP(String cep) {
        cep = cep.replaceAll("[^0-9]", "");

        if (cep.length() != 8) {
            return false;
        }

        return true;
    }
}
