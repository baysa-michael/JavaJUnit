package cit360.junit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BalanceSheet {
    private String owner;
    private float assets;
    private float liabilities;
    private float equity;
    private List<Float> transactionList;

    public BalanceSheet() {
        owner = "";
        assets = 0;
        liabilities = 0;
        equity = 0;
        transactionList = new ArrayList<Float>();
    }

    public BalanceSheet(String owner, float assets, float liabilities, float equity) {
        this.owner = owner;
        this.assets = assets;
        this.liabilities = liabilities;
        this.equity = equity;
        transactionList = new ArrayList<Float>();
    }

    public String getOwner() {
        return owner;
    }

    public float getAssets() {
        return assets;
    }

    public float getLiabilities() {
        return liabilities;
    }

    public float getEquity() {
        return equity;
    }

    public List<Float> getTransactionList() {
        return transactionList;
    }

    public void buyOnCredit(float cost) {
        this.assets += cost;
        this.liabilities += cost;
        this.transactionList.add(cost);
    }

    public void sellProduct(float salesPrice, float cogs) {
        this.assets += (salesPrice - cogs);
        this.equity += (salesPrice - cogs);
        this.transactionList.add(salesPrice);
        this.transactionList.add(cogs);
    }
}
