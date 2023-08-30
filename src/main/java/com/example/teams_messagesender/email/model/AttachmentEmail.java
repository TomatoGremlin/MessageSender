package com.example.teams_messagesender.email.model;

import com.example.teams_messagesender.email.model.BasicEmail;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AttachmentEmail extends BasicEmail {
    Map<String, String> attachmentFiles;
}
