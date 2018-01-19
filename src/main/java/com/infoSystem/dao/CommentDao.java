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

import com.infoSystem.entity.CommentEntity;

@Repository
@Transactional
public class CommentDao {

	@PersistenceContext
	private EntityManager entityManager;

	public int postComment(CommentEntity commentEntity) {
		try {
			entityManager.persist(commentEntity);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	public List<CommentEntity> getComments(int issueId) {
		List<CommentEntity> commentList = new ArrayList<CommentEntity>();
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<CommentEntity> criteriaQuery = builder.createQuery(CommentEntity.class);
		Root<CommentEntity> root = criteriaQuery.from(CommentEntity.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("issueId"), issueId));
		try{
			commentList = entityManager.createQuery(criteriaQuery).getResultList();
		} catch(Exception e){
			
		}
		return commentList;
	}

}
