package com.mutant.test;

import com.mutant.test.output.dto.DnaDto;
import com.mutant.test.output.dto.GroupedDnaCode;

import java.util.List;

public interface DnaOutputBoundary {
    DnaDto getDna(String dnaCode);
    void saveDna(DnaDto dna);
    List<GroupedDnaCode> getGroupedDNACode();
}
