package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLotList = new ArrayList<>();
        this.parkingLotList.add(parkingLot);
    }

    public Ticket park(Car car) throws NotEnoughParkingSlotException {
        Ticket ticket = null;
        for (ParkingLot parkingLot : this.parkingLotList) {
            try {
                ticket = parkingLot.park(car);
                break;
            } catch (NotEnoughParkingSlotException ignored) {
            }
        }
        if (ticket == null)
            throw new NotEnoughParkingSlotException();
        return ticket;
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
