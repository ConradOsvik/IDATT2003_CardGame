package edu.ntnu.stud.cardgame.models;

public class HandOfCards {
  private final PlayingCard[] cards;

  public HandOfCards(PlayingCard[] cards){
    this.cards = cards;
  }

  public PlayingCard[] getHand(){
    return this.cards;
  }
}
