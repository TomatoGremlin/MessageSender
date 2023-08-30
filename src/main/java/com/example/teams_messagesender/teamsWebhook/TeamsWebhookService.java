package com.example.teams_messagesender.teamsWebhook;

import com.example.teams_messagesender.teamsWebhook.model.TeamsMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamsWebhookService {
    @Autowired
    private RestTemplate restTemplate;

    public String sendToWebhook(String webhookURL, TeamsMessage simpleMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<TeamsMessage> requestEntity = new HttpEntity<>(simpleMessage, headers);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(webhookURL, requestEntity, String.class);
        return responseEntity.getBody();
    }

    public List<String> sendToMultipleWebhooks(List<String> webhookURLsList, TeamsMessage simpleMessage) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<TeamsMessage> requestEntity = new HttpEntity<>(simpleMessage, headers);
        List<String> requestResponses = new ArrayList<>();
        for (String webhookURL: webhookURLsList) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(webhookURL, requestEntity, String.class);
            requestResponses.add(responseEntity.getBody());
        }
        return requestResponses;
    }


}
