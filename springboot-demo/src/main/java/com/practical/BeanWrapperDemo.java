package com.practical;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.beans.PropertyEditorSupport;
import java.util.StringTokenizer;

/**
 * todo 写点注释
 *
 * @author zhengyumin
 * @create 2019-03-06 9:15 AM
 */
public class BeanWrapperDemo {

    public static void main(String[] args) {
        People p  = new People();
        p.setAge(11);
        p.setName("zhengyumin");
        BeanWrapper beanWrapper = new BeanWrapperImpl( p );
//        System.out.println(beanWrapper.getPropertyValue("age"));
//
//        PropertyValue propertyValue = new PropertyValue("name","guolianjie");
//        System.out.println(beanWrapper.getPropertyValue("name"));
//        beanWrapper.setPropertyValue(propertyValue);
//        System.out.println(beanWrapper.getPropertyValue("name"));
//
//        System.out.println(p.getName());

//        PropertyEditorManager.registerEditor (People.class, PeopleEditor.class) ;

        System.out.println(Integer.compare(1, 2));

    }

    class PeopleEditor extends PropertyEditorSupport{

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            People p = new People();
            StringTokenizer st = new StringTokenizer(text,"_");
            p.setName(st.nextToken());
            p.setAge(Integer.parseInt(st.nextToken()));

            setValue(p);

         }
    }

    public static class People{
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
