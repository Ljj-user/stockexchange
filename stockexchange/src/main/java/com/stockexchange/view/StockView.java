package com.stockexchange.view;

import com.stockexchange.pojo.Stock;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class StockView extends JFrame {
    private List<Stock> stocks;
    private DefaultTableModel tableModel;
    private JTable table;

    public StockView(List<Stock> stocks) {
        this.stocks = stocks;

        // 设置窗口标题
        setTitle("Stock Viewer");

        // 初始化Swing组件
        String[] columnNames = {"股票名称", "当前价格", "涨跌幅", "持有数量", "总市值", "收益率（盈亏）"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);

        // 添加股票信息到表格
        for (Stock stock : stocks) {
            addStockToTable(stock);
        }

        // 设置布局管理器
        setLayout(new BorderLayout());

        // 将表格添加到窗口中
        add(new JScrollPane(table), BorderLayout.CENTER);

        // 设置窗口大小和关闭操作
        setSize(600, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示窗口
        setLocationRelativeTo(null); // 居中显示
        setVisible(true);
    }

    // 将股票信息添加到表格
    private void addStockToTable(Stock stock) {
        Object[] rowData = {
                stock.getStockName(),
                formatDecimal(stock.getCurrentPrice()),
                formatDecimal(stock.getIncreasePercentage()) + "%",
                stock.getVolume(),
                "$" + formatDecimal(stock.getMarketCap()),
                formatDecimal(stock.getProfit()) + "%"
        };
        tableModel.addRow(rowData);
    }

    // 格式化小数，保留两位小数
    private String formatDecimal(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(value);
    }

    public static void main(String[] args) {
        // 创建股票对象列表
        List<Stock> stockList = new ArrayList<>();
        stockList.add(new Stock("ABC", 50.0));
        stockList.add(new Stock("XYZ", 75.5));

        // 创建股票信息展示窗口
        SwingUtilities.invokeLater(() -> new StockView(stockList));
    }
}