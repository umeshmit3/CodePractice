package com.caseStudy.notification.impl;

import com.caseStudy.notification.entity.NotificationRequest;

public class SlackChannel implements NotificationChannel {
	private SlackChannel() {
	}

	public static volatile SlackChannel instance;

	public void sendNotification(NotificationRequest request) {
		try {
			System.out.println("Sending message (ID : "+request.getId()+") using slack...");
			Thread.sleep(1000);
			System.out.println("Message(ID : "+request.getId()+") sent successfully!");
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static SlackChannel getSMSChannelInstance() {

		if (instance == null) {
			synchronized (SlackChannel.class) {
				if (instance == null) {
					instance = new SlackChannel();
				}
			}
		}
		return instance;
	}

}
