package com.free.demo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.free.demo.dto.PersonalIdentity;
import com.free.demo.exception.InvalidSSNException;

@Service
public class SSNValidateService {

    private static String COUNTRY_CODE = "FI";

    public boolean validateSSN(PersonalIdentity personalIdentity) {
        if (checkInput(personalIdentity.getSsn(), personalIdentity.getCountryCode())) {
            return validate(personalIdentity.getSsn());
        }
        throw new InvalidSSNException();
    }

    /*
     * check basic input format ex: ssn -> 020304-123L
     */
    public boolean checkInput(String ssn, String countryCode) {
        List<String> allowedChars = Arrays.asList("+", "-", "A");
        if (ssn.length() == 11 && COUNTRY_CODE.equals(countryCode)) {
            String inputChar = ssn.substring(6, 7);
            return allowedChars.contains(inputChar);
        } else {
            return false;
        }
    }

    /*
     * validate ssn and return true if its a valid
     * date check, individual number check & control char check
     */
    public boolean validate(String ssn) {
        String dateString = ssn.substring(0, 6);

        String individualNumber = ssn.substring(7, 10);

        return validateDate(formatDate(
                dateString)) && validateIndividualNumber(
                        individualNumber)
                && validateControlCharacter(ssn);
    }

    private String formatDate(String dateString) {
        String formatDate = dateString.substring(0, 2) + "-" + dateString.substring(2, 4) + "-"
                + dateString.substring(4);
        return formatDate;
    }

    /*
     * validate date and return true if its a valid date
     */
    public boolean validateDate(String inputDate) {
        try {
            // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
            LocalDate.parse(
                    inputDate,
                    DateTimeFormatter.ofPattern("d-M-u")
                            .withResolverStyle(ResolverStyle.STRICT));
            return true;

        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /*
     * validate individual and return true if its a valid one
     */
    public boolean validateIndividualNumber(String individualNumber) {
        int parsedIndividualNumber = Integer.parseInt(individualNumber);

        return individualNumber.length() == 3 && parsedIndividualNumber >= 2 && parsedIndividualNumber <= 899;

    }

    /*
     * validate control character and return true if its true
     */
    public boolean validateControlCharacter(String ssn) {

        String trimmedSSN = ssn.substring(0, 10);
        String numberOnly = trimmedSSN.replaceAll("[^0-9]", "");
        double parseInput = Integer.parseInt(numberOnly) / 31.0;
        String calculateControllCharacter = Long.toString(Math.round((parseInput % 1) * 31));

        String inputControlCharacter = ssn.substring(10);

        ControlCharacter controlCharacter = new ControlCharacter();
        return inputControlCharacter.equals(controlCharacter.getControllCharacter(calculateControllCharacter));

    }
}
