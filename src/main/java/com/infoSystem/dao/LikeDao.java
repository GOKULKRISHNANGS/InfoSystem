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

import com.infoSystem.entity.LikeEntity;

@Repository
@Transactional
public class LikeDao {

	@PersistenceContext
	private EntityManager entityManager;

	public int voteIssue(LikeEntity likeEntity) {
		LikeEntity likeList = new LikeEntity();
		int response = 0;

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LikeEntity> criteriaQuery = builder.createQuery(LikeEntity.class);
		Root<LikeEntity> root = criteriaQuery.from(LikeEntity.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("issueId"), likeEntity.getIssueId()),
				builder.equal(root.get("createdBy"), likeEntity.getCreatedBy()));
		try {
			likeList = entityManager.createQuery(criteriaQuery).getSingleResult();
			System.out.println(likeList.getIssueId());
			if (likeList.getCreatedBy() == likeEntity.getCreatedBy()) {
				entityManager.remove(likeEntity);
			} else {
				response = castVote(likeEntity);
			}
		} catch (Exception e) {
			response = castVote(likeEntity);
		}
		return response;

	}

	private int castVote(LikeEntity likeEntity) {
		try {
			entityManager.persist(likeEntity);
		} catch (Exception e) {
			return 0;
		}
		return 1;
	}

	public int getTotalVotes(int issueId) {
		List<LikeEntity> likeList = new ArrayList<LikeEntity>();
		int response = 0;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LikeEntity> criteriaQuery = builder.createQuery(LikeEntity.class);
		Root<LikeEntity> root = criteriaQuery.from(LikeEntity.class);
		criteriaQuery.select(root);
		criteriaQuery.where(builder.equal(root.get("issueId"), issueId));
		try {
			likeList = entityManager.createQuery(criteriaQuery).getResultList();
			if (likeList != null) {
				response = likeList.size();
			}
		} catch (Exception e) {

		}
		return response;
	}

}
