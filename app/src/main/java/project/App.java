package project;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import yahoofinance.YahooFinance;
import yahoofinance.Stock;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.scene.chart.LineChart;
import javafx.application.Application;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    private LineChart<Number, Number> linechart;

    @Override
    public void start(Stage stage){
        stage.setTitle("Dow Jones Industrial Average");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time sec");
        yAxis.setLabel("Price US$");
        lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Dow Jones Industrial Average Price");
        series = new XYChart.Series<>();
        Scene scene = new Scene(lineChart, 800, 600);
        stage.setScene(scene);
        stage.show();
        new Thread(this::updateData).start();
    }
    
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
                Thread.sleep(5000);  // wait 5000ms before the while loop continues
            }
            catch (InterruptedException e) {
                System.out.println("Error:" + e);
            }
        }
    

    }
    public static void main(String[] args) {
        start();
    }
}