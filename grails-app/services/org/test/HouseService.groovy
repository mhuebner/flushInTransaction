package org.test

import grails.transaction.Transactional

class HouseService {

    @Transactional
    void deleteHouse(House house) {
        house.delete()
    }

    @Transactional
    void saveHouse() {
        new House(name: UUID.randomUUID()).save()
    }
}
