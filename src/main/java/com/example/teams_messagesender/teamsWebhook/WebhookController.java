package com.example.teams_messagesender.teamsWebhook;

import com.example.teams_messagesender.teamsWebhook.model.TeamsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/webhook")
public class WebhookController {
    @Autowired
    private TeamsWebhookService teamsWebhookService;
    //cat webhook
    private final String webhookURL = "";
    //hamster webhook
    private final String webhookURL2 = "";


    @PostMapping("/send")
    public ResponseEntity<String> sendMessageToWebhook(@RequestBody TeamsMessage message)  {
        String response = teamsWebhookService.sendToWebhook(webhookURL, message);
        return ResponseEntity.ok(response) ;
    }

    @PostMapping("/sendToMultiple")
    public ResponseEntity<List<String>> sendMessageToMultipleWebhooks(@RequestBody TeamsMessage message)  {
        List<String> webhookURLs = Arrays.asList(webhookURL, webhookURL2);
        List<String> responses = teamsWebhookService.sendToMultipleWebhooks(webhookURLs, message);
        return ResponseEntity.ok(responses) ;
    }
}
