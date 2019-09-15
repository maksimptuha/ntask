package com.ntask.task1.tree;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HeightCalculator {

  public int calculate(Node root) {
    if (Objects.isNull(root)) {
      throw new IllegalArgumentException("passed tree root is null");
    }

    int height = 0;

    List<Node> nonVisitedNodes = Collections.singletonList(root);

    while (!nonVisitedNodes.isEmpty()) {
      nonVisitedNodes =
          nonVisitedNodes.stream()
              .flatMap(node -> node.getChildren().stream())
              .collect(Collectors.toList());

      height++;
    }

    return height;
  }
}
