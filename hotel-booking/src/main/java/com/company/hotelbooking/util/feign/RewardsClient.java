package com.company.hotelbooking.util.feign;

import com.company.hotelbooking.viewmodel.HotelRewardsView;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("rewards-service")
public interface RewardsClient {
    @GetMapping("/rewards/type/{roomType}")
    HotelRewardsView getRewards(@PathVariable String roomType);
}
