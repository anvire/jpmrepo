package com.jpmorgan.shared.pojo;

public interface Stock {
  
  	 /**
  	  * Returns the stock's symbol.
  	  * @return stock's symbol
  	  */
  	 String getStockSymbol();
  
  	 /**
  	  * Sets the stock's symbol.
  	  * @param stockSymbol stock's symbol
  	  */
    void setStockSymbol(String stockSymbol);

    /**
  	  * Returns the stock's type.
  	  * @return stock's type
  	  */
    StockTypeEnum getStockType();

    /**
  	  * Sets the stock's type.
  	  * @param stockType stock's type
  	  */
    void setStockType(StockTypeEnum stockType);


    /**
  	  * Returns the stock's last dividend.
  	  * @return stock's last dividend
  	  */
    Double getLastDividend();

    /**
  	  * Sets the stock's last dividend.
  	  * @param lastDividend stock's last dividend
  	  */
    void setLastDividend(Double lastDividend);

    /**
  	  * Returns the stock's fixed dividend.
  	  * @return stock's fixed dividend
  	  */
    Double getFixedDividend();

    /**
  	  * Sets the stock's fixed dividend.
  	  * @param fixedDividend stock's fixed dividend
  	  */
    void setFixedDividend(Double fixedDividend);

  
    /**
  	  * Returns the stock's par value.
  	  * @return stock's par value
  	  */
    Double getParValue();

    /**
  	  * Sets the stock's price.
  	  * @param parValue par value's par value
  	  */
    void setParValue(Double parValue);
  
    /**
  	  * Returns the stock's price.
  	  * @return stock's price
  	  */
    Double getPrice();

    /**
  	  * Sets the stock's price.
  	  * @param price stock's price
  	  */
    void setPrice(Double price);
}
