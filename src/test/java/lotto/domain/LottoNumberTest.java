package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {
	@Test
	@DisplayName("생성_유효하지 않은 로또 번호_throw IllegalArgumentException")
	void throwException() {
		assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class).hasMessage("유효하지 않은 번호입니다.");
		assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class).hasMessage("유효하지 않은 번호입니다.");
	}
}