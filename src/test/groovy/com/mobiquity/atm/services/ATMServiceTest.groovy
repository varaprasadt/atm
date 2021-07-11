package com.mobiquity.atm.services

import com.mobiquity.atm.controllers.Controller
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class ATMServiceTest extends Specification {
    ATMService atmService
    RestTemplate restTemplate
    def setup(){
        restTemplate = Mock(RestTemplate)
        atmService=new ATMService(restTemplate:restTemplate)
    }



    def "it should get Atms"() {
        given:
        restTemplate.getForObject(_,_)>>res
        when:
        def result = atmService.getATMsInfo()
        then:
       result.size()==2
        where:
        res|exp
        '''
       ])}',
[{"address":{"street":"Dr. Plesmanlaan","housenumber":"162A","postalcode":"3601 DE","city":"Maarssen","geoLocation":{"lat":"52.143335","lng":"5.045388"}},"distance":0,"openingHours":[{"dayOfWeek":2,"hours":[{"hourFrom":"07:00","hourTo":"23:00"}]},{"dayOfWeek":3,"hours":[{"hourFrom":"07:00","hourTo":"23:00"}]},{"dayOfWeek":4,"hours":[{"hourFrom":"07:00","hourTo":"23:00"}]},{"dayOfWeek":5,"hours":[{"hourFrom":"07:00","hourTo":"23:00"}]},{"dayOfWeek":6,"hours":[{"hourFrom":"07:00","hourTo":"23:00"}]},{"dayOfWeek":7,"hours":[{"hourFrom":"07:00","hourTo":"23:00"}]},{"dayOfWeek":1,"hours":[{"hourFrom":"07:00","hourTo":"23:00"}]}],"functionality":"Geldautomaat","type":"GELDMAAT"},{"address":{"street":"Dalipassage","housenumber":"59","postalcode":"7811 DA","city":"Emmen","geoLocation":{"lat":"52.78185","lng":"6.894098"}},"distance":0,"openingHours":[{"dayOfWeek":2,"hours":[]},{"dayOfWeek":3,"hours":[]},{"dayOfWeek":4,"hours":[]},{"dayOfWeek":5,"hours":[]},{"dayOfWeek":6,"hours":[]},{"dayOfWeek":7,"hours":[]},{"dayOfWeek":1,"hours":[]}],"functionality":"Geld storten en opnemen","type":"GELDMAAT"}]
        '''|_

    }

    def "it should get encode paassword"(){
        given:
        String samplePwd='admin'
        when:
        String ePwd=new BCryptPasswordEncoder().encode(samplePwd)
        then:
        null!=ePwd
    }
}
