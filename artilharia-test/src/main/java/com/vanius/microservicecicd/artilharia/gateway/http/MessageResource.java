package com.vanius.microservicecicd.artilharia.gateway.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vanius.microservicecicd.artilharia.service.message.AttackService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class MessageResource {

    @Autowired
    private AttackService resendMessageService;
	private Logger log = LoggerFactory.getLogger(MessageResource.class);

    @GetMapping(value = "/attack/{qtd}")
    public void attack(@PathVariable("qtd") String qtd) {
        log .info("Recebendo request de attack.");

        resendMessageService.execute(Integer.parseInt(qtd));
    }

}
