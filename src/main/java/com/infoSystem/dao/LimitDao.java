package com.infoSystem.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.infoSystem.entity.IssueEntity;
import com.infoSystem.entity.LimitEntity;
import com.infoSystem.entity.UserEntity;

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

	public int noOfIssues(int userId) {
		String sql = "SELECT * FROM DBO.TBLISSUE WHERE CREATED_BY = ? AND CREATED_TIMESTAMP >= ?";
		Query query = entityManager.createNativeQuery(sql, IssueEntity.class);
		query.setParameter(1, userId);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(date);
		query.setParameter(2, strDate);
		int count = 0;
		try {
			List<Object> list = (List<Object>) query.getResultList();
			if (list.size() > 0) {
				count = list.size();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	public Boolean checkLimitations(int userId) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = sdf.format(date);
		String sql = "SELECT * FROM DBO.TBLLIMIT WHERE USER_ID = " + userId + " AND CREATED_TIMESTAMP >=" + "'"
				+ strDate + "'";
		Query query = entityManager.createNativeQuery(sql);
		try {
			List<Object> list = (List<Object>) query.getResultList();
			if (list.size() > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
