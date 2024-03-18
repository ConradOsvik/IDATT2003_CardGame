package edu.ntnu.stud.cardgame.models;

/**
 * Represents a hand of playing cards.
 */
public class HandOfCards {

  private final PlayingCard[] cards;

  /**
   * Constructs a new hand of cards.
   *
   * @param cards the array of playing cards that make up the hand
   */
  public HandOfCards(PlayingCard[] cards) {
    this.cards = cards;
  }

  /**
   * Returns the array of playing cards that make up the hand.
   *
   * @return the array of playing cards
   */
  public PlayingCard[] getHand() {
    return this.cards;
  }

  /**
   * Checks if the hand is a flush. A flush is a hand where all cards have the same suit.
   *
   * @return true if the hand is a flush, false otherwise
   */
  public boolean isFlush() {
    for (int i = 1; i < cards.length; i++) {
      if (cards[i].getSuit() != cards[0].getSuit()) {
        return false;
      }
    }
    return true;
  }
}