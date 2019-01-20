package com.dynamic.springbootfilter.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * my first servlet demonstrate
 *
 * @author Administrator
 * @date 2019/1/10
 * commpany: yonyou
 * version:v1.0.0
 */
@WebServlet(name = "myServlet", urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(MyServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("发起servlet请求:{}",req.getPathInfo());
        ServletOutputStream writer = resp.getOutputStream();
        // writer.write("hello world!");
        String text = "Now is the winter of our discontent. How Now Brown Cow. The quick brown fox jumped over the lazy dog.\n";
        // for (int i = 0; i < 10; i++) {
        //     text = text + text;
        // }
        // resp.addCookie(new Cookie("username","bill"));
        // resp.setStatus(403);
        byte[] data = text.getBytes(StandardCharsets.UTF_8);
        writer.write(data);

        writer.flush();



    }
}
