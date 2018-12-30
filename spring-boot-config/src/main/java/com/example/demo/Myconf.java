package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.List;

/**
 * Config test
 * Created by Administrator on 2018/12/29.
 * commpany: Yonyou
 * version:v1.0.0
 */
@PropertySource("classpath:config/customconf.properties")
@ConfigurationProperties(prefix = "bill")
@Configuration
public class Myconf {

    @Autowired
    Environment environment;

    public String username;
    public String password;
    public String url ;
    public String port ;

public List<String> names;

    public void setNames(List<String> names) {
        this.names = names;
    }

    public  String test;

    public void setTest(String test) {
        this.test = test;
    }

    public String showMyconf() {
        username= environment.getProperty("name");
        password = environment.getProperty("pwd");
        url = environment.getProperty("url");
        port = environment.getProperty("port");

        return this.toString();
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("com.example.demo.Myconf{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", url='").append(url).append('\'');
        sb.append(", port='").append(port).append('\'');
        sb.append(", names=").append(names);
        sb.append(", test='").append(test).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
