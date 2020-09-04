package com.bgasparotto.datastructures.challenge;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class DuplicationRemover<T> {
    public void deduplicate(List<T> input) {
        Map<Integer, T> map = new HashMap<>();
        ListIterator<T> iterator = input.listIterator();

        while (iterator.hasNext()) {
            T element = iterator.next();

            if (map.containsKey(element.hashCode())) {
                iterator.remove();
                continue;
            }
            map.put(element.hashCode(), element);
        }
    }
}
