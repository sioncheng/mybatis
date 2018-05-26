package com.github.sioncheng.mybatis.dao;

import com.github.sioncheng.mybatis.model.Country;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CountryDao {
    List<Country> selectAll();
}
