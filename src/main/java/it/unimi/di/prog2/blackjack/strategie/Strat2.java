package it.unimi.di.prog2.blackjack.strategie;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import it.unimi.di.prog2.blackjack.Mazziere;
import it.unimi.di.prog2.blackjack.Sfidante;
import it.unimi.di.prog2.blackjack.Strategia;

import java.util.Iterator;

public class Strat2 implements Strategia {

    Strategia next;
    Sfidante player;
    Mazziere mazziere;

    public Strat2(Strategia next, Sfidante player, Mazziere mazziere) {
        this.next = next;
        this.player = player;
        this.mazziere = mazziere;
    }

    @Override
    public boolean chiediCarta() {
        int valPlayer=0;
        for (Iterator<Card> cards = player.getCards(); cards.hasNext(); ) {
            Card card = cards.next();
            valPlayer += card.getRank().ordinal();
        }

        int valMazziere=0;
        for (Iterator<Card> cards = mazziere.getCards(); cards.hasNext(); ) {
            Card card = cards.next();
            valMazziere += card.getRank().ordinal();
        }

        if (valMazziere>valPlayer)
            return true;
        return next.chiediCarta();

    }
}
