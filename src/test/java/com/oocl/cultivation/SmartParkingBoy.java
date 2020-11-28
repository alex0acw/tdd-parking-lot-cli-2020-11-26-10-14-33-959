package com.oocl.cultivation;

import java.util.Comparator;
import java.util.Optional;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public Ticket park(Car car) throws NotEnoughParkingSlotException {
        Optional<ParkingLot> preferredParkingLot = this.parkingLotList.stream().max(Comparator.comparingInt(ParkingLot::getRemainingSpaces));
        if (preferredParkingLot.isPresent())
            return preferredParkingLot.get().park(car);
        else return null;
    }
}
