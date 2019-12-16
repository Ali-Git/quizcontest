package com.quiz.contest.repo;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quiz.contest.UIQuestion;
import com.quiz.contest.entity.Participant;
import com.quiz.contest.entity.Question;

@Repository
@Transactional
public class QuizRepoImpl implements QuizRepo {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Question> getQuestions() {

		Session session = null;
		List<Question> list=null;
		try {
			session = sessionFactory.openSession();
			//Question ques1 = (Question) session.get(Question.class, new Integer(1));
			//Question ques5 = (Question) session.get(Question.class, new Integer(5));
			MultiIdentifierLoadAccess<Question> multiLoadAccess = session.byMultipleIds(Question.class);
			list = multiLoadAccess.multiLoad(new Integer(6),
					new Integer(2),new Integer(3), new Integer(4),
					new Integer(5),new Integer(1), new Integer(7),
					new Integer(8),new Integer(9), new Integer(10));

			
			//list = session.createCriteria(Question.class).list();
		} finally {
			session.close();
		}

		return list;
	}
	
	public Participant saveOrUpdateParticipant(Participant participant) {
		Session session = null;
		Transaction tx = null;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(participant);
			session.flush();
			System.out.println("participant inserted !!");
		} finally {
			tx.commit();
			session.close();
		}
		return participant;
	}

}

/*
 * 
 * 
 * 
 * */
