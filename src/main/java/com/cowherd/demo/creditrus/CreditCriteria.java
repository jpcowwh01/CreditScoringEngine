package com.cowherd.demo.creditrus;

public enum CreditCriteria {

    AgeOver20("AgeOver20", 20),
    AgeOver30("AgeOver30", 30),
    AgeOver40("AgeOver40", 40),
    AgeOver50("AgeOver50", 50),
    AgeOver60("AgeOver60", 40),
    AgeOver70("AgeOver70", 30),
    CollegeDegree("CollegeDegree", 100),
    OwnesHome("OwnesHome", 75);

    private int score;
    private String criteriaName;

    private CreditCriteria(String criteriaName, int score) {
        this.criteriaName = criteriaName;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getCriteriaName() {
        return criteriaName;
    }
}