package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    @Test
    @DisplayName("contains_보너스 번호를 포함한 LottoNumber_lotto contains 확인")
    void contains() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        assertThat(winningLotto.contains(new LottoNumber(1))).isTrue();
        assertThat(winningLotto.contains(new LottoNumber(7))).isFalse();
    }
}