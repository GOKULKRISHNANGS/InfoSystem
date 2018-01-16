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

import com.infoSystem.entity.IssueEntity;
import com.infoSystem.entity.UserEntity;

@Repository
@Transactional
public class IssueDao {

	@PersistenceContext
	private EntityManager entityManager;

	public List<IssueEntity> getIssues() {
		List<IssueEntity> issueList = new ArrayList<IssueEntity>();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<IssueEntity> criteriaQuery = builder.createQuery(IssueEntity.class);
		Root<IssueEntity> root = criteriaQuery.from(IssueEntity.class);
		criteriaQuery.select(root);
		issueList = entityManager.createQuery(criteriaQuery).getResultList();
		return issueList;
	}
	
	public String getName(int userId) {
		UserEntity userEntity = new UserEntity();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserEntity> criteriaQuery = builder.createQuery(UserEntity.class);
		Root<UserEntity> root = criteriaQuery.from(UserEntity.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("userId"), userId));
		userEntity = entityManager.createQuery(criteriaQuery).getSingleResult();
		String userName = userEntity.getUserFirstName()+"_"+userEntity.getUserLastName();
		return userName;
	}

	public int postIssue(IssueEntity issueEntity) {
		try {
			entityManager.persist(issueEntity);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

}
