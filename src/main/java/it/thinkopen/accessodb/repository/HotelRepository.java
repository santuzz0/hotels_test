package it.thinkopen.accessodb.repository;

import it.thinkopen.accessodb.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<HotelEntity, Integer>
{
    List<HotelEntity> getHotelEntityByCap(String cap);
}
