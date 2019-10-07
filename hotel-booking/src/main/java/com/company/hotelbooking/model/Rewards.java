package com.company.hotelbooking.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Rewards {

    private Integer id;
    private String roomType;
    private BigDecimal discount;
    private Integer points;
    private Boolean canDouble;

    public Rewards() {
    }

    public Rewards(Integer id, String roomType, BigDecimal discount, Integer points, Boolean canDouble) {
        this.id = id;
        this.roomType = roomType;
        this.discount = discount;
        this.points = points;
        this.canDouble = canDouble;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Boolean getCanDouble() {
        return canDouble;
    }

    public void setCanDouble(Boolean canDouble) {
        this.canDouble = canDouble;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rewards rewards = (Rewards) o;
        return Objects.equals(getId(), rewards.getId()) &&
                getRoomType().equals(rewards.getRoomType()) &&
                getDiscount().equals(rewards.getDiscount()) &&
                getPoints().equals(rewards.getPoints()) &&
                getCanDouble().equals(rewards.getCanDouble());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRoomType(), getDiscount(), getPoints(), getCanDouble());
    }
}
