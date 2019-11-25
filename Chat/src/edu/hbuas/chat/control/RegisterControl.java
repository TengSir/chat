package edu.hbuas.chat.control;

import edu.hbuas.chat.view.Head;
import edu.hbuas.chat.view.Login;
import edu.hbuas.chat.view.ModalWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author tengsir
 */
public class RegisterControl implements Initializable {
    @FXML
    private Button submitRegister,selectImage;
    @FXML
    private Button backLogin;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        submitRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ModalWindow.showModalDialog("温馨提示","准备注册");
            }
        });
        backLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login l=new Login();
                l.start(new Stage());
                backLogin.getScene().getWindow().hide();
            }
        });
        selectImage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Head h=new Head();
                h.start(new Stage());
            }
        });
    }
}
