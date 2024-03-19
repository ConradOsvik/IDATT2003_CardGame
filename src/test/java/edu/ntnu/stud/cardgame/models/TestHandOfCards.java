package edu.ntnu.stud.cardgame.models;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestHandOfCards {

  @Test
  @DisplayName("constructor works as expected")
  void constructor_constructsHand_true() {
    PlayingCard[] cards = new PlayingCard[5];
    for (int i = 0; i < cards.length; i++) {
      cards[i] = new PlayingCard('S', i + 1);
    }

    HandOfCards handOfCards = new HandOfCards(cards);

    assertNotNull(handOfCards);
    assertArrayEquals(cards, handOfCards.getHand());
  }

  @Test
  @DisplayName("constructor throws exception when given null cards array")
  void constructor_constructsHandWithoutCards_false() {
    assertThrows(IllegalArgumentException.class, () -> new HandOfCards(null));
  }

  @Test
  @DisplayName("getHand returns the hand of cards")
  void getHand_returnsHand_true() {
    PlayingCard[] cards = new PlayingCard[5];
    for (int i = 0; i < cards.length; i++) {
      cards[i] = new PlayingCard('S', i + 1);
    }

    HandOfCards handOfCards = new HandOfCards(cards);

    assertArrayEquals(cards, handOfCards.getHand());
  }

  @Test
  @DisplayName("isFlush returns true when all cards are of the same suit")
  void isFlush_cardsAreFlush_true() {
    PlayingCard[] cards = new PlayingCard[5];
    for (int i = 0; i < cards.length; i++) {
      cards[i] = new PlayingCard('S', i + 1);
    }
    HandOfCards handOfCards = new HandOfCards(cards);

    assert (handOfCards.isFlush());
  }

  @Test
  @DisplayName("isFlush returns false when not all cards are of the same suit")
  void isFlush_cardsAreFlush_false() {
    PlayingCard[] cards = new PlayingCard[5];
    for (int i = 0; i < cards.length; i++) {
      cards[i] = new PlayingCard('S', i + 1);
    }
    cards[0] = new PlayingCard('H', 1);
    HandOfCards handOfCards = new HandOfCards(cards);

    assert (!handOfCards.isFlush());
  }
}
