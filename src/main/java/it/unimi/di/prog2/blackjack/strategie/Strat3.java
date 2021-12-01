package it.unimi.di.prog2.blackjack.strategie;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import it.unimi.di.prog2.blackjack.Sfidante;
import it.unimi.di.prog2.blackjack.Strategia;

import java.util.Iterator;

public class Strat3 implements Strategia {
    private final Strategia next;
    private final Sfidante player;

    public Strat3(Strategia next, Sfidante player) {
        this.next = next;
        this.player = player;
    }

    @Override
    public boolean chiediCarta() {
        int nCards=0;
        for (Iterator<Card> cards = player.getCards(); cards.hasNext(); ) {
            Card card = cards.next();
            nCards++;
        }

        if (nCards<3)
            return true;
        return next.chiediCarta();
    }

}
