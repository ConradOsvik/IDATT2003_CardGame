package edu.ntnu.stud.cardgame.controllers;

import edu.ntnu.stud.cardgame.models.DeckOfCards;
import edu.ntnu.stud.cardgame.models.HandOfCards;
import edu.ntnu.stud.cardgame.models.PlayingCard;
import edu.ntnu.stud.cardgame.views.WindowView;
import java.util.Arrays;
import javafx.stage.Stage;

/**
 * This class represents the controller for the Card Game. It manages the game logic, including
 * dealing hands and checking the hand.
 */
public class CardGameController {

  private final WindowView view;
  private final DeckOfCards deck;
  private HandOfCards hand;

  /**
   * This class represents the controller for the Card Game. It manages the game logic, including
   * dealing hands and checking the hand.
   */
  public CardGameController(Stage stage) {
    this.view = new WindowView(this);
    stage.setTitle("CardGame");
    stage.setScene(view);

    this.deck = new DeckOfCards();
  }

  /**
   * Deals a new hand of cards. Updates the view with the new hand.
   */
  public void dealHand() {
    this.hand = deck.dealHand(5);
    this.view.updateHand(hand);
  }

  /**
   * Checks the current hand of cards. Calculates the sum of the faces, checks for hearts, checks
   * for the queen of spades, and checks for a flush. Updates the view with the result.
   */
  public void checkHand() {
    int sum = Arrays.stream(hand.getHand()).mapToInt(PlayingCard::getFace).sum();
    PlayingCard[] hearts = Arrays.stream(hand.getHand()).filter(card -> card.getSuit() == 'H')
        .toArray(PlayingCard[]::new);
    boolean containsSpadesQueen = Arrays.stream(hand.getHand())
        .anyMatch(card -> card.getSuit() == 'S' && card.getFace() == 12);
    boolean isFlush = hand.isFlush();

    this.view.updateResult(sum, hearts, containsSpadesQueen, isFlush);
  }
}