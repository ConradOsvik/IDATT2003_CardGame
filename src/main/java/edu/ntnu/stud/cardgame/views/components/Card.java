package edu.ntnu.stud.cardgame.views.components;

import java.util.Objects;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 * Represents a card in the user interface. This class extends BorderPane and can display a card
 * image or a question mark.
 */
public class Card extends BorderPane {

  /**
   * Default constructor. Creates a card with a question mark in the center.
   */
  public Card() {
    super();
    this.setId("card");
    Text text = new Text("?");
    this.setCenter(text);
  }

  /**
   * Constructor with card name. Creates a card with the image of the card specified by the card
   * name.
   *
   * @param cardName The name of the card to display.
   */
  public Card(String cardName) {
    super();
    Image image = new Image(
        Objects.requireNonNull(getClass().getResourceAsStream("/cards/" + cardName + ".png")));
    ImageView imageView = new ImageView(image);
    imageView.setImage(image);
    imageView.setFitWidth(200);
    imageView.setPreserveRatio(true);
    this.setCenter(imageView);
    BorderPane.setMargin(imageView, new Insets(5));
  }
}