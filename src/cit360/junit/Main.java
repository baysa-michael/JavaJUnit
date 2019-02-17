package cit360.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {

    public static void main(String[] args) {
        // Run the Test Suite
        Result testResults = JUnitCore.runClasses(TestPrimer.class);

        // Print the results of all failures to the console
        for (Failure thisFail : testResults.getFailures()) {
            System.out.println(thisFail.toString() + "\n" + thisFail.getTrace());
        }

        // Print Success
        if (testResults.wasSuccessful()) {
            System.out.println("CONGRATULATIONS!  All Assertions are True");
        }
    }
}
