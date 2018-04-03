package com.caseStudy.notification.impl;

import com.caseStudy.notification.entity.NotificationRequest;

public class EmailChannel implements NotificationChannel {
	private EmailChannel() {
	}

	public static volatile EmailChannel instance;

	public void sendNotification(NotificationRequest request) {

		try {
			System.out.println("Sending message(ID : "+request.getId()+") using Email...");
		
			Thread.sleep(1000);
			
			System.out.println("Message( ID : "+request.getId()+") sent successfully!");
		
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static EmailChannel getEmailChannelInstance() {

		if (instance == null) {
			
			synchronized (EmailChannel.class) {
			
				if (instance == null) {
					instance = new EmailChannel();
				}
			}
		}
		return instance;
	}

}
