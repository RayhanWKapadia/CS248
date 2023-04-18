import java.util.*;
// Fish Class

class Fish implements Comparable
{
  String Name;
  int Age;
  String Status;
  String con;
  
  public Fish(String c, int s, String f)
  {
    Name=c;
    Age=s;
    Status=f;

  }

  public Fish(Scanner Z)
  {

      Name=Z.next();
      Age=Z.nextInt();
      Status=Z.next();
  }
  // Accessors or Observers or getter
  public String getName()
  { return Name; }
  public int getAge()
  { return Age; }
  public String getStatus()
  { return Status; }
 
  public String getCon()
  {     
    String s=String.valueOf(Age);
    return Name+ " "+ Age+ " "+Status;
  }

  public String toString()
  {
    
          return " Name: "+ Name+ " Age: "+ Age + " Diet: " + Status;

    
  }

  public int compareTo(Object y)
  {
    if(y instanceof Fish)
    {
      Fish f=(Fish)y; // convert y to a Fish
      //return Name.compareTo(f.getName());
       return Name.compareTo(f.getName());
    }
    else
      return 0; // y isn't a fish!
  }
  
}




