package org.example;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class AppTest{
    @Test(testName = "verify 1 is 1 its true", description = "This test for verify 1 is 1")
    public void testApp()
    {
        assertEquals(1,1);
    }
}
