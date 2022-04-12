package com.mutant.test.domain;

import javax.persistence.*;

@Entity
@Table(name = "dna")
public class Dna {

    @Id
    @Column(name = "dna_code")
    String dnaCode;

    @Column(name = "mutant")
    int mutant;

    public Dna() {
    }

    public Dna(String dnaCode, int mutant) {
        this.dnaCode = dnaCode;
        this.mutant = mutant;
    }

    public String getDnaCode() {
        return dnaCode;
    }

    public void setDnaCode(String dnaCode) {
        this.dnaCode = dnaCode;
    }

    public int getMutant() {
        return mutant;
    }

    public void setMutant(int mutant) {
        this.mutant = mutant;
    }
}
