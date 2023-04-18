class BST implements tree // Binary Search Tree!!
{
  private class treenode
  {
    public Comparable data;
    public treenode left;
    public treenode right;
  }
  treenode root;
  int count;

  public BST()
  {
    root=null; count=0;
    Q=null;
  }

  public void print()
  {
    printhelp(root);
  }
  private void printhelp(treenode r)
  {
    if(r==null) return;
    printhelp(r.left);
    System.out.println(r.data);
    printhelp(r.right);
  }

  public void insert(Comparable x)
  {
    root=inserthelp(root,x); // fake pass-by-reference for root
  }
  private treenode inserthelp(treenode r, Comparable x)
  {
    if(r==null) // empty tree - base case
    {
      r=new treenode();
      r.data=x;
      r.left=r.right=null;
      count++;
      return r;
    }
    // recursive cases
    // insert in left subtree
    if(x.compareTo(r.data)<0) // x < r.data
      { r.left=inserthelp(r.left,x); }
    else // insert in right subtree
      { r.right=inserthelp(r.right,x); }
    return r; // root doesn't change in recursive case
  }


  public Comparable lookup(Comparable x) 
  {
    return lookuphelp(root,x);
  }
  private Comparable lookuphelp(treenode r, Comparable x)
  {
    // base cases
    if(r==null) return null;
    if(r.data.compareTo(x)==0) // it matches - we found it!
      { return r.data; }
    // recursive cases
    if(x.compareTo(r.data)<0) // look to the left
      { return lookuphelp(r.left,x); }
    else // look to the right
      { return lookuphelp(r.right,x); }
  }

  private Comparable itemdeleted;
  public Comparable delete(Comparable x)
  {
    itemdeleted=null;
    root=deletehelp(root,x);
    return itemdeleted;
  }
  private treenode deletehelp(treenode r,Comparable x)
  {
    // base cases
    if(r==null) // empty tree
      { return r; } // no change
    if(x.compareTo(r.data)==0) // found it
    {
      // 0 children
      if(r.left==null && r.right==null)
      {
        count--;
        itemdeleted=r.data;
        return null;
      }
      // 1 child
      if(r.left==null) // one child who's right
      {
        count--;
        itemdeleted=r.data;
        return r.right;
      }
      if(r.right==null) // one child who's left
      {
        count--;
        itemdeleted=r.data;
        return r.left;
      }
      // 2 children
      // 1. find the inorder successor
      treenode is=r.right;
      treenode isparent=r;
      while(is.left!=null) {isparent=is; is=is.left; }
      // 2. copy over the item to delete
      count--;
      itemdeleted=r.data;
      r.data=is.data;
      // 3. delete the original inorder successor
      if(is==isparent.left) // is is a left child
      {
        isparent.left=is.right; // promote the child if it exists
      }
      else // is is a right child
      {
        isparent.right=is.right; // promote the child if it exists
      }
      return r; // don't change the node holding x
    }
    // recursive cases
    if(x.compareTo(r.data)<0) // x is smaller - search left subtree
      { r.left=deletehelp(r.left,x); }
    else
      { r.right=deletehelp(r.right,x); }
    return r;
  }

  // traversals/iterators
  private Queue Q;
  /*
   order=  0 for preorder
           1 for inorder
           2 for postorder
  */
  public static final int PREORDER=0;
  public static final int INORDER=1;
  public static final int POSTORDER=2;

  public void reset(int order) 
  {
    if(Q==null) { Q=new QueueLL(); }
    else { Q.makeEmpty(); }
    traversal(root,order);
  }
  private void traversal(treenode r, int order)
  {
    if(r==null) return; // empty subtree
    
    if(order==PREORDER) { Q.enqueue(r.data); }
    traversal(r.left,order);
    if(order==INORDER) { Q.enqueue(r.data); }
    traversal(r.right,order);
    if(order==POSTORDER) { Q.enqueue(r.data); }
  }

  public boolean hasNext() { return !Q.isEmpty(); }
  public Comparable getNext() { return (Comparable)Q.dequeue(); }


  public void makeEmpty()
  {
    root=null; count=0;
  }
  public boolean isEmpty() { return (count<=0); }
  public boolean isFull() { return false; }
  public int size() { return count; }


}



