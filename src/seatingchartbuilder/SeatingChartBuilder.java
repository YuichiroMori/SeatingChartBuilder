package seatingchartbuilder;

import java.util.*;
import java.io.*;

public class SeatingChartBuilder {

    public static void main(String[] args) throws Exception{

            Scanner input=new Scanner(new File("input.txt"));
            ArrayList<Integer> orderList=new ArrayList<>();
            ArrayList<String> studentList=new ArrayList<>();
            ArrayList<String> extraStudents=new ArrayList<>();
            int checker=0;


            while(input.hasNextLine()) {

                String what = input.nextLine();


                //Checks to see if the line contains Teacher
                if (what.contains("Teacher:")) {

                    String teacher = what.replace("Teacher:", "").trim();
                    String divider = "";

                    for (int x = 0; x < teacher.length(); x++) {
                        divider += "=";
                    }

                    System.out.println(teacher);
                    System.out.println(divider);
                }


                //Checks to see if the line contains Order
                else if (what.contains("Order:")) {

                    String order = what.replace("Order:", "").trim();
                    order = order.replace(",", "");

                    BestSeat best = new BestSeat(order);

                    while (best.hasNext()) {
                        orderList.add(best.next());
                    }
                }

                //Checks to see if the line is the first class period to be pritned
                else if (what.contains("Class:")&&checker==0) {
                    String period = what.replace("Class: ", "");
                    System.out.println(period+"\n");
                }


                //Checks to see if the occurence is class: is more than once then prints out student names, and the next class
                else if(what.contains("Class:")&&checker==1){

                    Map<Integer,String> studentMap=new TreeMap<>();

                    Collections.shuffle(studentList);

                    for(int x=0;x<studentList.size();x++){
                        studentMap.put(orderList.get(x),studentList.get(x));
                    }

                    for(int y=1;y<orderList.size()/2+1;y++){

                        int half=orderList.size()/2;

                        if(studentMap.containsKey(y)&&studentMap.containsKey(y+half)) {

                            String student = studentMap.get(y);
                            String studentTwo=studentMap.get(y+half);
                            String studentSeatNumber="";
                            String studentTwoSeatNumber="";

                            if (y < 10) {

                                studentSeatNumber = "0" + Integer.toString(y) + " ";

                            } else {

                                studentSeatNumber = Integer.toString(y) + " ";

                            }
                            if(y+half<10){

                                studentTwoSeatNumber="0"+Integer.toString(y+half)+" ";
                            }

                            else{

                                studentTwoSeatNumber=Integer.toString(y+half)+" ";
                            }

                            studentSeatNumber=studentSeatNumber+student;
                            studentTwoSeatNumber=studentTwoSeatNumber+studentTwo;

                            for(int x=studentSeatNumber.length();x<40;x++){
                                studentSeatNumber+=" ";
                            }

                            System.out.println(studentSeatNumber+studentTwoSeatNumber);
                        }
                        else if(studentMap.containsKey(y)&&!studentMap.containsKey(y+half)){

                            String student=studentMap.get(y);
                            String studentSeatNumber="";
                            String studentTwoSeatNumber="";

                            if (y < 10) {

                                studentSeatNumber = "0" + Integer.toString(y) + " ";

                            } else {

                                studentSeatNumber = Integer.toString(y) + " ";

                            }
                            if(y+half<10){

                                studentTwoSeatNumber="0"+Integer.toString(y+half)+" ";
                            }

                            else{

                                studentTwoSeatNumber=Integer.toString(y+half)+" ";
                            }

                            studentSeatNumber=studentSeatNumber+student;

                            for(int x=studentSeatNumber.length();x<40;x++){
                                studentSeatNumber+=" ";
                            }
                            System.out.println(studentSeatNumber+studentTwoSeatNumber);
                        }

                        else if(!studentMap.containsKey(y)&&studentMap.containsKey(y+half)){

                            String studentSeatNumber="";
                            String studentTwo=studentMap.get(y+half);
                            String studentTwoSeatNumber="";

                            if (y < 10) {

                                studentSeatNumber = "0" + Integer.toString(y) + " ";

                            } else {

                                studentSeatNumber = Integer.toString(y) + " ";

                            }
                            if(y+half<10){

                                studentTwoSeatNumber="0"+Integer.toString(y+half)+" ";
                            }

                            else{

                                studentTwoSeatNumber=Integer.toString(y+half)+" ";
                            }

                            studentTwoSeatNumber=studentTwoSeatNumber+studentTwo;

                            for(int x=studentSeatNumber.length();x<40;x++){

                                studentSeatNumber+=" ";
                            }

                            System.out.println(studentSeatNumber+studentTwoSeatNumber);

                        }
                        else{

                            String studentSeatNumber="";
                            String studentTwoSeatNumber="";

                            if (y < 10) {

                                studentSeatNumber = "0" + Integer.toString(y) + " ";

                            } else {

                                studentSeatNumber = Integer.toString(y) + " ";

                            }
                            if(y+half<10){

                                studentTwoSeatNumber="0"+Integer.toString(y+half)+" ";
                            }

                            else{

                                studentTwoSeatNumber=Integer.toString(y+half)+" ";
                            }


                            for(int x=studentSeatNumber.length();x<40;x++){
                                studentSeatNumber+=" ";
                            }
                            System.out.println(studentSeatNumber+studentTwoSeatNumber);

                        }
                    }

                    if(extraStudents.size()>0){

                        System.out.println("Additional Students");

                        for(int x=0;x<extraStudents.size();x++){

                            String extra=extraStudents.get(x);
                            System.out.println(extra);
                        }
                    }

                    String period = what.replace("Class: ", "");
                    System.out.println("\n"+period);
                    studentList.clear();
                    extraStudents.clear();
                }

                //Adds student name to list of students
                else {

                    if(orderList.size()<=studentList.size()){
                        extraStudents.add(what);
                    }
                    else {
                        studentList.add(what);
                        checker = 1;
                    }
                }
            }

        Map<Integer,String> studentMap=new TreeMap<>();

        Collections.shuffle(studentList);

        for(int x=0;x<studentList.size();x++){
            studentMap.put(orderList.get(x),studentList.get(x));
        }

        for(int y=1;y<orderList.size()/2+1;y++){

            int half=orderList.size()/2;

            if(studentMap.containsKey(y)&&studentMap.containsKey(y+half)) {

                String student = studentMap.get(y);
                String studentTwo=studentMap.get(y+half);
                String studentSeatNumber="";
                String studentTwoSeatNumber="";

                if (y < 10) {

                    studentSeatNumber = "0" + Integer.toString(y) + " ";

                } else {

                    studentSeatNumber = Integer.toString(y) + " ";

                }
                if(y+half<10){

                    studentTwoSeatNumber="0"+Integer.toString(y+half)+" ";
                }

                else{

                    studentTwoSeatNumber=Integer.toString(y+half)+" ";
                }

                studentSeatNumber=studentSeatNumber+student;
                studentTwoSeatNumber=studentTwoSeatNumber+studentTwo;

                for(int x=studentSeatNumber.length();x<40;x++){
                    studentSeatNumber+=" ";
                }

                System.out.println(studentSeatNumber+studentTwoSeatNumber);
            }
            else if(studentMap.containsKey(y)&&!studentMap.containsKey(y+half)){

                String student=studentMap.get(y);
                String studentSeatNumber="";
                String studentTwoSeatNumber="";

                if (y < 10) {

                    studentSeatNumber = "0" + Integer.toString(y) + " ";

                } else {

                    studentSeatNumber = Integer.toString(y) + " ";

                }
                if(y+half<10){

                    studentTwoSeatNumber="0"+Integer.toString(y+half)+" ";
                }

                else{

                    studentTwoSeatNumber=Integer.toString(y+half)+" ";
                }

                studentSeatNumber=studentSeatNumber+student;

                for(int x=studentSeatNumber.length();x<40;x++){
                    studentSeatNumber+=" ";
                }
                System.out.println(studentSeatNumber+studentTwoSeatNumber);
            }

            else if(!studentMap.containsKey(y)&&studentMap.containsKey(y+half)){

                String studentSeatNumber="";
                String studentTwo=studentMap.get(y+half);
                String studentTwoSeatNumber="";

                if (y < 10) {

                    studentSeatNumber = "0" + Integer.toString(y) + " ";

                } else {

                    studentSeatNumber = Integer.toString(y) + " ";

                }
                if(y+half<10){

                    studentTwoSeatNumber="0"+Integer.toString(y+half)+" ";
                }

                else{

                    studentTwoSeatNumber=Integer.toString(y+half)+" ";
                }

                studentTwoSeatNumber=studentTwoSeatNumber+studentTwo;

                for(int x=studentSeatNumber.length();x<40;x++){

                    studentSeatNumber+=" ";
                }

                System.out.println(studentSeatNumber+studentTwoSeatNumber);

            }
            else{

                String studentSeatNumber="";
                String studentTwoSeatNumber="";

                if (y < 10) {

                    studentSeatNumber = "0" + Integer.toString(y) + " ";

                } else {

                    studentSeatNumber = Integer.toString(y) + " ";

                }
                if(y+half<10){

                    studentTwoSeatNumber="0"+Integer.toString(y+half)+" ";
                }

                else{

                    studentTwoSeatNumber=Integer.toString(y+half)+" ";
                }


                for(int x=studentSeatNumber.length();x<40;x++){
                    studentSeatNumber+=" ";
                }
                System.out.println(studentSeatNumber+studentTwoSeatNumber);

            }
        }
        if(extraStudents.size()>0){

            System.out.println("Additional Students");

            for(int x=0;x<extraStudents.size();x++){

                String extra=extraStudents.get(x);
                System.out.println(extra);
            }
        }
    }
}
