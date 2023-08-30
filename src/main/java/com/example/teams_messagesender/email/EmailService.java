package com.example.teams_messagesender.email;

import com.example.teams_messagesender.email.model.AttachmentEmail;
import com.example.teams_messagesender.email.model.BasicEmail;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;
    //the seTo() method accepts a String array of the recipients
    public BasicEmail sendEmail(BasicEmail basicEmail) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(basicEmail.getTo());
        helper.setSubject(basicEmail.getSubject());
        helper.setText(basicEmail.getText());

        mailSender.send(message);
        return basicEmail;
    }
    //the attachment(s) are stored in a map in the attachment email object - file name : location
    public AttachmentEmail sendMailWithAttachment(AttachmentEmail attachmentEmail) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(attachmentEmail.getTo());
        helper.setSubject(attachmentEmail.getSubject());
        helper.setText(attachmentEmail.getText());
        for ( Map.Entry<String,String> entry : attachmentEmail.getAttachmentFiles().entrySet() ) {
            helper.addAttachment(entry.getKey(), new File(entry.getValue()));
        }
        mailSender.send(message);
        return attachmentEmail;
    }
}
