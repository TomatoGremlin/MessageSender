package com.example.teams_messagesender.teamsWebhook.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class TeamsMessage {
    final String type = "MessageCard";
    final String context = "http://schema.org/extensions";
    String themeColor = "A2678A";
    String title;
    String text;

}
