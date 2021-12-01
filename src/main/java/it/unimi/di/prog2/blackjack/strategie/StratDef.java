package it.unimi.di.prog2.blackjack.strategie;

import it.unimi.di.prog2.blackjack.Strategia;

public class StratDef implements Strategia {
    @Override
    public boolean chiediCarta() {
        return false;
    }
}
