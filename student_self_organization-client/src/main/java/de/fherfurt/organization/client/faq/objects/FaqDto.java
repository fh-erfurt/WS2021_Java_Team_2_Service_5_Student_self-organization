package de.fherfurt.organization.client.faq.objects;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FaqDto {

    private int id = 0;
    private String title;
    private String content;
    private String author;
}
