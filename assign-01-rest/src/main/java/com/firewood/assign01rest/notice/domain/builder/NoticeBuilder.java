package com.firewood.assign01rest.notice.domain.builder;

import com.firewood.assign01rest.notice.domain.Notice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoticeBuilder {

    private String title;
    private String content;

    public Notice build() {
        return new Notice(title, content);
    }

}
