package com.datastructureandalgorithm;

class Exponentiation {
    public double myPow(double x, int n) {
        if(n==0) return 1;

        if(n<0) return (double)(1.0)/(double)(x*myPow(x,-n - 1));

        if(n%2==0) {
            double ans=myPow(x,n/2);
            return ans*ans;
        }

        double ans=myPow(x,n-1);
        return x*ans;
    }
}
public class BinaryExponentiation {
    public static void main(String[] args) {
      Exponentiation exponentiation=new Exponentiation();
      double answer=exponentiation.myPow(2.00000,-2);
      System.out.println(answer);

    }
}
