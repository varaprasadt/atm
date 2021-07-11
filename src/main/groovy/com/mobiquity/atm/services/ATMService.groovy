package com.mobiquity.atm.services

import com.fasterxml.jackson.databind.ObjectMapper
import com.mobiquity.atm.Util.JsonProcessor
import com.mobiquity.atm.models.ATM
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
@Service
class ATMService {

    @Autowired
    RestTemplate restTemplate
    public List<ATM> getATMsInfo(){
        String rawResp=   restTemplate.getForObject('https://www.ing.nl/api/locator/atms/',String.class)
        ObjectMapper objectMapper = new ObjectMapper()
        objectMapper.readValue( JsonProcessor.processJson(rawResp),List<ATM>.class)
    }
}
