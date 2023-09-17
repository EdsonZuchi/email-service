package io.github.edsonzuchi.emailservice.controller;

import io.github.edsonzuchi.emailservice.application.EmailSenderService;
import io.github.edsonzuchi.emailservice.core.EmailRequest;
import io.github.edsonzuchi.emailservice.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;

    @Autowired
    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/text")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest request){
        try{
            emailSenderService.sendEmail(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("Email sent successfully");
        }catch (EmailServiceException exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while sending email");
        }
    }

    @PostMapping("/html")
    public ResponseEntity<String> sendEmailHtml(@RequestBody EmailRequest request){
        try{
            emailSenderService.sendEmailHtml(request.to(), request.subject(), request.body());
            return ResponseEntity.ok("Email sent successfully");
        }catch (EmailServiceException exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Errir while sending email");
        }
    }


}
