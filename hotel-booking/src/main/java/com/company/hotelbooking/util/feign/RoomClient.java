package com.company.hotelbooking.util.feign;

import com.company.hotelbooking.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(name = "room-service")
public interface RoomClient {
    @RequestMapping(value="/room/{number}", method = RequestMethod.GET)
    public Optional<Room> getRoom(@PathVariable Integer number);

}
