package it.thinkopen.accessodb.controller;

import it.thinkopen.accessodb.entity.CityEntity;
import it.thinkopen.accessodb.entity.GenericEntity;
import it.thinkopen.accessodb.entity.HotelEntity;
import it.thinkopen.accessodb.exceptions.BusinessException;
import it.thinkopen.accessodb.repository.CityRepository;
import it.thinkopen.accessodb.repository.HotelRepository;
import it.thinkopen.accessodb.request_response.*;
import it.thinkopen.accessodb.service.LookUpServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class HotelsController {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private LookUpServiceImpl lookUpServiceImpl;

    final static Logger logger = Logger.getLogger(HotelsController.class);

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
        // Estraggo il filtro dall'oggetto request
        Filter requestFilter = request.getFilters()[0];

        // Estraggo il nome della città dall'oggetto Filter appena creato
        String city = requestFilter.getValue();

        // Estraggo il numero di elementi che voglio per pagina
        Integer maxElementiPageable = request.getPagination().getPerPage();

        // "Istanziamo l'oggetto" Pageable con i valore che mi sono stati passati in request
        Pageable pagination = PageRequest.of(1, maxElementiPageable);

        // Estraggo il CityEntity attraverso la sua repository di riferimento
        CityEntity cityEntity = cityRepository.getCityEntityByName(city);

        // Estraggo la Page degli hotel che sono nella città specificata nella variabile
        // city e con le condizioni di paginazione specificate in pagination
        Page<HotelEntity> hotelEntityPage = hotelRepository.getHotelEntitiesByCityEntity(cityEntity, pagination);

        // Creiamo l'oggetto response che dovrà essere la risposta a fronte della request
        Response response = new Response();

        // Setto all'interno della response gli stessi attributi contenuti nella request
        response.setPagination(request.getPagination());
        response.setFilters(request.getFilters());

        // Setto l'attributo page con il risultato della query
        response.setPage(hotelEntityPage);

        // Spernado che non ci siano errori, setto a "OK" lo status e vuoto il mesaggio
        response.setStatus("OK");
        response.setMessage("");

        return response;
    }

    @RequestMapping(value = "/requestSQL", method = RequestMethod.POST)
    public ResponseFromQuery requestSQL(@RequestBody Request request) {
        logger.info("------------------------");
        logger.info("Richista ricevuta da /requestSQL");
        logger.info("Elaborazione in corso ...");
        ResponseFromQuery responseFromQuery = new ResponseFromQuery();
        try {
            HashMap<String, String> filtersMap = toHasMap(request.getFilters());
            Pagination pagination = request.getPagination();

            /*----------Parte sensibile alle eccezioni----------*/
            List<GenericEntity> entityList = lookUpServiceImpl.findHotelsEntityByCityNameSQL(pagination, filtersMap);
            /*--------------------------------------------------*/

            responseFromQuery.setEntityList(entityList);
            responseFromQuery.setFilters(request.getFilters());
            responseFromQuery.setPagination(request.getPagination());
            responseFromQuery.setStatus("OK");
            responseFromQuery.setMessage("");
            logger.info("Elaborazione conclusa.");
            logger.info("------------------------");

            return responseFromQuery;
        } catch (BusinessException ex) {
            responseFromQuery.setEntityList(null);
            responseFromQuery.setFilters(request.getFilters());
            responseFromQuery.setPagination(request.getPagination());
            responseFromQuery.setStatus("KO");
            responseFromQuery.setMessage(ex.getMessage());
            logger.error("Errore: " + ex.getMessage());
            logger.info("------------------------");

            return responseFromQuery;
        }
    }

    @RequestMapping(value = "/requestHQL", method = RequestMethod.POST)
    public ResponseFromQuery requestHQL(@RequestBody Request request) {
        logger.info("------------------------");
        logger.info("Richista ricevuta da /requestHQL");
        logger.info("Elaborazione in corso ...");
        ResponseFromQuery responseFromQuery = new ResponseFromQuery();
        try {
            HashMap<String, String> filtersMap = toHasMap(request.getFilters());
            Pagination pagination = request.getPagination();

            /*----------Parte sensibile alle eccezioni----------*/
            List<GenericEntity> entityList = lookUpServiceImpl.findHotelsEntityByCityNameHQL(pagination, filtersMap);
            /*--------------------------------------------------*/

            responseFromQuery.setEntityList(entityList);
            responseFromQuery.setFilters(request.getFilters());
            responseFromQuery.setPagination(request.getPagination());
            responseFromQuery.setStatus("OK");
            responseFromQuery.setMessage("");
            logger.info("Elaborazione conclusa.");
            logger.info("------------------------");

            return responseFromQuery;
        } catch (BusinessException ex) {
            responseFromQuery.setEntityList(null);
            responseFromQuery.setFilters(request.getFilters());
            responseFromQuery.setPagination(request.getPagination());
            responseFromQuery.setStatus("KO");
            responseFromQuery.setMessage(ex.getMessage());
            logger.error("Errore: " + ex.getMessage());
            logger.info("------------------------");

            return responseFromQuery;
        }
    }

    private HashMap<String, String> toHasMap(Filter[] filters) {
        HashMap<String, String> filtersMap = new HashMap<String, String>();
        for (int i = 0; i < filters.length; i++) {
            filtersMap.put(filters[i].getName(), filters[i].getValue());
        }
        return filtersMap;
    }

}
