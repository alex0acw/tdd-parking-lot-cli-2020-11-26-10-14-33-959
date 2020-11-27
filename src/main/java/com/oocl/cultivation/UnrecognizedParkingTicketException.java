package com.oocl.cultivation;

public class UnrecognizedParkingTicketException extends Exception {
    UnrecognizedParkingTicketException() {
        super("Unrecognized parking ticket.");
    }
}
