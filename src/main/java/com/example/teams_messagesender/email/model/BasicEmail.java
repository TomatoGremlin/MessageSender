package com.example.teams_messagesender.email.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BasicEmail {
    String[] to;
    String subject;
    String text;
}