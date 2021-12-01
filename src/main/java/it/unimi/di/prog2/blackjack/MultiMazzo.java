package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import ca.mcgill.cs.stg.solitaire.cards.Deck;

import java.awt.*;
import java.util.*;
import java.util.List;


public class MultiMazzo implements DeckInterface {
  private List<Card> mazzo = new ArrayList<>();

  public MultiMazzo(int numMazzi) {
    //TODO definire un costruttore che crei un mazzo composto da numMazzi mescolato casualmente
    for (int i = 0; i < numMazzi; i++) {
      Deck deck = new Deck();
      while (!deck.isEmpty()) {
        mazzo.add(deck.draw());
      }

    }
    Collections.shuffle(mazzo);


  }


  @Override
  public Card draw() {
    assert mazzo.size() > 0;
    Random rand = new Random();
    return mazzo.remove(rand.nextInt(mazzo.size()));
  }

  @Override
  public boolean isEmpty() {
    return mazzo.size() == 0;
  }
}
