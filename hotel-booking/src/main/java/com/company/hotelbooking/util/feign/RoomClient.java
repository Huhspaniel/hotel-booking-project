package com.company.hotelbooking.util.feign;

import com.company.hotelbooking.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(name = "room-service")
public interface RoomClient {
    @RequestMapping(value="/room/{number}", method = RequestMethod.GET)
    public Optional<Room> getRoom(@PathVariable Integer number);

=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient("room-service")
public interface RoomClient {
    @GetMapping("/room/{number}")
    public Optional<Room> getRoom(@PathVariable String number);
>>>>>>> b11ee22029e8915440ba5e12bff2a699ce6d81ec
}
