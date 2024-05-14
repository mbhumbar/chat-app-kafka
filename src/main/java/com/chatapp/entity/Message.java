package com.chatapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "message")
public class Message {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "senderNumber")
	private String senderName;
	
	@Column(name = "receiverName")
	private String receivername;
	
	@Column(name = "messageBody")
	private String messageBody;
	
	
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Message(Long id, String senderName, String receivername, String messageBody) {
		super();
		this.id = id;
		this.senderName = senderName;
		this.receivername = receivername;
		this.messageBody = messageBody;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSenderName() {
		return senderName;
	}


	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}


	public String getReceivername() {
		return receivername;
	}


	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}


	public String getMessageBody() {
		return messageBody;
	}


	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}


	@Override
	public String toString() {
		return "Message [id=" + id + ", senderName=" + senderName + ", receivername=" + receivername + ", messageBody="
				+ messageBody + "]";
	}
	

}
