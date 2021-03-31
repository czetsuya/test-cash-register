package com.czetsuyatech;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Edward P. Legaspi
 * @version 0.11
 * @since 0.11
 */
@Data
@AllArgsConstructor
public class CurrencyDenominationKV {

  private int currency;
  private int denomination;
}
