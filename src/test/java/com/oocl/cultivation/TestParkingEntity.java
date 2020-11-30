package com.oocl.cultivation;

import com.oocl.cultivation.exceptions.NotEnoughParkingSlotException;
import com.oocl.cultivation.exceptions.UnrecognizedParkingTicketException;
import com.oocl.cultivation.parkingBoys.ParkingBoy;
import com.oocl.cultivation.parkingBoys.ParkingManager;
import com.oocl.cultivation.parkingBoys.SmartParkingBoy;
import com.oocl.cultivation.parkingBoys.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestParkingEntity {
    @Test
    void shouldParkingEntitiesWorks() throws NotEnoughParkingSlotException, UnrecognizedParkingTicketException {
        //given
        List<ParkingEntity> parkingEntityList = new ArrayList<>();
        parkingEntityList.add(new ParkingLot());
        parkingEntityList.add(new ParkingBoy(new ParkingLot()));
        parkingEntityList.add(new SmartParkingBoy(new ParkingLot()));
        parkingEntityList.add(new SuperSmartParkingBoy(new ParkingLot()));
        parkingEntityList.add(new ParkingManager().manage(new ParkingLot()));

        for (ParkingEntity parkingEntity : parkingEntityList) {
            //when
            Car originalCar = new Car();
            Ticket ticket = parkingEntity.park(originalCar);
            Car car = parkingEntity.getCarByTicket(ticket);
            //then
            assertEquals(originalCar, car);
        }

    }
}
