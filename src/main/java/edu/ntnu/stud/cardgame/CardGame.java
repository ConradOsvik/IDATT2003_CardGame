package edu.ntnu.stud.cardgame;

import edu.ntnu.stud.cardgame.controllers.CardGameController;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main class for the Card Game application. This class extends the JavaFX Application class and
 * is the entry point for the application. It creates a new CardGameController and shows the primary
 * stage.
 */
public class CardGame extends Application {

  /**
   * The controller for the Card Game.
   */
  private CardGameController controller;

  /**
   * The start method is the main entry point for all JavaFX applications. It is called after the
   * init method has returned, and after the system is ready for the application to begin running.
   *
   * @param stage The primary stage for this application, onto which the application scene can be
   *              set.
   * @throws IOException If there is an error loading the FXML file for the scene.
   */
  @Override
  public void start(Stage stage) throws IOException {
    this.controller = new CardGameController(stage);
    stage.show();
  }

  /**
   * The main method is ignored in correctly deployed JavaFX application. main() serves only as
   * fallback in case the application can not be launched through deployment artifacts.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch();
  }
}