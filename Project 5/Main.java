//Rayhan Kapadia 3/17/2023
import java.io.*;
import java.util.*;

class Main
{
  public static void main(String [] args)
  throws IOException
  {
    int lines=0;
    String waiting = " ";
    double timearrayholder=0;
    double peopleholder=0;
    int counter = 0;
    double holder= 0;
    String line, filename;
    String holderone=" ";
    int holdertwo=0;
    int totalpeople=0;
    double totalpeopletimer=0;
    System.out.println("*** Welcome to the La Food Restaurant Simulator ***");
    System.out.println("Input the name of your file");
    Scanner cin=new Scanner(System.in);
    //Scanner fishfile=new Scanner(new FileReader("fishfile.txt"));
    //int n=fishfile.nextInt();
    filename=cin.nextLine();
		Scanner infile;
    infile = new Scanner(new FileReader(filename));
    while(infile.hasNextLine()) {
        infile.nextLine();
      lines++;
      }
    //lines--;
   infile = new Scanner(new FileReader(filename));
    //This specific line will allow you to switch between a queue array or queue linked list
    //Queue Q=new QueueArray(1000);
    Queue Q=new QueueLL();
  for(int i=0; i<lines; i++)
    {
      //Q.enqueue(new Fish(fishfile));
      Q.enqueue(new Fish(infile));
      
    }
    //System.out.println(( (Fish) Q.getFront() ).gettime());
    String[] myarray = new String[100];
    int[] timearray = new int[100];
    int[] peoplearray = new int[100];
    int count= 0 ;
    while(!Q.isEmpty())
    {
      if(( (Fish) Q.getFront() ).getarrivetableorquit().equals("A"))
      {
        myarray [count]=( (Fish) Q.getFront() ).gettitle();
        timearray[count]=( (Fish) Q.getFront() ).gettime();
        peoplearray[count]=( (Fish) Q.getFront() ).gettotalpeople();
        totalpeople= totalpeople+( (Fish) Q.getFront() ).gettotalpeople();
        count++;
        System.out.println("Please wait at the bar,");
        System.out.println(Q.getFront().toString());
        Q.dequeue();
      }
       if(( (Fish) Q.getFront() ).getarrivetableorquit().equals("T"))
      {
        counter++;
        for(int i=0; i<myarray.length; i++)
          {
          if(myarray[i]!=null){
          waiting = myarray[i];
            myarray[i]=null;
            break;
          }
          }
        for(int i=0; i<timearray.length; i++){
        if(timearray[i]!=0){
          timearrayholder = timearray[i];
            timearray[i]=0;
            break;
        }
        
        }
        for(int i=0; i<peoplearray.length; i++){
        if(peoplearray[i]!=0){
          peopleholder = peoplearray[i];
            peoplearray[i]=0;
            break;
        }
        
        }
        
        System.out.println("Table for " + waiting+ "! (time="+ ( (Fish) Q.getFront() ).gettime()+")");
        totalpeopletimer=totalpeopletimer+((( (Fish) Q.getFront() ).gettime()-timearrayholder)*peopleholder);
        
        //System.out.println(timearrayholder);
        holder=holder+(( (Fish) Q.getFront() ).gettime())-timearrayholder;
        Q.dequeue();
      }
       if(( (Fish) Q.getFront() ).getarrivetableorquit().equals("Q"))
      {
        break;
      }
   
    }
    for(int i=0; i<myarray.length; i++)
          {
          if(myarray[i]!=null){
         // System.out.println("party " +myarray[i]+" of "+peoplearray[i]+" people");
            holderone=(myarray[i]);
            holdertwo=(peoplearray[i]);
          }
        }
    System.out.println("** Simulation Terminated **");
    System.out.println("");
    System.out.println("");
    System.out.println("The average waiting time was: " + totalpeopletimer/(totalpeople-holdertwo));
   // System.out.println(totalpeople-holdertwo);    
    System.out.println("The following parties were never seated ");
    for(int i=0; i<myarray.length; i++)
          {
          if(myarray[i]!=null){
          System.out.println("party" +myarray[i]+" of "+peoplearray[i]+" people");
          }
        }
    
    System.out.println("");
    System.out.println("Have a nice meal!");
    //(3*7)+(2*7)+(2*8)/total people
}
}
