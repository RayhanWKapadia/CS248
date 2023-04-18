import java.io.*;
import java.util.*;
// Fish Class

class Fish 
{
  String arrivetableorquit;
  int time;
  int totalpeople;
  String title ;

  // Constructor
  public Fish(String n, int c, int s, String t)
  {
    arrivetableorquit=n;
    time=c;
    totalpeople=s;
    title=t;
  }

  public Fish(Scanner c)
  {
    arrivetableorquit=c.next();
    if(arrivetableorquit.equals("A"))
    {
    time=c.nextInt();
    totalpeople=c.nextInt();
    title=c.nextLine();
    }
    else if(arrivetableorquit.equals("T"))
      {
      time=c.nextInt();
      }
    else if(arrivetableorquit.equals("Q"))
    {
      
    }
  }
  // Accessors or Observers or getter

  public String getarrivetableorquit()
  { 
    return arrivetableorquit; 
  }
  public  int gettime()
  { 
    return time; 
  }
  public int gettotalpeople()
  { 
    return totalpeople; 
  }
  public String gettitle()
  { 
    return title; 
  }

  public String toString()
  {
    return "party " + title+ " of " + totalpeople+ " people." + "(time="+ time+")";
  }

  public String doString()
  {
    return "";
  }
  
}
