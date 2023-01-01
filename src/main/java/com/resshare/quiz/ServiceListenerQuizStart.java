package com.resshare.quiz;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.resshare.quiz.services.AddSubjectListener;
import com.resshare.quiz.services.AnswerListener;
import com.resshare.quiz.services.CommitTotalAnswerListener;
import com.resshare.quiz.services.ImportQuessionListener;
import com.resshare.quiz.services.LoadGetListQuestionListener;
import com.resshare.quiz.services.grade.DashboardGradeCfgListener;
import com.resshare.quiz.services.grade.FormOptionCfgGradeListener;
import com.resshare.quiz.services.grade.LoadFormQuizGeneralListener;
import com.resshare.quiz.services.topic.LoadFormQuizTopicGeneralListener;

@SpringBootApplication // (scanBasePackages = { "com.websystique.springboot" }) // same as
						// @Configuration
						// @EnableAutoConfiguration @ComponentScan
						// combined
public class ServiceListenerQuizStart {

	public static void startListener() {

		LoadFormQuizGeneralListener loadFormInformaticsListener = new LoadFormQuizGeneralListener();
		loadFormInformaticsListener.onStart();
		LoadGetListQuestionListener loadFormInformaticsListener1 = new LoadGetListQuestionListener();
		loadFormInformaticsListener1.onStart();

		AnswerListener loadFormInformaticsListener2 = new AnswerListener();
		loadFormInformaticsListener2.onStart();

		CommitTotalAnswerListener loadFormInformaticsListener3 = new CommitTotalAnswerListener();
		loadFormInformaticsListener3.onStart();

		DashboardGradeCfgListener loadFormInformaticsListenerGradeCfg = new DashboardGradeCfgListener();
		loadFormInformaticsListenerGradeCfg.onStart();
		FormOptionCfgGradeListener loadFormInformaticsListenerGradeCfg2 = new FormOptionCfgGradeListener();
		loadFormInformaticsListenerGradeCfg2.onStart();

		LoadFormQuizTopicGeneralListener loadFormQuizTopicGeneralListener = new LoadFormQuizTopicGeneralListener();
		loadFormQuizTopicGeneralListener.onStart();

		ImportQuessionListener importQuessionListener = new ImportQuessionListener();
		importQuessionListener.onStart();

		AddSubjectListener addSubjectListener = new AddSubjectListener();
		addSubjectListener.onStart();

		// BookService bookService = new BookService();
		// bookService.onStart();

	}

}
