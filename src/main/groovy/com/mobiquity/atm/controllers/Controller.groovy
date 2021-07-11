package com.mobiquity.atm.controllers

import com.mobiquity.atm.models.ATM
import com.mobiquity.atm.services.ATMService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {
    @Autowired
    ATMService atmService

    @GetMapping('/atms')
    public ResponseEntity<Object> getAtmBy(@RequestParam(value = "city",required = false) String city ){
        List<ATM> list= atmService.getATMsInfo()
        ResponseEntity.ok( city?list.findAll {it.address.city== city}:list);
    }
}
