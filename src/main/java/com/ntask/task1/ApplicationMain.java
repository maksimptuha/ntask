package com.ntask.task1;

import com.ntask.task1.parser.JsonTreeParser;
import com.ntask.task1.parser.TreeParser;
import com.ntask.task1.tree.HeightCalculator;
import com.ntask.task1.tree.Node;

public class ApplicationMain {

  private static final String DEFAULT_INPUT_DATA_FILE_PATH = "task1.json";

  public static void main(String[] args) {
    try {
      String inputDataFilePath =
          args.length != 0 && args[0] != null ? args[0] : DEFAULT_INPUT_DATA_FILE_PATH;

      TreeParser treeParser = new JsonTreeParser();

      Node root = treeParser.parse(inputDataFilePath);

      HeightCalculator heightCalculator = new HeightCalculator();

      int height = heightCalculator.calculate(root);

      System.out.println(String.format("tree height is %d", height));
    } catch (Exception e) {
      e.printStackTrace();

      System.out.println(e.getMessage());
    }
  }
}
