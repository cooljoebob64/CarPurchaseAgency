package com.jlu.CarPurchaseAgency;

public class Dealership {
    private String homeOffice;
    private String name;
    private String brand;
    private String address;

    Dealership(){
        this("No Name");
    }
    Dealership(String name){
        this(name, "No Brand Specified");
    }
    Dealership(String name, String brand){
        this(name, brand, "No Address Listed");
    }
    Dealership(String name, String brand, String address){
        this.setName(name);
        this.setBrand(brand);
        this.setAddress(address);
    }

    public String getHomeOffice() {
        return homeOffice;
    }
    private void setHomeOffice(String brand){
        switch (brand){
            case "Chevy" : {
                String chevyHomeOffice = "Chevy Home Offices, USA";
                homeOffice = chevyHomeOffice;}
            case "Honda" : {
                String hondaHomeOffice = "Honda Offices, Japan";
                homeOffice = hondaHomeOffice;}
            default : {homeOffice = "none";}
        }
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setBrand(String brand) {
        this.brand = brand;
        setHomeOffice(brand);
    }
    public String getBrand() {
        return brand;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
