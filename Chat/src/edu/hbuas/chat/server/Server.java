package edu.hbuas.chat.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import edu.hbuas.chat.model.Message;
import edu.hbuas.chat.model.MessageType;
import javafx.scene.control.Alert;

/**
 * 封装一个聊天软件的服务器类，这个类对所有客户端提供服务功能
 * 
 * @author Lenovo
 *
 */
public class Server {
	private ServerSocket server;
	
	//在java类中的动态代码块中初始化服务器对象
	{
		try {
			server=new ServerSocket(SocketConfig.port);
			System.out.println("服务器启动成功！准备接受连接！");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "服务器启动失败！");
		}
	}
	
	/**
	 * 构造器中用来开启对外服务
	 */
	public Server() {
		//服务器的accept方法应该放入一个循环中，表示可以接受多人连接，对多个客户端提供聊天服务
		try {
			while(true) {
				Socket  client=server.accept();
				System.out.println(client.getInetAddress().getHostAddress()+"连接进来了！");
				
				//socket连接成功， 那么我们将io流准备好，准备传输数据
				ObjectInputStream  oIn=new ObjectInputStream(client.getInputStream());
				ObjectOutputStream  oOut=new ObjectOutputStream(client.getOutputStream());
				//开启一个线程不停地接受客户端那边发送过来的消息
				new Thread() {
					public void run() {
						while(true) {
							try {
								Message  recivedMessage=(Message)oIn.readObject();
								
								switch (recivedMessage.getMessageType()) {
								case LOGIN:
								{

									  
										System.out.println("接收到客户端发过来的一个要登录的消息请求");
										System.out.println(recivedMessage);
									break;
								}
								default:
									break;
								}
								
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
							
						}
					}
				}.start();
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Server();
	}
	

}
