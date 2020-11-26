package com.vanius.microservicecicd.send.gateway.client;

import feign.hystrix.FallbackFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import com.vanius.microservicecicd.send.gateway.json.Message;

@Component
@Log4j2
public class SmsClientFallback implements FallbackFactory<SmsClient> {
    @Override
    public SmsClient create(Throwable throwable) {
        return new SmsClient() {
            @Override
            public void receive(Message message) {
                log.info("Erro ao enviar o sms:" + throwable.getMessage());
            }
        };
    }
}
