package com.github.sioncheng.mybatis.dao;

import com.github.sioncheng.mybatis.model.Country;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryDaoImpl implements CountryDao {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Country> selectAll() {
        List<Country> countryList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = sqlSessionFactory.openSession();
            countryList = sqlSession.selectList("selectAll");
        } catch (Exception ex) {
            logger.error("select all countries", ex);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }

        return countryList;
    }

    private static Logger logger = LoggerFactory.getLogger(CountryDaoImpl.class);
}
