package com.ntask.task1.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Node {

  private String name;
  private List<Node> children = Collections.unmodifiableList(Collections.emptyList());

  public Node() {

  }

  public Node(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addChild(Node child) {
    List<Node> children = new ArrayList<>(this.children);
    children.add(child);

    this.children = Collections.unmodifiableList(children);
  }

  public List<Node> getChildren() {
    return children;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Node)) {
      return false;
    }
    Node node = (Node) o;
    return Objects.equals(getName(), node.getName()) &&
        Objects.equals(getChildren(), node.getChildren());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getChildren());
  }
}
