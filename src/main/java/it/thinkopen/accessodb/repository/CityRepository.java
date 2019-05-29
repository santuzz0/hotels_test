package it.thinkopen.accessodb.repository;

import it.thinkopen.accessodb.entity.CityEntity;
import it.thinkopen.accessodb.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {

    CityEntity getCityEntityByName(String name);
    List<HotelEntity> getHotelEntityByName(String cityName);

}
