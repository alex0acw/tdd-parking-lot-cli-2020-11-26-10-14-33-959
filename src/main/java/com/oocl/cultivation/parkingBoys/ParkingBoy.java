package com.oocl.cultivation.parkingBoys;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.Ticket;
import com.oocl.cultivation.exceptions.NotEnoughParkingSlotException;
import com.oocl.cultivation.exceptions.UnrecognizedParkingTicketException;
import com.oocl.cultivation.pickParkingLotStrategies.PickParkingLotStrategyInterface;
import com.oocl.cultivation.pickParkingLotStrategies.SequentialStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    protected List<ParkingLot> parkingLotList;
    private final PickParkingLotStrategyInterface pickParkingLotStrategy;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLotList = new ArrayList<>();
        this.parkingLotList.add(parkingLot);
        this.pickParkingLotStrategy = new SequentialStrategy();
    }

    protected ParkingBoy(ParkingLot parkingLot, PickParkingLotStrategyInterface pickParkingLotStrategy) {
        this.parkingLotList = new ArrayList<>();
        this.parkingLotList.add(parkingLot);
        this.pickParkingLotStrategy = pickParkingLotStrategy;
    }

    public Ticket park(Car car) throws NotEnoughParkingSlotException {
        ParkingLot parkingLot = this.pickParkingLotStrategy.pickParkingLot(this.parkingLotList);
        if (parkingLot == null)
            throw new NotEnoughParkingSlotException();
        return parkingLot.park(car);
    }

    public Car getCarByTicket(Ticket ticket) throws UnrecognizedParkingTicketException {
        Car car = null;
        for (ParkingLot parkingLot : this.parkingLotList) {
            try {
                car = parkingLot.getCarByTicket(ticket);
                break;
            } catch (UnrecognizedParkingTicketException ignored) {
            }
        }
        if (car == null)
            throw new UnrecognizedParkingTicketException();
        return car;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLotList.add(parkingLot);

    }
}
