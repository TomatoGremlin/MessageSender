# MessageSender

Helps send basic emails and basic messages to teams channels through a webhook.

## Includes:

- Models for email (basic and with attachments) and a teams message 
- Config for the email client
- Services for the sending
- (+ Controllers I used to test sending stuff)


## Note

The config for the email client has to have specified inside it:
- host
- port
- email username
- email password

You have the option available to send one email to multiple recipients and one message to multiple webhooks.
The email model has an array for the recipients so even if you want to send to only one person
it still has to be inside an array.

## Gmail

If you use your gmail account and don't want to use your password directly:
- go to your [google account security settings](https://myaccount.google.com/security)
-  have two-way verification enabled 
- in the two-way verification section at the very bottom you should see the option for app password
- there you can generate a unique pass to use here

## Creating a webhook

Tutorial:
- Click on "..." (more options) in the top right corner of the teams channel
- Select "Connectors"
- Search for "Incoming Webhook" then click "Configure"
- Name your webhook and select a pic for it
- After creating you will get its URL 
- You will use it to send the messages as it's an api path