package com.firewood.assign01rest.word.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Word {
    private String key;
    private String word;
    private String language;
}
