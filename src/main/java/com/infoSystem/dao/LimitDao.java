package com.infoSystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.infoSystem.entity.LimitEntity;

@Repository
@Transactional
public class LimitDao {

	@PersistenceContext
	private EntityManager entityManager;

	public String checkUser(String userId) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LimitEntity> criteriaQuery = builder.createQuery(LimitEntity.class);
		Root<LimitEntity> root = criteriaQuery.from(LimitEntity.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("userId"), Integer.parseInt(userId)));

		Subquery<String> maxSubQuery = criteriaQuery.subquery(String.class);
		Root<LimitEntity> fromEntityX = maxSubQuery.from(LimitEntity.class);
		maxSubQuery.select(builder.greatest(fromEntityX.get("createdTimestamp")));
		criteriaQuery.where(builder.equal(root.get("createdTimestamp"), maxSubQuery));

		try {
			LimitEntity dataArray = entityManager.createQuery(criteriaQuery).getSingleResult();
			if (dataArray != null) {
				return dataArray.getCreatedTimestamp() + "";
			} else {
				return "NOTFOUND";
			}
		} catch (Exception e) {
			return "NOTFOUND";
		}
	}

	public int insertLimit(LimitEntity limitEntity) {
		try {
			entityManager.persist(limitEntity);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

}
