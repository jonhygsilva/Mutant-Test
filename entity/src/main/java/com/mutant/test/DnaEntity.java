package com.mutant.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DnaEntity {

    private String[] dna;

    public DnaEntity(String[] dna) {
        this.dna = dna;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public boolean isMutant() {
        List<String[]> dnaMatrix = Arrays.stream(this.dna).map(it -> it.split("")).collect(Collectors.toList());

        if (searchColumns(dnaMatrix)) {
            return true;
        }

        if (searchLines(dnaMatrix)) {
            return true;
        }

        if (searchDownDiagonal(dnaMatrix)) {
            return true;
        }

        return searchUpDiagonal(dnaMatrix);
    }

    private boolean searchLines(List<String[]> dna) {
        int i = 0;
        boolean isMutant = false;
        while (i < dna.size() && !isMutant) {
            int j = 0;
            String lastCharLine = "";
            int countSequenceCharLine = 0;

            while (j < dna.size()) {
                String currentCharLine = dna.get(i)[j];

                if (currentCharLine.equals(lastCharLine)) {
                    countSequenceCharLine++;
                } else {
                    countSequenceCharLine = 1;
                }

                if (countSequenceCharLine == 4) {
                    isMutant = true;
                }

                lastCharLine = currentCharLine;
                j++;
            }

            i++;
        }

        return isMutant;
    }

    private boolean searchColumns(List<String[]> dna) {
        int i = 0;
        boolean isMutant = false;

        while (i < dna.size() && !isMutant) {
            int j = 0;
            String lastCharColumn = "";
            int countSequenceCharColumn = 0;

            while (j < dna.size()) {
                String currentCharColumn = dna.get(j)[i];

                if (currentCharColumn.equals(lastCharColumn)) {
                    countSequenceCharColumn++;
                } else {
                    countSequenceCharColumn = 1;
                }

                if (countSequenceCharColumn == 4) {
                    isMutant = true;
                }

                lastCharColumn = currentCharColumn;
                j++;
            }

            i++;
        }

        return isMutant;
    }

    private boolean searchUpDiagonal(List<String[]> dna) {
        boolean isMutant = false;

        int i = 0;
        while (i < dna.size() && !isMutant) {
            int x = 0;
            int j = i;
            String lastCharFirstDiagonal = "";
            String lastCharSecondDiagonal = "";
            int countSequenceCharFirstDiagonal = 0;
            int countSequenceCharSecondDiagonal = 0;

            while (j < dna.size() && !isMutant) {
                String currentCharFirstDiagonal = dna.get(x)[j];
                String currentCharSecondDiagonal = dna.get(j)[x];

                if (currentCharFirstDiagonal.equals(lastCharFirstDiagonal)) {
                    countSequenceCharFirstDiagonal++;
                } else {
                    countSequenceCharFirstDiagonal = 1;
                }

                if (currentCharSecondDiagonal.equals(lastCharSecondDiagonal)) {
                    countSequenceCharSecondDiagonal++;
                } else {
                    countSequenceCharSecondDiagonal = 1;
                }

                if (countSequenceCharFirstDiagonal == 4 || countSequenceCharSecondDiagonal == 4) {
                    isMutant = true;
                }

                lastCharFirstDiagonal = currentCharFirstDiagonal;
                lastCharSecondDiagonal = currentCharSecondDiagonal;
                j++;
                x++;
            }
            i++;
        }

        return isMutant;
    }

    private boolean searchDownDiagonal(List<String[]> dna) {

        boolean isMutant = false;
        int i = dna.size() - 1;
        int a = 1;
        while (i >= 0 && !isMutant) {
            int x = 0;

            String lastCharFirstDiagonal = "";
            int countSequenceCharFirstDiagonal = 0;

            int j = i;
            while (j >= 0 && !isMutant) {
                String currentCharFirstDiagonal = dna.get(x)[j];

                if (currentCharFirstDiagonal.equals(lastCharFirstDiagonal)) {
                    countSequenceCharFirstDiagonal++;
                } else {
                    countSequenceCharFirstDiagonal = 1;
                }

                if (countSequenceCharFirstDiagonal == 4) {
                    isMutant = true;
                }

                lastCharFirstDiagonal = currentCharFirstDiagonal;
                j--;
                x++;
            }

            if (!isMutant) {
                String lastCharSecondDiagonal = "";
                int countSequenceCharSecondDiagonal = 0;

                j = a;
                x = dna.size() - 1;
                while (j < dna.size()) {
                    String currentCharSecondDiagonal = dna.get(j)[x];

                    if (currentCharSecondDiagonal.equals(lastCharSecondDiagonal)) {
                        countSequenceCharSecondDiagonal++;
                    } else {
                        countSequenceCharSecondDiagonal = 1;
                    }

                    if (countSequenceCharSecondDiagonal == 4) {
                        isMutant = true;
                    }

                    lastCharSecondDiagonal = currentCharSecondDiagonal;
                    j++;
                    x--;
                }
            }

            a++;
            i--;
        }

        return isMutant;
    }
}
