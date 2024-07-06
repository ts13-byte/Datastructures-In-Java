package com.datastructureandalgorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Constants{
    public static final String[] APP_TYPE_PRIORITY={"SALES","TV","CALL_CENTRE"};
    public static final String[] RULE_TYPE_PRIORITY={"RISKY","HIGH","MEDIUM","NORMAL","LOW"};
}

class Rule{
    String id;
    String app_type;

    public Rule(String id, String app_type, String rule_type) {
        this.id = id;
        this.app_type = app_type;
        this.rule_type = rule_type;
    }

    String rule_type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApp_type() {
        return app_type;
    }

    public void setApp_type(String app_type) {
        this.app_type = app_type;
    }

    public String getRule_type() {
        return rule_type;
    }

    public void setRule_type(String rule_type) {
        this.rule_type = rule_type;
    }
}
public class CustomSorting {

    public static void main(String[] args) {

        List<Rule> rules = new ArrayList<>();

        Rule rule1 = new Rule("1", "TV", "LOW");
        Rule rule2 = new Rule("2", "TV", "MEDIUM");
        Rule rule3 = new Rule("3", "SALES", "HIGH");
        Rule rule4 = new Rule("4", "SALES", "RISKY");
        Rule rule5 = new Rule("5", "CALL_CENTRE", "LOW");
        Rule rule6 = new Rule("6", "CALL_CENTRE", "RISKY");
        Rule rule7=  new Rule("7","TV","RISKY");
        Rule rule8=new Rule("8","SALES","LOW");
        Rule rule9=new Rule("9","MEOW","MEOW");





        Comparator<Rule> ruleComparator = Comparator
                .comparingInt((Rule rule) -> Arrays.asList(Constants.APP_TYPE_PRIORITY).indexOf(rule.getApp_type()))
                .thenComparingInt((Rule rule) -> Arrays.asList(Constants.RULE_TYPE_PRIORITY).indexOf(rule.getRule_type()));

        // Sorting the rules
        rules.sort(ruleComparator);

        // Displaying sorted rules
        for (Rule rule : rules) {
            System.out.println("ID: " + rule.id + ", App Type: " + rule.app_type + ", Rule Type: " + rule.rule_type);

        }

    }
}
//I want to sort my rules array according to this--> first give priority basis on the app_type i.e. SALES>TV>CALL_CENTRE
//and then the rule_type i.e. RISKY>HIGH>MEDIUM>NORMAL>LOW and the priority is already mentioned in the APP_TYPE_PRIORITY and RULE_TYPE_PRIORITY.