package com.example.sahilgogna.drinksurvey.Model;

import java.io.Serializable;

public class ClientDetails implements Serializable {

    int clientNumber;
    String DrinkType;
    String Drink;
    int numberOfCups;

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getDrinkType() {
        return DrinkType;
    }

    public void setDrinkType(String drinkType) {
        DrinkType = drinkType;
    }

    public String getDrink() {
        return Drink;
    }

    public void setDrink(String drink) {
        Drink = drink;
    }

    public int getNumberOfCups() {
        return numberOfCups;
    }

    public void setNumberOfCups(int numberOfCups) {
        this.numberOfCups = numberOfCups;
    }
}
