package com.ct.面试;

import java.util.HashMap;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class HashTest {

    private static class Person{

        private String idCard;
        private String name;

        public Person(String idCard, String name) {
            this.idCard = idCard;
            this.name = name;
        }

        public String getIdCard() {
            return idCard;
        }

        public void setIdCard(String idCard) {
            this.idCard = idCard;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o){
                //如果引用相同,则返回true
                return true;
            }
            if(o == null || getClass() != o.getClass()){
                return false;
            }
            Person person = (Person)o;
            //比较两个对象的idCard
            return this.idCard == person.getIdCard();
        }
    }

    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person person = new Person("1234", "乔峰");
        map.put(person,"天龙八部");
        //这里get取出,逻辑上来说应该会输出天龙八部
        Person person1 = new Person("1234", "乔峰");
        System.out.println(person.equals(person1));
        //这里没有重写hashCode 所以get不到,
        //因为hashCode是个int 根据对象的内存地址值做hash得到的hash索引。
        System.out.println("结果"+map.get(person1));
    }
}
