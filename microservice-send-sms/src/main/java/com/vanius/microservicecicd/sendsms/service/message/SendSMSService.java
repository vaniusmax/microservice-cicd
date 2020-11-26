package com.vanius.microservicecicd.sendsms.service.message;

import org.springframework.stereotype.Service;

import com.vanius.microservicecicd.sendsms.gateway.json.Message;

import java.util.UUID;

@Service
public class SendSMSService {

    private static final String identificador = UUID.randomUUID().toString();
    private static int cont = 0;

    public void execute(Message message) throws InterruptedException {
       // Thread.sleep(2000);
        cont++;
        System.out.println("Instância " + identificador + ", Mensagem: " + cont + ", Enviando sms para: " + message.getClient());
    }

}
