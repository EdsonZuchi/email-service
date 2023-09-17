package io.github.edsonzuchi.emailservice.adapters;

public interface EmailSenderGateway {

    void sendEmail(String to, String subject, String body);

    void sendEmailHtml(String to, String subject, String html);
}
