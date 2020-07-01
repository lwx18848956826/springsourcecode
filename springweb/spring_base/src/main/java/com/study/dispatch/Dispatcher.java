package com.study.dispatch;

import com.study.controller.AnnotationController;
import com.study.controller.Controller;
import com.study.handler.HandlerAdapter;
import com.study.handler.impl.AnnotationHandlerAdapter;
import com.study.handler.impl.HttpHandlerAdapter;
import com.study.handler.impl.SimpleHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liwenxing
 * @Version 1.0
 * @Description
 * @date 2020/6/22 12:00
 */
public class Dispatcher {

    public static List<HandlerAdapter> handlerAdapter = new ArrayList<HandlerAdapter>();

    public Dispatcher() {
        handlerAdapter.add(new SimpleHandlerAdapter());
        handlerAdapter.add(new HttpHandlerAdapter());
        handlerAdapter.add(new AnnotationHandlerAdapter());

    }

    //核心功能
    public void doDispatch() {
        //前端控制器（DispatcherServlet）接收到Handler对象后
        //SimpleController handler = new SimpleController();
        //HttpController handler = new HttpController();
        AnnotationController handler = new AnnotationController();

        //传递给对应的处理器适配器（HandlerAdapter）
        HandlerAdapter handlerAdapter = getHandlerAdapter(handler);

        //处理器适配器调用相应的Handler方法
        handlerAdapter.handle(handler);
    }

    /** 通过Handler找到对应的处理器适配器（HandlerAdapter）*/
    public HandlerAdapter getHandlerAdapter(Controller handler) {
        for(HandlerAdapter adapter : handlerAdapter){
            if(adapter.supports(handler)){
                return adapter;
            }
        }
        return null;
    }
}
