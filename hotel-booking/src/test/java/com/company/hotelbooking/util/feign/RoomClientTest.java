package com.company.hotelbooking.util.feign;

import com.company.hotelbooking.model.Room;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoomClientTest {

    @Autowired
    RoomClient roomClient;

    @Test
    public void getRoomShouldReturnRoomWithValidInput() {

        Room expectedRoom = new Room("101","double",new BigDecimal("189.0"));

        Optional<Room> roomFromClient = roomClient.getRoom("101");
        assertEquals(expectedRoom, roomFromClient.get());
    }

    @Test
    public void getRooomShouldReturnEmptyOptionalIfInvalidInput() {
        Optional<Room> room = roomClient.getRoom("9999");
        assertEquals(Optional.empty(), room);
        }
    }