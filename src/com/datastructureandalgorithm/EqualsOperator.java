package com.datastructureandalgorithm;


class Animal{
String name;
String sound;

    public Animal(String name, String sound) {
        this.name = name;
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}

 class StaticVariableClass {
    // Static variable
    static int count = 0;

    // Constructor increments the count
    public StaticVariableClass() {
        count++;
    }

     public static int getCount() {
         return count;
     }

     public static void setCount(int count) {
         StaticVariableClass.count = count;
     }
 }
public class EqualsOperator {
    public static void main(String[] args) {
        Animal dog1=new Animal("Dog1","Bark");
        Animal dog2=new Animal("Dog1","Bark");
        Animal cat=new Animal("Cat","meow");
        System.out.println(dog1.equals(dog2));
        String name1="dog";
        String name2="dog";
        Integer var1=1;
        Integer var2=1;
        System.out.println(name1.equals(name2));
        System.out.println(var1.equals(var2));
        if(dog1==dog2){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

        StaticVariableClass staticVariableClass1=new StaticVariableClass();
        StaticVariableClass staticVariableClass2=new StaticVariableClass();
        StaticVariableClass staticVariableClass3=new StaticVariableClass();
        System.out.println(StaticVariableClass.count);

    }


}
