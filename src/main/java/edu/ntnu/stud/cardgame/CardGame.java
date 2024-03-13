package edu.ntnu.stud.cardgame;

import edu.ntnu.stud.cardgame.controllers.CardGameController;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class CardGame extends Application {
  private CardGameController controller;

  @Override
  public void start(Stage stage) throws IOException {
    this.controller = new CardGameController(stage);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}