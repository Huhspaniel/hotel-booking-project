package com.company.hotelbooking.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Room {

    private String number;
    private String roomType;
    private BigDecimal baseRate;

    public Room() {
    }

    public Room(String number, String roomType, BigDecimal baseRate) {
        this.number = number;
        this.roomType = roomType;
        this.baseRate = baseRate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return getNumber().equals(room.getNumber()) &&
                getRoomType().equals(room.getRoomType()) &&
                getBaseRate().equals(room.getBaseRate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber(), getRoomType(), getBaseRate());
    }
}
