package com.company.hotelbooking.service;

import com.company.hotelbooking.util.feign.RewardsClient;
import com.company.hotelbooking.util.feign.RoomClient;
import com.company.hotelbooking.viewmodel.HotelRewardsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        return Optional.empty();
    }
}
