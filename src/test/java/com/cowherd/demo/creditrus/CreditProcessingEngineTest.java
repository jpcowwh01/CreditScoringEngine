package com.cowherd.demo.creditrus;

import org.junit.jupiter.api.Test;

public class CreditProcessingEngineTest {

    @Test
    void setup() {
        // Setup
        CreditApplicant creditApplicant = new CreditApplicant();
        CreditProcessingEngine creditProcessingEngine = new CreditProcessingEngine();
        creditApplicant.setName("John Q. Public");
        creditApplicant.setAddress("4555 Lake Forest Dr.  Cinci, OH  45242");
        creditApplicant.setAge(46);
        creditApplicant.setCollegeDegree(false);
        creditApplicant.setDeclaredBankruptcy(false);
        creditApplicant.setEmployed(true);  // for now
        creditApplicant.setOwnHome(true);

        creditProcessingEngine.rateApplicants(creditApplicant);
    }

}