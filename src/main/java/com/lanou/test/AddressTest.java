package com.lanou.test;


import com.lanou.impl.AddressServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by gaozhichao on 2018/4/11.
 */
public class AddressTest {
    @Test
    public void test01(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        AddressServiceImpl addressService = (AddressServiceImpl) applicationContext.getBean("addressService");
    }

}
