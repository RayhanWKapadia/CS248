//Rayhan Kapadia Wumpus Project 2/27/2023
import java.io.*;
import java.util.*;
public class Main {
  public static void main(String [] args)
  throws IOException
  {
  Scanner cave=new Scanner(new FileReader("Cave.txt"));
    int n=cave.nextInt();
    Room [] roomlayout=new Room[n];
    for(int i=0; i<roomlayout.length; i++)
    {
      roomlayout[i]=new Room(cave);
    }
    int spider1 = (int)(Math.random()*(roomlayout.length-1)+1);
    int spider2 = (int)(Math.random()*(roomlayout.length-1)+1);
    int wumpuss = (int)(Math.random()*(roomlayout.length-1)+1);
    int hole = (int)(Math.random()*(roomlayout.length-1)+1);
    while(spider1==spider2||spider1==wumpuss||spider1==hole||spider1==1)
      {
        spider1 = (int)(Math.random()*(roomlayout.length-1)+1);
      }
    while(wumpuss==spider2||wumpuss==spider1||wumpuss==hole||wumpuss==1)
      {
      wumpuss = (int)(Math.random()*(roomlayout.length-1)+1);
      }
    while(spider2==1)
      {
        spider2 = (int)(Math.random()*(roomlayout.length-1)+1);
      }
    while(hole==spider2||hole==wumpuss||hole==spider1||hole==1)
      {
        hole = (int)(Math.random()*(roomlayout.length-1)+1);
      }
    //Uncomment to see the rooms of the traps
    /*
    System.out.println(hole);
    System.out.println(spider1);
    System.out.println(spider2);
    System.out.println(wumpuss);
    */
    
    System.out.println("Welcome to Wumpus Game");
    int roomcount = 0;
    int arrows = 3;
    String newnewanswer = " ";
    int newanswer=0;
    boolean user = true;
    while (user==true)
      {
        if(roomcount+1==wumpuss)
        {
          System.out.println("The wumpus got you!");
          break;
        }
        if(roomcount+1==hole)
        {
          System.out.println("You fell down a hole!");
          break;
        }
        if(roomcount+1==spider1)
        {
          System.out.println("The spider got you!");
          break;
        }
        if(roomcount+1==spider2)
        {
          System.out.println("The spider got you!");
          break;
        }
        int z = roomlayout[roomcount].adjacent1;
          int y = roomlayout[roomcount].adjacent2;
         int q = roomlayout[roomcount].adjacent3;
        System.out.println(roomlayout[roomcount]);
    System.out.println("You have "+arrows+" arrows");
        if(spider1==z||spider1==y||spider1==q)
        {
          System.out.println("You hear a faint clickig noise!");
        }
        if(spider2==z||spider2==y||spider2==q)
        {
          System.out.println("You hear a faint clickig noise!");
        }
        if(wumpuss==z||wumpuss==y||wumpuss==q)
        {
          System.out.println("You smell some nasty wumpus");
        }
        if(hole==z||hole==y||hole==q)
        {
          System.out.println("You smell a dank odor.");
        }
        
    System.out.println("Move or shoot?");
        Scanner moveorshoot = new Scanner(System.in);
      newnewanswer = moveorshoot.next();
        while(!newnewanswer.equals("M")&&!newnewanswer.equals("S")){
          System.out.println("Please enter a valid command!");
            System.out.println("Move or shoot?");
                newnewanswer = moveorshoot.next();
          }
        if(newnewanswer.equals("S")){
          System.out.println("Shoot which room?");
          Scanner mynewObj = new Scanner(System.in);
          newanswer = mynewObj.nextInt();
          while(newanswer!=z&&newanswer!=y&&newanswer!=q)
            {
              System.out.println("Please enter a valid room");
              newanswer = mynewObj.nextInt();
            }
          if(newanswer!=wumpuss)
          {
            System.out.println("Your arrow is lost");
            arrows--;
            if(arrows==0)
            {
              System.out.println("You are defenseless against the wumpus!");
              break;
            }
          }
          if(newanswer==wumpuss)
          {
            arrows--;
            System.out.println("YOU WIN!!!");
            break;
          }
        }
        if(newnewanswer.equals("M"))
        {
          System.out.println("Which room?");
          Scanner mynewObj = new Scanner(System.in);
          newanswer = mynewObj.nextInt();
          while(newanswer!=z&&newanswer!=y&&newanswer!=q)
            {
              System.out.println("Please enter a valid room");
              newanswer = mynewObj.nextInt();
            }
          if(newanswer==z||newanswer==y||newanswer==q)
          {
            roomcount=newanswer;
            roomcount--;
          }
        }   
      }
    }
}
