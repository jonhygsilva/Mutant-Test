package com.mutant.test.output.dto;

public class DnaDto {
    private String dnaCode;
    private int mutant;

    public DnaDto() {
    }

    public DnaDto(String dnaCode, int mutant) {
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
