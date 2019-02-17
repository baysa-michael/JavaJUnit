package cit360.junit;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class BSTest {

    @Test
    public void testEqualsObject() {
        // Assert Not Null, Assert Null, Assert Same, Assert Not Same

        //Initialize
        BalanceSheet testBS = new BalanceSheet("Michael", 200, 100, 100);
        IncomeStatement testIS = new IncomeStatement();

        System.out.println("BEGIN");

        // Make Sure the balance sheet is not empty
        assertNotNull(testBS);

        // Make sure the balance sheet is not the income statement
        assertNotSame(testBS, testIS);

        // Empty Balance Sheet & Test this is Null and Not the Same
        BalanceSheet otherBS = null;
        assertNull(otherBS);
        assertNotSame(testBS, otherBS);

        // Assign otherBS to testBS & Test to make sure these two point to the same object
        otherBS = testBS;
        assertSame(testBS, otherBS);

        // Create Another Balance Sheet
        BalanceSheet anotherBS = new BalanceSheet("Michael", 200, 100, 100);
        assertNotSame(testBS, anotherBS);


        System.out.println("END WITHOUT ERROR");
    }

    @Test
    public void testEqualsPrimitive() {
        // Assert Equals
        BalanceSheet testBS = new BalanceSheet("Michael", 200, 100, 100);

        System.out.println("BEGIN");

        // Empty Balance Sheet
        BalanceSheet otherBS = new BalanceSheet();

        // Validate A = L + E
        assertEquals((Float) testBS.getAssets(), (Float) (testBS.getLiabilities() + testBS.getEquity()));

        // Purchase an item
        testBS.buyOnCredit(25);

        // Sell a product
        testBS.sellProduct(75, 25);

        // Validate A = L + E after buy on credit
        assertEquals(testBS.getAssets(), (testBS.getLiabilities() + testBS.getEquity()), .01f);

        System.out.println("END WITHOUT ERROR");
    }

    @Test
    public void testArrayEquals() {
        // Assert Array Equals

        System.out.println("BEGIN");

        BalanceSheet testBS = new BalanceSheet("Michael", 200, 100, 100);
        float[] manualTransactions = {50f, 10f};

        // Record Sale
        testBS.sellProduct(50, 10);

        // Retrieve Transactions
        float[] recordedTransactions = new float[2];
        for (int i = 0; i < testBS.getTransactionList().size(); i++) {
            recordedTransactions[i] = testBS.getTransactionList().get(i);
        }

        // Test Arrays Match
        assertArrayEquals(manualTransactions, recordedTransactions, .01f);

        System.out.println("END WITHOUT ERROR");
    }

    @Test
    public void testValue() {
        // Assert True, Assert False, & Assert That
        BalanceSheet testBS = new BalanceSheet("Michael", 200, 100, 100);

        System.out.println("BEGIN");

        float currentEquity = testBS.getEquity();

        assertTrue(testBS.getAssets() == (testBS.getLiabilities() + testBS.getEquity()));

        testBS.buyOnCredit(75);

        assertFalse(currentEquity != testBS.getEquity());

        // NOTE:  This method is deprecated according to the JUnit 4 Documentation
        assertThat(currentEquity, is(testBS.getEquity()));

        System.out.println("END WITHOUT ERROR");
    }


}
