package com.mutant.test.interfaces;

import com.mutant.test.domain.Dna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DnaCrudRepository extends JpaRepository<Dna, Long> {
    Dna findByDnaCode(String dna);
    @Query("SELECT d.mutant as mutant, count(d.mutant) as count from Dna as d group by d.mutant order by d.mutant")
    List<Object[]> getGroupedDNACode();
}
