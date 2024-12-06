package com.example.propra2proj.Controller;

import com.example.propra2proj.MultipleChoiceQuestion;
import com.example.propra2proj.Question;
import com.example.propra2proj.Test_Exam;
import com.example.propra2proj.Text_Question;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrganiserController {

    private int numberOfTextQuestions;
    private int numberOfMultipleChoiceQuestions;

    @PostMapping("/Organiser/step1")
    public String step1(
            @RequestParam int numberOfTextQuestions,
            @RequestParam int numberOfMultipleChoiceQuestions,
            Model model) {
        this.numberOfTextQuestions = numberOfTextQuestions;
        this.numberOfMultipleChoiceQuestions = numberOfMultipleChoiceQuestions;
        model.addAttribute("numberOfTextQuestions", numberOfTextQuestions);
        model.addAttribute("numberOfMultipleChoiceQuestions", numberOfMultipleChoiceQuestions);
        return "Organiser/exam_forms";
    }

    @PostMapping("/saveExam")
    public String saveExam(
            @RequestParam(value = "textQuestions", required = false) List<String> textQuestions,
            @RequestParam(value = "sampleAnswers", required = false) List<String> sampleAnswers,
            @RequestParam(value = "mcQuestions", required = false) List<String> mcQuestions,
            @RequestParam(value = "options", required = false) List<List<String>> options,
            @RequestParam(value = "correctAnswers", required = false) List<Integer> correctAnswers
            ,@RequestParam(value="textQuestionScore", required = false) List< Integer> textQuestionScore,
            @RequestParam (value="questionScore", required = false) List<Integer> questionScore,
            Model model) {
        List<Question> questions = new ArrayList<>();
        int totalScoreMultipleChoice=0;
        int totalScoreText=0;
        if (textQuestions != null) {

            for (int i = 0; i < numberOfTextQuestions; i++) {
                questions.add(new Text_Question(textQuestions.get(i), sampleAnswers.get(i), textQuestionScore.get(i) ));
            totalScoreText += textQuestionScore.get(i);
            }
        }

        if (mcQuestions != null) {

            for (int i = 0; i < numberOfMultipleChoiceQuestions; i++) {
                questions.add(new MultipleChoiceQuestion(
                        mcQuestions.get(i),
                         correctAnswers.get(i).toString(),options.get(i), questionScore.get(i)
                ));
            totalScoreMultipleChoice=totalScoreMultipleChoice+questionScore.get(i);
            }
        }

        Test_Exam testExam = new Test_Exam(
                numberOfTextQuestions + numberOfMultipleChoiceQuestions,
                questions, totalScoreMultipleChoice+totalScoreText
        );

        System.out.println("Test Created: " + testExam);

        return "redirect:/Organiser/organiser_dashboard";
    }

    @GetMapping("/Organiser/create_exams")
    public String showCreateExamsForm() {
        return "Organiser/create_exams";
    }

    @GetMapping("/Organiser/exam_forms")
    public String showExamForms(Model model) {
        model.addAttribute("numberOfTextQuestions", numberOfTextQuestions);
        model.addAttribute("numberOfMultipleChoiceQuestions", numberOfMultipleChoiceQuestions);
        return "Organiser/exam_forms";
    }




}

