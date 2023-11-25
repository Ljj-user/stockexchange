package com.stockexchange.service;

import com.stockexchange.mapper.StockMapper;
import com.stockexchange.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Package: com.stockexchange.service
 * ClassName: StockService
 * Description 股票服务
 *
 * @author
 * @Create 2023/11/17/ 20:46
 * @Version 1.0
 */
@Service
@SuppressWarnings({"all"})
public class StockService {
    @Autowired
    private StockMapper stockMapper;

}
