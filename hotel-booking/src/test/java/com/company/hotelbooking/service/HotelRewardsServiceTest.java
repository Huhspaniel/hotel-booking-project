package com.company.hotelbooking.service;

import com.company.hotelbooking.model.Rewards;
import com.company.hotelbooking.model.Room;
import com.company.hotelbooking.util.feign.RewardsClient;
import com.company.hotelbooking.util.feign.RoomClient;
import com.company.hotelbooking.viewmodel.HotelRewardsView;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HotelRewardsServiceTest {

    @InjectMocks
    private HotelRewardsService service;
    @Mock
    private RewardsClient rewardsClient;
    @Mock
    private RoomClient roomClient;

    @Before
    public void setUp() {
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

        when(rewardsClient.getRewards(view.getRoomType())).thenReturn(rewards);
        when(roomClient.getRoom(view.getRoomNumber())).thenReturn(Optional.of(room));
    }
}