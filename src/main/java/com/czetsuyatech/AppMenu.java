package com.czetsuyatech;

import java.io.IOException;

public class AppMenu {

  private InputReader inputReader = new InputReader();
  private CashRegister cashRegister = new CashRegister();

  public void run() throws IOException {
    while (true) {
      String[] input = inputReader.read();

      String cmd = input[0];
      int[] params = inputReader.getIntParams(input);

      switch (cmd) {
        case "put":
          cashRegister.put(params);
          break;
        case "take":
          cashRegister.take(params);
          break;
        case "change":
          cashRegister.change(params[0]);
          break;
        case "quit":
          System.out.println("Bye");
          break;
        case "show":
        default:
          cashRegister.show();
      }
    }
  }
}
