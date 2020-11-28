package com.oocl.cultivation;

import com.oocl.cultivation.exceptions.NotEnoughParkingSlotException;
import com.oocl.cultivation.exceptions.UnrecognizedParkingTicketException;
import com.oocl.cultivation.parkingBoys.ParkingBoy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingBoyTest {
    @Test
    void should_parking_boy_returns_same_car_given_ticket_of_parked_car() throws UnrecognizedParkingTicketException, NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        //when
        Car actual = parkingBoy.getCarByTicket(ticket);
        //then
        assertEquals(car, actual);
    }

    @Test
    void should_parking_boy_returns_same_cars_given_2_car_and_2_parking_lots_with_1_slot() throws NotEnoughParkingSlotException, UnrecognizedParkingTicketException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.addParkingLot(parkingLot2);
        Car car = new Car();
        Car car2 = new Car();
        Ticket ticket = parkingBoy.park(car);
        Ticket ticket2 = parkingBoy.park(car2);
        //when
        Car actual = parkingBoy.getCarByTicket(ticket);
        Car actual2 = parkingBoy.getCarByTicket(ticket2);
        //then
        assertEquals(car, actual);
        assertEquals(car2, actual2);
    }

    @Test
    void should_parking_boy_returns_exception_when_park_cars_to_full_parking_lots() throws NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.addParkingLot(parkingLot2);
        Car car = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        //when
        parkingBoy.park(car);
        parkingBoy.park(car2);

        Exception actual = assertThrows(NotEnoughParkingSlotException.class,
                () -> parkingBoy.park(car3));
        //then
        assertEquals("Not enough position.", actual.getMessage());
    }

    @Test
    void should_parking_boy_returns_exception_when_got_invalid_ticket_given_multiple_parking_lots() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        parkingBoy.addParkingLot(parkingLot2);
        Ticket invalidTicket = new Ticket();

        //when
        Exception actual = assertThrows(UnrecognizedParkingTicketException.class,
                () -> parkingBoy.getCarByTicket(invalidTicket));

        //then
        assertEquals("Unrecognized parking ticket.", actual.getMessage());
    }
}
