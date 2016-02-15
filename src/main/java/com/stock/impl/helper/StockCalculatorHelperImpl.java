package com.stock.impl.helper;

import com.stock.shared.helper.StockCalculatorHelper;
import com.stock.shared.helper.StockCalculatorException;

/**
 * Class used for stock calculation.
 * @author AN
 */
public class StockCalculatorHelperImpl implements StockCalculatorHelper {

  	/**
  	 * @see StockCalculatorHelper.calculateDividendYieldCommon(double, double)
  	 */
    @Override
    public double calculateDividendYieldCommon(double tickerPrice, double lastDividend) {

      	return lastDividend / tickerPrice;
    }

  	/**
  	 * @see StockCalculatorHelper.calculateDividendYieldPreferred(double, double, double)
  	 */
    @Override
    public double calculateDividendYieldPreferred(double tickerPrice, double parValue, double fixedDividend) {

      	return (fixedDividend * parValue) / tickerPrice;
    }

  	/**
  	 * @see StockCalculatorHelper.calculatePeRatio(double, double)
  	 */
    @Override
    public double calculatePeRatio(double tickerPrice, double lastDividend) {

      	return tickerPrice / lastDividend;
    }

   /**
  	 * @see StockCalculatorHelper.calculateGeometricMean(double...)
  	 */
   @Override
    public double calculateGeometricMean(double... tradesPrices) {

        if (tradesPrices == null || (tradesPrices != null && tradesPrices.length == 0)) {

            return 0d;
        }

        double geometricMean = tradesPrices[0];

        for(int i = 1; i < tradesPrices.length; i++) {

            geometricMean *= tradesPrices[i];
        }

        Integer n = new Integer(tradesPrices.length);

        return Math.pow(geometricMean, 1.0d / n.doubleValue());
    }
    @Override
    public double calculateStockPrice(double[] tradesPrices, double[] tradesQuantities) throws StockCalculatorException {

		  if (tradesPrices == null || (tradesPrices != null && tradesPrices.length == 0)) {

            return 0d;
        }

        if (tradesQuantities == null) {

            throw new StockCalculatorException("trades quantities array is null !");
        }

        if (tradesPrices.length != tradesQuantities.length) {

            throw new StockCalculatorException("trades prices and quantities arrays are not the same length !");
        }

		  double pricesPerQuantities = 0d;
        double quantities = 0d;

        for(int i = 1; i < tradesPrices.length; i++) {

            pricesPerQuantities += tradesPrices[i] * tradesQuantities[i];

            quantities += tradesQuantities[i];
        }

        return pricesPerQuantities / quantities;
    }
}
