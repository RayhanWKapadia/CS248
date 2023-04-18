import java.util.*;
import java.io.*;

public class Room{
   public int roomnumber;
   public int adjacent1;
   public int adjacent2;
   public int adjacent3;
   public String roomspook;
   public String placeholder;
  public Room(int r, int ad1, int ad2, int ad3, String rsp, String plc, String roomtextinfo)
  {
    roomnumber=r;
    adjacent1=ad1;
    adjacent2=ad2;
    adjacent3=ad3;
    roomspook=rsp;
  }
   public Room(Scanner f)
  {
    roomnumber=f.nextInt();
    adjacent1=f.nextInt();
    adjacent2=f.nextInt();
    adjacent3=f.nextInt();
    placeholder=f.nextLine();
    roomspook=f.nextLine();
  }
  public int getr()
  {return roomnumber;}
   public int getad1()
  { return adjacent1; }
  public int getad2()
  { return adjacent2; }
  public int getad3()
  { return adjacent3; }
  public String getplaceholder()
  { return placeholder;}
  public String getrsp()
  { return roomspook;}
  
  public String toString()
  {
    return "You are in room: "+roomnumber+" The adjacent rooms are "+adjacent1+","
      +adjacent2+", "+adjacent3+ " "+roomspook+" " ;
  }
}
