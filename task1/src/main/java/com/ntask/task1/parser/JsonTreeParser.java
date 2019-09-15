package com.ntask.task1.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntask.task1.tree.Node;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class JsonTreeParser implements TreeParser {

  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public Node parse(String path) {
    if (Objects.isNull(path)) {
      throw new IllegalArgumentException("passed json is null");
    }

    Node root;

    try {
      URL pathUrl = new URL(String.format("file:%s", path));

      root = objectMapper.readValue(pathUrl, Node.class);
    } catch (IOException e) {
      throw new IllegalArgumentException("failed to parse the json", e);
    }

    return root;
  }
}
