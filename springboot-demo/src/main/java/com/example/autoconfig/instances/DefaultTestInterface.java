package com.example.autoconfig.instances;

/**
 * 封装数据类 {@link TestInterface}
 *
 * @author zhengyumin
 * @create 2019-01-09 10:30 AM
 */
public class DefaultTestInterface implements TestInterface {

    private String name;

    private String id;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
