package com.exam.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;
    private int brand;
    private float price;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrandString(){
        List<Brand> brands = Arrays.asList(Brand.values());
        for (Brand brand : brands) {
            if(brand.getValue() == this.brand){
                return brand.toString();
            }
        }
        return Brand.OTHERS.toString();
    }

    public enum Brand{
        APPLE(1), SAMSUNG(2), NOKIA(3), OTHERS(0);
        private final int value;
        private String brandStr;

        Brand(final int newValue) {
            value = newValue;
        }

        public int getValue() { return value; }
    }

    public static final class Builder {
        private int id;
        private String name;
        private int brand;
        private float price;
        private String description;

        private Builder() {
        }

        public static Builder aPhone() {
            return new Builder();
        }

        public Builder withId(int id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withBrand(int brand) {
            this.brand = brand;
            return this;
        }

        public Builder withPrice(float price) {
            this.price = price;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Phone build() {
            Phone phone = new Phone();
            phone.setId(id);
            phone.setName(name);
            phone.setBrand(brand);
            phone.setPrice(price);
            phone.setDescription(description);
            return phone;
        }


    }
}
