package Generics;

public class WhatAreGenerics {
    public static void main(String[] args) {

        // generics vs legacy

        LegacyBox legacyBox = new LegacyBox();
        legacyBox.setItem(1);
        // now i changed it to string here, but didnt change the  getItem code below
//        legacyBox.setItem("YouTube");

        int legacyValue = (int) legacyBox.getItem();  // here i need to do the casting of the result
        System.out.println(legacyValue);


        GenericBox<String> genericString = new GenericBox<>();
        genericString.setItem("YouTube");

        String genericValue = genericString.getItem();
        System.out.println(genericValue);

    }


}

class GenericBox<T>{
    private T item;
    public void setItem(T item){this.item=item;}
    public T getItem(){return this.item;}
}


class LegacyBox{
    private Object item;

    public void setItem(Object item){this.item = item;}

    public Object getItem(){return item;}

}

