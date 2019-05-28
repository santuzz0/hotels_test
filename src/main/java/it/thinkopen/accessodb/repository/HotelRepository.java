package it.thinkopen.accessodb.repository;

import it.thinkopen.accessodb.entity.CityEntity;
import it.thinkopen.accessodb.entity.HotelEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {

    List<HotelEntity> getHotelEntityByCap(String cap);

    List<HotelEntity> getHotelEntityByCityEntity(CityEntity cityEntity);

}
