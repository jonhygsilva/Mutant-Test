package com.mutant.test;

import org.springframework.stereotype.Service;

@Service
public class MutantUseCase implements MutantInputBoundary {

    @Override
    public Boolean isMutant(String[] dna) {
        DnaEntity dnaEntity = new DnaEntity(dna);
        return dnaEntity.isMutant();
    }
}
