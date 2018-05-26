package com.github.sioncheng.mybatis.model;

public class Country {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s", id, name, code);
    }

    private int id;

    private String name;

    private String code;
}
