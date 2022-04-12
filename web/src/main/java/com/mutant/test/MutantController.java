package com.mutant.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mutant.test.dto.DnaDTO;
import com.mutant.test.dto.StatsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MutantController {

    private final MutantInputBoundary userInput;

    public MutantController(MutantInputBoundary userInput) {
        this.userInput = userInput;
    }

    @PostMapping("/mutant")
    public ResponseEntity<HttpStatus> isMutant(@RequestBody DnaDTO dna) {
         if (userInput.isMutant(dna.getDna())) return new ResponseEntity<>(HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/stats")
    public ResponseEntity<StatsDTO> getStats() {

        return new ResponseEntity<StatsDTO>(userInput.getStats(), HttpStatus.OK);
    }
}
