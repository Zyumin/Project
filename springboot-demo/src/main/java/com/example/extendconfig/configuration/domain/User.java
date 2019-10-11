package com.example.extendconfig.configuration.domain;


import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * 用户 Domain 类
 *
 * @author zhengyumin
 * @since 2019-01-11
 */
@Validated
public class User {

    @NotNull
    private Long id;

    @NotEmpty
    private String name;


    private Integer age;

    private City city = new City();

    public static class City {

        @NotNull
        private String name;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "City{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city=" + city +
                '}';
    }
}
