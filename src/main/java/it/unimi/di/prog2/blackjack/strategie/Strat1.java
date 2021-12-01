package it.unimi.di.prog2.blackjack.strategie;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import it.unimi.di.prog2.blackjack.Sfidante;
import it.unimi.di.prog2.blackjack.Strategia;

import java.util.Iterator;

public class Strat1 implements Strategia {

    private final Strategia next;
    private final Sfidante player;

    public Strat1(Strategia next, Sfidante player) {
        this.next = next;
        this.player = player;
    }

    public boolean chiediCarta() {
        int val=player.getPunti();

        if (val <15)
            return true;
        return next.chiediCarta();
    }
}

