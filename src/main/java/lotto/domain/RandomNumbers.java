package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomNumbers implements Numbers {

    public List<Integer> numbers() {
        List<Integer> shuffledLottoNumbers = new ArrayList<>(NUMBERS);
        Collections.shuffle(shuffledLottoNumbers);
        return shuffledLottoNumbers.subList(0, 6).stream().sorted().collect(Collectors.toList());
    }
}
