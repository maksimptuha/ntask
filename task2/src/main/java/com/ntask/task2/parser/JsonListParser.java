package com.ntask.task2.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;

public class JsonListParser implements ListParser {

  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public List<Integer> parse(String path) {
    if (Objects.isNull(path)) {
      throw new IllegalArgumentException("passed json is null");
    }

    List<Integer> list;

    try {
      URL pathUrl = new URL(String.format("file:%s", path));

      list = objectMapper.readValue(pathUrl, new TypeReference<List<Integer>>(){});
    } catch (IOException e) {
      throw new IllegalArgumentException("failed to parse the json", e);
    }

    return list;
  }
}
