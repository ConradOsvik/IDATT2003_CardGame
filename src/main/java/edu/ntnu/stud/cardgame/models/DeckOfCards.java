package edu.ntnu.stud.cardgame.models;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
  private final Random rand = new Random();
  private final char[] suits = {'S', 'H', 'D', 'C'};
  private final PlayingCard[] cards = new PlayingCard[52];
  public DeckOfCards(){
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        cards[(suit - 1) * 13 + face - 1] = new PlayingCard(suit, face);
      }
    }
  }

  public HandOfCards dealHand(int n){
    ArrayList<PlayingCard> hand = new ArrayList<>();

    for(int i = 0; i < n; i++){
      int randIndex = rand.nextInt(52);
      hand.add(cards[randIndex]);
    }

    return new HandOfCards(hand.toArray(new PlayingCard[n]));
  }
}
