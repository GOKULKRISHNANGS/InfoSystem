package com.infoSystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.infoSystem.entity.UserEntity;

@Repository
@Transactional
public class UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void createUser(UserEntity user) {
		entityManager.persist(user);
	}

	public UserEntity getUser(String registrationNumber) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
		Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("userRegistrationNumber"), registrationNumber));
		UserEntity userEntity = entityManager.createQuery(criteriaQuery).getSingleResult();
		return userEntity;
	}

	public List<UserEntity> getStudents() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
		Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("roleTxt"), "student"));
		List<UserEntity> userEntity = entityManager.createQuery(criteriaQuery).getResultList();
		return userEntity;
	}

}
