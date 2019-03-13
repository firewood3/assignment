package com.firewood.assign01rest.word.service;

import com.firewood.assign01rest.word.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class WordService {

    private final MessageSource messageSource;

    @Autowired
    public WordService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public Optional<Word> getMessage(String key, String language) {
        try {
            return Optional.of(new Word(key, language, messageSource.getMessage(key, null, new Locale(language))));
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }
}
