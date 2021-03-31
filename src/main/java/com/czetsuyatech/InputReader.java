package com.czetsuyatech;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class InputReader {

  private String[] commands = {"show", "take", "put", "change"};

  public String[] read() throws IOException {

    System.out.println(">");
    Scanner in = new Scanner(System.in);
    String str = in.nextLine();

    String[] input = str.split(" ");

    validateInput(input);

    return input;
  }

  private void validateInput(String[] input) {

    String cmd = input[0];
    if (!List.of(commands).contains(cmd)) {
      throw new RuntimeException("Unknown command");
    }

    if ((cmd.equals("take") || cmd.equals("put")) && input.length != 6) {
      throw new RuntimeException("Invalid arguments");
    }

    if (cmd.equals("change") && input.length != 2) {
      throw new RuntimeException("Invalid arguments");
    }
  }

  public int[] getIntParams(String[] params) {

    int[] result = new int[params.length - 1];
    for (int i = 1; i < params.length; i++) {
      result[i - 1] = Integer.parseInt(params[i]);
    }

    return result;
  }
}
