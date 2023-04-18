//The Dating Game Rayhan Kapadia February 3
import java.util.*;
import java.io.*;

public class MyDate implements DateInterface
  
  {
    private int Day;
    private int Dow;
    private int Month;
    private int Year;
    
    public int getDay(){
      return Day;
      }
    
    public int getDow(){
      return Dow;
      }
    
      public int getMonth(){
       return Month;

      }
    
    public int getYear(){
      return Year; 
      }




      /** sets the date
      @param m the month of the year (1-12)
      @param d the day of the mongth (1-31)
      @param y the year (four digits)
      @param dow the day of the week (0-6) */
     public void set(int m, int d, int y, int dow){
       Month = m;
       Day = d;
       Year = y;
       Dow = dow;
     }



  /** moves the date forward by exactly one day */
      public void tomorrow(){
      boolean leapyear = false;
    if (Year % 4 == 0) {
      if (Year % 100 == 0) {
        if (Year % 400 == 0)
        {
          leapyear = true;
        }
        else
        {
          leapyear = false;
        }
      }else{
          leapyear = true;
      }
    }else{
      leapyear= false;
    }

        if (Month==1|| Month ==3|| Month==5||Month== 7||Month== 8||Month== 10)
        {
         Dow++;
          if(Dow ==7)
          {
            Dow=0;
          }
          
          if(Day==31)
          {
            Day=1;
            Month++;

          }
          else
            {
            Day++;
            }
        }
        else if (Month == 12)
        {
          Dow++;
          if(Dow ==7)
          {
            Dow=0;
          }
          if (Day==31)
            {
              Year++;
              Day=1;
              Month=1;
            }
          else{
            Day++;
          }
        }
          
        else if(Month==4 || Month== 6 || Month== 9 || Month== 11)
        {
           Dow++;
          if(Dow ==7)
          {
            Dow=0;
          }
          if (Day==30)
          {
            Day=1;
            Month++;
          }
          else{
            Day++;
          }
        }
        else if (Month==2 && leapyear==false)
        {
        Dow++;
          if(Dow ==7)
          {
            Dow=0;
          }
          if (Day==28)
          {
            Day=1;
            Month++;
          }
          else{
            Day++;
          }
        }
      else if (Month==2 && leapyear==true)
        {
         Dow++;
          if(Dow ==7)
          {
            Dow=0;
          }
          if (Day==29)
          {
            Day=1;
            Month++;
          }
          else{
            Day++;
          }
        }
        
        }
      
    
    public String toString(){
      String Doww = " ";
      String Monthh = " ";
      if (Dow==0)
      {
        Doww="Sunday";
      }
      if (Dow==1)
      {
        Doww="Monday";
      }
      if (Dow==2)
      {
        Doww="Tuesday";
      }
      if (Dow==3)
      {
        Doww="Wednesday";
      }
      if (Dow==4)
      {
        Doww="Thursday";
      }
      if (Dow==5)
      {
        Doww="Friday";
      }
      if (Dow==6)
      {
        Doww="Saturday";
      }

      if(Month==1)
      {
        Monthh="January";
      }
      if(Month==2)
      {
        Monthh="February";
      }
      if(Month==3)
      {
        Monthh="March";
      }
      if(Month==4)
      {
        Monthh="April";
      }
      if(Month==5)
      {
        Monthh="May";
      }
      if(Month==6)
      {
        Monthh="June";
      }
      if(Month==7)
      {
        Monthh="July";
      }
      if(Month==8)
      {
        Monthh="August";
      }
      if(Month==9)
      {
        Monthh="September";
      }
      if(Month==10)
      {
        Monthh="October";
      }
      if(Month==11)
      {
        Monthh="November";
      }
      if(Month==12)
      {
        Monthh="December";
      }
      return Doww+" "+Monthh+ " "+ Day+ ", "+ Year;
    }


    
  }
