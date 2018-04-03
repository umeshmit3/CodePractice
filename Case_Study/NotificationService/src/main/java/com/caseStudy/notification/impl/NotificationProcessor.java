package com.caseStudy.notification.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.caseStudy.notification.entity.NotificationRequest;

public class NotificationProcessor {
	private NotificationProcessor() {
		init();
	}

	@SuppressWarnings("rawtypes")
	private void init() {

		lock = new ReentrantLock();
		count = new AtomicInteger(0);
		semaphore = new Semaphore(1);

		service = Executors.newFixedThreadPool(poolSize);
		queue = new LinkedList<NotificationRequest>();
		responseMap = new HashMap<Integer, Future>();
		

	}

	int poolSize = 10;
	private static Object lockObj = new Object();;
	private static NotificationProcessor processor;

	private Lock lock;
	private AtomicInteger count;

	private ExecutorService service;
	private Queue<NotificationRequest> queue;
	@SuppressWarnings("rawtypes")
	private Map<Integer, Future> responseMap;
	private Semaphore semaphore;

	public int processNotification(NotificationRequest request) {

		lock.lock();
		setSequenceId(request);
		System.out.println("Processing notification for message ID : " + request.getId());

		queue.add(request);
		Runnable notificationTask = getNotificationTask(request, queue);

		Future<?> response = service.submit(notificationTask);
		responseMap.put(request.getId(), response);
		lock.unlock();

		return request.getId();
	}

	private void setSequenceId(NotificationRequest request) {
		// For generating message sequence;
		request.setId(count.incrementAndGet());
	}

	private Runnable getNotificationTask(NotificationRequest request, Queue<NotificationRequest> queue) {
		Runnable notificationTask = new Runnable() {
			@Override
			public void run() {
				try {
					semaphore.acquire();

					NotificationRequest notification = queue.remove();
					NotificationChannel channel = NotificationChannelFactory.getChannel(notification.getChannel());
					channel.sendNotification(request);

					semaphore.release();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		return notificationTask;
	}

	public static NotificationProcessor getNotificationProcessor() {

		if (processor == null) {
			synchronized (lockObj) {
				if (processor == null) {
					processor = new NotificationProcessor();
				}
			}
		}

		return processor;
	}

	@SuppressWarnings("rawtypes")
	public String getNotificationStatus(int id) {
		Future response = responseMap.get(id);
		if (null == response) {
			return null;
		} else if (response.isDone()) {
			return "Notifiication sent successfully..";
		} else if (!response.isDone()) {
			return "Notifiication not sent";
		}
		return null;

	}

}
