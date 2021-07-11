package com.mobiquity.atm.controllers

import com.mobiquity.atm.services.ATMService
import spock.lang.Specification

class ControllerTest extends Specification {

    ATMService atmService
    Controller controller
    def setup(){
        atmService=Mock(ATMService)
        controller=new Controller(atmService: atmService)
    }

    def 'it should return respnose'(){
        given:
        atmService.getATMsInfo()>>[]
        when:
        def res=controller.getAtmBy(city)
        then:
        null != res
        where:
        city|_
        null|_
        'test'|_

    }

}
