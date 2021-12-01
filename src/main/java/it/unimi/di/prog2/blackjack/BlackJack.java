package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;
import it.unimi.di.prog2.blackjack.strategie.Strat1;
import it.unimi.di.prog2.blackjack.strategie.Strat2;
import it.unimi.di.prog2.blackjack.strategie.Strat3;
import it.unimi.di.prog2.blackjack.strategie.StratDef;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
  public static int cardValue(Card c) {
    return Math.min(c.getRank().ordinal() + 1, 10);
  }

  public static void main(String[] args) {

    Mazziere banco = new Mazziere();

    Sfidante carlo = new Sfidante("Carlo", banco);
    Sfidante mattia = new Sfidante("Mattia", banco);
    Sfidante violetta = new Sfidante("Violetta", banco);

    List<Sfidante> sfidanti = new ArrayList<>();

    sfidanti.add(carlo);
    sfidanti.add(mattia);
    sfidanti.add(violetta);


    //TODO  gestire lo svolgimento di una partita con i tre sfidanti

    banco.carteIniziali();

    Strategia strat;

    strat = new RandomStrategy(new StratDef());
    carlo.setStrategia(strat);

    strat = new Strat1(new Strat2(new StratDef(),mattia,banco),mattia);
    mattia.setStrategia(strat);

    strat = new Strat3(new Strat2(new Strat1(new StratDef(),violetta),violetta,banco),violetta);
    violetta.setStrategia(strat);

    boolean sballato = true;
    for (Sfidante sfidante : sfidanti){
      sfidante.gioca();
      if (!sfidante.isSballato()){
        sballato=false;
      }
    }

    if(!sballato)
      banco.gioca();


    //System.out.println(banco);
    System.out.println("-----Carte banco:------ ");
    banco.toString();
    System.out.println("_________________________");
    for (Sfidante sfidante : sfidanti) {
      System.out.println("------"+sfidante.getName()+"----------");
      sfidante.toString();
      //System.out.println(sfidante.getName());
      if (sfidante.isSballato() || (sfidante.getPunti() < banco.getPunti() && !banco.isSballato()))
        System.out.println("Vince il banco.");
      else if (banco.isSballato() || sfidante.getPunti() > banco.getPunti())
        System.out.println("Il banco perde!!!");
      else
        System.out.println("Pareggio.");
    }
    System.out.println("_________________________");
  }

}
