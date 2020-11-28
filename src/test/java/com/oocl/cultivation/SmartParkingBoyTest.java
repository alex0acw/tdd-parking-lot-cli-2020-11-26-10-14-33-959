package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SmartParkingBoyTest {
    @Test
    void should_smart_parking_boy_park_to_parking_lot_with_more_empty_positions_given_two_parking_lot_with_different_remaining_spaces() throws UnrecognizedParkingTicketException, NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot largerParkingLot = new ParkingLot(2);
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        smartParkingBoy.addParkingLot(largerParkingLot);
        Car car = new Car();

        //when
        Ticket ticket = smartParkingBoy.park(car);
        Car actual = largerParkingLot.getCarByTicket(ticket);
        //then
        assertEquals(car, actual);
    }

    @Test
    void should_smart_parking_throw_exception_given_parking_lots_with_no_spaces() throws NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot1 = new ParkingLot(1);
        parkingLot.park(new Car());
        parkingLot1.park(new Car());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLot);
        smartParkingBoy.addParkingLot(parkingLot1);

        //when
        //then
        NotEnoughParkingSlotException actual = assertThrows(NotEnoughParkingSlotException.class, () -> smartParkingBoy.park(new Car()));
        assertEquals("Not enough position.", actual.getMessage());
    }
}
