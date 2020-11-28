package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    private List<ParkingLot> parkingLotList;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLotList = new ArrayList<>();
        this.parkingLotList.add(parkingLot);
    }

    public Ticket park(Car car) {
        Ticket ticket = null;
        for (ParkingLot parkingLot : this.parkingLotList) {
            try {
                ticket = parkingLot.park(car);
                break;
            } catch (NotEnoughParkingSlotException ignored) {
            }
        }
        return ticket;
    }

    public Car getCarByTicket(Ticket ticket) {
        Car car = null;
        for (ParkingLot parkingLot : this.parkingLotList) {
            try {
                car = parkingLot.getCarByTicket(ticket);
                break;
            } catch (UnrecognizedParkingTicketException ignored) {
            }
        }
        return car;
    }

    public void addParkingLot(ParkingLot parkingLot) {
        this.parkingLotList.add(parkingLot);

    }
}
