import com.mutant.test.DnaEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DnaEntity.class)
public class DnaEntityTest {

    @Autowired
    private DnaEntity dnaEntity;

    @Test
    public void dnaCodaMutantRightDiagonal() {
        String [] dna = {
                "CTGAGA",
                "CTAAGC",
                "TATTGT",
                "AGAGCG",
                "CGCCTA",
                "TCACTG"};
        dnaEntity.setDna(dna);

        assertThat(dnaEntity.isMutant()).isTrue();
    }

    @Test
    public void dnaCodaMutantLeftDiagonal() {
        String [] dna = {
                "CTGAGA",
                "CTGAGC",
                "TATTGT",
                "ATAGCG",
                "CGTCTA",
                "TCATTG"};
        dnaEntity.setDna(dna);

        assertThat(dnaEntity.isMutant()).isTrue();
    }

    @Test
    public void dnaCodaMutantColumn() {
        String [] dna = {
                "CTGAGA",
                "CTGAGC",
                "TATTGT",
                "ATAGGG",
                "CGTCTA",
                "TCACTG"};
        dnaEntity.setDna(dna);

        assertThat(dnaEntity.isMutant()).isTrue();
    }

    @Test
    public void dnaCodaMutantLine() {
        String [] dna = {
                "CTGAGA",
                "CTATTC",
                "TATTCT",
                "ATAGGG",
                "CGTCTA",
                "TCACTG"};
        dnaEntity.setDna(dna);

        assertThat(dnaEntity.isMutant()).isTrue();
    }
}
