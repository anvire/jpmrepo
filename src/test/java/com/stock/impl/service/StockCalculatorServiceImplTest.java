package com.stock.impl.service;

import java.util.List;
import java.util.Date;
import java.util.ArrayList;
import com.stock.shared.pojo.Stock;
import com.stock.shared.pojo.Trade;
import com.stock.shared.pojo.StockTypeEnum;
import com.stock.shared.pojo.BuyOrSellEnum;
import com.stock.shared.service.StockCalculatorService;
import com.stock.shared.helper.StockCalculatorException;
import com.stock.impl.pojo.TradeImpl;
import com.stock.impl.pojo.StockImpl;
import org.junit.Test;
import org.junit.Assert;

/**
 * Test class of stock calculation service implementation StockCalculatorServiceImpl.
 * @author AN
 * @see StockCalculatorServiceImpl
 */
public class StockCalculatorServiceImplTest {

    private StockCalculatorService stockCalculatorService = new StockCalculatorServiceImpl();

    /**
     * Test of @see StockCalculatorServiceImpl.calculateStockPrice(List<Trade>)
     */
    @Test
    public void testCalculateStockPrice() throws StockCalculatorException {

        Stock tea = new StockImpl("TEA", StockTypeEnum.COMMON, 0d, null, 100d, 110d);

        Trade trade1 = new TradeImpl(tea, new Date(), 1000d, BuyOrSellEnum.BUY, 110d);
        Trade trade2 = new TradeImpl(tea, new Date(), 300d, BuyOrSellEnum.SELL, 102d);

        List<Trade> trades = new ArrayList<Trade>();
        trades.add(trade1);
        trades.add(trade2);

		  Assert.assertEquals(102.0,
                           stockCalculatorService.calculateStockPrice(trades), 0d);
    }

    /**
     * Test of @see StockCalculatorServiceImpl.calculateSharesIndexes(List<Stock>)
     */
    @Test
    public void testCalculateSharesIndexes() {

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

		  Assert.assertEquals(0.17938927757244394d,
                           stockCalculatorService.calculateSharesIndexes(stocks), 0d);
    }
}
