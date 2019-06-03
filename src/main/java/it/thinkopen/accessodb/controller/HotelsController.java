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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final static Logger logger = Logger.getLogger(HotelsController.class);

    @RequestMapping("/hotelsByCAP")
    public String getHotelsByCap(@RequestParam("cap") String cap) {
        StringBuilder hotels = new StringBuilder();
        List<HotelEntity> hotelEntityArrayList = hotelRepository.getHotelEntityByCap(cap);
        for (HotelEntity hotelEntity : hotelEntityArrayList) {
            hotels.append(hotelEntity.toString()).append("<br>");
        }
        return hotels.toString();
    }

    @RequestMapping("/hotelsByCity")
    public String getHotelsByCity(@RequestParam("city") String city) {
        StringBuilder hotels = new StringBuilder();
        List<HotelEntity> hotelEntityArrayList = hotelRepository.getHotelEntityByCityEntity(
                cityRepository.getCityEntityByName(city));
        for (HotelEntity hotelEntity : hotelEntityArrayList) {
            hotels.append(hotelEntity.toString()).append("<br>");
        }
        return hotels.toString();
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
    public ResponseFromQuery requestSQL(@RequestBody Request request) throws BusinessException {
        logger.info("------------------------");
        logger.info("Richista ricevuta da /requestSQL");
        logger.info("Elaborazione in corso ...");
//        try {
        HashMap<String, String> filtersMap = toHasMap(request.getFilters());
        Pagination pagination = request.getPagination();

        /*----------Parte sensibile alle eccezioni----------*/
        List<GenericEntity> entityList = lookUpServiceImpl.findHotelsEntityByCityNameSQL(pagination, filtersMap);
        /*--------------------------------------------------*/

        ResponseFromQuery responseFromQuery = buildResponse(entityList, request.getFilters(),
                request.getPagination(), "OK", "");
        logger.info("Elaborazione conclusa.");
        logger.info("------------------------");

        return responseFromQuery;
//        } catch (BusinessException ex) {
//            ResponseFromQuery responseFromQuery = buildResponse(null, request.getFilters(),
//                    request.getPagination(), "KO", ex.getMessage());
//            logger.error("Errore: " + ex.getMessage());
//            logger.info("------------------------");
//
//            return responseFromQuery;
//        }
    }

    @RequestMapping(value = "/requestHQL", method = RequestMethod.POST)
    public ResponseFromQuery requestHQL(@RequestBody Request request) throws BusinessException {
        logger.info("------------------------");
        logger.info("Richista ricevuta da /requestHQL");
        logger.info("Elaborazione in corso ...");
//        try {
        HashMap<String, String> filtersMap = toHasMap(request.getFilters());
        Pagination pagination = request.getPagination();

        /*----------Parte sensibile alle eccezioni----------*/
        List<GenericEntity> entityList = lookUpServiceImpl.findHotelsEntityByCityNameHQL(pagination, filtersMap);
        /*--------------------------------------------------*/

        ResponseFromQuery responseFromQuery = buildResponse(entityList, request.getFilters(),
                request.getPagination(), "OK", "");
        logger.info("Elaborazione conclusa.");
        logger.info("------------------------");

        return responseFromQuery;
//        } catch (BusinessException ex) {
//
//            handleBusinessException(ex);
//
//            ResponseFromQuery responseFromQuery = buildResponse(null, request.getFilters(),
//                    request.getPagination(), "KO", ex.getMessage());
//
//
//            return responseFromQuery;
//        }
    }

    private HashMap<String, String> toHasMap(Filter[] filters) {
        HashMap<String, String> filtersMap = new HashMap<>();
        for (Filter filter : filters) {
            filtersMap.put(filter.getName(), filter.getValue());
        }
        return filtersMap;
    }

    private ResponseFromQuery buildResponse(List<GenericEntity> entityList, Filter[] filters, Pagination pagination, String status, String message) {
        ResponseFromQuery responseFromQuery = new ResponseFromQuery();

        responseFromQuery.setEntityList(entityList);
        responseFromQuery.setFilters(filters);
        responseFromQuery.setPagination(pagination);
        responseFromQuery.setStatus(status);
        responseFromQuery.setMessage(message);

        return responseFromQuery;
    }

}
