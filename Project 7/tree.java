public interface tree extends DataStructure
{
  public void insert(Comparable x);
  public Comparable lookup(Comparable x);
  public Comparable delete(Comparable x);

  public void print(); // inorder printing of tree data

  // traversals/iterators
  public void reset(int order);
  public boolean hasNext();
  public Comparable getNext();
}
