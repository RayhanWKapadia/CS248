class Sorts
{
  public static void selection(Comparable [] list)
  {
    // repeat
    //   find the max (by position)
    //   swap
    for(int i=list.length-1; i>0; i--)
    {
      int maxpos=findmax(list,i);
      swap(list,i,maxpos);
    }
  }
  private static void swap(Object [] list,int x, int y)
  {
    Object temp=list[x];
    list[x]=list[y];
    list[y]=temp;
  }
  private static int findmax(Comparable [] list, int end)
  {
    int maxpos=0;
    for(int j=1; j<=end; j++)
    {
      if(list[maxpos].compareTo(list[j])<0) // if list[max]<list[j]
        { maxpos=j; }
    }
    return maxpos;
  }
  //--------------------------------------------------------
  public static void bubble(Comparable [] list)
  {
    boolean done=false;
    while(!done)
    {
      // do one pass
      done=true;
      for(int i=0; i+1<list.length; i++)
      {
        if(list[i].compareTo(list[i+1])>0) // if out of order
          { swap(list,i,i+1); done=false; }
      }
    }
  }
  //--------------------------------------------------------
  public static void insertion(Comparable [] list)
  {
    for(int toinsert=1; toinsert<list.length; toinsert++)
    {
      Comparable saved=list[toinsert];
      int i;
      for(i=toinsert-1; i>=0; i--)
      {
        if(list[i].compareTo(saved)>0)
          { list[i+1]=list[i]; }
        else
          break;
      }
      list[i+1]=saved;
      //   5 7 8   2
    }
  }
  //--------------------------------------------------------
  public static void insertion(Comparable [] list, int gap, int offset)
  {
    for(int toinsert=gap+offset; toinsert<list.length; toinsert+=gap)
    {
      Comparable saved=list[toinsert];
      int i;
      for(i=toinsert-gap; i>=0; i-=gap) // i=i-gap is i-=gap
      {
        if(list[i].compareTo(saved)>0)
          { list[i+gap]=list[i]; }
        else
          break;
      }
      list[i+gap]=saved;
      //   5 7 8   2
    }
  }
  public static void shell(Comparable [] list)
  {
    int gap=list.length/5;
    while(gap>=3)
    {
      for(int offset=0; offset<gap; offset++)
        { insertion(list,gap,offset); }
      gap=(int)(gap/2.2);
    }
    insertion(list);
  }
  //--------------------------------------------------------
  private static int partition(Comparable [] list, int start, int stop)
  // returns the location of the pivot after partitioning
  {
    Comparable pivot=list[stop];
    int green=start;  // green is the array position just after the green line
      // or, everything in the array before position green is <pivot
      // or, green is the first position of the items >=pivot
    for(int blue=start; blue<stop; blue++)
    {
      if(list[blue].compareTo(pivot)<0) // then swap
        { swap(list,blue,green); green++; }
    }
    swap(list,stop,green);
    return green;
  }
  public static void quick(Comparable [] list)
  {
    quickhelp(list,0,list.length-1);
  }
  private static void quickhelp(Comparable [] list, int start, int stop)
  {
    // base cases
    if(start>=stop) // size 0 or 1
      { return; }
    if(start+1==stop) // size 2
    {
      if(list[start].compareTo(list[stop])>0) // if out of order
        { swap(list,start,stop); }
      return;
    }
    // recursive case
    int pivotpos=partition(list,start,stop);
    quickhelp(list,start,pivotpos-1);
    quickhelp(list,pivotpos+1,stop);
  }
  public static void merge(Comparable [] list)
  {
    mergehelp(list,0,list.length-1);
  }
  private static void mergehelp(Comparable [] list, int start, int stop)
  {
    // base cases
    if(start>=stop) // size 0 or 1
      { return; }
    if(start+1==stop) // size 2
    {
      if(list[start].compareTo(list[stop])>0) // if out of order
        { swap(list,start,stop); }
      return;
    }
    // recursive case
    int mid=(stop+start)/2;
    mergehelp(list,start,mid);
    mergehelp(list,mid+1,stop);
    domerge(list,start,mid,stop);
  }
  private static void domerge(Comparable [] list, int start, int mid, int stop)
  {
    int left=start, right=mid+1;
    Comparable [] A=new Comparable[stop-start+1];
    for(int i=0; i<A.length; i++)
    {
      // pull from the left when
      // the right is empty OR (left is not empty) and (list[left]<list[right])
      if(right>stop || (left<=mid && list[left].compareTo(list[right])<0))
        { A[i]=list[left++]; }
      else
        { A[i]=list[right++]; }
    }
    for(int i=0; i<A.length; i++)
      { list[start+i]=A[i]; }
  }
}








