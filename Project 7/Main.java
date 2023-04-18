//Rayhan Kapadia April 11, 2023
import java.io.*;
import java.util.*;

class Main
{
  public static void main(String [] args)
  throws IOException
  {
    char a= 'A';
    String dog = "cat";
    tree giving=new BST();
    Scanner fishfile2 = new Scanner(new FileReader("camp.txt"));
    System.out.println("Welcome to Camp Posanivee!!");
    while(fishfile2.hasNextLine()) {
      a = fishfile2.next().charAt(0);
      if(a=='E')
      {   
        System.out.print("Command: E ");
        Fish key=new Fish(fishfile2);
        giving.insert(key);
        System.out.println(key.getCon());
        System.out.println("New camper added.");
      }
        
        
      
  
     else if(a=='A')
      {
        System.out.println("Command: A");
        if(giving.isEmpty())
            {
              System.out.println("There are no campers.");
            }
        double totals=0;
        double average=0;
        giving.reset(BST.PREORDER);
        if(!giving.isEmpty())
      {
        while(giving.hasNext()) 
      { 
        if((((Fish)giving.getNext()).getAge())!=0)
        {
          average += ((Fish)giving.getNext()).getAge(); 
           totals ++;
          
        }
      }
        System.out.println("The average age is: "+average/totals);
      }
      }

      
      else if(a=='P')
      {
      System.out.println("Command: P ");
      System.out.println("Preorder Traversal");
      giving.reset(BST.PREORDER);
      while(giving.hasNext()) 
      {System.out.println(((Fish)giving.getNext()).getName()); }
      }
        else if(a=='H')
        {
          System.out.println("H	Help: print a list of commands");
          System.out.println("E name age diet	Enroll a new camper (insert)");
          System.out.println("W name	Withdraw a camper (delete)");
          System.out.println("D name	Display the age and diet of a camper");
          System.out.println("A	Print the average age of the campers");  
          System.out.println("L	List all campers names in alphabetical order");  
          System.out.println("V	Print the number of vegan campers");                             
          System.out.println("P	List all campers names in preorder");  
          System.out.println("Q	Quit");  
        }
 
       else if(a=='L')
      {
        int it=0;
        String names = "";
          System.out.println("Command: L");
        System.out.println("Alphabetical List of Campers:");
         String[] myarray = new String[100];
        giving.reset(BST.PREORDER);
    while(giving.hasNext()) 
      { 
        myarray[it] = ((Fish)giving.getNext()).getName();
        it++;
      }
        for(int i = 0; i<100; i++) 
         {  
             for (int j = i+1; j<100; j++)   
             {  
               if(myarray[i]!=null&& myarray[j]!=null)
               {
                if(myarray[i].compareTo(myarray[j])>0)   
                {  
                  
           
           
                    String temp = myarray[i];  
                    myarray[i] = myarray[j];  
                    myarray[j] = temp;  
           
                 }
               }
              }  
           }
         for (String element: myarray) {
           if(element!=null)
           {
              System.out.println(element);
           }
           
        }
      }
     
      else if(a=='W')
      {
        System.out.print("Command: W ");
        String jack = "";
        jack = fishfile2.next();
        System.out.print(jack);
        Fish key=new Fish(jack,0,"");
        Fish answer=(Fish)giving.lookup(key);
        answer=(Fish) giving.delete(key);
       System.out.println("\nDeleting "+key.getName());
      }
        else if(a=='D')
      {
       System.out.print("Command: D ");
        String jake = "";
        jake = fishfile2.next();
        System.out.print(jake);
        Fish key=new Fish(jake,0,"");
        Fish answer=(Fish)giving.lookup(key);
       System.out.println("\n"+ giving.lookup(answer));
      }
      
      else if(a=='V')
      {
        System.out.print("Command: V ");
        int vegoons=0;
         giving.reset(BST.PREORDER);
       while(giving.hasNext()) 
      { 
        if((((Fish)giving.getNext()).getStatus()).equals("V"))
        {
           vegoons ++;

        }
      }
       System.out.println("\nTotal Vegans "+vegoons);
      }
      else if(a=='Q')
      {
        System.out.println("Command: Q ");
        System.out.println("End of Program.");
        System.out.println("Bring plenty of calomine!");
        break;
      }
    }


    }
  }
}

