package project;

import java.io.IOException;
import java.math.BigDecimal;

import yahoofinance.YahooFinance;
import yahoofinance.Stock;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class App {
    private void retrieveData() {
        Queue<ArrayList<Object>> stockPriceQueue = new LinkedList<>();
        while (true) {
            try {
                // gets price of dow jones index
                String ticker = "DJI";
                Stock stock = YahooFinance.get(ticker);
                BigDecimal price = stock.getQuote(true).getPrice();
                //

            }
            catch(IOException e) {
                System.out.println("Error: " + e);
            }
        }

    }
}