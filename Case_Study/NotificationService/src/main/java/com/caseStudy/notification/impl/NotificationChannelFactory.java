package com.caseStudy.notification.impl;

import com.caseStudy.notification.entity.ChannelType;
import com.caseStudy.notification.impl.EmailChannel;
import com.caseStudy.notification.impl.NotificationChannel;
import com.caseStudy.notification.impl.SlackChannel;

public class NotificationChannelFactory {

	public static NotificationChannel getChannel(ChannelType type) {
		NotificationChannel channel = null;
		
		if (type.equals(ChannelType.SLACK)) {
			channel = SlackChannel.getSMSChannelInstance();
	
		} else if (type.equals(ChannelType.EMAIL)) {
			channel = EmailChannel.getEmailChannelInstance();
		}

		return channel;
	}
}
