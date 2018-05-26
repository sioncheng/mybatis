package com.github.sioncheng;

import com.github.sioncheng.mybatis.dao.CountryDao;
import com.github.sioncheng.mybatis.model.Country;
import com.github.sioncheng.mybatis.spring.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        CountryDao countryDao = context.getBean(CountryDao.class);

        List<Country> countryList = countryDao.selectAll();

        assert countryList != null;

        for (Country country: countryList) {
            System.out.println(country);
        }
    }
}
