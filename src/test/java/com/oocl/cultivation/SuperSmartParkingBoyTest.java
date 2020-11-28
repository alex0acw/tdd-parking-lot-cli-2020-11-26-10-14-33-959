package com.oocl.cultivation;

import com.oocl.cultivation.exceptions.NotEnoughParkingSlotException;
import com.oocl.cultivation.exceptions.UnrecognizedParkingTicketException;
import com.oocl.cultivation.parkingBoys.SuperSmartParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SuperSmartParkingBoyTest {

    @Test
    void should_super_smart_parking_boy_park_to_parking_lot_with_larger_proportion_of_spaces_given_two_parking_lot_of_different_proportion_of_spaces() throws UnrecognizedParkingTicketException, NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot(10);
        parkingLot.park(new Car());
        ParkingLot relativelyMoreSpaceParkingLot = new ParkingLot(1);

        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot);
        superSmartParkingBoy.addParkingLot(relativelyMoreSpaceParkingLot);
        Car car = new Car();

        //when
        Ticket ticket = superSmartParkingBoy.park(car);
        Car actual = relativelyMoreSpaceParkingLot.getCarByTicket(ticket);
        //then
        assertEquals(car, actual);
    }

    @Test
    void should_super_smart_parking_throw_exception_given_parking_lots_with_no_spaces() throws NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot1 = new ParkingLot(1);
        parkingLot.park(new Car());
        parkingLot1.park(new Car());
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy(parkingLot);
        superSmartParkingBoy.addParkingLot(parkingLot1);

        //when
        //then
        NotEnoughParkingSlotException actual = assertThrows(NotEnoughParkingSlotException.class, () -> superSmartParkingBoy.park(new Car()));
        assertEquals("Not enough position.", actual.getMessage());
    }
}
