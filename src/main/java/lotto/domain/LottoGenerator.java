package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGenerator {
	private final int amount;
	private final Numbers lottoNumbers;

	public LottoGenerator(int amount, Numbers lottoNumbers) {
		this.amount = amount;
		this.lottoNumbers = lottoNumbers;
	}

	public List<Lotto> generate() {
		return Stream
				.generate(() -> new Lotto(lottoNumbers.numbers()))
				.limit(amount)
				.collect(Collectors.toList());
	}
}
