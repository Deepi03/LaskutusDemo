package com.free.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SSNValidateServiceTest {
    private static String VALID_SSN = "131052-308T";
    private static String INVALID_SSN = "131059-309T";
    private static String INVALID_SSN1 = "1310594-309T";
    private static String VALID_COUNTRY = "FI";
    private static String INVALID_COUNTRY = "SE";

    SSNValidateService service = new SSNValidateService();

    @Test
    public void testValidateSSN() {
        assertEquals(false, service.validateSSN(VALID_SSN, INVALID_COUNTRY));
        assertEquals(true, service.validateSSN(VALID_SSN, VALID_COUNTRY));
        assertEquals(false, service.validateSSN(INVALID_SSN, INVALID_COUNTRY));
    }

    @Test
    public void testCheckInput() {
        assertEquals(false, service.checkInput(VALID_SSN, "SE"));
        assertEquals(true, service.checkInput(VALID_SSN, "FI"));
        assertEquals(false, service.checkInput(INVALID_SSN1, "FI"));
    }

    @Test

    public void testValidate() {
        assertEquals(false, service.validate(INVALID_SSN));
        assertEquals(true, service.validate(VALID_SSN));
    }

    // @Test
    public void testVlaidateDate() {
        assertEquals(true, service.validateDate("04-09-92"));

    }

    // @Test
    public void testValidateIndividualInput() {
        assertEquals(true, service.validateIndividualNumber("002"));
        assertEquals(false, service.validateIndividualNumber("900"));
    }

    // @Test
    public void testValidateControllCharacter() {
        assertEquals(true, service.validateControlCharacter("040992-342L"));
    }
}