package com.vanius.microservicecicd.send.service.message;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vanius.microservicecicd.send.enums.TypeMessageEnum;
import com.vanius.microservicecicd.send.gateway.client.EmailClient;
import com.vanius.microservicecicd.send.gateway.client.SmsClient;
import com.vanius.microservicecicd.send.gateway.json.Message;

@Log4j2
@Service
public class ResendMessageService {

    @Autowired
    private SmsClient smsClient;

    @Autowired
    private EmailClient emailClient;

    public void execute(Message message) {

        log.info("Reenviando mensagem: " + message.getType());

        if (TypeMessageEnum.EMAIL.toString().equals(message.getType())) {
            emailClient.receive(message);
        } else if (TypeMessageEnum.SMS.toString().equals(message.getType())) {
            smsClient.receive(message);
        }
    }

}
