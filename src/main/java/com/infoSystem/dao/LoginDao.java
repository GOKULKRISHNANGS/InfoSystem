package com.infoSystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.infoSystem.entity.LoginEntity;

@Repository
@Transactional
public class LoginDao {

	@PersistenceContext
	private EntityManager entityManager;

	public String checkUser(LoginEntity loginEntity) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LoginEntity> criteriaQuery = builder.createQuery(LoginEntity.class);
		Root<LoginEntity> root = criteriaQuery.from(LoginEntity.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("userRegistrationNumber"), loginEntity.getUserRegistrationNumber()),
				builder.equal(root.get("userPassword"), loginEntity.getUserPassword()));
		try {
			LoginEntity dataArray = entityManager.createQuery(criteriaQuery).getSingleResult();
			if (dataArray != null) {
				return dataArray.getLoginId()+"";
			} else {
				return "INVALID";
			}
		} catch (Exception e) {
			return "INVALID";
		}
	}

}
