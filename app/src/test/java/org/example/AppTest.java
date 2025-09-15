package org.example;

import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class AppTest {
    private static void test() {
        try {
            Stock stock = YahooFinance.get("DJI");
            BigDecimal price = stock.getQuote(true).getPrice();
            System.out.println("Query sucess:" + price);
        }
        catch(IOException e){
            System.out.println("Error: " + e);
        }
    }
    
    public static void main(String[] args) {
        test();
      }
}
