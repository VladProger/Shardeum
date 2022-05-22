package com.shardeum.controller;

import com.shardeum.dto.SearchByMessageResponse;
import com.shardeum.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/faq")
public class FaqController {

    private final FaqService faqService;

    @GetMapping("by-message/{message}")
    public SearchByMessageResponse findAnswerByMessage(String message){
        return faqService.findAnswerByMessage(message);
    }

    @GetMapping("by-id/{id}")
    public String findAnswerById(Integer id){
        return faqService.findAnswerById(id);
    }
}
