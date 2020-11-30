package com.oocl.cultivation;

import com.oocl.cultivation.exceptions.NotEnoughParkingSlotException;
import com.oocl.cultivation.exceptions.UnrecognizedParkingTicketException;

public interface ParkingEntity {
    Ticket park(Car car) throws NotEnoughParkingSlotException;
    Car getCarByTicket(Ticket ticket) throws UnrecognizedParkingTicketException;
}
