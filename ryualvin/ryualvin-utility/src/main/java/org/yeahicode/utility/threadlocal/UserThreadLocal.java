package org.yeahicode.utility.threadlocal;

public class UserThreadLocal {
    private static InheritableThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

    public static void set(Integer id){
        threadLocal.set(id);
    }
    public static Integer get(){
        return threadLocal.get();
    }
    public static void remove(){ 
        threadLocal.remove();
    }
}
