package seatingchartbuilder;

import java.util.*;
import java.io.*;

public class SeatingChartBuilder {

    public static void main(String[] args) throws Exception{
        
        Scanner input=new Scanner(new File("input.txt"));
        String output="";
        BestSeat best;
        
        while(input.hasNext()){
            
        String what=input.next();
        
            if(what.equals("Teacher:")){
                String last=input.next();
                String first=input.next();
                String divider="";
                System.out.println(last+" "+first);
                
                for(int x=0;x<last.length()+first.length()+1;x++){
                    divider+="=";
                }
                System.out.println(divider);
    }
            else if(what.equals("Order:")){
                
                Scanner loop=new Scanner(input.nextLine());
                String order="";
                
                while(loop.hasNext()){
                    order+=loop.next();
                }
                
                String[] orderlist=order.split(",");
                
                for(int x=0;x<orderlist.length;x++){
                    output=output+orderlist[x]+" ";
                }
            }
            else if(what.equals("Class:")){
                String period=input.next();
                String period1=input.next();
                System.out.println(period+" "+period1);
            }
            else{
                
                ArrayList<String> studentList=new ArrayList<String>();
                 
                while(input.hasNext()){
                    
                    if(what.equals("Class:")){
                        
                        for(int x=0;x<studentList.size();x++){
                            System.out.println(studentList.get(x));
                        }
                        
                        studentList.clear();
                        String period=input.next();
                        String period1=input.next();
                        System.out.println(period+" "+period1);                        
                    }
                    else{
                        studentList=new ArrayList<String>();
                        String firstName=what;
                        String lastName=input.next();
                        String fullName=firstName+lastName;
                        best=new BestSeat(output);
                        int bestSeat=best.next();
                        
                        
                        if(studentList.size()>0){
                        studentList.add(bestSeat,fullName);
                        }
                        else{
                            studentList.add(fullName);
                        }
                        what=input.next();
                    }
                }
            }
        }
    }
    
    //Make arraylist of students
    //get bestSeat with next() and write into the file by studentList[next()];
    
}
