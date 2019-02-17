package cit360.junit;

import java.util.ArrayList;
import java.util.List;

public class IncomeStatement {
    private float revenue;
    private float expense;
    private List<Float> transactionList;

    public IncomeStatement() {
        this.revenue = 0;
        this.expense = 0;
        this.transactionList = new ArrayList<Float>();
    }

    public IncomeStatement(float revenue, float expense, float netIncome) {
        this.revenue = revenue;
        this.expense = expense;
        this.transactionList = new ArrayList<Float>();
    }

    public void sellProduct(float salesPrice, float cogs) {
        this.revenue += salesPrice;
        this.expense += cogs;
        this.transactionList.add(salesPrice);
        this.transactionList.add(-cogs);
    }

    public void incurExpense(float expense) {
        this.expense += expense;
        this.transactionList.add(-expense);
    }

    public float calculateNetIncome() {
        return this.revenue - this.expense;
    }
}
