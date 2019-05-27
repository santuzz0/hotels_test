package it.thinkopen.accessodb.controller;

import it.thinkopen.accessodb.entity.HotelEntity;
import it.thinkopen.accessodb.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HotelsController {

    @Autowired
    private HotelRepository hotelRepository;

    @RequestMapping("/hotelsByCAP")
    public String redirectToHelloPage(@RequestParam("cap") String cap) {
        String hotels = "";
        ArrayList<HotelEntity> hotelEntityArrayList = hotelRepository.getHotelEntityByCap(cap);
        for (HotelEntity hotelEntity : hotelEntityArrayList) {
            hotels = hotels + hotelEntity.toString() + "<br>";
        }
        return hotels;
    }

}
