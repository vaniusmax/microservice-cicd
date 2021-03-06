package com.vanius.microservicecicd.sendemail.gateway.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vanius.microservicecicd.sendemail.gateway.json.Message;
import com.vanius.microservicecicd.sendemail.service.message.SendEmailService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class MessageResource {

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping(value = "/receive")
    public void receive(@RequestBody @Valid @NotNull Message message) throws InterruptedException {
        sendEmailService.execute(message);
    }

}
