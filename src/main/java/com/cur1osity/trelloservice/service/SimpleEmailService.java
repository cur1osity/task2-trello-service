package com.cur1osity.trelloservice.service;

import com.cur1osity.trelloservice.domain.Mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    private JavaMailSender javaMailSender;

    private SimpleMailMessage createMailMessage(final Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        if (mail.getToCc() != null) {
            mailMessage.setCc(mail.getToCc());
        }

        return mailMessage;
    }
    public void send(final Mail mail) {
        LOGGER.info("Starting email preparation...");
        LOGGER.info("Email send to: " + mail.getMailTo());
        LOGGER.info("CC send to: " + mail.getToCc());
        LOGGER.info("Email subject: " + mail.getSubject());
        LOGGER.info("Email message: " + mail.getMessage());
        try {
            SimpleMailMessage mailMessage = createMailMessage(mail);
            javaMailSender.send(mailMessage);
            LOGGER.info("Email has been sent");
        } catch (MailException e) {
            LOGGER.error("Failed to process email sending: ", e.getMessage(), e);
        }
    }
}
