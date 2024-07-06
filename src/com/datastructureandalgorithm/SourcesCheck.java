package com.datastructureandalgorithm;

import java.lang.reflect.Member;
import java.util.*;

class Field{
    String fieldName;

    public Field(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}

class Values{
    String valueName;

    public Values(String valueName) {
        this.valueName = valueName;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }
}
class Criteria{
    List<Field> fields;
    String operation;
    List<Values> values;

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public List<Values> getValues() {
        return values;
    }

    public void setValues(List<Values> values) {
        this.values = values;
    }
}
public class SourcesCheck {

    public static boolean performOperation(String operation, String ruleValue, String memberValues){
        if((ruleValue!=null && !ruleValue.isEmpty()) && (memberValues!=null && !memberValues.isEmpty())){
        if(operation.equals("Does Not Equal")){
            return !ruleValue.equalsIgnoreCase(memberValues);
        }else if(operation.equals("Equals")){
            return ruleValue.equalsIgnoreCase(memberValues);
        }
        }
        return false;
    }

    public static Optional<String> getName(Field field,Map<String, String> memberValues){
        Optional<String> nameOpt
                =memberValues.keySet()
                .stream()
                .filter(key->key!=null && key.equalsIgnoreCase(field.getFieldName()))
                .findFirst();
        return nameOpt;
    }
    public static Optional<String> matchValues(Criteria criteria, Map<String, String> memberValues) {
        String code = "";
        String logicalNameOfField=null;
        for (Field field : criteria.getFields()) {
            Optional<String> nameOpt=getName(field,memberValues);
            String memberName=null;
            if(nameOpt.isPresent()) {
                memberName = nameOpt.get();
            }

            code+=String.format("%s : %s;", field.getFieldName(), memberValues.get(memberName));

            for (Values value : criteria.getValues()) {

                if (criteria.getOperation().equals("Does Not Equal")) {
                    if (performOperation(criteria.getOperation(), value.getValueName(), memberValues.get(memberName)) || (memberName==null)) {
                        continue;
                    } else {
                        System.out.println("Getting in the else block of does not equal!!");
                        return Optional.empty();
                    }
                } else {
                    if (performOperation(criteria.getOperation(), value.getValueName(), memberValues.get(field.getFieldName()))) {

                        return Optional.of(String.format("%s : %s,", field.getFieldName(), memberValues.get(field.getFieldName())));

                    }
                }
            }
        }

        if (!code.isEmpty() && criteria.getOperation().equals("Does Not Equal")) {
            return Optional.of(code);
        }

        return Optional.empty();


    }

    public static Optional<String> getEligCodeForDoesNotEqual(Field field, Map<String,String>memberValues,Criteria criteria,String memberName){
        String code="";
        code+=String.format("%s : %s;", field.getFieldName(), memberValues.get(memberName));
        for (Values value : criteria.getValues()){
            if (performOperation(criteria.getOperation(), value.getValueName(), memberValues.get(memberName)) || (memberName==null)) {
                continue;
            } else {
                System.out.println("Getting in the else block of does not equal!!");
                return Optional.empty();
            }
        }
        if (!code.isEmpty()) {
            return Optional.of(code);
        }
        return Optional.empty();
    }

    public static Optional<String> getEligCodeForOtherScenarios(Field field, Map<String,String>memberValues,Criteria criteria,String memberName){
        for (Values value : criteria.getValues()) {
            if (performOperation(criteria.getOperation(), value.getValueName(), memberValues.get(field.getFieldName()))) {

                return Optional.of(String.format("%s : %s,", field.getFieldName(), memberValues.get(field.getFieldName())));

            }
        }
        return Optional.empty();

    }

    public static void main(String[] args) {
        Criteria criteria=new Criteria();
        List<Field> fieldList=new ArrayList<>();
        Field field1=new Field("ABCD");
        Field field2=new Field("DEF");
        Field field3=new Field("JKL");
        fieldList.add(field1);
        fieldList.add(field2);
        fieldList.add(field3);
        List<Values> valuesList=new ArrayList<>();
        Values value1=new Values("71");
        Values value2=new Values("72");
       Values value3=new Values("73");
       Values value4=new Values("74");
        valuesList.add(value1);
       valuesList.add(value2);
        valuesList.add(value3);
       valuesList.add(value4);
        criteria.setFields(fieldList);
        criteria.setValues(valuesList);
        criteria.setOperation("Equals");

        Map<String, String> memberValues=new HashMap<>();
      memberValues.put("ABCD","37");
       //memberValues.put("DEF","20");
      // memberValues.put("JKL","76");

       Optional<String> opt= matchValues(criteria,memberValues);
       if(!opt.isEmpty()) {
           System.out.println("This criteria is evaluated as true");
           System.out.println(opt.get());
       }else{
           System.out.println("This criteria is evaluated as false");
       }

    }
}
