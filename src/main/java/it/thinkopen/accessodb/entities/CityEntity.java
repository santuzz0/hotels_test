package it.thinkopen.accessodb.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CITY", schema = "hotels")
public class CityEntity {
    private int id;
    private String name;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<HotelEntity> hotelEntities;

    @OneToMany(mappedBy = "cityEntity")
    public List<HotelEntity> getHotelEntities() {
        return hotelEntities;
    }

    public void setHotelEntities(List<HotelEntity> hotelEntities) {
        this.hotelEntities = hotelEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
