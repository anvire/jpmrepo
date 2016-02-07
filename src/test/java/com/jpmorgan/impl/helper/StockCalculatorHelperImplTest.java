package com.jpmorgan.impl.helper;

import com.jpmorgan.shared.helper.StockCalculatorHelper;
import com.jpmorgan.shared.helper.StockCalculatorException;
import com.jpmorgan.impl.helper.StockCalculatorHelperImpl;
import org.junit.Test;
import org.junit.Assert;

/**
 * Test class of stock calculation helper implementation StockCalculatorHelperImpl.
 * @author AN
 * @see StockCalculatorHelperImpl
 */
public class StockCalculatorHelperImplTest {

  	private StockCalculatorHelper stockCalculatorHelper = new StockCalculatorHelperImpl();

  	/**
  	 * Test method for @see StockCalculatorHelperImpl.calculateDividendYieldCommon(double, double)
  	 */
	 @Test
    public void testCalculateDividendYieldCommon()
    {
        Assert.assertEquals(0.06d,
                    this.stockCalculatorHelper.calculateDividendYieldCommon(25d, 1.5d), 0d);

		  Assert.assertEquals(0d,
                    this.stockCalculatorHelper.calculateDividendYieldCommon(25d, 0d), 0d);

        double result = this.stockCalculatorHelper.calculateDividendYieldCommon(0d, 1.5d);

        Assert.assertTrue(result == Double.POSITIVE_INFINITY ||
                    result == Double.NEGATIVE_INFINITY);
    }

   /**
  	 * Test method for @see StockCalculatorHelperImpl.calculateDividendYieldPreferred(double, double, double)
  	 */
	 @Test
    public void testCalculateDividendYieldPreferred()
    {
        Assert.assertEquals(0.4d,
                    this.stockCalculatorHelper.calculateDividendYieldPreferred(25d, 20d, 0.5d), 0d);

		  Assert.assertEquals(0d,
                    this.stockCalculatorHelper.calculateDividendYieldPreferred(25d, 0d, 0.5d), 0d);

		  Assert.assertEquals(0d,
                    this.stockCalculatorHelper.calculateDividendYieldPreferred(25d, 20d, 0d), 0d);

        double result = this.stockCalculatorHelper.calculateDividendYieldPreferred(0d, 20d, 0.5d);

        Assert.assertTrue(result == Double.POSITIVE_INFINITY ||
                    result == Double.NEGATIVE_INFINITY);
    }


  	/**
  	 * Test method for @see StockCalculatorHelper.calculatePeRatio(double, double)
  	 */
	 @Test
    public void testCalculatePeRatio()
    {
        Assert.assertEquals(22.05128205128205d,
                    this.stockCalculatorHelper.calculatePeRatio(43d, 1.95d), 0d);

		  Assert.assertEquals(0d,
                    this.stockCalculatorHelper.calculatePeRatio(0d, 1.95d), 0d);

        double result = this.stockCalculatorHelper.calculatePeRatio(43d, 0d);

        Assert.assertTrue(result == Double.POSITIVE_INFINITY ||
                    result == Double.NEGATIVE_INFINITY);
    }

  	/**
  	 * Test method for @see StockCalculatorHelper.calculateGeometricMean(double...)
  	 */
	 @Test
    public void testCalculateGeometricMean()
    {
        Assert.assertEquals(0d,
                    this.stockCalculatorHelper.calculateGeometricMean(), 0d);

        Assert.assertEquals(0d,
                    this.stockCalculatorHelper.calculateGeometricMean(0d), 0d);

        Assert.assertEquals(23.321576831999096,
                    this.stockCalculatorHelper.calculateGeometricMean(43d, 1.95d, 56d, 63d), 0d);

		  Assert.assertEquals(0d,
                    this.stockCalculatorHelper.calculateGeometricMean(0d, 1.95d), 0d);
    }

   /**
  	 * Test method for @see StockCalculatorHelper.calculateStockPrice(double, double)
  	 */
	 @Test
    public void testCalculateStockPrice() throws StockCalculatorException
    {

        Assert.assertEquals(0d,
                    this.stockCalculatorHelper.calculateStockPrice(null, null), 0d);

        try {

            this.stockCalculatorHelper.calculateStockPrice(new double[] {24d, 13d, 2.5d}, null);

            Assert.fail("A StockCalculatorException must have been thrown");

        } catch (StockCalculatorException sce) {}

        try {

            this.stockCalculatorHelper.calculateStockPrice(
              	 new double[] {24d, 13d, 2.5d}, new double[] {4d, 8d, 10d, 12d});

            Assert.fail("A StockCalculatorException must have been thrown");

        } catch (StockCalculatorException sce) {}

        Assert.assertEquals(7.166666666666667d,
                    this.stockCalculatorHelper.calculateStockPrice(
              	 new double[] {24d, 13d, 2.5d}, new double[] {4d, 8d, 10d}), 0d);
    }
}
