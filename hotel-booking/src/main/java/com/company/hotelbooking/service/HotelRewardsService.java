package com.company.hotelbooking.service;

import com.company.hotelbooking.model.Room;
import com.company.hotelbooking.util.feign.RewardsClient;
import com.company.hotelbooking.util.feign.RoomClient;
import com.company.hotelbooking.viewmodel.HotelRewardsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class HotelRewardsService {
    private RewardsClient rewardsClient;
    private RoomClient roomClient;

    @Autowired
    public HotelRewardsService(RewardsClient rewardsClient, RoomClient roomClient) {
        this.rewardsClient = rewardsClient;
        this.roomClient = roomClient;
    }

    public Optional<HotelRewardsView> getRewardsInfo(String roomNumber, Boolean rewardsMember, Boolean doubleBonusDay) {
        System.out.println("TEST TEST");
        Room room = roomClient.getRoom(roomNumber).orElse(null);
        if (room != null) {
            HotelRewardsView hrv = new HotelRewardsView();
            hrv.setRoomNumber(roomNumber);
            hrv.setRoomType(room.getRoomType());
            hrv.setRewardsMember(rewardsMember);
            hrv.setDoubleBonusDay(doubleBonusDay);
            hrv.setBaseRate(room.getBaseRate());
            hrv.setMemberDiscount(rewardsClient.getRewards(room.getRoomType()).getDiscount());
            hrv.setBaseRewardsPoints(rewardsClient.getRewards(room.getRoomType()).getPoints());
            hrv.setCanDouble(rewardsClient.getRewards(room.getRoomType()).getCanDouble());
            BigDecimal one = new BigDecimal(1);
            BigDecimal base = new BigDecimal(String.valueOf(hrv.getBaseRate()));
            if (rewardsMember) {
                hrv.setFinalCost(base.multiply(one.subtract(hrv.getMemberDiscount())));
            } else {
                hrv.setFinalCost(hrv.getBaseRate());
            }
            if (rewardsMember == false) {
                hrv.setTotalRewardsPoints(0);
            } else if (doubleBonusDay && hrv.getCanDouble()) {
                hrv.setTotalRewardsPoints(2 * hrv.getBaseRewardsPoints());
            } else {
                hrv.setTotalRewardsPoints(hrv.getBaseRewardsPoints());
            }
            return Optional.of(hrv);

        } else {
            return Optional.empty();
        }
    }
}
