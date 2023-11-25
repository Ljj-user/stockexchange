package com.stockexchange.pojo;

import java.time.LocalDateTime;

/**
 * Package: com.stockexchange.pojo
 * ClassName: Transaction
 * Description 交易类，用于记录买入卖出的交易信息
 *
 * @author
 * @Create 2023/11/17/ 23:52
 * @Version 1.0
 */
public class Transaction {
    private boolean transactionType; // 交易类型 0买入 1卖出
    private Stock stock; // 交易所对应的股票
    private int quantity; // 交易数量
    private double transactionPrice; // 交易金额
    private LocalDateTime transactionDate; // 交易日期，这是日期时间类
    private String transactionUser; // 交易用户


    // 全参构造方法
    public Transaction(boolean transactionType, Stock stock, int quantity, double transactionPrice, LocalDateTime transactionDate) {
        this.transactionType = transactionType;
        this.stock = stock;
        this.quantity = quantity;
        this.transactionPrice = transactionPrice;
        this.transactionDate = transactionDate;
    }

    // get和set方法
    public boolean isTransactionType() {
        return transactionType;
    }

    public void setTransactionType(boolean transactionType) {
        this.transactionType = transactionType;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTransactionPrice() {
        return transactionPrice;
    }

    public void setTransactionPrice(double transactionPrice) {
        this.transactionPrice = transactionPrice;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
