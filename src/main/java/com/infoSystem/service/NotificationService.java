package com.infoSystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoSystem.dao.NotificationDao;
import com.infoSystem.entity.NotificationEntity;
import com.infoSystem.model.NotificationModel;

@Service
public class NotificationService {

	@Autowired
	NotificationDao notificationDao;

	public List<NotificationModel> getAllNotifications() {
		List<NotificationModel> notificationList = new ArrayList<NotificationModel>();
		List<NotificationEntity> notificationEntityList = notificationDao.getAllNotifications();
		for (NotificationEntity notificationEntity : notificationEntityList) {
			NotificationModel notificationModel = new NotificationModel();
			notificationModel.setCreatedBy(notificationEntity.getCreatedBy());
			notificationModel.setNotificationId(notificationEntity.getNotificationId());
			notificationModel.setNotificationSummary(notificationEntity.getNotificationSummary());
			notificationModel.setNotificationText(notificationEntity.getNotificationText());
			notificationModel.setCreatedTimestamp(notificationEntity.getCreatedTimestamp());
			notificationList.add(notificationModel);
		}
		return notificationList;
	}

	public int createNotification(NotificationModel notificationModel) {
		NotificationEntity notificationEntity = new NotificationEntity();
		notificationEntity.setNotificationSummary(notificationModel.getNotificationSummary());
		notificationEntity.setNotificationText(notificationModel.getNotificationText());
		notificationEntity.setCreatedTimestamp(new Date());
		notificationEntity.setCreatedBy(notificationModel.getCreatedBy());
		int response = notificationDao.createNotification(notificationEntity);
		return response;
	}
}
