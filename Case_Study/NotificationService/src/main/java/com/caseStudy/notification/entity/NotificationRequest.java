package com.caseStudy.notification.entity;

/**
 * @author umeshkumar
 *
 */
public class NotificationRequest {
	private int id;
	private String sender;
	private String receipients;
	private ChannelType channel;
	private String message;
	private String subject;

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public ChannelType getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		if (channel.equals("email")) {
			this.channel = ChannelType.EMAIL;
		} else if (channel.equals("slack")) {
			this.channel = ChannelType.SLACK;
		}

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReceipients() {
		return receipients;
	}

	public void setReceipients(String receipients) {
		this.receipients = receipients;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
