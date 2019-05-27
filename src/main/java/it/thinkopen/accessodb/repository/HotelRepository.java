package it.thinkopen.accessodb.repository;

import it.thinkopen.accessodb.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer> {

    ArrayList<HotelEntity> getHotelEntityByCap(String cap);

}
