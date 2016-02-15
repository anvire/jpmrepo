package com.stock.shared.pojo;

import java.util.Date;

/**
 * Interface of a trade.
 * @author AN
 */
public interface Trade {

    /**
  	  * Returns the trade's stock.
  	  * @return trade's stock
  	  */
  	 Stock getStock();

  	 /**
  	  * Sets the trade's stock.
  	  * @param stock trade's stock
  	  */
    void setStock(Stock stock);

  	 /**
  	  * Returns the trade's timestamp.
  	  * @return trade's timestamp
  	  */
  	 Date getTimestamp();

  	 /**
  	  * Sets the trade's timestamp.
  	  * @param timestamp trade's timestamp
  	  */
    void setTimestamp(Date timestamp);

    /**
  	  * Returns the trade's shares quantity.
  	  * @return trade's shares quantity
  	  */
    Double getSharesQuantity();

  	 /**
  	  * Sets the trade's timestamp.
  	  * @param sharesQuantity trade's shares quantity
  	  */
    void setSharesQuantity(Double sharesQuantity);

    /**
  	  * Returns the trade's buy or sell indicator.
  	  * @return trade's buy or sell indicator
  	  */
    BuyOrSellEnum getBuyOrSellIndicator();

  	 /**
  	  * Sets the trade's buy or sell indicator.
  	  * @param buyOrSellIndicator trade's buy or sell indicator
  	  */
    void setBuyOrSellIndicator(BuyOrSellEnum buyOrSellIndicator);

    /**
  	  * Returns the trade's price.
  	  * @return trade's price
  	  */
    Double getPrice();

  	 /**
  	  * Sets the trade's price.
  	  * @param price trade's price
  	  */
    void setPrice(Double price);

}
