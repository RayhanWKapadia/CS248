import java.util.Scanner;
import java.io.*;
import java.io.*;
import java.util.*;

class Main
{
   public static int[] removeFirstElement(int[] A) {
        int newArr[] = new int[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            newArr[i-1] = A[i];
        }
        return newArr;
    }
  
	public static void main(String [] args) 
	throws IOException
	{
    int count = 0;
    String line, filename;
		Scanner cin=new Scanner(System.in);
        System.out.println("***Welcome to the Exam Statistics Program!!***");

		System.out.print("Please enter a filename: ");
		filename=cin.nextLine();
		Scanner infile;
    infile = new Scanner(new FileReader(filename));
      while(infile.hasNextInt()) {
        infile.nextInt();
        count++;
      }
    count= count;
    int [] A;
    A = new int [count];
    infile = new Scanner(new FileReader(filename));
    for (int i = 0; i<A.length; i++)
      {
        if (infile.hasNextInt()) 
        {
          A[i] = infile.nextInt();
        }
      }
    int newArr[] = removeFirstElement(A);

    double sum=0.0;
    int max= newArr[0];
    int min=newArr[0];
    int a=0;
    int b=0;
    int c=0;
    int d=0;
    int f=0;

    
    for (int i= 0; i<newArr.length; i++)
      {
        if (newArr[i]>max)
        {
          max=newArr[i];
        }
          if (newArr[i]<min)
        {
          min=newArr[i];
        }
        sum+=newArr[i];
        if(newArr[i]>90)
        {
          a++;
        }
        if(newArr[i]<90 && newArr[i]>80)
        {
          b++;
        }
        
        if(newArr[i]<80 && newArr[i]>70)
        {
          c++;
        }
        if(newArr[i]<70 && newArr[i]>60)
        {
          d++;
        }
        if(newArr[i]<60)
        {
          f++;
        }
      }
          infile.close();
    System.out.println("\nMinimum score: " +min);
    System.out.println("Maximum score: " +max);
    System.out.println("Average score: " +sum/(count-1));
    System.out.println("\nNumber of scores by letter grade");
    System.out.println("A: "+ a);
    System.out.println("B: "+ b);
    System.out.println("C: "+ c);
    System.out.println("D: "+ d);
    System.out.println("F: "+ f);
  }
}
