package it.thinkopen.accessodb.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hotel", schema = "hotels")
public class HotelEntity {
    private int id;
    //    private Integer ihNumber;
    private String name;
    private String address;
    private String cap;

    private CityEntity cityEntity;

//    private Double latitude;
//    private Double longitude;
//    private String foPhone;
//    private String boPhone;
//    private String fax;
//    private String foMail;
//    private String boMail;
//    private String webSite;
//    private String b2CContractFlag;
//    private String b2CMailedFlag;
//    private String b2COnLineFlag;
//    private String b2CEditOk;
//    private String b2CStoppedFlag;
//    private String b2CStopDescr;
//    private String taManagedFlag;
//    private String taAssociatedFlag;
//    private String b2CFlag;
//    private String b2CSaleableFlag;
//    private String b2CEditOkFlag;
//    private String b2CCallAssignedFlag;
//    private String bookOnLineFlag;
//    private String onRequestFlag;

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    @Column(name = "IHNumber", nullable = true)
//    public Integer getIhNumber() {
//        return ihNumber;
//    }
//
//    public void setIhNumber(Integer ihNumber) {
//        this.ihNumber = ihNumber;
//    }

    @Column(name = "Name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "Address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "Cap", nullable = true, length = 5)
    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    @ManyToOne
    @JoinColumn(name = "CityId")
    public CityEntity getCityEntity() {
        return cityEntity;
    }

    public void setCityEntity(CityEntity cityEntity) {
        this.cityEntity = cityEntity;
    }

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
//
//    @Column(name = "FOPhone", nullable = true, length = 20)
//    public String getFoPhone() {
//        return foPhone;
//    }
//
//    public void setFoPhone(String foPhone) {
//        this.foPhone = foPhone;
//    }
//
//    @Column(name = "BOPhone", nullable = true, length = 20)
//    public String getBoPhone() {
//        return boPhone;
//    }
//
//    public void setBoPhone(String boPhone) {
//        this.boPhone = boPhone;
//    }
//
//    @Column(name = "Fax", nullable = true, length = 20)
//    public String getFax() {
//        return fax;
//    }
//
//    public void setFax(String fax) {
//        this.fax = fax;
//    }
//
//    @Column(name = "FOMail", nullable = true, length = 50)
//    public String getFoMail() {
//        return foMail;
//    }
//
//    public void setFoMail(String foMail) {
//        this.foMail = foMail;
//    }
//
//    @Column(name = "BOMail", nullable = true, length = 50)
//    public String getBoMail() {
//        return boMail;
//    }
//
//    public void setBoMail(String boMail) {
//        this.boMail = boMail;
//    }
//
//    @Column(name = "WebSite", nullable = true, length = 100)
//    public String getWebSite() {
//        return webSite;
//    }
//
//    public void setWebSite(String webSite) {
//        this.webSite = webSite;
//    }
//
//    @Column(name = "B2CContractFlag", nullable = false, length = 1)
//    public String getB2CContractFlag() {
//        return b2CContractFlag;
//    }
//
//    public void setB2CContractFlag(String b2CContractFlag) {
//        this.b2CContractFlag = b2CContractFlag;
//    }
//
//    @Column(name = "B2CMailedFlag", nullable = false, length = 1)
//    public String getB2CMailedFlag() {
//        return b2CMailedFlag;
//    }
//
//    public void setB2CMailedFlag(String b2CMailedFlag) {
//        this.b2CMailedFlag = b2CMailedFlag;
//    }
//
//    @Column(name = "B2COnLineFlag", nullable = false, length = 1)
//    public String getB2COnLineFlag() {
//        return b2COnLineFlag;
//    }
//
//    public void setB2COnLineFlag(String b2COnLineFlag) {
//        this.b2COnLineFlag = b2COnLineFlag;
//    }
//
//    @Column(name = "B2CEditOk", nullable = false, length = 1)
//    public String getB2CEditOk() {
//        return b2CEditOk;
//    }
//
//    public void setB2CEditOk(String b2CEditOk) {
//        this.b2CEditOk = b2CEditOk;
//    }
//
//    @Column(name = "B2CStoppedFlag", nullable = false, length = 1)
//    public String getB2CStoppedFlag() {
//        return b2CStoppedFlag;
//    }
//
//    public void setB2CStoppedFlag(String b2CStoppedFlag) {
//        this.b2CStoppedFlag = b2CStoppedFlag;
//    }
//
//    @Column(name = "B2CStopDescr", nullable = true, length = 255)
//    public String getB2CStopDescr() {
//        return b2CStopDescr;
//    }
//
//    public void setB2CStopDescr(String b2CStopDescr) {
//        this.b2CStopDescr = b2CStopDescr;
//    }
//
//    @Column(name = "TAManagedFlag", nullable = false, length = 1)
//    public String getTaManagedFlag() {
//        return taManagedFlag;
//    }
//
//    public void setTaManagedFlag(String taManagedFlag) {
//        this.taManagedFlag = taManagedFlag;
//    }
//
//    @Column(name = "TAAssociatedFlag", nullable = false, length = 1)
//    public String getTaAssociatedFlag() {
//        return taAssociatedFlag;
//    }
//
//    public void setTaAssociatedFlag(String taAssociatedFlag) {
//        this.taAssociatedFlag = taAssociatedFlag;
//    }
//
//    @Column(name = "B2CFlag", nullable = false, length = 1)
//    public String getB2CFlag() {
//        return b2CFlag;
//    }
//
//    public void setB2CFlag(String b2CFlag) {
//        this.b2CFlag = b2CFlag;
//    }
//
//    @Column(name = "B2CSaleableFlag", nullable = false, length = 1)
//    public String getB2CSaleableFlag() {
//        return b2CSaleableFlag;
//    }
//
//    public void setB2CSaleableFlag(String b2CSaleableFlag) {
//        this.b2CSaleableFlag = b2CSaleableFlag;
//    }
//
//    @Column(name = "B2CEditOkFlag", nullable = false, length = 1)
//    public String getB2CEditOkFlag() {
//        return b2CEditOkFlag;
//    }
//
//    public void setB2CEditOkFlag(String b2CEditOkFlag) {
//        this.b2CEditOkFlag = b2CEditOkFlag;
//    }
//
//    @Column(name = "B2CCallAssignedFlag", nullable = false, length = 1)
//    public String getB2CCallAssignedFlag() {
//        return b2CCallAssignedFlag;
//    }
//
//    public void setB2CCallAssignedFlag(String b2CCallAssignedFlag) {
//        this.b2CCallAssignedFlag = b2CCallAssignedFlag;
//    }
//
//    @Column(name = "BookOnLineFlag", nullable = false, length = 1)
//    public String getBookOnLineFlag() {
//        return bookOnLineFlag;
//    }
//
//    public void setBookOnLineFlag(String bookOnLineFlag) {
//        this.bookOnLineFlag = bookOnLineFlag;
//    }
//
//    @Column(name = "OnRequestFlag", nullable = false, length = 1)
//    public String getOnRequestFlag() {
//        return onRequestFlag;
//    }
//
//    public void setOnRequestFlag(String onRequestFlag) {
//        this.onRequestFlag = onRequestFlag;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        HotelEntity that = (HotelEntity) o;
//        return id == that.id &&
//                Objects.equals(ihNumber, that.ihNumber) &&
//                Objects.equals(name, that.name) &&
//                Objects.equals(address, that.address) &&
//                Objects.equals(cap, that.cap) &&
//                Objects.equals(latitude, that.latitude) &&
//                Objects.equals(longitude, that.longitude) &&
//                Objects.equals(foPhone, that.foPhone) &&
//                Objects.equals(boPhone, that.boPhone) &&
//                Objects.equals(fax, that.fax) &&
//                Objects.equals(foMail, that.foMail) &&
//                Objects.equals(boMail, that.boMail) &&
//                Objects.equals(webSite, that.webSite) &&
//                Objects.equals(b2CContractFlag, that.b2CContractFlag) &&
//                Objects.equals(b2CMailedFlag, that.b2CMailedFlag) &&
//                Objects.equals(b2COnLineFlag, that.b2COnLineFlag) &&
//                Objects.equals(b2CEditOk, that.b2CEditOk) &&
//                Objects.equals(b2CStoppedFlag, that.b2CStoppedFlag) &&
//                Objects.equals(b2CStopDescr, that.b2CStopDescr) &&
//                Objects.equals(taManagedFlag, that.taManagedFlag) &&
//                Objects.equals(taAssociatedFlag, that.taAssociatedFlag) &&
//                Objects.equals(b2CFlag, that.b2CFlag) &&
//                Objects.equals(b2CSaleableFlag, that.b2CSaleableFlag) &&
//                Objects.equals(b2CEditOkFlag, that.b2CEditOkFlag) &&
//                Objects.equals(b2CCallAssignedFlag, that.b2CCallAssignedFlag) &&
//                Objects.equals(bookOnLineFlag, that.bookOnLineFlag) &&
//                Objects.equals(onRequestFlag, that.onRequestFlag);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, ihNumber, name, address, cap, latitude, longitude, foPhone, boPhone, fax, foMail, boMail, webSite, b2CContractFlag, b2CMailedFlag, b2COnLineFlag, b2CEditOk, b2CStoppedFlag, b2CStopDescr, taManagedFlag, taAssociatedFlag, b2CFlag, b2CSaleableFlag, b2CEditOkFlag, b2CCallAssignedFlag, bookOnLineFlag, onRequestFlag);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelEntity that = (HotelEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(cap, that.cap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, cap);
    }

    @Override
    public String toString() {
        return "Hotel: " + name + " - " + address + " CAP: " + cap;
    }
}
