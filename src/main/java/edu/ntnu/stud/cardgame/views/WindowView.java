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

/**
 * WindowView is the main view of the card game. It displays the game title, the cards, the buttons
 * to deal and check hand, and the result of the hand. This class extends the JavaFX Scene class.
 */
public class WindowView extends Scene {

  private final CardGameController controller;
  private final VBox root;
  private final HBox cards;
  private final VBox result;

  /**
   * Constructor for WindowView. Creates a new WindowView with the specified controller.
   *
   * @param controller The controller to handle the game logic.
   */
  public WindowView(CardGameController controller) {
    super(new VBox(), getPrimary().getVisualBounds().getWidth(),
        getPrimary().getVisualBounds().getHeight());
    this.controller = controller;
    this.root = (VBox) getRoot();
    this.cards = new HBox();
    this.result = new VBox();
    this.getStylesheets().add("/app.css");
    this.view();
  }

  /**
   * Sets up the view of the game. This includes the title, the cards, the buttons, and the result.
   */
  private void view() {
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

  /**
   * Updates the hand of cards displayed in the view.
   *
   * @param hand The new hand of cards to display.
   */
  public void updateHand(HandOfCards hand) {
    cards.getChildren().clear();
    for (PlayingCard playingCard : hand.getHand()) {
      Card card = new Card(playingCard.toString());
      cards.getChildren().add(card);
    }
  }

  /**
   * Updates the result displayed in the view.
   *
   * @param sum                 The sum of the face values of the cards in the hand.
   * @param hearts              The array of cards in the hand that are hearts.
   * @param containsSpadesQueen Whether the hand contains the queen of spades.
   * @param isFlush             Whether the hand is a flush.
   */
  public void updateResult(int sum, PlayingCard[] hearts, boolean containsSpadesQueen,
      boolean isFlush) {
    result.getChildren().clear();

    Text sumText = new Text("Sum: " + sum);
    sumText.setId("result-text");
    StringBuilder heartsString = new StringBuilder();
    if (hearts.length == 0) {
      heartsString.append("No hearts");
    } else {
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
