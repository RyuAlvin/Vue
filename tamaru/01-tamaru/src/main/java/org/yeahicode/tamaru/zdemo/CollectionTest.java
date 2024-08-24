package org.yeahicode.tamaru.zdemo;

import java.util.*;

public class CollectionTest {
    public static void main(String[] args) {
        /**
         * Vector
         * 1、初始化：10个单位的Object[]
         * 2、扩容：两倍，int newCapacity = oldCapacity + ((capacityIncrement > 0) ? capacityIncrement : oldCapacity);
         *
         * ArrayList
         * 1、初始化：
         *      JDK8：延迟加载，{}的Object[]，在第一次添加操作的时候，如果新的容量小于10，则Object[]设置成10个单位，否则设置成新的容量大小
         *      JDK7：10个单位的Object[]
         * 2、扩容：1.5倍，int newCapacity = oldCapacity + (oldCapacity >> 1);
         *      10 => 1010 => 0*1+1*2+0*4+1*8=10
         *      5 => 101 => 1*1+0*2+1*4=5
         */
//        LinkedList<String> ll = new LinkedList<>();
//        ll.add("11");
//        ll.add("22");
//        ll.add("33");
//        ll.add(1, "44");
//        ll.forEach(System.out::println);

//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(4);
//        list.add(5);
//        list.add(6);
//
//        list.remove(new Integer(5));
//        System.out.println(list);

//        TreeSet<User> ts = new TreeSet<>(new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return 0;
//            }
//        });

//        List list = new ArrayList();
//        list.add(new Integer(1));
//        list.add(new Integer(2));
//        list.add(new Integer(2));
//        list.add(new Integer(4));
//        list.add(new Integer(4));
//        List list2 = duplicateList(list);
//        for (Object integer : list2) {
//            System.out.println(integer);
//        }


        Thread t1 = new Thread(new Runnable() {
            // 2、
            @Override
            public void run() {

            }
        });
        // 1、
        t1.start();
    }

    public static List duplicateList(List list) {
        HashSet set = new HashSet();
        set.addAll(list);
        return new ArrayList(set);
    }
}
