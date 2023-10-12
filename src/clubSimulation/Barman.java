package clubSimulation;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/*
 This is the basic ClubGoer Thread class, representing the patrons at the club
 */

public class Barman extends Thread {

   public static ClubGrid club;
   public static PeopleLocation customerLocation ;
   
   private PeopleLocation myLocation ;
   private int ID; //thread ID 
   public thirsty
   
   Barman( int ID,  PeopleLocation loc) {
		this.ID=ID;
		this.myLocation = loc; //for easy lookups
      this.myLocation.setLocation(club.whichBlock(7,5));
	}
   
   public void serve() throws InterruptedException
   {
   	int x_mv= Integer.signum(customerLocation.getX()-myLocation.getX());//-1,0 or 1
		int y_mv= Integer.signum(customerLocation.getY()-myLocation.getY());//-1,0 or 1
		myLocation.setLocation(club.moveB(myLocation.getLocation(),x_mv,y_mv,myLocation)); //head toward thirsty customer
		System.out.println("Thread "+this.ID + " moved toward customer: " + customerLocation.getX()  + " " +customerLocation.getY() );
		sleep(5);  //wait a bit
      if(x_mv== 0 && y_mv==0)
      {System.out.println("Thread "+customerLocation.getID() + " got drink at bar position: " + customerLocation.getX()  + " " +customerLocation.getY() );}
      
   }
   
   public void run()
   {
     
   while(true)
   {
      try
      {
      serve();
      }
      catch (InterruptedException e) {
                   e.printStackTrace();
               }
   }
   }



}
