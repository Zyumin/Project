//package com.example.autoconfig.web.servlet;
//
//import javax.servlet.AsyncContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * servlet 异步demo
// *
// * @author zhengyumin
// * @create 2018-12-27 4:30 PM
// */
//@WebServlet(urlPatterns = "/servletAsyncDemo", asyncSupported = true)
//public class ServletAsyncDemo extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        //注意设置格式否则flush不会实时刷新
//        resp.setContentType("text/html;charset=utf-8");
//
//        resp.getWriter().print(Thread.currentThread().getName() + ": before doWork...<br/>");
//
//        doWork(req);
//
//        resp.getWriter().println(Thread.currentThread().getName() + ": after doWork...<br/>");
//    }
//
//    private void doWork(HttpServletRequest req) {
//        final AsyncContext ac = req.startAsync();
//        //设置超时 1 * 60 * 60 * 1000L
//        ac.setTimeout(1 * 60 * 60 * 1000L);
//
//        ac.start(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    PrintWriter w = ac.getResponse().getWriter();
//                    for (int i = 0; i < 10; i++) {
//                        w.print(Thread.currentThread().getName() + ": do job" + i + "<br/>");
//                        Thread.sleep(1000L);
//                        w.flush();
//                    }
//                    //触发完成
//                    ac.complete();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//    }
//}
