package com.basic.part3.pet;/*
    @Author  87814   algs4.xufei
    @Date  2019/3/24    19:53
*//*
    @Author  87814   algs4.xufei
    @Date  2019/3/24    19:53
*/


//实现一种猫狗队列的结构
//用户可以调用add方法将cat类或dog类的实例放入队列中;
//
//用户可以调用pollall方法,将队列中所有的实例按照进队列的先后顺序依次弹出;
//
//用户可以调用 polldog方法,将队列中dog类的实例按照进队列的先后顺序依次弹出；
//
//用户可以调用 poll Cat方法,将队列中cat类的实例按照进队列的先后顺序依次弹出;
//
//用户可以调用iscatEmpty方法,检查队列中是否还有dog或cat的实例；
//
//用户可以调用 isdogempty方法,检查队列中是否有dog类的实例；
//
//用户可以调用 iscatempty方法,检查队列中是否有cat类的实例；

public class  Pet {
    private String type;

    public Pet(String type){
        this.type=type;
    }
    public String getPetType(){
        return this.type;
    }

}

