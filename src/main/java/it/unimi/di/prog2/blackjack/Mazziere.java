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

  @Override
  public void carteIniziali() {
    mano.add(draw());
  }

  @Override
  public void gioca() {
    mano.add(draw());
    while(getPunti()<17)
      mano.add(draw());
  }

  @Override
  public Iterator<Card> getCards() {
    return mano.iterator();
  }

  @Override
  public String getName() {
    return null;
  }

  //TODO i vari metodi richiesti per aderire all'interfaccia

  public String toString(){
    for (Card carta : mano) System.out.println(carta);
    return null;
  }
}
