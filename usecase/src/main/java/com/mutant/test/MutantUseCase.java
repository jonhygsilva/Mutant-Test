package com.mutant.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mutant.test.dto.StatsDTO;
import com.mutant.test.output.dto.DnaDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MutantUseCase implements MutantInputBoundary {

    private final DnaOutputBoundary dnaOutputBoundary;
    ObjectMapper objectMapper = new ObjectMapper();

    public MutantUseCase(DnaOutputBoundary dnaOutputBoundary) {
        this.dnaOutputBoundary = dnaOutputBoundary;
    }

    @Override
    public Boolean isMutant(String[] dna) {
        DnaDto dnaDto = dnaOutputBoundary.getDna(Arrays.toString(dna));

        if (dnaDto != null) {
            return dnaDto.getMutant() == 1;
        }

        DnaEntity dnaEntity = new DnaEntity(dna);
        dnaEntity.analyzeDna();

        dnaOutputBoundary.saveDna(new DnaDto(
                Arrays.toString(dna),
                dnaEntity.getMutant()
        ));

        return dnaEntity.getMutant() == 1;
    }

    @Override
    public StatsDTO getStats() {
        List<GroupedDnaEntity> groupedDna = dnaOutputBoundary.getGroupedDNACode()
                .stream().map(it -> objectMapper.convertValue(it, GroupedDnaEntity.class)).collect(Collectors.toList());

        StatsEntity statsEntity = new StatsEntity();
        statsEntity.createStatsByGroupedData(groupedDna);

        return new StatsDTO(
                statsEntity.getCount_mutant_dna(),
                statsEntity.getCount_human_dna(),
                statsEntity.getRatio()
        );
    }
}
