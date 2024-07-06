package com.datastructureandalgorithm;

class Rev{
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Rev{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class MathException1 extends Exception {
    public MathException1() {
        super();
    }

    public MathException1(String message) {
        super(message);
    }

    public MathException1(String message, Throwable cause) {
        super(message, cause);
    }

    public MathException1(Throwable cause) {
        super(cause);
    }
}

class MathException2 extends Exception {
    public MathException2() {
        super();
    }

    public MathException2(String message) {
        super(message);
    }

    public MathException2(String message, Throwable cause) {
        super(message, cause);
    }

    public MathException2(Throwable cause) {
        super(cause);
    }
}

public class ExceptionMadness {
    public static int  add1(int a , int b) throws MathException1 {
        if((a+b) > 6) throw new MathException1("Math exception occurred in service 1");

        return a+b;
    }

    public static int  add2(int a , int b) throws MathException1 {
        if((a+b) > 10) throw new MathException1("Math exception occurred in service 2");

        return a+b;
    }

    public static void callMathService1() throws Exception {
       try { add1(0,5);
       } catch(Exception e) {
           throw new MathException2("math exception at the method 1");
       }
    }

    public static void callMathService2() throws MathException1 {
        add2(2,9);
    }

    public static void additionLogic() throws MathException1, MathException2 {
        try {
            callMathService1();
            callMathService2();
        }
        catch(MathException2 e) {
            System.out.println(e.getMessage());
            throw e;
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) throws Exception {
        try{
            additionLogic();
        } catch(Exception e){
            System.out.println("exception occured in addition logic!");
        }
        Rev rev = new Rev();
        rev.setId(1);
        rev.setName("sara");

        System.out.println(rev.toString());


    }
}
