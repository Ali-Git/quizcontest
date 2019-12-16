package com.quiz.contest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.contest.UIQuestion;
import com.quiz.contest.entity.Participant;
import com.quiz.contest.service.QuizService;

@RestController
@RequestMapping("/api")
public class QuizController {

	@Autowired
	private QuizService quizService;

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.GET, value = "/questions", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UIQuestion> getQuestions() {
		return quizService.getQuestions();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.POST, value = "/saveorupdate/participant", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Participant insertParticipant(@RequestBody Participant participant) {
		return quizService.saveOrUpdateParticipant(participant);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(method = RequestMethod.GET, value = "/answers", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Integer> getAnswers() {
		return quizService.getAnswers();
	}

}
