package com.stockexchange.pojo;

import java.util.List;

/**
 * Package: com.stockexchange.pojo
 * ClassName: User
 * Description 用户类
 *
 * @author
 * @Create 2023/11/17/ 20:40
 * @Version 1.0
 */
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private double balance; // 用户余额 指可用于购买股票的现金余额
    private double cashBalance; // 总资产 = 用户余额 + 用户持有的股票总市值
    private List<Stock> ownedStocks; // 持有的股票列表 这是一个集合，其元素类型为Stock


    // 构造方法
    // 要输入的参数：用户名，密码
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    // get和set方法
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(double cashBalance) {
        this.cashBalance = cashBalance;
    }

    public List<Stock> getOwnedStocks() {
        return ownedStocks;
    }

    public void setOwnedStocks(List<Stock> ownedStocks) {
        this.ownedStocks = ownedStocks;
    }
}
