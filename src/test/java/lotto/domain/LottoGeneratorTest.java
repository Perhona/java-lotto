package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @Test
    void 생성() {
        LottoGenerator lottoGenerator = new LottoGenerator(14, new RandomNumbers());
        assertThat(lottoGenerator.generate()).hasSize(14);
    }
}