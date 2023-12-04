package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }

    public boolean contains(LottoNumber lottoNo) {
        return lotto.contains(lottoNo);
    }
}
