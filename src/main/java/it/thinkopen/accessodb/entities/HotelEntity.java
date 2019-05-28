package it.thinkopen.accessodb.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "\"HOTEL\"", schema = "hotels")
public class HotelEntity {
    private int id;
    private String name;
    private String cap;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Cap", nullable = true, length = 5)
    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }


    private CityEntity cityEntity;

    @ManyToOne
    @JoinColumn(name = "CityId")
    public CityEntity getCityEntity() {
        return cityEntity;
    }

    public void setCityEntity(CityEntity cityEntity) {
        this.cityEntity = cityEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelEntity that = (HotelEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(cap, that.cap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cap);
    }

    @Override
    public String toString() {
        return "HotelEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cap='" + cap + '\'' +
                '}';
    }
}
