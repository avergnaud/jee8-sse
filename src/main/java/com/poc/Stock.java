package com.poc;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Stock {
    private Integer id;
    private BigDecimal price;
    LocalDateTime dateTime;

    public Stock(Integer id, BigDecimal price, LocalDateTime dateTime) {
        this.id = id;
        this.price = price;
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}