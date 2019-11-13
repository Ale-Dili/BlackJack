package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Sfidante implements GiocatoreBJ {
  final private String name;
  final private Mazziere banco;
  final private List<Card> mano = new ArrayList<>();
  private Strategia strategia;


  public Sfidante(String name, Mazziere banco) {
    this.name = name;
    this.banco = banco;
  }

  //TODO: spiegare in un commento di poche righe se e perché questo setter
  // è sufficiente a garantire la proprietà di immutabilità della strategia di un giocatore
  public void setStrategia(Strategia strategia) {
    assert this.strategia == null : "non puoi cambiare strategia se è già settata";
    this.strategia = strategia;
  }

  @Override
  public void gioca() {
    assert strategia != null : "Per giocare serve una strategia.";
    //TODO implementare il metodo assumendo il rispetto della precondizione
  }

  //TODO i vari metodi richiesti per aderire all'interfaccia
}
