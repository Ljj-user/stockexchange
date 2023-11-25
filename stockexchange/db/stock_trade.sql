-- 创建数据库
create database stock_trade;

-- 使用数据库
use stock_trade;

-- 创建User表
CREATE TABLE User (
                      userId INT PRIMARY KEY,
                      userName VARCHAR(255) NOT NULL,
                      password VARCHAR(255) NOT NULL,
                      balance DOUBLE NOT NULL,
                      cashBalance DOUBLE NOT NULL
);

-- 创建Stock表
CREATE TABLE Stock (
                       stockCode INT PRIMARY KEY,
                       stockName VARCHAR(255) NOT NULL,
                       currentPrice DOUBLE NOT NULL,
                       increasePercentage DOUBLE NOT NULL,
                       volume INT NOT NULL,
                       marketCap DOUBLE NOT NULL,
                       Profit DOUBLE NOT NULL
);

-- 创建Transaction表
CREATE TABLE Transaction (
                             transactionId INT PRIMARY KEY,
                             transactionType BOOLEAN NOT NULL,
                             stockCode INT,
                             quantity INT NOT NULL,
                             transactionPrice DOUBLE NOT NULL,
                             transactionDate TIMESTAMP NOT NULL,
                             userId INT,
                             FOREIGN KEY (stockCode) REFERENCES Stock(stockCode),
                             FOREIGN KEY (userId) REFERENCES User(userId)
);
