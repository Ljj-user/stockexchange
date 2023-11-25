package com.stockexchange.view;

import com.stockexchange.pojo.Transaction;
import com.stockexchange.service.AdminService;
import com.stockexchange.service.StockService;
import com.stockexchange.service.TransactionService;
import com.stockexchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Package: com.stockexchange.view
 * ClassName: View
 * Description 控制台界面
 *
 * @author
 * @Create 2023/11/18/ 17:27
 * @Version 1.0
 */
@Component
public class MainView {
    // 创建业务层对象
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private StockService stockService;
    @Autowired
    private TransactionService transactionService;

    private String userName;

//-------------------------------------主菜单------------------------------------------
    /**
     * 功能：展示选项
     * 登录: 调用方法loginView();
     * 注册：调用方法regeditView();
     * 退出: 调用exit(0);
     */
    public void menuView(){
        System.out.println("==============================================");
        System.out.println("    1.用户登录");
        System.out.println("    2.用户注册");
        System.out.println("    3.管理员登录");
        System.out.println("    4.退出");
        System.out.println("==============================================");
        System.out.print("请输入数字以选择相应功能：");

        Scanner s = new Scanner(System.in);
        char choice = s.next().charAt(0);

        switch (choice) {
            case '1' :
                userLoginView();
                break;
            case '2' :
                regeditView();
                break;
            case '3' :
                regeditView();
                break;
            case 'q':
                System.out.print("正在退出...");
                exit(0);
                break;
            default :
                System.out.println("输入值不合法！");
        }
    }

    /**
     * 功能：用户登录
     *      提示用户输入账号和密码：
     *      调用UserService中的userLogin()方法进行校验
     *      如果账号和密码匹配则调用方法userView()
     *      不匹配则输出提示信息并重新调用本函数
     * 返回: 调用menuView();
     */
    public void userLoginView(){
        System.out.println("请输入账号和密码：");

        Scanner s = new Scanner(System.in);
        String userName = s.nextLine();
        String password = s.nextLine();

        int isEqual = userService.userLogin(userName, password);

        // 判断是否登录成功
        if (isEqual == 0) {
            System.out.println("用户不存在！");
            userLoginView();
        }
        if (isEqual == 1) {
            System.out.println("登录成功！");
        }
        if (isEqual == 0) {
            System.out.println("密码错误！");
            userLoginView();
        }
    }

    /**
     * 功能：管理员登录
     *      提示输入账号和密码：
     *      调用AdminService中的adminLogin()方法进行校验
     *      如果账号和密码匹配则调用方法adminView()
     *      不匹配则输出提示信息并重新调用本函数
     * 返回: 调用menuView();
     */
    public void adminLoginView(){

    }

    /**
     * 功能：用户注册
     *      提示用户输入用户名和密码：
     *      调用UserService中的regedit方法进行注册
     *      如果用户名不重复且输入合法则调用userView()
     *      否则输出提示信息并重新调用本函数
     * 返回: 调用menuView();
     */
    public void regeditView(){

    }
//-------------------------------------主菜单------------------------------------------


//-------------------------------------用户界面------------------------------------------
    /**
     * 功能：用户界面
     * 股票管理：选择后调用userStockManagerView()
     * 个人交易记录：选择后调用TransactionService中的userTransaction()打印个人的交易记录
     *              询问是否要输出日志文件：
     *              是则输出日志到txt文件
     *              否则调用userView()
     * 修改用户信息：选择后调用updateUserInfoView()
     * 股票和用户信息常驻：选择后调用StockView中的？？？
     * 登出: 调用menuView();
     */
    public void userView(){
        System.out.println("╔═══════════════════════════════════╗");
        System.out.println("║            用户界面                ║");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.println("║ 1. 股票管理                        ║");
        System.out.println("║ 2. 交易记录                        ║");
        System.out.println("║ 3. 修改用户个人信息                 ║");
        System.out.println("║ 4. 展示股票用户面板                 ║");
        System.out.println("║ 5. 账户登出                        ║");
        System.out.println("╚═══════════════════════════════════╝");
        System.out.println("请选择操作（1-5）：");

        Scanner scanner = new Scanner(System.in);
        char userChoose = scanner.next().charAt(0);
        scanner.nextLine();

        switch (userChoose) {
            case '1' :
                userStockManagerView();
                break;
            case '2' :
                List<Transaction> reList = transactionService.userTransaction();//reList接收返回list
//                System.out.println(reList);
                for(Transaction a : reList){
                    System.out.println(a);
                }

                System.out.println("是否需要打印日志文件(YES/NO)");
                String s = scanner.nextLine();
                    if (s.equals("YES")) {
                        LocalDate currentDate = LocalDate.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd"); // 定义日期格式
                        String nowDate = currentDate.format(formatter);

                        String fileName = userName+"的交易信息"+nowDate +".txt";//重新定义文件名
                        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                            for (Transaction transaction : reList) {
                                writer.write(transaction.toString()); // 假设 toString() 方法返回适合的字符串表示
                                writer.newLine();//换行
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (s.equals("NO")) {
                        System.out.println("已为您返回到功能界面");
                        userView();
                    }
                break;
            case '3' :
                updateUserInfoView();
                break;
            case '4':
                new StockView(userService.userStockList(this.userName));
                break;
            case '5':
                menuView();
                break;
            default :
                System.out.println("输入值不合法！");
        }

    }

    /**
     * 功能：修改用户信息界面
     *      提示用户重新输入用户信息：
     *      调用UserService中的updateUserInfo()修改用户信息
     *      如果修改成功则输出提示信息并调用userView()
     *      如果修改失败则输出提示信息并重新调用本函数
     * 返回: 调用userView();
     */
    public void updateUserInfoView() {

    }

    /**
     * 功能：股票管理界面界面（用户）
     * 查看持有的股票：选择后选择后调用UserService中的userStockList()方法并重新调用本函数
     * 买入股票：选择后调用buyStockView()
     * 卖出股票：选择后调用sellStockView()
     * 添加股票：选择后调用addStockView()
     * 返回: 调用userView();
     */
    public void userStockManagerView() {

    }

    /**
     * 功能：买入股票界面
     *      提示用户输入要买入股票的id：
     *      调用UserService中的buyStock()方法查找股票
     *      如果买入成功则调用userStockManagerView()
     *      如果买入失败则输出提示信息并重新调用本函数
     * 返回: 调用userStockManagerView();
     */
    public void buyStockView() {

    }

    /**
     * 功能：卖出股票界面
     *      提示用户输入要卖出股票的id：
     *      调用UserService中的sellStock()方法查找股票
     *      如果卖出成功则输出提示信息并调用userStockManagerView()
     *      如果卖出失败则输出提示信息并重新调用本函数
     * 返回: 调用userStockManagerView();
     */
    public void sellStockView() {

    }

    /**
     * 功能：添加股票界面
     *      提示用户输入股票相关信息：
     *      调用UserService中的addStock()方法添加股票
     *      如果添加成功则输出提示信息并调用userStockManagerView()
     *      如果添加失败则输出提示信息并重新调用本函数
     * 返回: 调用userStockManagerView();
     */
    public void addStockView() {

    }
//-------------------------------------用户界面------------------------------------------


//-------------------------------------管理员界面------------------------------------------
    /**
     * 功能：管理员界面
     * 用户管理：调用userManageView()方法
     * 股票管理：调用adminStockManageView()方法
     * 查看交易记录：调用TransactionService中的allTransaction()打印所有交易记录
     *              询问是否要输出日志文件：
     *              是则输出日志到txt文件
     *              否则调用adminView()
     * 股票和用户信息常驻：选择后调用StockView中的？？？
     * 登出: 调用menuView();
     */
    public void adminView(){

    }

    /**
     * 功能：管理股票
     * 删除股票：提示输入要删除的股票id:
     *          调用AdminService中的deleteStock()方法删除股票
     *          删除成功则输出提示信息并调用stockManageView()
     *          失败则输出提示信息并重新调用本函数
     * 修改股票信息：提示输入要修改的股票id:
     *              调用AdminService中的updateStockInfo()方法修改股票信息
     *              修改成功则输出提示信息并调用stockManageView()
     *              失败则输出提示信息并重新调用本函数
     * 返回: 调用adminView();
     */
    public void stockManageView(){

    }

    /**
     * 功能：管理用户
     * 删除用户：提示输入要删除的用户id:
     *          调用AdminService中的deleteUser()方法删除用户
     *          删除成功则输出提示信息并调用stockManageView()
     *          失败则输出提示信息并重新调用本函数
     * 修改用户信息：提示输入要修改的用户id:
     *              调用UserService中的updateUserInfo()方法修改用户信息
     *              修改成功则输出提示信息并调用stockManageView()
     *              失败则输出提示信息并重新调用本函数
     * 返回: 调用adminView();
     */
    public void userManageView(){

    }
//-------------------------------------管理员界面------------------------------------------
}
