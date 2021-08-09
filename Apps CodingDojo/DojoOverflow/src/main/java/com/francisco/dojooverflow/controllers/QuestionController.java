package com.francisco.dojooverflow.controllers;

import com.francisco.dojooverflow.models.Answer;
import com.francisco.dojooverflow.models.Question;
import com.francisco.dojooverflow.models.Tag;
import com.francisco.dojooverflow.services.AnswerService;
import com.francisco.dojooverflow.services.QuestionService;
import com.francisco.dojooverflow.services.TagService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class QuestionController {
    private final QuestionService questionService;
    private final TagService tagService;
    private final AnswerService answerService;

    public QuestionController(QuestionService questionService, TagService tagService, AnswerService answerService) {
        this.questionService = questionService;
        this.tagService = tagService;
        this.answerService = answerService;
    }

    @RequestMapping("/questions")
    public String questions(
            @ModelAttribute("question") Question question, Model model) {
        List<Question> questions = questionService.allQuestions();
        model.addAttribute("questions",questions );
        return "/questionsDashboard.jsp";
    }

    @GetMapping("/questions/new")
    public String newQuestion(
            @ModelAttribute("questions") Question question ){
        return "/newQuestion.jsp";
    }

    @PostMapping("/questions/new")
    public String addQuestion(
            @RequestParam(value = "tgs") String tag,
            @Valid
            @ModelAttribute("questions") Question question, BindingResult result)
            {
        if (result.hasErrors()){
            System.out.println(result.getAllErrors());
            return "/newQuestion.jsp";
        }
        else{
            questionService.createQuestion(question);//guardar pregunta
            String[] tg = new String[3];// numero de palabras
            tg = tag.split(",");//separa con comas las cositas
            for (String string: tg) {//for mamadisimo
                string.toLowerCase();//convierte los tag a chiquitos
                string = string.trim();// borra los espacios de los costados
                if(tagService.findTag(string) == null){
                    Tag t = new Tag(string);
                    tagService.createTag(t);//si el tag no existe te la crea By Saimon :)
                }
                    question.setTags(tagService.findTag(string));
//                question.getTags().add(tagService.findTag(string));// esto hace lo mismo que lo del model By Saimon >:c
            }
            questionService.createQuestion(question);//guardar pregunta c:
            return "redirect:/questions/";
        }
    }

    @GetMapping("/questions/{id}")
    public String showQuestion(
            @PathVariable("id") Long id, Model model,
            @ModelAttribute("answer") Answer answer) {
        Question questions = questionService.findQuestion(id);
        List<Tag> tags = questions.getTags();//obtener listas
        List<Answer> answers = questions.getAnswers();//obtener listas
        model.addAttribute("questions", questions);
        model.addAttribute("tags",tags);
        model.addAttribute("answers",answers);
        return "/questionsProfile.jsp";
    }
    @PostMapping("/questions/{idQ}")
    public String answer(
            @PathVariable("idQ")Long idQ,
            @Valid
            @ModelAttribute("answer") Answer answer, BindingResult result) {
        Question question = questionService.findQuestion(idQ);
        if (result.hasErrors()) {
            return "/questionsProfile.jsp";
        } else {
            answer = answerService.createAnswer(answer);
            answer.setQuestion(question);
            answerService.createAnswer(answer);//guardar respuesta
            return "redirect:/questions/"+question.getId();
        }
    }
}


