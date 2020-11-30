package com.springbootintro;


import com.springbootintro.applicationcontext.BookingApplicationConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableAutoConfiguration
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
//        To enable annotation based configuration uncomment following lines:
        ApplicationContext context = new AnnotationConfigApplicationContext(BookingApplicationConfig.class);

//        To enable xml based configuration uncomment following lines:
//        ApplicationContext context = new ClassPathXmlApplicationContext("booking-bean-config.xml");
//        BookingFacadeService bookingFacadeService = context.getBean(BookingFacadeService.class);

    }
}
