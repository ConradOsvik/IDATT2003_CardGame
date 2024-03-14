package edu.ntnu.stud.cardgame.views;

import static javafx.stage.Screen.getPrimary;

import edu.ntnu.stud.cardgame.controllers.CardGameController;
import edu.ntnu.stud.cardgame.models.HandOfCards;
import edu.ntnu.stud.cardgame.models.PlayingCard;
import edu.ntnu.stud.cardgame.views.components.Card;
import edu.ntnu.stud.cardgame.views.components.UIButton;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class WindowView extends Scene {
  private final CardGameController controller;
  private final VBox root;
  private final HBox cards;
  private final VBox result;

  public WindowView(CardGameController controller) {
    super(new VBox(), getPrimary().getVisualBounds().getWidth(), getPrimary().getVisualBounds().getHeight());
    this.controller = controller;
    this.root = (VBox) getRoot();
    this.cards = new HBox();
    this.result = new VBox();
    this.getStylesheets().add("/app.css");
    this.view();
  }

  private void view(){
    this.root.setAlignment(Pos.TOP_CENTER);

    //Title
    Text title = new Text("CardGame");
    title.setId("title");
    Separator separator = new Separator();

    //Container
    HBox container = new HBox();
    container.setAlignment(Pos.CENTER);

    //Cards
    cards.setAlignment(Pos.CENTER);

    for (int i = 0; i < 5; i++) {
      Card card = new Card();
      cards.getChildren().add(card);
    }

    //Buttons
    VBox buttons = new VBox();
    buttons.setAlignment(Pos.CENTER);

    // deal hand button
    UIButton dealHandButton = new UIButton("Deal Hand");
    dealHandButton.setOnAction(e -> controller.dealHand());

    // check hand button
    UIButton checkHandButton = new UIButton("Check Hand");
    checkHandButton.setOnAction(e -> controller.checkHand());

    buttons.getChildren().addAll(dealHandButton, checkHandButton);

    container.getChildren().addAll(cards, buttons);

    //Result
    result.setAlignment(Pos.CENTER);

    root.getChildren().addAll(title, separator, container, result);
  }

  public void updateHand(HandOfCards hand){
    cards.getChildren().clear();
    for (PlayingCard playingCard : hand.getHand()) {
      Card card = new Card(playingCard.toString());
      cards.getChildren().add(card);
    }
  }

  public void updateResult(int sum, PlayingCard[] hearts,  boolean containsSpadesQueen, boolean isFlush){
    result.getChildren().clear();

    Text sumText = new Text("Sum: " + sum);
    sumText.setId("result-text");
    StringBuilder heartsString = new StringBuilder();
    if(hearts.length == 0){
      heartsString.append("No hearts");
    }
    else{
      heartsString.append("Hearts: ");
      for (PlayingCard heart : hearts) {
        heartsString.append(heart.getSuit()).append(heart.getFace()).append(" ");
      }
    }
    Text heartsText = new Text(heartsString.toString());
    heartsText.setId("result-text");
    Text containsSpadesQueenText = new Text("Contains Spades Queen: " + containsSpadesQueen);
    containsSpadesQueenText.setId("result-text");
    Text isFlushText = new Text("Is Flush: " + isFlush);
    isFlushText.setId("result-text");

    result.getChildren().addAll(sumText, heartsText, containsSpadesQueenText, isFlushText);
  }
}
