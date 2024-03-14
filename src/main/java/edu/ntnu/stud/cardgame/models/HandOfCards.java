package edu.ntnu.stud.cardgame.models;

public class HandOfCards {
  private final PlayingCard[] cards;

  public HandOfCards(PlayingCard[] cards){
    this.cards = cards;
  }

  public PlayingCard[] getHand(){
    return this.cards;
  }

  public boolean isFlush(){
    for(int i = 1; i < cards.length; i++){
      if(cards[i].getSuit() != cards[0].getSuit()){
        return false;
      }
    }
    return true;
  }
}