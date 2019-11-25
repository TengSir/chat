package edu.hbuas.chat.server;
/**
 * TCP通讯的配置接口类，这个类中用来定义tcp通讯的一些基本固定参数
 * @author Lenovo
 *
 */
public interface SocketConfig {
	public int port=8888;//定义好服务器将使用哪个端口通讯
    public String serverIP="localhost";//定义一个服务器IP地址属性，方便客户端可以调用这个属性连接到指定的服务器
}
