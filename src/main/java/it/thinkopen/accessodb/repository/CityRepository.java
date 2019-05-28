package it.thinkopen.accessodb.repository;

import it.thinkopen.accessodb.entities.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    CityEntity getCityEntityByName(String name);
}
