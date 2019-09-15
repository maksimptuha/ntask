package com.ntask.task1.tree;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class HeightCalculatorTest {

  private HeightCalculator heightCalculator = new HeightCalculator();

  @Test(expected = IllegalArgumentException.class)
  public void heightCalculate_NullRootPassed_ZeroHeight() {
    heightCalculator.calculate(null);
  }

  @Test
  public void heightCalculate_RootPassed_Successful() {
    Node eNode = new Node("e");
    Node bNode = new Node("b");
    bNode.addChild(eNode);
    Node cNode = new Node("c");
    Node dNode = new Node("d");
    Node tree = new Node("a");
    tree.addChild(bNode);
    tree.addChild(cNode);
    tree.addChild(dNode);

    int height = heightCalculator.calculate(tree);

    assertThat("failed to calculate a tree height", height, is(3));
  }
}
