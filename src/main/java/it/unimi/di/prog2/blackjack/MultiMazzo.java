package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.List;


public class MultiMazzo implements DeckInterface {
  private List<Card> mazzo = new ArrayList<>();

  public MultiMazzo(int numMazzi) {
    //TODO definire un costruttore che crei un mazzo composto da numMazzi mescolato casualmente
  }

  @Override
  public Card draw() {
    assert mazzo.size() > 0;
    return mazzo.remove(0);
  }

  @Override
  public boolean isEmpty() {
    return mazzo.size() == 0;
  }
}
