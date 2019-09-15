package com.ntask.task2;

import com.ntask.task2.parser.JsonListParser;
import com.ntask.task2.parser.ListParser;
import com.ntask.task2.remover.ListRemover;
import java.util.List;

public class ApplicationMain {

  private static final String DEFAULT_INPUT_DATA_FILE_PATH = "task2.json";

  private static final int ELEMENTS_OCCURRENCE = 3;

  public static void main(String[] args) {
    try {
      String inputDataFilePath =
          args.length != 0 && args[0] != null ? args[0] : DEFAULT_INPUT_DATA_FILE_PATH;

      ListParser jsonListParser = new JsonListParser();

      List<Integer> list = jsonListParser.parse(inputDataFilePath);

      ListRemover<Integer> listRemover = new ListRemover<>();

      List<Integer> removedInRowList = listRemover.remove(list, ELEMENTS_OCCURRENCE, true);
      List<Integer> removedNotInRowList = listRemover.remove(list, ELEMENTS_OCCURRENCE, false);

      System.out.println(
          String.format(
              "list with removed in row by %d elements: %s",
              ELEMENTS_OCCURRENCE, removedInRowList));

      System.out.println(
          String.format(
              "list with removed non in row by %d elements: %s",
              ELEMENTS_OCCURRENCE, removedNotInRowList));
    } catch (Exception e) {
      e.printStackTrace();

      System.out.println(e.getMessage());
    }
  }
}
