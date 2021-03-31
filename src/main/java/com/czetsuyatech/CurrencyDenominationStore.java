package com.czetsuyatech;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores currency notes are arranged in this order #$20 #$10 #$5 #$2 #$1
 *
 * @author Edward P. Legaspi
 * @version 0.11
 * @since 0.11
 */
public class CurrencyDenominationStore {

  private static List<CurrencyDenominationKV> register = new ArrayList<>();

  static {
    register.add(new CurrencyDenominationKV(20, 0));
    register.add(new CurrencyDenominationKV(10, 0));
    register.add(new CurrencyDenominationKV(5, 0));
    register.add(new CurrencyDenominationKV(2, 0));
    register.add(new CurrencyDenominationKV(1, 0));
  }

  public List<CurrencyDenominationKV> getRegister() {
    return register;
  }

  private static int accept(CurrencyDenominationKV e) {
    return e.getCurrency() * e.getDenomination();
  }

  public int getTotal() {
    return register.stream().mapToInt(CurrencyDenominationStore::accept).sum();
  }

  public void put(int index, int denomination) {

    int prevDenomination = getDenomination(index);
    get(index).setDenomination(prevDenomination + denomination);
  }

  public void take(int index, int denomination) {

    int prevDenomination = getDenomination(index);
    int tempDenomination = prevDenomination - denomination;
    if (tempDenomination < 0) {
        throw new RuntimeException("Insufficient funds or no change can be made");
    }
    get(index).setDenomination(tempDenomination);
  }

  public CurrencyDenominationKV get(int index) {
    return register.get(index);
  }

  public int getDenomination(int index) {
    return get(index).getDenomination();
  }
}
