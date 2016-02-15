package com.stock.impl.pojo;

import java.util.Date;
import com.stock.shared.pojo.Trade;
import com.stock.shared.pojo.Stock;
import com.stock.shared.pojo.BuyOrSellEnum;

/**
 * Class representing a trade.
 * @author AN
 * @see com.stock.shared.pojo.Trade
 */
public class TradeImpl implements Trade {

  	 /*
  	  * Stock.
  	  */
    private Stock stock;

  	 /*
  	  * Timestamp of the trade.
  	  */
  	 private Date timestamp;

    /*
  	  * Share quantity of trade.
  	  */
    private Double sharesQuantity;

  	 /*
  	  * Buy or sell indicator.
  	  */
    private BuyOrSellEnum buyOrSellIndicator;

    /*
  	  * Trade's price.
  	  */
    private Double price;

  	 /**
  	  * Default constructor.
  	  */
    public TradeImpl() {

    }

    /**
     * Constructor with all properties.
     * @param stock
     * @param timestamp
     * @param sharesQuantity
     * @param buyOrSellIndicator
     * @param price
     */
    public TradeImpl(Stock stock,
                     Date timestamp,
                     Double sharesQuantity,
                     BuyOrSellEnum buyOrSellIndicator,
                     Double price) {

        this.stock = stock;
        this.timestamp = timestamp;
        this.sharesQuantity = sharesQuantity;
        this.buyOrSellIndicator = buyOrSellIndicator;
        this.price = price;
    }

    @Override
  	 public Stock getStock() {

        return this.stock;
    }

    @Override
    public void setStock(Stock stock) {

        this.stock = stock;
    }

    @Override
  	 public Date getTimestamp() {

        return this.timestamp;
    }

    @Override
    public void setTimestamp(Date timestamp) {

        this.timestamp = timestamp;
    }

    @Override
    public Double getSharesQuantity() {

        return this.sharesQuantity;
    }

    @Override
    public void setSharesQuantity(Double sharesQuantity) {

        this.sharesQuantity = sharesQuantity;
    }

    @Override
    public BuyOrSellEnum getBuyOrSellIndicator() {

        return this.buyOrSellIndicator;
    }

    @Override
    public void setBuyOrSellIndicator(BuyOrSellEnum buyOrSellIndicator) {

        this.buyOrSellIndicator = buyOrSellIndicator;
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

        if (this.stock != null) {

            hash *= this.stock.hashCode();
        }

        if (this.timestamp != null) {

            hash *= this.timestamp.hashCode();
        }

        if (this.sharesQuantity != null) {

            hash *= this.sharesQuantity.hashCode();
        }

        if (this.buyOrSellIndicator != null) {

            hash *= this.buyOrSellIndicator.hashCode();
        }

        if (this.price != null) {

            hash *= this.price.hashCode();
        }

        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof TradeImpl)) {
            return false;
        }

        if (obj == this) {

            return true;
        }

        Trade trade = (Trade) obj;

        boolean equals = true;

        if (this.stock != null) {

            equals &= this.stock.equals(trade.getStock());
        }

        if (this.timestamp != null) {

            equals &= this.timestamp.equals(trade.getTimestamp());
        }

        if (this.sharesQuantity != null) {

            equals &= this.sharesQuantity.equals(trade.getSharesQuantity());
        }

        if (this.buyOrSellIndicator != null) {

            equals &= this.buyOrSellIndicator.equals(trade.getBuyOrSellIndicator());
        }

        if (this.price != null) {

            equals &= this.price.equals(trade.getPrice());
        }

        return equals;
    }
}
