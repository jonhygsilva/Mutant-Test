package com.mutant.test;

import lombok.Data;

import java.util.List;

@Data
public class StatsEntity {
    private Long count_mutant_dna;
    private Long count_human_dna;
    private float ratio;

    public Long getCount_mutant_dna() {
        return count_mutant_dna;
    }

    public void setCount_mutant_dna(Long count_mutant_dna) {
        this.count_mutant_dna = count_mutant_dna;
    }

    public Long getCount_human_dna() {
        return count_human_dna;
    }

    public void setCount_human_dna(Long count_human_dna) {
        this.count_human_dna = count_human_dna;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public void createStatsByGroupedData(List<GroupedDnaEntity> groupedDna) {
        if (groupedDna.size() > 0) {
            GroupedDnaEntity groupedMutant = groupedDna.stream().filter(it -> it.getMutant() == 1).findAny().orElse(null);
            GroupedDnaEntity groupedHuman = groupedDna.stream().filter(it -> it.getMutant() == 0).findAny().orElse(null);

            setCount_human_dna(groupedHuman != null ? groupedHuman.getCount() : 0);
            setCount_mutant_dna(groupedMutant != null ? groupedMutant.getCount() : 0);

            float ratio = 0;

            if (getCount_mutant_dna() > 0 && getCount_human_dna() > 0) {
                ratio = getCount_mutant_dna().floatValue() / getCount_human_dna().floatValue();
            }

            setRatio(ratio);
        } else {
            setRatio(0);
            setCount_human_dna(0L);
            setCount_mutant_dna(0L);
        }
    }
}
