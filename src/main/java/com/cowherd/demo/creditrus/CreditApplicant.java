package com.cowherd.demo.creditrus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter @Setter @ToString
public class CreditApplicant implements Serializable {

    private String name;
    private String address;

    private Integer age;
    private Integer yearlyIncome;
    private Integer valueAssets;
    private Integer valueDebt;

    private Boolean ownHome;
    private Boolean declaredBankruptcy;
    private Boolean recentlyDelinquent;
    private Boolean employed;
    private Boolean collegeDegree;

    private List<CreditCriteria> creditCriteria;
}