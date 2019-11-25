package edu.hbuas.chat.view;

import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 * @author tengsir
 */
public class ModalWindow {

    public static void showModalDialog(String title,String content,int width,int height){
        Alert a=new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setContentText(content);
        a.showAndWait();
//        Stage s=new Stage();
//        s.initModality(Modality.APPLICATION_MODAL);
//        s.setTitle(title);
//        s.setResizable(false);
//        s.setWidth(width);
//        s.setHeight(height);
//        s.showAndWait();
    }
    public static void showModalDialog(String title,String content){
//        Alert a=new Alert(Alert.AlertType.INFORMATION);
//        a.setTitle(title);
//        a.setContentText(content);
//        a.showAndWait();
        Stage s=new Stage();
        s.initModality(Modality.APPLICATION_MODAL);
        s.setTitle(title);
        s.setResizable(false);
        s.setWidth(140 );
        s.setHeight(100);
        s.showAndWait();
    }
    public static void showAlertDialog(String title,String text,Alert.AlertType type){
        Alert a=new Alert(type);
        a.setTitle(title);
        a.setContentText(text);
        a.showAndWait();
    }
}
