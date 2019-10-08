package com.company.hotelbooking.controller;

import com.company.hotelbooking.service.HotelRewardsService;
import com.company.hotelbooking.viewmodel.HotelRewardsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
//@RequestMapping("/hotelRewards")
public class HotelBookingController {

    @Autowired
    private HotelRewardsService service;

    @GetMapping("/hotelRewards/{roomId}")
    @ResponseStatus(HttpStatus.OK)
    public HotelRewardsView getBookingInfo(@PathVariable String roomId, @RequestParam(required = false) boolean rewardsMember, @RequestParam(required = false) boolean doubleBonusDay) throws EntityNotFoundException {
        return service.getRewardsInfo(roomId, rewardsMember, doubleBonusDay)
                .orElseThrow(() -> new EntityNotFoundException("Room number " + roomId + " does not exist"));
    }

}
