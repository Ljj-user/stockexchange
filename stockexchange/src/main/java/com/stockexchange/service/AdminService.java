package com.stockexchange.service;

import com.stockexchange.mapper.StockMapper;
import com.stockexchange.mapper.UserMapper;
import com.stockexchange.pojo.Stock;
import com.stockexchange.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Package: com.stockexchange.service
 * ClassName: AdminService
 * Description 管理员服务
 *
 * @author
 * @Create 2023/11/18/ 19:42
 * @Version 1.0
 */
@Service
@SuppressWarnings({"all"})
public class AdminService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 功能：删除用户
     *      先调用UserMapper中的findByUserName()来根据用户名查找用户
     *      如果查找到的user值为null则返回0（用户不存在）
     *      如果查找到的user值不为null则调用UserMapper中的deleteUser()来删除用户并返回1（删除成功）
     */
    public int deleyeUser(String userName) {
        return 1;
    }

    /**
     * 功能：删除股票
     *      先调用StockMapper中的findStockByName()来根据股票名查找股票：
     *      如果查找到的stock值为null则返回0（股票不存在）
     *      如果查找到的stock值不为null则调用StockMapper中的deleteStock()来删除故股票并返回1（删除成功）
     */
    public int deleteStock(String stockName) {
        return 1;
    }

    /**
     * 功能：修改股票信息
     *      先调用StockMapper中的findStockByName()来根据股票名查找股票：
     *      如果查找到的stock值为null则返回0（股票不存在）
     *      如果查找到的stock值不为null则
     *          先执行stock.setStockName(newStockName)
     *          再调用StockMapper中的updateStockInfo()来修改股票名称并返回1（修改成功）
     */
    public int updateStockInfo(String oldStockName, String newStockName) {
//        StockMapper.findStockByName();
        // 调用 StockMapper 的 findStockByName 方法来查找股票
        Stock stock = stockMapper.findStockByName(oldStockName);

        // 检查是否找到了股票
        if (stock == null) {
            // 股票不存在
            return 0;
        } else {
            // 股票存在，更新股票信息
            stock.setStockName(newStockName); // 设置新的股票名
            stockMapper.updateStockInfo(stock); // 更新股票信息
            return 1; // 修改成功
        }
    }
}
