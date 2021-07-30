package com.tuling.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author by chentao
 * @Description: com.changgou 畅购网
 */
public class Test01 {

    private static Collection collection;

    public static void main(String[] args) {
        User u1 = new User("wangjing");
        User u2 = new User("wangjing");
        User u3 = new User("chentao");
        collection = new ArrayList();
        collection.add(u1);
        collection.add(u2);
        collection.add(u3);

        Iterator it = collection.iterator();
        while (it.hasNext()){
            Object next = it.next();
            System.out.println(next);
            //collection.remove(next);
            //要删除迭代器指向的当前元素
            it.remove();
        }
        //collection.remove(u2);
        System.out.println(collection.size());
    }




}

class User{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }


}
