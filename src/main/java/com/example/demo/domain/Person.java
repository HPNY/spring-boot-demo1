package com.example.demo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Component//加入spring管理
@ConfigurationProperties(prefix = "person")//和yml中关联
@Entity//对应数据库中的表
public class Person {

    @Id//主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer id;

    private String name;

    @Min(value = 18, message = "未成年禁止入内")//设置最小值
    private Integer age;

    @NotNull(message = "金额必填")
    private Double money;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
