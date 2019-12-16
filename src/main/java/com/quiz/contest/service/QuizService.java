package com.quiz.contest.service;

import java.util.List;

import com.quiz.contest.UIQuestion;
import com.quiz.contest.entity.Participant;

public interface QuizService {

	public List<UIQuestion> getQuestions();

	public Participant saveOrUpdateParticipant(Participant participant);
	
	public List<Integer> getAnswers();
}
