package edu.ntnu.stud.cardgame.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestPlayingCard {

  @Test
  void constructor_constructsWithValidArgs_true() {
    PlayingCard card = new PlayingCard('H', 1);
    assertEquals('H', card.getSuit());
    assertEquals(1, card.getFace());
  }

  @Test
  void constructor_constructsWithWrongSuit_false() {
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('X', 1));
  }

  @Test
  void constructor_constructsWithWrongFace_false() {
    assertThrows(IllegalArgumentException.class, () -> new PlayingCard('H', 14));
  }

  @Test
  void getSuit_returnsSuit_true() {
    PlayingCard card = new PlayingCard('H', 1);
    assertEquals('H', card.getSuit());
  }

  @Test
  void getFace_returnsFace_true() {
    PlayingCard card = new PlayingCard('H', 1);
    assertEquals(1, card.getFace());
  }

  @Test
  void toString_stringifies_true() {
    PlayingCard card = new PlayingCard('H', 1);
    assertEquals("ace_of_hearts", card.toString());
  }

  @Test
  void equals_isEqual_true() {
    PlayingCard card1 = new PlayingCard('H', 1);
    PlayingCard card2 = new PlayingCard('H', 1);
    assertEquals(card1, card2);
  }

  @Test
  void equals_isEqual_false() {
    PlayingCard card1 = new PlayingCard('H', 1);
    PlayingCard card2 = new PlayingCard('D', 1);
    assertNotEquals(card1, card2);
  }

  @Test
  void hashCode_createsCode_true() {
    PlayingCard card1 = new PlayingCard('H', 1);
    PlayingCard card2 = new PlayingCard('H', 1);
    assertEquals(card1.hashCode(), card2.hashCode());
  }
}