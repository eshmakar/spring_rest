package ru.eshmakar.spring.rest.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//этот класс заменяет src\main\webapp\WEB-INF\web.xml

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//читаем конфигурационный класс
        return new Class[]{MyConfig.class};
    }

    @Override
    protected String[] getServletMappings() { //какая страница будет по умолчанию
        return new String[]{"/"};
    }
}
