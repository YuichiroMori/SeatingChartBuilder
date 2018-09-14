package seatingchartbuilder;

import java.util.*;

public class BestSeat implements Iterator{
    
    private ArrayList seat;
    private int position;

    
    public BestSeat(String order){
        
        try{
        
        String[] numbers=order.split(" ");
        seat=new ArrayList<>();
        position=0;
        int a=0;
        
        for(int x=0;x<numbers.length;x++){
            a=Integer.parseInt(numbers[x]);
            seat.add(a);
        }
    }
    catch (Exception e) {
	System.out.println("Oops, something really bad happened");
	System.out.println( e ); 
}
}
    
    public Integer next(){
        
    Iterator loop=seat.iterator();
    int x=0;
    int ans=0;
    
    while(x<position){
        loop.next();
        x++;
    }
    
      if(loop.hasNext()){
          ans=(int)seat.get(position);
          position++;
      }
      else{
          throw new NoSuchElementException("No more"); 
      }
      return ans;
    }
    
    public boolean hasNext(){
        
        Iterator loop=seat.iterator();
        int x=0;
        
        while(x<position){
            loop.next();
            x++;
        }
        
        return loop.hasNext();
        
    }
    
}
