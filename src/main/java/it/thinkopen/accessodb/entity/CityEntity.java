package it.thinkopen.accessodb.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import it.thinkopen.accessodb.LocalDBConf;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = LocalDBConf.CITY_TABLE_NAME, schema = LocalDBConf.SCHEMA_NAME)
public class CityEntity extends GenericEntity {
    private int id;
    //private String istatCode;
    //private Double latitude;
    //private Double longitude;
    private String name;
    private List<HotelEntity> hotelEntityList;

    @Id
    @Column(name = "Id", nullable = false)
    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Column(name = "ISTATCode", nullable = false, length = 6)
//    public String getIstatCode() {
//        return istatCode;
//    }
//
//    public void setIstatCode(String istatCode) {
//        this.istatCode = istatCode;
//    }
//
//    @Column(name = "Latitude", nullable = true, precision = 0)
//    public Double getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(Double latitude) {
//        this.latitude = latitude;
//    }
//
//    @Column(name = "Longitude", nullable = true, precision = 0)
//    public Double getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(Double longitude) {
//        this.longitude = longitude;
//    }

    @Column(name = "Name", length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonManagedReference
    @OneToMany(mappedBy = "cityEntity")
    public List<HotelEntity> getHotelEntityList() {
        return hotelEntityList;
    }

    public void setHotelEntityList(List<HotelEntity> hotelEntityList) {
        this.hotelEntityList = hotelEntityList;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return id == that.id &&
                Objects.equals(istatCode, that.istatCode) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(name, that.name);
    }*/

    @Override
    public int hashCode() {
        return Objects.hash(id, /*istatCode, latitude, longitude,*/ name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return id == that.id && Objects.equals(name, that.name);
    }
}
