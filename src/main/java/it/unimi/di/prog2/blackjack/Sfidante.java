package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.Iterator;
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

  //si perchè non posso accedere direttamente alla strategie e non ho escaping references
  public void setStrategia(Strategia strategia) {
    assert this.strategia == null : "non puoi cambiare strategia se è già settata";
    this.strategia = strategia;
  }

  @Override
  public void carteIniziali() {
    for (int i = 0; i < 2; i++) {
      mano.add(banco.draw());
    }
  }

  @Override
  public void gioca() {
    assert strategia != null : "Per giocare serve una strategia.";
    carteIniziali();

    while(strategia.chiediCarta()){
      if (isSballato()||getPunti()!=21)
        break;
      mano.add(banco.draw());
    }

    //TODO implementare il metodo assumendo il rispetto della precondizione
  }

  @Override
  public Iterator<Card> getCards() {
    return mano.iterator();
  }


  @Override
  public String getName() {
    return name;
  }


  //TODO i vari metodi richiesti per aderire all'interfaccia

  public String toString(){
  for (Card carta : mano) System.out.println(carta);
    return null;
  }
}
