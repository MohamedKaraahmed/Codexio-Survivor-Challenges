package org.example;

import java.util.ArrayList;
import java.util.List;

class Shop {
    private static Shop instance;

    public static Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }

        return instance;
    }

    private List workers = new ArrayList();

    public void addWorker(Object worker) {
        this.workers.add(worker);
    }

    public double getTurnover() {
        var turnOver = 0.0;
        for (Object worker : this.workers) {
            if (worker instanceof  SalesConsultant); {
                assert worker instanceof SalesConsultant;
                turnOver += (( SalesConsultant)worker).getMoney();
            }

        }

        return turnOver;
    }
}

class SalesConsultant {

    private  Shop workingShop;
    private double earnedMoney;

    public  SalesConsultant() {
        this.workingShop =  Shop.getInstance();
        this.workingShop.addWorker(this);
    }

    public void sellProduct(double price) {
        this.earnedMoney += Math.max(price, 0);
    }

    public double getMoney() {
        return this.earnedMoney;
    }
}

class MarketingSpecialist {
    private Shop workingShop;
    private double budget = 5000.00;

    public MarketingSpecialist() {
        this.workingShop =  Shop.getInstance();
        this.workingShop.addWorker(this);
    }

    public void spendMoney(double marketingCampaignCost) {
        this.budget -= Math.max(marketingCampaignCost, 0);
    }

    public double getBudget() {
        return this.budget;
    }
}