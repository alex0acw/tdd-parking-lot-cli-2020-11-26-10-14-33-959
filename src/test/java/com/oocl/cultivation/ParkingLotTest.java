package com.oocl.cultivation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    void should_return_ticket_when_request_parking_to_available_parking_lot() throws NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        //when
        Ticket ticket = parkingLot.park(car);
        //then
        assertNotNull(ticket);
    }


    @Test
    void should_parking_lot_returns_ticket_when_park_car_to_available_parking_lot() throws NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        //when
        Ticket actual = parkingLot.park(car);
        //then
        assertNotNull(actual);
    }

    @Test
    void should_parking_lot_throws_exception_when_park_car_given_full_parking_lot() throws NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Car car2 = new Car();
        parkingLot.park(car2);
        //when
        Exception actual = assertThrows(NotEnoughParkingSlotException.class,
                () -> parkingLot.park(car));
        //then
        assertEquals("Not enough position.", actual.getMessage());
    }

    @Test
    void should_parking_lot_returns_same_car_given_ticket_of_parked_car() throws UnrecognizedParkingTicketException, NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        //when
        Car actual = parkingLot.getCarByTicket(ticket);
        //then
        assertEquals(car, actual);
    }

    @Test
    void should_parking_lot_returns_multiple_tickets_given_available_parking_lot_and_multiple_cars() throws NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot();
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            carList.add(new Car());
        }
        //when
        List<Ticket> actualTickets =
                new ArrayList<>();
        for (Car car : carList) {
            Ticket park = parkingLot.park(car);
            actualTickets.add(park);
        }
        //then
        for (Ticket actualTicket : actualTickets) {
            assertNotEquals(null, actualTicket);
        }
    }

    @Test
    void should_parking_lot_returns_one_tickets_given_parking_lot_with_1_slot_and_multiple_cars() throws NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            carList.add(new Car());
        }
        //when
        //then
        Ticket actualFirstTicket = parkingLot.park(carList.get(0));
        assertNotNull(actualFirstTicket);
        for (int i = 1; i < carList.size(); i++) {
            int finalI = i;
            Exception actual = assertThrows(NotEnoughParkingSlotException.class,
                    () -> parkingLot.park(carList.get(finalI)));
            assertEquals("Not enough position.", actual.getMessage());
        }
    }

    @Test
    void should_parking_lot_returns_correct_exception_given_used_ticket() throws UnrecognizedParkingTicketException, NotEnoughParkingSlotException {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car();
        Ticket ticket = parkingLot.park(car);
        parkingLot.getCarByTicket(ticket);
        //when
        Exception actual = assertThrows(UnrecognizedParkingTicketException.class,
                () -> parkingLot.getCarByTicket(ticket));
        //then
        assertEquals("Unrecognized parking ticket.", actual.getMessage());
    }

    @Test
    void should_parking_lot_returns_correct_exception_given_fake_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot(1);
        Ticket fakeTicket = new Ticket();
        //when
        Exception actual = assertThrows(UnrecognizedParkingTicketException.class, () ->
                parkingLot.getCarByTicket(fakeTicket)
        );
        //then
        assertEquals("Unrecognized parking ticket.", actual.getMessage());
    }
}
