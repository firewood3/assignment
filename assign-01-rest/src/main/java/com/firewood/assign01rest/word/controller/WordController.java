package com.firewood.assign01rest.word.controller;

import com.firewood.assign01rest.word.domain.Word;
import com.firewood.assign01rest.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/word")
public class WordController {

    private final WordService wordService;

    @Autowired
    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping(value = "/{language}/{key}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Word> getWord(@PathVariable String language,
                                         @PathVariable String key) {
        return wordService
                .getMessage(key, language)
                .map(word -> new ResponseEntity(word, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.BAD_REQUEST));
    }
}
