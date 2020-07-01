package com.study;

import com.study.config.AppConfig;
import com.study.service.AccountService;
import com.study.service.ExampleBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description App测试类
 * @date 2020/6/19 15:59
 */
public class App {

    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
       /* Student student = applicationContext.getBean(Student.class);
        System.out.println(student.getName() + "准备做作业了");
        student.doHomeWork();
        applicationContext.close();
*/
      /*  IBookService bookService = (IBookService) applicationContext.getBean("BookServiceId");
        bookService.addBook();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
*/

//        ExampleBean example1 = (ExampleBean) context.getBean("exampleInitBean1");
//        AnotherExampleBean example2 = (AnotherExampleBean) context.getBean("exampleInitBean2");
      /*  System.out.println(example1);
        System.out.println(example2);*/
//        context.registerShutdownHook();
//        System.out.println(example1);
//        context.registerShutdownHook();

       /* AnnotationConfigApplicationContext context2 = new AnnotationConfigApplicationContext(AppConfig.class);
       *//* IBookService bookService = context.getBean("bookService", BookServiceImpl.class);
        bookService.addBook();*//*

        ExampleBean exampleBean1 = context2.getBean("exampleBean", ExampleBean.class);
//        ExampleBean exampleBean2 = context.getBean("exampleBean", ExampleBean.class);
        System.out.println(exampleBean1);
        context2.registerShutdownHook();*/
//        System.out.println(exampleBean2);
//        context.getStartupDate()

      /*  AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ExampleBean exampleBean = context.getBean("exampleBean", ExampleBean.class);
        System.out.println(exampleBean);
        context.registerShutdownHook();*/

        String xmlPath = "ApplicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        AccountService accountService =  (AccountService) applicationContext.getBean("accountService");
        accountService.transfer("jack", "rose", 1000);



    }
}
