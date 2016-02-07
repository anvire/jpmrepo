package com.jpmorgan;

import java.lang.StringBuffer;
import java.util.Formatter;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import com.jpmorgan.shared.pojo.Stock;
import com.jpmorgan.shared.pojo.Trade;
import com.jpmorgan.shared.pojo.StockTypeEnum;
import com.jpmorgan.shared.pojo.BuyOrSellEnum;
import com.jpmorgan.shared.service.StockCalculatorService;
import com.jpmorgan.shared.helper.StockCalculatorHelper;
import com.jpmorgan.shared.helper.StockCalculatorException;
import com.jpmorgan.impl.pojo.TradeImpl;
import com.jpmorgan.impl.pojo.StockImpl;
import com.jpmorgan.impl.service.StockCalculatorServiceImpl;
import com.jpmorgan.impl.helper.StockCalculatorHelperImpl;

/**
 * Main class of search.co.uk Java code test
 * @author AN
 * Usage : java -jar super-simple-stocks-1.0-SNAPSHOT.jar
 */
public class App
{
    public static void main( String[] args ) throws StockCalculatorException
    {
        StockCalculatorHelper stockCalculatorHelper = new StockCalculatorHelperImpl();
        StockCalculatorService stockCalculatorService = new StockCalculatorServiceImpl();


        Stock tea = new StockImpl("TEA", StockTypeEnum.COMMON, 0d, null, 100d, 110d);
        Stock pop = new StockImpl("POP", StockTypeEnum.COMMON, 8d, null, 100d, 120d);
        Stock ale = new StockImpl("ALE", StockTypeEnum.COMMON, 23d, null, 60d, 55d);
        Stock gin = new StockImpl("GIN", StockTypeEnum.PREFERRED, 8d, 2d, 100d, 100d);
        Stock joe = new StockImpl("JOE", StockTypeEnum.COMMON, 13d, null, 250d, 216.12d);

        List<Stock> stocks = new ArrayList<Stock>();
        stocks.add(tea);
        stocks.add(pop);
        stocks.add(ale);
        stocks.add(gin);
        stocks.add(joe);

        Stock stock = null;
        Trade trade = null;
        List<Trade> trades = null;

        Random rand = new Random();

        int nbTrades = rand.nextInt(100 - 10 + 1) + 10;

        Map<Stock, List<Trade>> map = new HashMap<Stock, List<Trade>>();

        for(int i = 0; i < nbTrades; i++) {

            stock = stocks.get(rand.nextInt(stocks.size() - 1));

            trades = map.get(stock);

            if (trades == null) {

                trades = new ArrayList<Trade>();

                map.put(stock, trades);
            }

            trade = new TradeImpl(stock, new Date(), (rand.nextDouble()*1000d + 50d),
                                  rand.nextBoolean()?BuyOrSellEnum.BUY:BuyOrSellEnum.SELL, (rand.nextDouble()*1000d + 50d));

            trades.add(trade);
        }

        StringBuffer buff = null;
        Formatter formatter = null;

        System.out.println("+--------+----------------+-----------+-------------+");
        System.out.println("| Symbol | Dividend yield | P/E ratio | Stock price |");
        System.out.println("+--------+----------------+-----------+-------------+");

        for(Stock stockForCalculs : stocks) {

            trades = map.get(stockForCalculs);

            buff = new StringBuffer();
            formatter = new java.util.Formatter(buff);

            formatter.format("| %6s | %14.2f | %9.2f | %11.2f |",
                              stockForCalculs.getStockSymbol(),

                               stockForCalculs.getStockType().equals(StockTypeEnum.COMMON)?
                              	stockCalculatorHelper.calculateDividendYieldCommon(
                                		stockForCalculs.getParValue(), stockForCalculs.getLastDividend()):
                              	stockCalculatorHelper.calculateDividendYieldPreferred(
                                		stockForCalculs.getParValue(), stockForCalculs.getParValue(), stockForCalculs.getFixedDividend())
                               ,
                              stockCalculatorHelper.calculatePeRatio(
                                stockForCalculs.getParValue(), stockForCalculs.getLastDividend()),

                              stockCalculatorService.calculateStockPrice(trades)
                              );
            System.out.println(buff);
            System.out.println("+--------+----------------+-----------+-------------+");
        }

        System.out.println();
        System.out.println();

        System.out.println("+----------------+");
        System.out.println("| GBCE All share |");
        System.out.println("+----------------+");

        buff = new StringBuffer();
        formatter = new java.util.Formatter(buff);

        formatter.format("| %14.2f |",
        					 stockCalculatorService.calculateSharesIndexes(stocks)
                        );
        System.out.println(buff);
        System.out.println("+----------------+");
        System.out.println();
        System.out.println();
}
}
