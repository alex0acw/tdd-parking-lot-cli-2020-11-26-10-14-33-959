package com.oocl.cultivation;

public class NotEnoughParkingSlotException extends Exception {
    NotEnoughParkingSlotException(){
        super("Not enough position.");
    }
}
