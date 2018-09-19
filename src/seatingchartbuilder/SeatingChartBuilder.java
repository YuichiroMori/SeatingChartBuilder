package seatingchartbuilder;

import java.util.*;
import java.io.*;

public class SeatingChartBuilder {

    public static void main(String[] args) throws Exception{
        
        Scanner input=new Scanner(new File("input.txt"));
        int checker=0;
        int orderIndex=0;
        ArrayList<Integer> orderList=new ArrayList<>();
        ArrayList<String> studentList=new ArrayList<>();
        Map<Integer,String> seat=new TreeMap<>();
        
        while(input.hasNext()){
            
            String next=input.nextLine();
            
            if(next.contains("Teacher")){
                
                String teacher=next.replace("Teacher:", "").trim();
                String divider="";
                
                for(int x=0;x<teacher.length();x++){
                    
                    divider+="=";
                }
                
                System.out.println(teacher);
                System.out.println(divider);
            }
            
            
            else if(next.contains("Order:")){
                
                String order=next.replace("Order:","").trim();
                String[] orders=order.split(", ");
                String output="";
                
                for(int x=0;x<orders.length;x++){
                    
                    output+=orders[x]+" ";
                }
                
                BestSeat best=new BestSeat(output);
                
                while(best.hasNext()){
                    
                    orderList.add(best.next());
                    
                }
            }
            
            else if(next.contains("Class:")&&checker==0){
                
                String period=next.replace("Class:","").trim();
                System.out.println(period);
                
            }
            
            
            else if(next.contains("Class:")&&checker==1){
                
                Collections.shuffle(studentList);
                orderIndex=0;
                
                for(int x=0;x<studentList.size();x++){
                    seat.put(orderList.get(orderIndex),studentList.get(x));
                    orderIndex++;
                }
                
                for(int x=1;x<orderList.size()+1;x++){
                    
                    if(x<10){
                    String seatNumber="0"+Integer.toString(x)+" ";
                    String name=seatNumber+seat.get(x);
                    System.out.println(name);
                    }
                    else{
                        String seatNumber=Integer.toString(x)+" ";
                        String name=seat.get(x);
                        System.out.println(seatNumber+name);
                    }
                }
                
                seat.clear();
                studentList.removeAll(studentList);
                
                String period=next.replace("Class:","").trim();
                System.out.println(period);
                
            }
            
            else{
                
                studentList.add(next);
                checker=1;
                
            }
        }
        
                    
        for(int x=1;x<orderList.size()+1;x++){
            
                Collections.shuffle(studentList);
                orderIndex=0;
                
                for(int y=0;y<studentList.size();y++){
                    seat.put(orderList.get(orderIndex),studentList.get(y));
                    orderIndex++;
                }
                    
            if(seat.get(x)!=null){
                    if(x<10){
                    String seatNumber="0"+Integer.toString(x)+" ";
                    String name=seatNumber+seat.get(x);
                    System.out.println(name);
                    }
                    else{
                        String seatNumber=Integer.toString(x)+" ";
                        String name=seat.get(x);
                        System.out.println(seatNumber+name);
                    }
            }
            else{
                //break;
            }
    } 
}
}

