package edu.hbuas.chat.control;

import com.sun.corba.se.spi.ior.iiop.AlternateIIOPAddressComponent;
import edu.hbuas.chat.view.File;
import edu.hbuas.chat.view.ModalWindow;
import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;
/**
 * @author tengsir
 */
public class ChatControl implements Initializable {
    @FXML
    private ListView ofenText;
    @FXML
    private TextArea  editText,messages;
    @FXML
    private Button sendMessageButton,clearText,sendFile;
    @FXML
    private Accordion panels;
    @FXML
    private TitledPane friendInfo;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String>  texts= FXCollections.observableArrayList("出来聊五毛钱的！","陈独秀你坐下！","有事晚点再聊！","天空飘来五个字！","追求诗和远方！","礼貌不失尴尬一笑！","定个小目标！","我对钱不感兴趣！","我这个人脸盲！","咸鱼没有梦想！","你是来写bug的吗？");
        ofenText.setItems(texts);
//        ofenText.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
//            @Override
//            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
//                System.out.println(newValue );
//                editText.setText(newValue.toString());
//            }
//        });
        ofenText.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount()==2&&event.getButton()==MouseButton.PRIMARY){
                    editText.setText(  ofenText.getSelectionModel().getSelectedItem().toString());
                }
            }
        });

        sendMessageButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String text=editText.getText();
                if(text.length()==0){
                    ModalWindow.showAlertDialog("温馨提示","不能发送空消息！", Alert.AlertType.INFORMATION);
                }else{
                    messages.appendText(text+"\r\n\r\n");
                    editText.setText("");
                }
            }
        });
        clearText.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                editText.setText("");
            }
        });
        sendFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                File f=new File();
                f.start(new Stage());
            }
        });

        friendInfo.setExpanded(true);
        panels.setExpandedPane(friendInfo);

    }
}
