package com.example.demo.comtrollers;

import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuetionsController {
    @Autowired
    private QuestionRepository quetionRepository;

    @GetMapping("/quetions")
    public Page<Question> getQuestions(Pageable pageable){
        return quetionRepository.findAll(pageable);
    }

    @PostMapping
    public  Question createQuestion(@Valid @RequestBody Question question){
        return quetionRepository.save(question);
    }

    @PutMapping("/quetions/{quetionId}")
    public Question updateQuestions(@PathVariable Long questins,
                                    @Valid @RequestBody Question questionRequest){
        return quetionRepository.findById(questinId)
                .map(question-> {
                    question.setTitle(questionRequest.getTitle());
                    question
                }).orElseThrow(() -> new ResourceNotFoundException("Question not found with id" + questionId));
    }
}
