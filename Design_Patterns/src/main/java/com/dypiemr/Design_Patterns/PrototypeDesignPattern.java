package com.dypiemr.Design_Patterns;

import java.util.ArrayList;
import java.util.List;

class Motor implements Cloneable {
  private List<String> MotorList;
  
  public Motor() {
    this.MotorList = new ArrayList<String>();
  }
  
  public Motor(List<String> list) {
    this.MotorList = list;
  }
  
  public void insertData() {
    MotorList.add("Honda amaze");
    MotorList.add("Audi A4");
    MotorList.add("Hyundai Creta");
    MotorList.add("Maruti Baleno");
    MotorList.add("Renault Duster");
  }
  
  public List<String> getMotorList() {
    return this.MotorList;
  }
  
  @Override
  public Object clone() throws CloneNotSupportedException {
    List<String> tempList = new ArrayList<String>();
    
    for(String s : this.getMotorList()) {
      tempList.add(s);
    }
    
    return new Motor(tempList);
  }
}

public class PrototypeDesignPattern {

  public static void main(String[] args) throws CloneNotSupportedException {
    Motor a = new Motor();
    a.insertData();
    
    Motor b = (Motor) a.clone();
    List<String> list = b.getMotorList();
    list.add("Honda new Amaze");
    
    System.out.println(a.getMotorList());
    System.out.println(list);
    
    b.getMotorList().remove("Audi A4");
    System.out.println(list);
    System.out.println(a.getMotorList());
  }

}