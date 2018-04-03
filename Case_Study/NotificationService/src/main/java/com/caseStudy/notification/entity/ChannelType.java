package com.caseStudy.notification.entity;

/**
 * @author umeshkumar
 *
 */
public enum ChannelType {

	EMAIL, SLACK;

	public ChannelType getChannelType(String type) {
		if (type.equalsIgnoreCase("slack")) {
			return ChannelType.SLACK;
		} else if (type.equalsIgnoreCase("email")) {
			return ChannelType.EMAIL;
		}
		return null;
	}

}
