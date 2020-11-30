package com.oocl.cultivation.parkingBoys;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingEntity;
import com.oocl.cultivation.Ticket;
import com.oocl.cultivation.exceptions.NotEnoughParkingSlotException;
import com.oocl.cultivation.exceptions.UnrecognizedParkingTicketException;

import java.util.HashSet;
import java.util.Set;

public class ParkingManager implements ParkingEntity {
    private final Set<ParkingEntity> parkingEntities;

    public ParkingManager() {
        parkingEntities = new HashSet<>();
    }

    public ParkingManager manage(ParkingEntity parkingEntity) {
        this.parkingEntities.add(parkingEntity);
        return this;
    }

    public Ticket parkWithParkingBoy(ParkingBoy parkingBoy, Car car) throws NotEnoughParkingSlotException {
        if (this.parkingEntities.contains(parkingBoy)) {
            return parkingBoy.park(car);
        }
        return null;
    }

    public Car getCarByTicket(ParkingBoy parkingBoy, Ticket ticket) throws UnrecognizedParkingTicketException {
        if (this.parkingEntities.contains(parkingBoy)) {
            return parkingBoy.getCarByTicket(ticket);
        }
        return null;
    }

    @Override
    public Ticket park(Car car) throws NotEnoughParkingSlotException {
        Ticket ticket = null;
        for (ParkingEntity parkingEntity : this.parkingEntities) {
            try {
                ticket = parkingEntity.park(car);
                break;
            } catch (NotEnoughParkingSlotException ignored) {
            }
        }
        if (ticket == null)
            throw new NotEnoughParkingSlotException();
        return ticket;
    }

    @Override
    public Car getCarByTicket(Ticket ticket) throws UnrecognizedParkingTicketException {
        Car car = null;
        for (ParkingEntity parkingEntity : this.parkingEntities) {
            try {
                car = parkingEntity.getCarByTicket(ticket);
                break;
            } catch (UnrecognizedParkingTicketException ignored) {
            }
        }
        if (car == null)
            throw new UnrecognizedParkingTicketException();
        return car;
    }
}