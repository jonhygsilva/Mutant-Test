package com.mutant.test;


import com.mutant.test.dto.StatsDTO;

public interface MutantInputBoundary {

    Boolean isMutant(
            String[] dna
    );

    StatsDTO getStats();
}
