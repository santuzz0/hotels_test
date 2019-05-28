package it.thinkopen.accessodb.controller;

import it.thinkopen.accessodb.entity.HotelEntity;
import it.thinkopen.accessodb.entity.Request;
import it.thinkopen.accessodb.entity.Response;
import it.thinkopen.accessodb.repository.CityRepository;
import it.thinkopen.accessodb.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public Response generateSearchCondition(@RequestBody Request request) {
        // Creo la risposta a fronte della richiesta che mi arriva
        Response response = new Response();

        // Setto le stesse informazioni che mi arrivano dalla richiesta
        response.setPagination(request.getPagination());
        response.setFilters(request.getFilters());

        // Setto il risultato (che sarà una Page)
        // che mi arriva dalla query i cui parametri
        // sono specificati in request


        // Setto l'esito della mia operazione di query
        response.setStatus("OK");
        response.setMessage("");
        return response;
    }

}
