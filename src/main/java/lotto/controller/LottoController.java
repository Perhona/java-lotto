package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

	public void run() {
		int amount = inputView.purchase();
		List<Lotto> manualLottos = inputView.manualLottos();
        List<Lotto> autoLottos = new LottoGenerator(amount - manualLottos.size(), new RandomNumbers()).generate();
		Lottos lottos = new Lottos(manualLottos, autoLottos);

		resultView.generatedLottoGuide(manualLottos.size(), amount - manualLottos.size());
		resultView.showLottos(lottos);

        WinningLotto winningLotto = inputView.winningLotto();
        resultView.winningStats(new LottosResult(lottos, winningLotto));
    }
}
