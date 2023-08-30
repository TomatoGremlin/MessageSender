package com.example.teams_messagesender.email;

import com.example.teams_messagesender.email.model.AttachmentEmail;
import com.example.teams_messagesender.email.model.BasicEmail;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private  EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<BasicEmail> sendEmail(@RequestBody BasicEmail basicEmail) throws MessagingException {
        BasicEmail sentBasicEmail = emailService.sendEmail(basicEmail);
        return ResponseEntity.ok(sentBasicEmail) ;
    }

    @PostMapping("/sendWithAttachment")
    public ResponseEntity<AttachmentEmail> sendEmailWithAttachment(@RequestBody AttachmentEmail email) throws MessagingException {
        AttachmentEmail sentEmail = emailService.sendMailWithAttachment(email);
        return ResponseEntity.ok(sentEmail) ;
    }
}
