package com.oocl.cultivation;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ParkingBoyTest {
    @Test
    void should_parking_boy_call_parking_lot_func_park_once_when_parking_boy_park_given_car() {
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
    void should_parking_boy_returns_ticket_when_park_car_to_available_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        //when
        Ticket actual = parkingBoy.park(car);
        //then
        assertNotNull(actual);
    }

    @Test
    void should_parking_boy_returns_null_when_park_car_given_full_parking_lot() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Car car2 = new Car();
        parkingBoy.park(car2);
        //when
        Ticket actual = parkingBoy.park(car);
        //then
        assertNull(actual);
    }

    @Test
    void should_parking_boy_returns_same_car_given_ticket_of_parked_car() {
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
    void should_parking_boy_returns_multiple_tickets_given_available_parking_lot_and_multiple_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            carList.add(new Car());
        }
        //when
        List<Ticket> actualTickets =
                carList.stream().map(parkingBoy::park).collect(Collectors.toList());
        //then
        for (Ticket actualTicket : actualTickets) {
            assertNotEquals(null, actualTicket);
        }
    }

    @Test
    void should_parking_boy_returns_one_tickets_given_parking_lot_with_1_slot_and_multiple_cars() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            carList.add(new Car());
        }
        //when
        List<Ticket> actualTickets =
                carList.stream().map(parkingBoy::park).collect(Collectors.toList());
        //then
        assertNotEquals(null, actualTickets.get(0));
        for (int i = 1; i < actualTickets.size(); i++) {
            assertNull(actualTickets.get(i));
        }
    }

    @Test
    void should_parking_boy_returns_null_given_used_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);
        parkingBoy.getCarByTicket(ticket);
        //when
        Car actual = parkingBoy.getCarByTicket(ticket);
        //then
        assertNull(actual);
    }

    @Test
    void should_parking_boy_returns_null_given_fake_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Ticket fakeTicket = new Ticket();
        //when
        Car actual = parkingBoy.getCarByTicket(fakeTicket);
        //then
        assertNull(actual);
    }
}
