package com.vanius.microservicecicd.send.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.vanius.microservicecicd.send.gateway.json.Message;

@FeignClient(name = "EmailClient", url = "${email.server.url}", fallbackFactory = EmailClientFallback.class)
public interface EmailClient {

    @PostMapping(value = "/receive")
    void receive(Message message);

}
