package models;

import java.util.List;

public class Order {

    private String firstName;
    private String lastName;
    private String address;
    private List<String> color;
    private String phone;
    private String comment;
    private Integer rentTime;
    private String deliveryDate;
    private Integer metroStation;

    public Order() {
    }

    public Order(String firstName, String lastName, String address, String phone, String comment,
                 Integer rentTime, String deliveryDate, Integer metroStation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.comment = comment;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.metroStation = metroStation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public List<String> getColor() {
        return color;
    }

    public String getPhone() {
        return phone;
    }

    public String getComment() {
        return comment;
    }

    public Integer getRentTime() {
        return rentTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public Integer getMetroStation() {
        return metroStation;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }
}