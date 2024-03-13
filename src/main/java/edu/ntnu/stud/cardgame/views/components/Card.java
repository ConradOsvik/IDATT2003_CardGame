package edu.ntnu.stud.cardgame.views.components;

import java.util.Objects;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class Card extends BorderPane {

  public Card(){
    super();
    this.setId("card");
    Text text = new Text("?");
    this.setCenter(text);
  }

  public Card(String cardName) {
    super();
    this.setId("card");
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