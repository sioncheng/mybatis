package com.github.sioncheng.mybatis.model;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class CountryMapperTest {

    private static SqlSessionFactory sqlSessionFactory;


    @BeforeClass
    public static void beforeClass () throws Exception {
        Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    @Test
    public void testSelectAll()    {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            List<Country> countryList = sqlSession.selectList("selectAll");
            Assert.assertNotNull(countryList);
            for (Country country: countryList) {
                System.out.println(country);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

    }
}
