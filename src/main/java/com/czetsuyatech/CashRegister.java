package com.czetsuyatech;

import java.util.List;

/**
 * @author Edward P. Legaspi
 * @version 0.11
 * @since 0.11
 */
public class CashRegister {

  private CurrencyDenominationStore store = new CurrencyDenominationStore();

  public void show() {

    int total = store.getTotal();
    System.out.println(String.format("$%d %d %d %d %d %d", total, store.getRegister().get(0).getDenomination(),
        store.getRegister().get(1).getDenomination()
        , store.getRegister().get(2).getDenomination(),
        store.getRegister().get(3).getDenomination(), store.getRegister().get(4).getDenomination()));
  }

  public void put(int[] state) {

    for (int i = 0; i < state.length; i++) {
      store.put(i, state[i]);
    }
  }

  public void take(int[] state) {

    for (int i = 0; i < state.length; i++) {
      store.take(i, state[i]);
    }
  }

  public void change(int amount) {

    List<CurrencyDenominationKV> currencyNotes = store.getRegister();
    int[] currencyNoteCtr = new int[currencyNotes.size()];

    for (int i = 0; i < currencyNotes.size(); i++) {
      int noteCurrency = currencyNotes.get(i).getCurrency();
      if (amount >= noteCurrency) {
        currencyNoteCtr[i] = amount / noteCurrency;
        int tempAmount = amount - currencyNoteCtr[i] * noteCurrency;
        if (tempAmount < 0) {
          throw new RuntimeException("Insufficient funds or no change can be made");
        }
        amount = tempAmount;
      }
    }

    take(currencyNoteCtr);
  }
}
