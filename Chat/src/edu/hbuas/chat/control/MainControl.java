package edu.hbuas.chat.control;

import edu.hbuas.chat.view.Chat;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
/**
 * @author tengsir
 */
public class MainControl implements Initializable {
    @FXML
    private TreeView  tree;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TreeItem  root=new TreeItem("好友列表",new ImageView("images/friends.png"));
        TreeItem  friends=new TreeItem("好友列表",new ImageView("images/friends.png"));
        for(int n=0;n<5;n++){
            TreeItem  f=new TreeItem(new Random().nextInt(1000)+100+"-\'"+"个性签名"+new Random().nextDouble()+"\'");
            f.setGraphic(new ImageView(new Image("images/"+(new Random().nextInt(40)+97)+".gif" ,16,16,false,false)));

            friends.getChildren().add(f);
        }
        TreeItem  group=new TreeItem("群聊列表",new ImageView("images/group.png"));
        for(int n=0;n<5;n++){
            TreeItem  f=new TreeItem(new Random().nextInt(1000)+100+"-\'"+"xx信息交流群"+new Random().nextInt()+"\'");
            f.setGraphic(new ImageView(new Image("images/group"+(new Random().nextInt(5)+1)+".png" ,16,16,false,false)));

            group.getChildren().add(f);
        }
        root.getChildren().add(friends);
        root.getChildren().add(group);
        tree.setRoot(root);
        tree.setShowRoot(false);
        tree.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount()==2&&event.getButton()== MouseButton.PRIMARY){
                    Chat c=new Chat();
                    c.start(new Stage());
                }
            }
        });

    }
}
