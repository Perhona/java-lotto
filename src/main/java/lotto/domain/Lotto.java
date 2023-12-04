package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
	public static final Integer PRICE = 1000;
	private final List<LottoNumber> lottoNumbers;

	public Lotto(List<Integer> lottoNumbers) {
		validate(lottoNumbers);
		this.lottoNumbers = lottoNumbers.stream()
				.map(LottoNumber::new)
				.collect(Collectors.toList());
	}

	private void validate(List<Integer> lottoNumbers) {
		if (lottoNumbers.size() != 6) {
			throw new IllegalArgumentException("로또는 6개의 숫자로 이루어져야 합니다.");
		}
	}

	public Ranking ranking(WinningLotto winningLotto) {
		int matchingCount = (int) lottoNumbers.stream().filter(winningLotto::contains).count();
		boolean hasBonusNumber = contains(winningLotto.bonusNumber());

		return Ranking.of(matchingCount, hasBonusNumber);
	}

	public boolean contains(LottoNumber lottoNumber) {
		return lottoNumbers.contains(lottoNumber);
	}

	@Override
	public String toString() {
		return lottoNumbers + "";
	}
}
