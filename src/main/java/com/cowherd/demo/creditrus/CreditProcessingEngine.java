package com.cowherd.demo.creditrus;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class CreditProcessingEngine {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private KieSession setup() {

        // Services for drools
        KieServices kieServices = KieServices.get();

        // Setting put up the resources
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        // reading from file, but could easily be read from DB or other data store
        kieFileSystem.write(ResourceFactory.newClassPathResource("rules/credit.drl"));

        // Build Knowledge
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll(); // compile everything to use
        KieContainer kieContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());

        // Setup session
        KieSession kieSession = kieContainer.newKieSession();
        logger.info("Setup of engine complete.");
        return kieSession;
    }

    public void rateApplicants(CreditApplicant creditApplicant) {

        logger.info("Rating applicant: [{}]",creditApplicant);

        // inject fact(s) into knowledge session
        KieSession session = setup();
        session.insert(creditApplicant); // add each to the session

        // Here's where the magic occurs
        session.fireAllRules();

        // extract results
        Optional<CreditResult> criteriaResultOptional =
            session.getObjects(CreditResult.class::isInstance)
                .stream()
                .map(CreditResult.class::cast)
                .findAny();

        // adjust score with aggregated criteria scores
        if(criteriaResultOptional.isPresent()) {
            logger.info("The credit result is "+criteriaResultOptional.get().name());
        } else {
            logger.warn("No credit result found!");
        }
    }
}