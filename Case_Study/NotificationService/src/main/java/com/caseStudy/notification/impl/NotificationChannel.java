package com.caseStudy.notification.impl;

import com.caseStudy.notification.entity.NotificationRequest;

public interface NotificationChannel {

	public void sendNotification(NotificationRequest request);

}
