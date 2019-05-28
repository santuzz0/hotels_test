package it.thinkopen.accessodb.controller;

import it.thinkopen.accessodb.entities.CityEntity;
import it.thinkopen.accessodb.entities.HotelEntity;
import it.thinkopen.accessodb.repository.CityRepository;
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

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping("/hello")
    public String redirectToHelloPage() {
        return "Yo!";
    }

    @RequestMapping("/hotelsByCap")
    public List<HotelEntity> hotelByCap(@RequestParam("cap") String cap) {
        List<HotelEntity> hotelEntityList = hotelRepository.getHotelEntityByCap(cap);
        return hotelEntityList;
    }

    @RequestMapping("/hotelsByCityName")
    public String hotelsByCityName(@RequestParam("cityname") String cityname)
    {
        CityEntity cityEntity = cityRepository.getCityEntityByName(cityname);

        List<HotelEntity> hotelEntityList = hotelRepository.getHotelEntityByCityEntity(cityEntity);

        String info = "";

        for (HotelEntity hotelEntity : hotelEntityList)
        {
            info += hotelEntity.toString();
        }

        return info;
    }
}
