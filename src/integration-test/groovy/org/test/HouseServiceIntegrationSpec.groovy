package org.test

import grails.test.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class HouseServiceIntegrationSpec extends Specification {

    def houseService

    void "house is deleted correctly"() {
        def house = new House(name: 'MySweetHouse').save(flush: true)
        assert House.count() == 1

        when:
        houseService.deleteHouse(house)

        then:
        House.count() == 0
    }

    void "house is saved"() {
        when:
        houseService.saveHouse()

        then:
        House.count() == 1
    }

}
