/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Car;
import java.util.Objects;

/**
 *
 * @author Joe
 */
public class CarDTO {
    private Long id;
    private int year;
    private String make;
    private String model;
    private int price;
    private String owner;
    private int kmDrived;

    public CarDTO(Car car) {
        this.id = car.getId();
        this.year = car.getYear();
        this.make = car.getMake();
        this.model = car.getModel();
        this.price = car.getPrice();
        this.owner = car.getOwner();
        this.kmDrived = car.getKmDrived();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getKmDrived() {
        return kmDrived;
    }

    public void setKmDrived(int kmDrived) {
        this.kmDrived = kmDrived;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + this.year;
        hash = 67 * hash + Objects.hashCode(this.make);
        hash = 67 * hash + Objects.hashCode(this.model);
        hash = 67 * hash + this.price;
        hash = 67 * hash + Objects.hashCode(this.owner);
        hash = 67 * hash + this.kmDrived;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CarDTO other = (CarDTO) obj;
        if (this.year != other.year) {
            return false;
        }
        if (this.price != other.price) {
            return false;
        }
        if (this.kmDrived != other.kmDrived) {
            return false;
        }
        if (!Objects.equals(this.make, other.make)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
