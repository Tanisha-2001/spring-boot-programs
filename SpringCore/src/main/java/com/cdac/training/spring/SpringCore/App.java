package com.cdac.training.spring.SpringCore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.training.spring.SpringCore.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {ClassPathXmlApplicationContext  context= new ClassPathXmlApplicationContext("EmpConfig.xml");
    Employee e=(Employee) context.getBean("obj1");
        System.out.println( "Hello World!" );
        e.display();
    }
}
