package com.infoSystem.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.infoSystem.entity.NotificationEntity;

@Repository
@Transactional
public class NotificationDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<NotificationEntity> getAllNotifications() {
		List<NotificationEntity> notificationList = new ArrayList<NotificationEntity>();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<NotificationEntity> criteriaQuery = builder.createQuery(NotificationEntity.class);
		Root<NotificationEntity> root = criteriaQuery.from(NotificationEntity.class);
		criteriaQuery.select(root);
		notificationList = entityManager.createQuery(criteriaQuery).getResultList();
		return notificationList;
	}

	public int createNotification(NotificationEntity notificationEntity) {
		try {
			entityManager.persist(notificationEntity);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

}
