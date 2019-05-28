package it.thinkopen.accessodb.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "city", schema = "hotels", catalog = "")
public class CityEntity {
    private int id;
//    private String istatCode;
//    private Double latitude;
//    private Double longitude;
    private String name;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    private List<HotelEntity> hotelEntities;

    @OneToMany(mappedBy = "cityEntity")
    public List<HotelEntity> getHotelEntities() {
        return hotelEntities;
    }

    public void setHotelEntities(List<HotelEntity> hotelEntities) {
        this.hotelEntities = hotelEntities;
    }
//    @Basic
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
//    @Basic
//    @Column(name = "Longitude", nullable = true, precision = 0)
//    public Double getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(Double longitude) {
//        this.longitude = longitude;
//    }
//

    @Column(name = "Name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CityEntity that = (CityEntity) o;
//        return id == that.id &&
//                Objects.equals(istatCode, that.istatCode) &&
//                Objects.equals(latitude, that.latitude) &&
//                Objects.equals(longitude, that.longitude) &&
//                Objects.equals(name, that.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, istatCode, latitude, longitude, name);
//    }

}
