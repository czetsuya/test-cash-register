package com.czetsuyatech;

import java.io.IOException;
import java.util.stream.IntStream;

/**
 * App runner class.
 */
public class App {

  public static void main(String[] args) {

    System.out.println("Cash Register\r\n");
    try {
      new App();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public App() throws IOException {

    System.out.println("Ready...\r\n");

    AppMenu appMenu = new AppMenu();
    appMenu.run();
  }

  private void internalTest() {

    CashRegister cashRegister = new CashRegister();
    cashRegister.show();

    cashRegister.put(IntStream.of(1, 2, 3, 4, 5).toArray());
    cashRegister.show();

    cashRegister.put(IntStream.of(1, 2, 3, 0, 5).toArray());
    cashRegister.show();

    cashRegister.take(IntStream.of(1, 4, 3, 0, 10).toArray());
    cashRegister.show();

    cashRegister.change(27);
    cashRegister.show();

    cashRegister.change(14);
    cashRegister.show();
  }
}
