package it.thinkopen.accessodb.controller;

import it.thinkopen.accessodb.entity.HotelEntity;
import it.thinkopen.accessodb.entity.SearchConditions;
import it.thinkopen.accessodb.repository.CityRepository;
import it.thinkopen.accessodb.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelsController {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private CityRepository cityRepository;

    @RequestMapping("/hotelsByCAP")
    public String getHotelsByCap(@RequestParam("cap") String cap) {
        String hotels = "";
        List<HotelEntity> hotelEntityArrayList = hotelRepository.getHotelEntityByCap(cap);
        for (HotelEntity hotelEntity : hotelEntityArrayList) {
            hotels = hotels + hotelEntity.toString() + "<br>";
        }
        return hotels;
    }

    @RequestMapping("/hotelsByCity")
    public String getHotelsByCity(@RequestParam("city") String city) {
        String hotels = "";
        List<HotelEntity> hotelEntityArrayList = hotelRepository.getHotelEntityByCityEntity(
                cityRepository.getCityEntityByName(city));
        for (HotelEntity hotelEntity : hotelEntityArrayList) {
            hotels = hotels + hotelEntity.toString() + "<br>";
        }
        return hotels;
    }

    @RequestMapping(value = "/searchCondition", method = RequestMethod.POST)
    public SearchConditions generateSearchCondition(@RequestBody SearchConditions searchConditions) {
        return null;
    }

}
