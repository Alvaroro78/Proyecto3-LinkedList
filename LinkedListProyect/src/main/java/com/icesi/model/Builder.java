package com.icesi.model;

import com.icesi.structures.LinkedList;

import com.icesi.comparators.CompareFloor;

import java.util.ArrayList;

public class Builder {
    private LinkedList houses = new LinkedList();

    public Builder(){
    }


    public void add(int position,double area, int floor){
        houses.add(new House(area,floor));
    }

    public void addFirst(double area, int floor){
        houses.addFirst(new House(area,floor));
    }

    public void addLast(double area, int floor){
        houses.addLast(new House(area,floor));
    }

    public House getHouse(int position){
        return houses.get(position);
    }

    public ArrayList<String> getHousesInfo(){
        return houses.getTotalData();
    }

    public void naturalSort(){
        for(int i=1;i<houses.getSize();i++){
            House key = houses.get(i);
            int j=i-1;
            while (j>=0 && houses.get(j).getFloor()>key.getFloor()){
                houses.exchange(j+1,j);
                j--;
            }
        }
    }

    public void customSort(){
        for(int i=1;i<houses.getSize();i++){
            House key = houses.get(i);
            int j=i-1;
            ComparatorFloor cf = new ComparatorFloor();
            while (j>=0 && cf.compare(houses.get(i),key)=1){
                houses.exchange(j+1,j);
                j--;
            }
        }
    }

    
}
