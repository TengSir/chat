package edu.hbuas.chat.model;

import java.io.Serializable;

public class Message implements Serializable {
	public Message() {
		super();
	}
	@Override
	public String toString() {
		return "Message [from=" + from + ", to=" + to + ", sendTime=" + sendTime + ", content=" + content
				+ ", messageType=" + messageType + "]";
	}
	public Message(User from, User to, String sendTime, String content, MessageType messageType) {
		super();
		this.from = from;
		this.to = to;
		this.sendTime = sendTime;
		this.content = content;
		this.messageType = messageType;
	}
	public User getFrom() {
		return from;
	}
	public void setFrom(User from) {
		this.from = from;
	}
	public User getTo() {
		return to;
	}
	public void setTo(User to) {
		this.to = to;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public MessageType getMessageType() {
		return messageType;
	}
	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	private User  from;
	private User to;
	private String sendTime;
	private String content;
	private  MessageType  messageType;
}

