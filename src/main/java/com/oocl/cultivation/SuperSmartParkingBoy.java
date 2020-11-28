package com.oocl.cultivation;

import java.util.Comparator;
import java.util.Optional;

public class SuperSmartParkingBoy extends ParkingBoy {

    public SuperSmartParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public Ticket park(Car car) throws NotEnoughParkingSlotException {
        Optional<ParkingLot> preferredParkingLot = this.parkingLotList.stream().max(Comparator.comparing(ParkingLot::getAvailableProportion));
        if (preferredParkingLot.isPresent())
            return preferredParkingLot.get().park(car);
        else return null;
    }
}
