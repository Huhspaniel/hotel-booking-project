package com.company.hotelbooking.controller;

import com.company.hotelbooking.service.HotelRewardsService;
import com.company.hotelbooking.viewmodel.HotelRewardsView;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
//@RequestMapping("/hotelRewards")
public class HotelBookingController {

    HotelRewardsService service;

    @GetMapping("/hotelRewards/{roomId}?rewardsMember=[true|false]&doubleBonusDay=[true|false]")
    @ResponseStatus(HttpStatus.OK)
    public Optional<HotelRewardsView> getBookingInfo(@PathVariable int roomId, @PathParam("rewardsMember") boolean rewardsMember, @PathParam("doubleBonusDay") boolean doubleBonusDay){
        return service.getRewardsInfo(roomId, rewardsMember, doubleBonusDay);
    }

}
