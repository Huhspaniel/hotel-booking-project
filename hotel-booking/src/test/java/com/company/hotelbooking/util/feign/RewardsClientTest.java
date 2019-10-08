package com.company.hotelbooking.util.feign;

import com.company.hotelbooking.model.Rewards;
import feign.FeignException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RewardsClientTest {

    @Autowired
    RewardsClient rewardsClient;

    @Test
    public void shouldReturnRewardWithValidInput() {

        Rewards expectedRewards = new Rewards(1,
                "double",
                new BigDecimal("0.2"),
                200, true);

        Rewards rewardsFromClient = rewardsClient.getRewards("double");
        assertEquals(expectedRewards, rewardsFromClient);
    }

   @Test(expected = FeignException.NotFound.class)
    public void shouldReturnExceptionWithInvalidInput() {
        rewardsClient.getRewards("GARBAGECHUTE");
    }
}