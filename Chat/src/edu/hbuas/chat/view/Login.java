package edu.hbuas.chat.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * @author tengsir
 */
public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Group g= FXMLLoader.load(new java.io.File("Login.fxml").toURL());
            Scene  s=new Scene(g,300,200, Color.LIGHTGRAY);
            primaryStage.setTitle("用户登陆");
            primaryStage.setResizable(false);
            primaryStage.setScene(s);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
