package org.javamoney.moneybook.chapter.six;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryFunctions;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by otaviojava on 31/05/15.
 */
public class ReduceSumMonetaryAmountError {

    public static void main(String[] args) {
        CurrencyUnit dollar = Monetary.getCurrency("USD");
        CurrencyUnit real = Monetary.getCurrency("BRL");

        MonetaryAmount money = Money.of(10, dollar);
        MonetaryAmount money2 = Money.of(10, dollar);
        MonetaryAmount money3 = Money.of(10, real);
        MonetaryAmount money4 = Money.of(9, dollar);
        MonetaryAmount money5 = Money.of(8, dollar);

        Optional<MonetaryAmount> result = Stream.of(money, money2, money3, money4, money5).reduce(
                MonetaryFunctions.sum());//javax.money.MonetaryException: Currency mismatch: BRL/USD
        
    }
}
