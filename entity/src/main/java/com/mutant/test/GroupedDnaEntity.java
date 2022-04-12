package com.mutant.test;

public class GroupedDnaEntity {
    int mutant;
    Long count;

    public GroupedDnaEntity() {
    }

    public GroupedDnaEntity(int mutant, Long count) {
        this.mutant = mutant;
        this.count = count;
    }

    public int getMutant() {
        return mutant;
    }

    public void setMutant(int mutant) {
        this.mutant = mutant;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
