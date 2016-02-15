package com.stock.impl.pojo;

import com.stock.shared.pojo.Stock;
import com.stock.shared.pojo.StockTypeEnum;

/**
 * Class representing a stock.
 * @author AN
 * @see com.stock.shared.pojo.Stock
 */
public class StockImpl implements Stock {

  	 /**
  	  * the stock symbol.
  	  */
    private String stockSymbol;

    /**
  	  * the stock type.
  	  */
    private StockTypeEnum stockType;

    /**
     * the stock last dividend.
     */
    private Double lastDividend;

    /**
     * the stock fixed dividend.
     */
    private Double fixedDividend;

    /**
     * the stock par value.
     */
    private Double parValue;

    /**
     * the stock price.
     */
    private Double price;

    /**
     * Default constructor.
     */
    public StockImpl() {

    }

	 /**
	  * Constructor with all properties.
	  * @param stockSymbol
	  * @param stockType
	  * @param lastDividend
	  * @param fixedDividend
	  * @param parValue
	  * @param price
	  */
    public StockImpl(String stockSymbol,
                     StockTypeEnum stockType,
                     Double lastDividend,
                     Double fixedDividend,
                     Double parValue,
                     Double price) {

        this.stockSymbol = stockSymbol;
        this.stockType = stockType;
        this.lastDividend = lastDividend;
		  this.fixedDividend = fixedDividend;
		  this.parValue = parValue;
        this.price = price;
    }


	 @Override
  	 public String getStockSymbol() {

        return this.stockSymbol;
    }

    @Override
    public void setStockSymbol(String stockSymbol) {

        this.stockSymbol = stockSymbol;
    }


    @Override
    public StockTypeEnum getStockType() {

        return this.stockType;
    }

    @Override
    public void setStockType(StockTypeEnum stockType) {

        this.stockType = stockType;
    }

    @Override
    public Double getLastDividend() {

        return this.lastDividend;
    }

    @Override
    public void setLastDividend(Double lastDividend) {

        this.lastDividend = lastDividend;
    }

    @Override
    public Double getFixedDividend() {

        return this.fixedDividend;
    }

    @Override
    public void setFixedDividend(Double fixedDividend) {

        this.fixedDividend = fixedDividend;
    }

    @Override
    public Double getParValue() {

        return this.parValue;
    }

    @Override
    public void setParValue(Double parValue) {

        this.parValue = parValue;
    }

    @Override
    public Double getPrice() {

        return this.price;
    }

    @Override
    public void setPrice(Double price) {

        this.price = price;
    }

    @Override
    public int hashCode() {

        int hash = 1;

        if (this.stockSymbol != null) {

            hash *= this.stockSymbol.hashCode();
        }

        if (this.price != null) {

            hash *= this.price.hashCode();
        }

        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof StockImpl)) {
            return false;
        }

        if (obj == this) {

            return true;
        }

        Stock stock = (Stock) obj;

        boolean equals = true;

        if (this.stockSymbol != null) {

            equals &= this.stockSymbol.equals(stock.getStockSymbol());
        }

        if (this.price != null) {

            equals &= this.price.equals(stock.getPrice());
        }

        return equals;
    }
}
