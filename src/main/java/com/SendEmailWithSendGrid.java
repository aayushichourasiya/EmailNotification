package com;

import com.sendgrid.*;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

import java.io.IOException;

public class SendEmailWithSendGrid {

    // SendGrid API Key
    private static final String API_KEY = "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";

    public static void main(String[] args) throws IOException {
    	
    	// Create a SendGrid client with the API key
        SendGrid sendGrid = new SendGrid(API_KEY);
    	
    	SendEmailWithSendGrid s = new SendEmailWithSendGrid();
    	String status = s.sendEmail(sendGrid);
    	System.out.println(status);
    }
    public String sendEmail(SendGrid sendGrid) {
        
        Email from = new Email("chourasiyaaayushi@gmail.com"); // Sender's email
        String subject = "Test Email from SendGrid";
        Email to = new Email("aayushichourasiyaa@gmail.com"); // Recipient's email
        Content content = new Content("text/plain", "This is a test email sent using SendGrid API.");

        Mail mail = new Mail(from, subject, to, content);

        //Request to send the email
        Request request = new Request();
        try {
            // Set the API endpoint and method
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            // Send the email and get the response
            Response response = sendGrid.api(request);
            
            if(response.getStatusCode() >= 200 && response.getStatusCode() <= 202)
            	return "Email sent successfully.";
            
        } catch (IOException ex) {
            System.err.println("Error sending email: " + ex.getMessage());
        }
        return "Failed to send email.";
    }
}
