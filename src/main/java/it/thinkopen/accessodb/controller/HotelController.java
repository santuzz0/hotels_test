package it.thinkopen.accessodb.controller;

import it.thinkopen.accessodb.entities.HotelEntity;
import it.thinkopen.accessodb.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @RequestMapping("/hello")
    public String redirectToHelloPage() {
        return "Yo!";
    }

    @RequestMapping("/hotelsByCap")
    public List<HotelEntity> hotelByCap(HotelEntity hotelEntity, @RequestParam("cap") String cap) {
        List<HotelEntity> hotelEntityList = hotelRepository.getHotelEntityByCap(hotelEntity.getCap());
        return hotelEntityList;
    }
}
