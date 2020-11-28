package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperSmartParkingBoyTest {

    @Test
    void should_parking_boy_park_to_parking_lot_with_larger_proportion_of_spaces_given_two_parking_lot_of_different_proportion_of_spaces() throws UnrecognizedParkingTicketException, NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        parkingLot.park(new Car());
        ParkingLot relativelyMoreSpaceParkingLot = new ParkingLot(1);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();
        superSmartParkingBoy.addParkingLot(relativelyMoreSpaceParkingLot);
        Car car = new Car();

        //when
        Ticket ticket = superSmartParkingBoy.park(car);
        Car actual = relativelyMoreSpaceParkingLot.getCarByTicket(ticket);
        //then
        assertEquals(car, actual);
    }
}
