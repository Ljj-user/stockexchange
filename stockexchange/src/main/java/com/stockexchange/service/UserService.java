package com.stockexchange.service;

import com.stockexchange.mapper.UserMapper;
import com.stockexchange.pojo.Stock;
import com.stockexchange.pojo.User;
import com.stockexchange.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.stockexchange.service
 * ClassName: UserService
 * Description 用户服务
 *
 * @author
 * @Create 2023/11/17/ 20:41
 * @Version 1.0
 */
@Service
@SuppressWarnings({"all"})
public class UserService {
    // 创建一个持久层对象
    @Autowired
    private UserMapper userMapper;

    /**
     * 功能：用户登录
     *      调用UserMapper中的findByUserName()来根据用户名查找用户：
     *      如果查找到的user值为null则返回0（用户不存在）
     *      如果查找到的user.getPassword和传入的passowrd值相同，则返回1（登录成功）
     *      如果查找到的user.getPassword和传入的passowrd值不相同，则返回2（密码错误）
     */
    public int userLogin(String userName, String password) {
        // 根据用户名查询用户
        User user = userMapper.findByUserName(userName);

        if (user == null) {
            return 0; // 用户不存在
        }

        if (user.getPassword().equals(password)) {
            return 1; // 登录成功
        }

        return 2; // 密码错误
    }

    /**
     * 功能：用户注册
     *      先将balance（用户余额）和cashBalanc(总资产)设为0
     *      然后调用UserMapper中的regedit()将用户名，密码，用户余额，总资产添加到数据库
     */
    public void regedit(String userName, String password) {
        // 密码加密
        String md5String = Md5Util.getMD5String(password);
        // 将用户余额和总资产的初始值设为0
        double balance = 0;
        double cashBalance = 0;
        // 调用持久层的对应方法，将用户信息添加到数据库
        userMapper.regedit(userName, md5String, balance, cashBalance);
    }

    /**
     * 功能：修改用户信息
     *      先调用UserMapper中的findByUserName()来根据用户名查找用户：
     *      如果查找到的user值为null则返回0（用户不存在）
     *      如果查找到的user值不为null则
     *          先执行user.setUserName(newUserName)，user.setPassowrd(newPassword)
     *          再调用UserMapper中的updateUserInfo()来修改用户名称和密码并返回1（修改成功）
     */
    public int updateUserInfo(String oldUserName, String newUserName, String newPassword) {
        return 1;
    }

    /**
     * 功能：查看用户持有的股票
     *      先调用UserMapper中的findByUserName()来根据用户名查找用户：
     *      如果查找到的user值为null则返回0（用户不存在）
     *      如果查找到的user值不为null则调用UserMapper中的userStockList()来修查看用户持有的股票并返回1（查找成功）
     */
    public List<Stock> userStockList(String userName) {
        return new ArrayList<>();//乱填
    }

    /**
     * 功能：买入股票
     *      先调用UserMapper中的findByUserName()来根据用户名查找用户
     *      再调用StockMapper中的findStockByName()来根据股票名查找股票：
     *      如果查找到的stock值为null则返回0（股票不存在）
     *      如果查找到的stock值不为null则将查到stock的信息添加到user.ownedStocks（用户股票列表）中
     *      使stock.volume（股票持有量）+1，根据stock.currentPrice（当前股价）减少user.balance（现金）
     *      返回1（买入成功）
     */
    public int sellStock(String userName, String stockName) {
        return 1;
    }

    /**
     * 功能：卖出股票
     *      先调用UserMapper中的findByUserName()来根据用户名查找用户
     *      再调用StockMapper中的findStockByName()来根据股票名查找股票：
     *      如果查找到的stock值为null则返回0（股票不存在）
     *      如果查找到的stock值不为null则将stock的信息从user.ownedStocks（用户股票列表）中移除
     *      使stock.volume（股票持有量）-1，根据stock.currentPrice（当前股价）增加user.balance（现金）
     *      返回1（买入成功）
     */
    public int buyStock(String userName, String stockName) {
        return 1;
    }

    /**
     * 功能：添加股票
     *      先调用UserMapper中的findByUserName()来根据用户名查找用户
     *      再调用StockMapper中的findStockByName()来根据股票名查找股票：
     *      如果查找到的stock值不为null则返回0（股票已存在）
     *      如果查找到的stock值为null则
     *          先使stock.volume（股票持有量）等于1，根据输入的currentPrice（当前股价）来设置stock.currentPrice并减少user.balance（现金）
     *          调用StockMapper中的addStock()将输入的股票信息添加到数据库
     *          返回1（添加成功）
     */
    public int addStock(String userName, String stockName, double currentPrice) {
        return 1;
    }
}
