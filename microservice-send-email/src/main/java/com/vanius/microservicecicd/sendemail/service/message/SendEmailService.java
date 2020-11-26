package com.vanius.microservicecicd.sendemail.service.message;

import org.springframework.stereotype.Service;

import com.vanius.microservicecicd.sendemail.gateway.json.Message;

import java.util.UUID;

@Service
public class SendEmailService {

    private static final String identificador = UUID.randomUUID().toString();
    private static int cont = 0;

    public void execute(Message message) throws InterruptedException {
       // Thread.sleep(2000);
        cont++;
        System.out.println("Instância " + identificador + ", Mensagem: " + cont + ", Enviando email para: " + message.getClient());
    }
}
