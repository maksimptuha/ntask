package com.ntask.task2.remover;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class ListRemoverTest {

  private ListRemover<Integer> listRemover = new ListRemover<>();

  @Test(expected = IllegalArgumentException.class)
  public void listRemove_NullListPassed_ExceptionThrown() {
    listRemover.remove(null, 1, true);
  }

  @Test(expected = IllegalArgumentException.class)
  public void listRemove_ZeroOccurrencePassed_ExceptionThrown() {
    listRemover.remove(Collections.emptyList(), 0, true);
  }

  @Test
  public void listRemove_RemoveInRow_Successful() {
    List<Integer> list = Arrays.asList(1, 1, 1, 2, 1, 3, 4, 5, 6, 3, 7, 8, 3);

    List<Integer> removedList = listRemover.remove(list, 3, true);

    List<Integer> expectedRemovedList = Arrays.asList(2, 3, 4, 5, 6, 3, 7, 8, 3);

    assertThat(
        "failed to remove element occurred in row", removedList, equalTo(expectedRemovedList));
  }

  @Test
  public void listRemove_RemoveNotInRow_Successful() {
    List<Integer> list = Arrays.asList(1, 1, 1, 2, 1, 3, 4, 5, 6, 3, 7, 8, 3);

    List<Integer> removedList = listRemover.remove(list, 3, false);

    List<Integer> expectedRemovedList = Arrays.asList(2, 4, 5, 6, 7, 8);

    assertThat(
        "failed to remove element occurred not in row", removedList, equalTo(expectedRemovedList));
  }
}
