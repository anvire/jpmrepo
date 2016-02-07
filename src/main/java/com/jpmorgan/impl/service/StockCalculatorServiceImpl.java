package com.jpmorgan.impl.service;

import java.util.List;
import com.jpmorgan.shared.pojo.Trade;
import com.jpmorgan.shared.pojo.Stock;
import com.jpmorgan.shared.helper.StockCalculatorException;
import com.jpmorgan.shared.service.StockCalculatorService;
import com.jpmorgan.shared.helper.StockCalculatorHelper;
import com.jpmorgan.impl.service.StockCalculatorServiceImpl;
import com.jpmorgan.impl.helper.StockCalculatorHelperImpl;

/**
 * Class of stock calculation service.
 * @author AN
 */
public class StockCalculatorServiceImpl implements StockCalculatorService {

    private StockCalculatorHelper stockCalculatorHelper = new StockCalculatorHelperImpl();

    @Override
    public double calculateStockPrice(List<Trade> trades) throws StockCalculatorException {

        if (trades == null) {

            return 0d;
        }

        double[] tradesPrices = new double[trades.size()];
        double[] tradesQuantities = new double[trades.size()];


        int  i = 0;
        for(Trade trade : trades) {

            tradesPrices[i] = trade.getPrice();
            tradesQuantities[i] = trade.getSharesQuantity();

            i++;
        }

        return stockCalculatorHelper.calculateStockPrice(tradesPrices, tradesQuantities);
    }

    @Override
    public double calculateSharesIndexes(List<Stock> stocks) {

        double[] tradesPrices = new double[stocks.size()];

        double totalParValues = 0d;

        int  i = 0;
        for(Stock stock : stocks) {

            totalParValues += stock.getParValue();

            tradesPrices[i] = stock.getPrice();

            i++;
        }

        double geometricMean = stockCalculatorHelper.calculateGeometricMean(tradesPrices);

        return geometricMean / totalParValues;
    }

    @Override
    public double calculateGeometricMean(List<Stock> stocks) {

        double[] tradesPrices = new double[stocks.size()];

        double totalParValues = 0d;

        int  i = 0;
        for(Stock stock : stocks) {

            totalParValues += stock.getParValue();

            tradesPrices[i] = stock.getPrice();

            i++;
        }

        double geometricMean = stockCalculatorHelper.calculateGeometricMean(tradesPrices);

        return geometricMean / totalParValues;
    }
}