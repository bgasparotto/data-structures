package com.bgasparotto.datastructures.challenge;

import com.bgasparotto.datastructures.model.SampleType;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DuplicationRemoverTest {
    private final DuplicationRemover<SampleType> remover = new DuplicationRemover<>();
    private final SampleType john = new SampleType(1, "John");
    private final SampleType rick = new SampleType(2, "Rick");
    private final SampleType jane = new SampleType(3, "Jane");
    private final SampleType robin = new SampleType(4, "Robin");

    @Test
    public void shouldRemoveDuplicatedElementsFromLinked1List() {
        List<SampleType> input = new LinkedList<>();
        input.add(john);
        input.add(john); // duplicated
        input.add(rick);
        input.add(jane);
        input.add(robin);
        input.add(robin); // duplicated
        input.add(robin); // duplicated

        remover.deduplicate(input);

        assertThat(input).hasSize(4);
        assertThat(input).containsExactly(john, rick, jane, robin);
    }
}
