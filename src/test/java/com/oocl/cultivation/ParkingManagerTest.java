package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ParkingManagerTest {

    @Test
    void should_manager_park_and_fetch_with_specified_managed_parking_boy_park_when_being_asked_to_park_given_multiple_parking_boys() throws NotEnoughParkingSlotException, UnrecognizedParkingTicketException {
        //given
        ParkingManager parkingManager = new ParkingManager();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingManager.manage(parkingBoy);
        parkingManager.manage(new ParkingBoy(new ParkingLot()));
        Car car = new Car();
        //when
        Ticket ticket = parkingManager.park(parkingBoy, car);
        Car actual = parkingManager.getCarByTicket(parkingBoy, ticket);
        //then
        assertEquals(car, actual);
    }
}
