package com.oocl.cultivation;

public class UnrecognizedParkingTicket extends Exception {
    UnrecognizedParkingTicket() {
        super("Unrecognized parking ticket.");
    }
}
