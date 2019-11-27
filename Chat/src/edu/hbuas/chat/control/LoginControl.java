package edu.hbuas.chat.control;

import edu.hbuas.chat.model.Message;
import edu.hbuas.chat.model.MessageType;
import edu.hbuas.chat.server.SocketConfig;
import edu.hbuas.chat.view.Login;
import edu.hbuas.chat.view.Main;
import edu.hbuas.chat.view.ModalWindow;
import edu.hbuas.chat.view.Register;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
/**
 * @author tengsir
 */
public class LoginControl implements Initializable {
	private Socket  client;
	private ObjectInputStream  oIn;
	private ObjectOutputStream oOut;
    private User user;

    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;
    @FXML
    private TextField  usernameText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private void processLogin(ActionEvent e){
    	/**
    	 * 所有的数据都存储在服务器端
    	 * 而且本次的底层模型都是采用tcp连接到服务器完成各种业务功能
    	 * 所以，登录也应该发送登录消息，让服务器帮我们查询数据并返回登录的结果，然后客户端才做出响应
    	 */
    	//1.先获取用户在窗口上输入的用户名和密码
    	String  username=usernameText.getText().trim();
    	String password=passwordText.getText().trim();
    	
    	//2.表单验证
    	
    	//3.封装登录的请求消息
    	Message  loginMessage=new Message();
    	loginMessage.setMessageType(MessageType.LOGIN);//封装消息的类型为登录消息
    	
    	edu.hbuas.chat.model.User  user=new edu.hbuas.chat.model.User(username,password);//将表单上填写的用户名和密码封装成一个user对象
    	loginMessage.setFrom(user);//将要登录的账户名和密码的user对象封装到消息的from里面
    	
    	//4.使用socket将登录消息对象发送给服务器
    	
        try {
			oOut.writeObject(loginMessage);
			oOut.flush();
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        
    	
//        System.out.println(user.usernameProperty().get());
//        Main m=new Main();
//        m.start(new Stage());
//        loginButton.getScene().getWindow().hide();
       // ModalWindow.showModalDialog("温馨提示","处理用户登陆功能");
    }
    /**
     * javafx窗口控制器的初始化函数，ui第一次被渲染时调用
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
        /**
         * 控制器默认的初始化方法，用来执行一些组件额外的初始化业务，这个方法会在ui组件渲染打开前执行。
         */
        user=new User();
        user.usernameProperty().bind(usernameText.textProperty());
        user.passwordProperty().bind(passwordText.textProperty());


        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Register  r=new Register();
                r.start(new Stage());
                registerButton.getScene().getWindow().hide();
            }
        });

        //UI渲染完毕，则应该让底层的socket对象初始化，准备后期可以和服务器通讯
        try {
			client =new Socket(SocketConfig.serverIP,SocketConfig.port);
			System.out.println("连接服务器成功！");
			
			  oOut=new ObjectOutputStream(client.getOutputStream());
			  oIn=new ObjectInputStream(client.getInputStream());
			  
		} catch (IOException e) {
			System.out.println("无法连接到服务器端");
			Alert a=new Alert(Alert.AlertType.ERROR);
			a.setContentText("无法连接到服务器端");
			a.show();
		}  

    }
}
