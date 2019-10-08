package com.company.hotelbooking.util.feign;

import com.company.hotelbooking.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name="room-service", decode404=true)
public interface RoomClient {
    @GetMapping("/room/{number}")
    public Optional<Room> getRoom(@PathVariable String number);
}
