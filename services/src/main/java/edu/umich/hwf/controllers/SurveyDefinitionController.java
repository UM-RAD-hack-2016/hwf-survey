package edu.umich.hwf.controllers;

import edu.umich.hwf.domain.AnswerType;
import edu.umich.hwf.domain.Survey;
import edu.umich.hwf.domain.SurveyQuestion;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static edu.umich.hwf.domain.SurveyQuestion.*;

@RestController
@RequestMapping("/survey-definition")
public class SurveyDefinitionController {

    @RequestMapping
    @ResponseStatus(HttpStatus.OK)
    public Survey getSurveyDefinition() {
        Survey survey = new Survey();

        survey.getQuestions().add(new SurveyQuestion("Would you attend Hacks with Friends next year?",
                AnswerType.BUTTONS,
                new ArrayList<String>() {{
                    add(ANSWER_YES);
                    add(ANSWER_NO);
        }}));

        survey.getQuestions().add(new SurveyQuestion("How would you rate your overall experience at Hacks with Friends?",
                AnswerType.BUTTONS_VERTICAL,
                new ArrayList<String>() {{
                    add(ANSWER_EXTREMELY_LOW);
                    add(ANSWER_LOW);
                    add(ANSWER_AVERAGE);
                    add(ANSWER_ABOVE_AVERAGE);
                    add(ANSWER_EXTREMELY_HIGH);
        }}));

        survey.getQuestions().add(new SurveyQuestion("Did you learn something that could be useful at your present job?",
                AnswerType.BUTTONS,
                new ArrayList<String>() {{
                    add(ANSWER_YES);
                    add(ANSWER_NO);
        }}));

        survey.getQuestions().add(new SurveyQuestion("What could we do to improve Hacks with Friends next year?", AnswerType.TEXTAREA));

        survey.getQuestions().add(new SurveyQuestion("Other feedback or comments?", AnswerType.TEXTAREA));

        return survey;
    }
}