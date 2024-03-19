package edu.ntnu.stud.cardgame.models;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestDeckOfCards {

  private DeckOfCards deckOfCards;

  @BeforeEach
  void setUp() {
    this.deckOfCards = new DeckOfCards();
  }

  @Test
  @DisplayName("Test that a hand of 5 cards is dealt from the deck of cards.")
  void dealHand_createsHandWith5Cards_true() {
    Object hand = deckOfCards.dealHand(5);

    assertInstanceOf(HandOfCards.class, hand);
  }

  @Test
  @DisplayName("Test that a hand of -1 cards is not dealt from the deck of cards.")
  void dealHand_createsHandWithNegative1Cards_false() {
    assertThrows(IllegalArgumentException.class, () -> deckOfCards.dealHand(-1)
    );
  }
}
