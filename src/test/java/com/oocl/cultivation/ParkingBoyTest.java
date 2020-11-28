package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ParkingBoyTest {
    @Test
    void should_parking_boy_call_parking_lot_func_park_once_when_parking_boy_park_given_car() throws NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = Mockito.mock(ParkingLot.class);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        //when
        parkingBoy.park(car);
        //then
        verify(parkingLot, times(1)).park(car);
    }

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
}
