package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name = "alphaNum")
    public Object[][] testData(){
        return new Object[][]{
                {"a",'1'}, {"b",'2'}
        };
    }
    @Test(dataProvider = "alphaNum")
    public void dataProviderTest(String alpha, char num){
        System.out.println(alpha+num);
    }
}
