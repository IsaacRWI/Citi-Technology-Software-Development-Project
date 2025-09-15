package project;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import yahoofinance.YahooFinance;
import yahoofinance.Stock;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.HashMap;

public class App {
    private void retrieveData() {
        Queue<ArrayList<Object>> stockPriceQueue = new LinkedList<>();
        while (true) {
            try {
                // gets price of dow jones index
                String ticker = "DJI";
                Stock stock = YahooFinance.get(ticker);
                BigDecimal price = stock.getQuote(true).getPrice();
                LocalDateTime timestamp = LocalDateTime.now();
                
                // add stock data to queue
                // HashMap<LocalDateTime, BigDecimal> stockData = new HashMap<>();
                ArrayList<Object> stockData = new ArrayList<>();
                stockData.add(timestamp);
                stockData.add(price);
                stockPriceQueue.add(stockData);

            }
            catch(IOException e) {
                System.out.println("Error: " + e);
            }
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                System.out.println("Error:" + e);
            }
        }
    

    }
}