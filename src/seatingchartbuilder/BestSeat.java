package seatingchartbuilder;

import java.util.*;
import java.io.*;

public class SeatingChartBuilder {

    public static void main(String[] args) throws Exception{

        Scanner input=new Scanner(new File("input.txt"));
        int checker=0;
        int orderIndex=0;
        ArrayList<Integer> orderList=new ArrayList<>();
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


            else if(next.contains("Class:")&&checker==1||!input.hasNext()){


                for(int x=1;x<=seat.size();x++){

                    String name=seat.get(x);
                    System.out.println(name);
                }

                seat.clear();
                orderIndex=0;

                String period=next.replace("Class:","").trim();
                System.out.println(period);

            }

            else{

                seat.put(orderList.get(orderIndex), next);
                orderIndex++;
                checker=1;

            }
        }
    }
}
