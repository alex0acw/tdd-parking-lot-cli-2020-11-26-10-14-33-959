package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingManagerTest {

    @Test
    void should_manager_park_and_fetch_with_specified_managed_parking_boy_park_when_being_asked_to_park_given_multiple_parking_boys() throws NotEnoughParkingSlotException, UnrecognizedParkingTicketException {
        //given
        ParkingManager parkingManager = new ParkingManager(new ParkingLot());
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

    @Test
    void should_manager_not_park_nor_fetch_when_specified_parking_boy_not_managed() throws NotEnoughParkingSlotException, UnrecognizedParkingTicketException {
        //given
        ParkingManager parkingManager = new ParkingManager(new ParkingLot());
        ParkingLot parkingLot = new ParkingLot();
        parkingManager.manage(new ParkingBoy(parkingLot));
        Ticket ticket = parkingLot.park(new Car());
        //when
        Ticket actualTicket = parkingManager.park(new ParkingBoy(parkingLot), new Car());
        Car actualCar = parkingManager.getCarByTicket(new ParkingBoy(parkingLot), ticket);
        //then
        assertNull(actualCar);
        assertNull(actualTicket);
    }

    @Test
    void should_manager_park_or_fetch_car_like_normal_parking_boy() throws NotEnoughParkingSlotException, UnrecognizedParkingTicketException {
        //given
        ParkingManager parkingManager = new ParkingManager(new ParkingLot());
        Car car = new Car();
        //when
        Ticket actualTicket = parkingManager.park(car);
        Car actualCar = parkingManager.getCarByTicket(actualTicket);
        //then
        assertEquals(car, actualCar);
        assertNotNull(actualTicket);
    }

    @Test
    void should_manager_fail_when_park_or_fetch_car_like_normal_parking_boy() {
        //given
        ParkingManager parkingManager = new ParkingManager(new ParkingLot(0));
        //when
        //then
        assertThrows(NotEnoughParkingSlotException.class, () -> parkingManager.park(new Car()));
        assertThrows(UnrecognizedParkingTicketException.class, () -> parkingManager.getCarByTicket(new Ticket()));
    }
}
