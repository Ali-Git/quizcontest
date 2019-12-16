package com.quiz.contest.repo;

import java.util.List;

import com.quiz.contest.entity.Participant;
import com.quiz.contest.entity.Question;

public interface QuizRepo {
	public List<Question> getQuestions();
	public Participant saveOrUpdateParticipant(Participant participant);
}
