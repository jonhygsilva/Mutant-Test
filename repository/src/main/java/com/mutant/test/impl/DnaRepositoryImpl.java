package com.mutant.test.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mutant.test.DnaOutputBoundary;
import com.mutant.test.domain.Dna;
import com.mutant.test.interfaces.DnaCrudRepository;
import com.mutant.test.output.dto.DnaDto;
import com.mutant.test.output.dto.GroupedDnaCode;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DnaRepositoryImpl implements DnaOutputBoundary {

    @PersistenceContext
    EntityManager entityManager;

    final DnaCrudRepository dnaCrudRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    public DnaRepositoryImpl(DnaCrudRepository dnaCrudRepository) {
        this.dnaCrudRepository = dnaCrudRepository;
    }

    @Override
    public DnaDto getDna(String dnaCode) {
        return objectMapper.convertValue(dnaCrudRepository.findByDnaCode(dnaCode), DnaDto.class);
    }

    @Override
    public void saveDna(DnaDto dna) {
        dnaCrudRepository.save(objectMapper.convertValue(dna, Dna.class));
    }

    @Override
    public List<GroupedDnaCode> getGroupedDNACode() {
        List<Object[]> result = dnaCrudRepository.getGroupedDNACode();
//        List<Object[]> result = entityManager.createQuery(query).getResultList();
        return result.stream().map(it ->
                new GroupedDnaCode(
                        (Number) it[0],
                        (Number) it[1]
                )
        ).collect(Collectors.toList());

    }
}
