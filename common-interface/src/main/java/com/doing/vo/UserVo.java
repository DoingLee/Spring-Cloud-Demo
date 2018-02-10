package com.doing.vo;

/**
 * @author：ldy on 10/02/2018 13:32
 */
public class UserVo {
    private String name;
    private Integer age;
    private UserVo father;
    private UserVo mother;

    //用于feign传参。比如有默认构造函数
    public UserVo() {
    }

    public UserVo(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public UserVo(String name, Integer age, UserVo father, UserVo mother) {
        this.name = name;
        this.age = age;
        this.father = father;
        this.mother = mother;
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

    public UserVo getFather() {
        return father;
    }

    public void setFather(UserVo father) {
        this.father = father;
    }

    public UserVo getMother() {
        return mother;
    }

    public void setMother(UserVo mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        return "{" +
                       "name='" + name + '\'' +
                       ", age=" + age +
                       ", father=" + father.toString() +
                       ", mother=" + mother.toString() +
                       '}';
    }
}
