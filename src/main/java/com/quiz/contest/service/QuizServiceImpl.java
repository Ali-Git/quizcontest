package com.quiz.contest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.contest.UIQuestion;
import com.quiz.contest.entity.Participant;
import com.quiz.contest.entity.Question;
import com.quiz.contest.repo.QuizRepo;

@Service
public class QuizServiceImpl implements QuizService {

	
	private List<Integer> answerList = new ArrayList<>();
	
	@Autowired
	private QuizRepo quizRepo;
	
	@Override
	public List<UIQuestion> getQuestions() {

		List<UIQuestion> uiQuestionList = new ArrayList<>();
		List<Question> list = quizRepo.getQuestions();
		int i=0;
		for(Question qn: list) {
			UIQuestion  uiQuestion = new UIQuestion();
			uiQuestion.setQnID(qn.getQnID());
			uiQuestion.setQn(qn.getQn());
			uiQuestion.setImageName(qn.getImageName());
			uiQuestion.setOptions(new String[] {qn.getOption1(), qn.getOption2(), qn.getOption3(), qn.getOption4()});
			answerList.add(qn.getAnswer());
			uiQuestion.setCorrectAnswer(qn.getAnswer());
			uiQuestionList.add(uiQuestion);
		}
		return uiQuestionList;
	}

	@Override
	public Participant saveOrUpdateParticipant(Participant participant) {
		return quizRepo.saveOrUpdateParticipant(participant);
	}

	@Override
	public List<Integer> getAnswers() {
		return answerList;
	}

	
}
