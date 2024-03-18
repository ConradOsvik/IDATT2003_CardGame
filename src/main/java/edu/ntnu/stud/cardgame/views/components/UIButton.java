package edu.ntnu.stud.cardgame.views.components;

import javafx.scene.control.Button;

/**
 * UIButton is a custom button class for the user interface. This class extends the JavaFX Button
 * class and sets a specific ID for the button. The ID can be used for CSS styling.
 */
public class UIButton extends Button {

  /**
   * Constructor for UIButton. Creates a new UIButton with the specified text.
   *
   * @param text The text to display on the button.
   */
  public UIButton(String text) {
    super(text);
    this.setId("ui-button");
  }
}
