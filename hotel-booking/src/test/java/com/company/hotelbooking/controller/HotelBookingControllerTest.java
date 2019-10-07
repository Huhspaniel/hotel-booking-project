package com.company.hotelbooking.controller;

import com.company.hotelbooking.model.Rewards;
import com.company.hotelbooking.model.Room;
import com.company.hotelbooking.service.HotelRewardsService;
import com.company.hotelbooking.viewmodel.HotelRewardsView;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HotelBookingController.class)
public class HotelBookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    HotelRewardsService service;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getBookingInfoWithJson() throws Exception {
        HotelRewardsView view = new HotelRewardsView(
                "123",
                "room type",
                true,
                true,
                new BigDecimal("200.00"),
                new BigDecimal("0.1"),
                2000,
                true,
                new BigDecimal("180.0"),
                4000
        );
        Rewards rewards = new Rewards(
                1,
                view.getRoomType(),
                view.getMemberDiscount(),
                view.getBaseRewardsPoints(),
                view.getCanDouble()
        );
        Room room = new Room(
                view.getRoomNumber(),
                view.getRoomType(),
                view.getBaseRate()
        );

        String outputJson = mapper.writeValueAsString(view);

        when(service.getRewardsInfo(view.getRoomNumber(), view.getRewardsMember(), view.getDoubleBonusDay());

        this.mockMvc.perform(get("/hotelRewards/123?rewardsMember=true&doubleBonusDay=true"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getBookingInfoReturn404() throws Exception {
        HotelRewardsView view = new HotelRewardsView;
        
    }
}