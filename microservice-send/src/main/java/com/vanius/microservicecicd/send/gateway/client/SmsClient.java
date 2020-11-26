package com.vanius.microservicecicd.send.gateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.vanius.microservicecicd.send.gateway.json.Message;

@FeignClient(name = "SmsClient", url = "${sms.server.url}", fallbackFactory = SmsClientFallback.class)
public interface SmsClient {

    @PostMapping(value = "/receive")
    void receive(Message message);

}
