package com.spring.ioc.service;

import com.spring.ioc.annotation.IocService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author John Lee
 * @Version 1.0
 * @Description
 * @date 2020/6/17 16:04
 */
@IocService
public class OrderServiceImpl implements IOrderService {

    @Override
    public String findOrder(String username) {
        return "用户"+username+"的订单编号是:1001";
    }

    /**
     * 获取当天零点时间戳（毫秒）
     * @return
     */
    public static long getTodayZero() {
        long current = System.currentTimeMillis();
        long todayStartTime = current - (current + TimeZone.getDefault().getRawOffset()) % (1000 * 3600 * 24);
        return todayStartTime;
    }

  /*  public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime.of(LocalDate.now(), LocalTime.MIN);


       *//* DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, df);*//*

        System.out.println(localDateTime);
    }*/

    public static void main(String[] args) {
        String url1 = "http://www.xx.com";

        String url2 = "w.xx.com";

        String url3 = "http://w.xx.com";

        String url4 = "ssss";

        String regUrl="^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\\\/])+$";

        String regex = "(((https|http)?://)?([a-z0-9]+[.])|(www.))"
                + "\\w+[.|\\/]([a-z0-9]{0,})?[[.]([a-z0-9]{0,})]+((/[\\S&&[^,;\u4E00-\u9FA5]]+)+)?([.][a-z0-9]{0,}+|/?)";//设置正则表达式

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(8);
        list.add(22);
        list.add(18);
        list.forEach(integer -> {
            System.out.println(integer);
            if(integer == 8){
                System.out.println(integer);
                return;
            }
        });

        /*Pattern pat = Pattern.compile(regUrl.trim());


        System.out.println(pat.matcher(url1).matches());

        System.out.println(pat.matcher(url2).matches());

        System.out.println(pat.matcher(url3).matches());

        System.out.println(pat.matcher(url4).matches());*/
    }
}
