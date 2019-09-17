package com.ntask.task2.remover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ListRemover<T extends Integer> {

  public List<T> remove(List<T> list, int occurrence, boolean occurInRow) {
    if (Objects.isNull(list)) {
      throw new IllegalArgumentException("passed list is null");
    }

    if (occurrence < 1) {
      throw new IllegalArgumentException("passed occurrence must be bigger than 0");
    }

    List<T> result = new ArrayList<>(list);

    list.forEach(
        element -> {
          if (result.contains(element)) {
            if (occurInRow) {
              for (int i = 0, j = occurrence - 1; j < result.size(); i++, j++) {
                boolean foundRow = true;
                for (int k = i; k < j; k++) {
                  if (!Objects.equals(result.get(k), element)
                      || !Objects.equals(result.get(k), result.get(i))) {
                    foundRow = false;
                  }
                }

                if (foundRow) {
                  while (result.remove(element)) {}
                  
                  break;
                }
              }
            } else {
              int elementOccurTimes = Collections.frequency(list, element);

              if (elementOccurTimes >= occurrence) {
                while (result.remove(element)) {}
              }
            }
          }
        });

    return result;
  }
}
