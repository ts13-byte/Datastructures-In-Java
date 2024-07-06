package com.datastructureandalgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class CurrentAddress {
    String city;
    String zip;
    String state;

    public CurrentAddress(String city, String zip, String state) {
        this.city = city;
        this.zip = zip;
        this.state = state;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentAddress that = (CurrentAddress) o;
        return Objects.equals(city, that.city) && Objects.equals(zip, that.zip) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, zip, state);
    }
}
class Plan {
    String planName;
    String planCode;

    public Plan(String planName, String planCode) {
        this.planName = planName;
        this.planCode = planCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Objects.equals(planName, plan.planName) && Objects.equals(planCode, plan.planCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planName, planCode);
    }
}
class MyRequest {
    String name;
    String process;
    List<Plan> planList;
    CurrentAddress currentAddress;



    public MyRequest(String name, String process, List<Plan> planList, CurrentAddress currentAddress) {
        this.name = name;
        this.process = process;
        this.planList = planList;
        this.currentAddress = currentAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyRequest myRequest = (MyRequest) o;
        return Objects.equals(name, myRequest.name) && Objects.equals(planList, myRequest.planList) && Objects.equals(currentAddress, myRequest.currentAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, process, planList, currentAddress);
    }
}
public class EqualsMethodStupidity {
    public static void main(String[] args) {
        Plan plan = new Plan("plan1","2");
        Plan plan3 = new Plan("plan2","3");
        List<Plan> planList = new ArrayList<>();
        planList.add(plan);
        planList.add(plan3);

        Plan plan2 = new Plan("plan1","2");
        Plan plan4 = new Plan("plan3","2");
        List<Plan> planList2 = new ArrayList<>();
        planList2.add(plan2);
        planList2.add(plan4);

        CurrentAddress currentAddress = new CurrentAddress("ABCD","1234","DEF");

        CurrentAddress currentAddress2 = new CurrentAddress("ABCD","1234","DEF");

        MyRequest myRequest1 = new MyRequest("req1","1",planList,currentAddress);

        MyRequest myRequest2 = new MyRequest("req1","1",planList2,currentAddress2);

        System.out.println("are both requests equal : " + myRequest1.equals(myRequest2));


    }
}
