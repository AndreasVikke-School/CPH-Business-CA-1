/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author Joe
 */
@Entity
@NamedQuery(name = "Car.deleteAllRows", query = "DELETE from Car")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int year;
    private String make;
    private String model;
    private int price;
    private String owner;
    private int kmDrived;

    public Car() {
    }

    public Car(int year, String make, String model, int price, String owner, int kmDrived) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.price = price;
        this.owner = owner;
        this.kmDrived = kmDrived;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public String getOwner() {
        return owner;
    }

    public int getKmDrived() {
        return kmDrived;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + this.year;
        hash = 17 * hash + Objects.hashCode(this.make);
        hash = 17 * hash + Objects.hashCode(this.model);
        hash = 17 * hash + this.price;
        hash = 17 * hash + Objects.hashCode(this.owner);
        hash = 17 * hash + this.kmDrived;
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
        final Car other = (Car) obj;
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
