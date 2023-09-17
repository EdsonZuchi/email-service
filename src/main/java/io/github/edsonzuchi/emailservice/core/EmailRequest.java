package io.github.edsonzuchi.emailservice.core;

public record EmailRequest(String to, String subject, String body) {
}
