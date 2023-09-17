package io.github.edsonzuchi.emailservice.core;

public interface EmailSenderUseCase {

    void sendEmail(String to, String subject, String body);

    void sendEmailHtml(String to, String subject, String html);
}
