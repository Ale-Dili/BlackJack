package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mazziere implements GiocatoreBJ {
  private List<Card> mano = new ArrayList<>();
  private DeckInterface mazzo = new MultiMazzo(6);

  public Card draw() {
    return mazzo.draw();
  }

  //TODO i vari metodi richiesti per aderire all'interfaccia

}
