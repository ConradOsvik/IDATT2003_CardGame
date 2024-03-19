package edu.ntnu.stud.cardgame.models;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class represents a deck of playing cards. It contains 52 cards, one for each combination of
 * the four suits and thirteen faces.
 */
public class DeckOfCards {

  private final Random rand = new Random();
  private final char[] suits = {'S', 'H', 'D', 'C'};
  private final PlayingCard[] cards = new PlayingCard[52];

  /**
   * Constructs a new deck of cards. The deck is initially ordered from Ace of Spades to King of
   * Clubs.
   */
  public DeckOfCards() {
    for (int i = 0; i < suits.length; i++) {
      char suit = suits[i];
      for (int face = 1; face <= 13; face++) {
        cards[i * 13 + face - 1] = new PlayingCard(suit, face);
      }
    }
  }

  /**
   * Deals a hand of n cards from the deck. The cards are chosen randomly from the deck.
   *
   * @param n the number of cards to deal
   * @return a hand of n cards
   */
  public HandOfCards dealHand(int n) {
    if(n < 1) throw new IllegalArgumentException("Number of cards must be positive");

    ArrayList<PlayingCard> hand = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int randIndex = rand.nextInt(52);
      hand.add(cards[randIndex]);
    }

    return new HandOfCards(hand.toArray(new PlayingCard[n]));
  }
}
