package com.ntask.task1.parser;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import com.ntask.task1.tree.Node;
import org.junit.Test;

public class JsonTreeParserTest {

  private TreeParser jsonTreeParser = new JsonTreeParser();

  @Test(expected = IllegalArgumentException.class)
  public void treeParse_NullPathPassed_ExceptionThrown() {
    jsonTreeParser.parse(null);
  }

  @Test
  public void treeParse_PathPassed_Successful() {
    Node tree = jsonTreeParser.parse("src/test/resources/task1.json");

    Node eNode = new Node("e");
    Node bNode = new Node("b");
    bNode.addChild(eNode);
    Node cNode = new Node("c");
    Node dNode = new Node("d");
    Node expectedTree = new Node("a");
    expectedTree.addChild(bNode);
    expectedTree.addChild(cNode);
    expectedTree.addChild(dNode);

    assertThat("failed to parse a tree", tree, equalTo(expectedTree));
  }
}