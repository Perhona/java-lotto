package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottosResultTest {
    private Lottos lottos;

    @BeforeEach
    public void init() {
        lottos = makeLottos();
    }

    private Lottos makeLottos() {
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 10, 11));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 10));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto5 = new Lotto(List.of(11, 12, 13, 14, 15, 16));
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        lottos.add(lotto4);
        lottos.add(lotto5);

        return new Lottos(lottos);
    }

    @Test
    @DisplayName("profitRate_5개 중 1개, 5등 1개 당첨_1.0")
    void profitRate() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(11, 12, 13, 40, 41, 42)), 45);
        LottosResult lottosResult = new LottosResult(lottos, winningLotto);
        assertThat(lottosResult.profitRate()).isEqualTo(1.0);
    }

    @Test
    @DisplayName("isLoss_5개 중 1개, 5등 1개 당첨_false")
    void isLoss() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(40, 41, 42, 10, 11, 12)), 45);
        LottosResult lottosResult = new LottosResult(lottos, winningLotto);
        assertThat(lottosResult.isLoss()).isFalse();
    }

    @Test
    @DisplayName("countByRanking_Raking value_ranking 값이 일치하는 lotto 갯수")
    void countWinner() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 10);
        LottosResult lottosResult = new LottosResult(lottos, winningLotto);

        assertThat(lottosResult.countByRanking(Ranking.FIRST)).isEqualTo(1);
        assertThat(lottosResult.countByRanking(Ranking.SECOND)).isEqualTo(1);
        assertThat(lottosResult.countByRanking(Ranking.THIRD)).isEqualTo(0);
        assertThat(lottosResult.countByRanking(Ranking.FOURTH)).isEqualTo(1);
        assertThat(lottosResult.countByRanking(Ranking.FIFTH)).isEqualTo(1);
        assertThat(lottosResult.countByRanking(Ranking.NOT_RANKED)).isEqualTo(1);
    }
}