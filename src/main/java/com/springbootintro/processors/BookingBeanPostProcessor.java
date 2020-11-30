package com.springbootintro.processors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springbootintro.business.repository.storage.Storage;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;
import java.io.File;

public class BookingBeanPostProcessor implements BeanPostProcessor {

    @PostConstruct
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Called postProcessBeforeInitialization() for :" + beanName);
        ObjectMapper mapper = new ObjectMapper();
        if (bean instanceof Storage)
            try {
                mapper.writeValue(new File("data-input/event-input.json"), Storage.eventRepositoryMap);
                mapper.writeValue(new File("data-input/ticket-input.json"), Storage.ticketRepositoryMap);
                mapper.writeValue(new File("data-input/user-input.json"), Storage.userRepositoryMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return bean;
    }
}
