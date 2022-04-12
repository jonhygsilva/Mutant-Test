package com.mutant.test.output.dto;


public class GroupedDnaCode {
    long mutant;
    long count;

    public GroupedDnaCode() {
    }

    public GroupedDnaCode(Number mutant, Number count) {
        this.mutant = mutant.longValue();
        this.count = count.longValue();
    }

    public long getMutant() {
        return mutant;
    }

    public void setMutant(long mutant) {
        this.mutant = mutant;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}