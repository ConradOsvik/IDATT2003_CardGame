module edu.ntnu.stud.cardgame {
  requires javafx.controls;
  requires javafx.fxml;
  requires javafx.web;

  requires org.controlsfx.controls;
  requires com.dlsc.formsfx;
  requires net.synedra.validatorfx;
  requires org.kordamp.ikonli.javafx;
  requires org.kordamp.bootstrapfx.core;
  requires eu.hansolo.tilesfx;
  requires com.almasb.fxgl.all;

  opens edu.ntnu.stud.cardgame to javafx.fxml;
  exports edu.ntnu.stud.cardgame;
  exports edu.ntnu.stud.cardgame.controllers;
  opens edu.ntnu.stud.cardgame.controllers to javafx.fxml;
}