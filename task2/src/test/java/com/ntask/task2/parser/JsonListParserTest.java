package com.ntask.task2.parser;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import org.junit.Test;

public class JsonListParserTest {

  private ListParser jsonListParser = new JsonListParser();

  @Test(expected = IllegalArgumentException.class)
  public void listParse_NullPathPassed_ExceptionThrown() {
    jsonListParser.parse(null);
  }

  @Test
  public void listParse_PathPassed_Successful() {
    List<Integer> list = jsonListParser.parse("src/test/resources/task2.json");

    assertThat("failed to parse a list", list.size(), is(3));
    assertThat("failed to parse a list", list, contains(1, 2, 3));
  }
}
