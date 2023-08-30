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
    private final String webhookURL = "https://casinosolutioninteractive.webhook.office.com/webhookb2/828ae674-f70a-4992-baaa-787ed533b464@440eae1c-3369-4397-a12b-1fd4e9b627f9/IncomingWebhook/059d23e5b71640eb94b5311905ba123d/62058810-8a08-459e-a39b-78d828eda230";
    //hamster webhook
    private final String webhookURL2 = "https://casinosolutioninteractive.webhook.office.com/webhookb2/828ae674-f70a-4992-baaa-787ed533b464@440eae1c-3369-4397-a12b-1fd4e9b627f9/IncomingWebhook/8d3807a1c3e444cab1fd661977b21fce/62058810-8a08-459e-a39b-78d828eda230";


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
