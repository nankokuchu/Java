package com.atzzazz.colection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {
        Collection list = new ArrayList();
        list.add("a");
        list.add("b");
        list.add(123);
        list.add(new Date());
        list.add(LocalDate.now());

        //iterator迭代器遍历集合
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //iterator.remove()；操作 注意点： 每次生成iterator对象，都会生成指向集合第一个前面的指针
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj.equals(123)) {
                iterator.remove();
            }

            //foreach遍历方法
            //for(集合元素的类型(对应要便利的对象类型)  局部变量（ブロック変数） ： 集合对象名（数组对象名）)
            for(Object obj1 : list){
                System.out.println(obj1);
            }

        }
    }
}