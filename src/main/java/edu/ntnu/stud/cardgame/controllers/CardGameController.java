package edu.ntnu.stud.cardgame.controllers;

import edu.ntnu.stud.cardgame.models.DeckOfCards;
import edu.ntnu.stud.cardgame.models.HandOfCards;
import edu.ntnu.stud.cardgame.views.WindowView;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CardGameController {
  private final WindowView view;
  private final DeckOfCards deck;
  private HandOfCards hand;
  public CardGameController(Stage stage){
      this.view = new WindowView(this);
      stage.setTitle("CardGame");
      stage.setScene(view);

      this.deck = new DeckOfCards();
  }

  public void dealHand(){
    this.hand = deck.dealHand(5);
    this.view.updateHand(hand);
  }
}