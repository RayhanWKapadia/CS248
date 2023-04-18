//Rayhan Kapadia 3-31-2023
import java.io.*;
import java.util.*;
import java.util.Arrays;


class Main
{
   static long run1, run2, run3, run4, run5, run6, run7, run8, run9, run10;
  public static Integer [] randomlist(int n)
  {
    Integer [] list=new Integer[n];
    for(int i=0; i<list.length; i++)
      { list[i]=new Integer((int)(n*Math.random())); }
    return list;
  }

  public static void main(String [] args)
  throws IOException
  {
    System.out.println("Welcome to the program");
    System.out.println("Give an array size");
    Scanner userinputdirect = new Scanner(System.in);
    int userinput = userinputdirect.nextInt();
    Integer [] list=randomlist(userinput);
if (userinput<=100)
{
    System.out.println("Original:");
    for(int i=0; i<list.length; i++)
      { System.out.print(list[i]+" "); }
    System.out.println("");
    Integer [] list2 = Arrays.copyOf(list, list.length);
        Integer [] list3 = Arrays.copyOf(list, list.length);
        Integer [] list4 = Arrays.copyOf(list, list.length);
        Integer [] list5 = Arrays.copyOf(list, list.length);
        Integer [] list6 = Arrays.copyOf(list, list.length);
   run1= System.currentTimeMillis();
  Sorts.merge(list);
       run2=System.currentTimeMillis();

    
   
    System.out.println("Merge Sort:");
    for(int i=0; i<list.length; i++)
      { System.out.print(list[i]+" "); }

    System.out.println("");
     run3=System.currentTimeMillis();

    Sorts.bubble(list2);
       run4=System.currentTimeMillis();

    System.out.println("Bubble Sort:");
    for(int i=0; i<list2.length; i++)
      { System.out.print(list2[i]+" "); }

    System.out.println("");

       run5=System.currentTimeMillis();
    Sorts.quick(list3);
       run6=System.currentTimeMillis();
    System.out.println("Quick Sort:");
    for(int i=0; i<list3.length; i++)
      { System.out.print(list3[i]+" ");
           }
    System.out.println("");

     run7=System.currentTimeMillis();
    Sorts.insertion(list4);
       run8=System.currentTimeMillis();

    System.out.println("Insertion Sort:");
    for(int i=0; i<list4.length; i++)
      { System.out.print(list4[i]+" "); }
    System.out.println("");


     run9=System.currentTimeMillis();
    Sorts.selection(list5);
       run10=System.currentTimeMillis();
    System.out.println("Selection Sort:");
    for(int i=0; i<list5.length; i++)
      { System.out.print(list5[i]+" "); }
    System.out.println("");


     System.out.println("Here are our run times:");
    System.out.println("Merge Sort: "+(run2-run1));
    System.out.println("Bubble Sort: "+(run4-run3));
    System.out.println("Quick Sort: "+(run6-run5));
    System.out.println("Insertion Sort: "+(run8-run7));
    System.out.println("Selection Sort: "+(run10-run9));
}

    else{
      
    Integer [] list2 = Arrays.copyOf(list, list.length);
        Integer [] list3 = Arrays.copyOf(list, list.length);
        Integer [] list4 = Arrays.copyOf(list, list.length);
        Integer [] list5 = Arrays.copyOf(list, list.length);
        Integer [] list6 = Arrays.copyOf(list, list.length);
   run1= System.currentTimeMillis();
    Sorts.merge(list);
   run2=System.currentTimeMillis();
    
     run3=System.currentTimeMillis();
    Sorts.bubble(list2);
    run4=System.currentTimeMillis();

       run5=System.currentTimeMillis();
    Sorts.quick(list3);
       run6=System.currentTimeMillis();

     run7=System.currentTimeMillis();
    Sorts.insertion(list4);
       run8=System.currentTimeMillis();


     run9=System.currentTimeMillis();
    Sorts.selection(list5);
       run10=System.currentTimeMillis();
      
     System.out.println("Here are our run times:");
    System.out.println("Merge Sort: "+(run2-run1));
    System.out.println("Bubble Sort: "+(run4-run3));
    System.out.println("Quick Sort: "+(run6-run5));
    System.out.println("Insertion Sort: "+(run8-run7));
    System.out.println("Selection Sort: "+(run10-run9));
    }

  }
}






