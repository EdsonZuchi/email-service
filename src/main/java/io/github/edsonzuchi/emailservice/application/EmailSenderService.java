package io.github.edsonzuchi.emailservice.application;

import io.github.edsonzuchi.emailservice.adapters.EmailSenderGateway;
import io.github.edsonzuchi.emailservice.core.EmailSenderUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailSenderGateway) {
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }

    @Override
    public void sendEmailHtml(String to, String subject, String html) {
        this.emailSenderGateway.sendEmailHtml(to, subject, html);
    }
}
