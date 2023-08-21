public class BST
{
  private class Node{
    int data;
    Node left;
    Node right;

    Node(int newdata){
      data = newdata;
      left = null;
      right = null;
    }
  }

  private Node root;

  public BST()
  {
    root = null;
  }



  public void insert(int key)
  {
    root = insertnode(root, key);
  }

  private Node insertnode(Node p, int key) // which node and key you want to insert
  {
    if (key == p.data) return p;
    if (p == null) return new Node(key);
    if (key < p.data) p.left = insert(p.left, key);
    else p.right = insert(p.right, key);

    return p;
  }



  public void delete(int key)
  {
    root = delete(root, key);
  }

  private Node delete(Node p, int key)
  {
    if (p == null) throw new RuntimeException("Cannot delete");

    else
    if (key < p.data) p.left = delete(p.left, key);
    else
    if (key > p.data) p.right = delete(p.right, key);

    else
    {
      if (p.left == null) return p.right;
      else
      if (p.right == null) return p.left;
      else
      {
      p.data = retrieve(p.left);
      p.left = delete(p.left, p.data);
      }
    }
    return p;
  }

  public int count(int low, int high)
  {
    // define number of key values from low to high (inclusive)
  }

  private int retrieve(Node p)
  {
    while (p.right != null) p = p.right;
    return p.data;
  }

  public void preorderTraversal()
  {
    preorderTraversal(root);
  }

  private void preorderTraversal(Node t)
  {
    if (t != null)
    {
      System.out.print(t.data + "");
      preorderTraversal(t.left);
      preorderTraversal(t.right);
    }

  }
    public static void main(String[] args)
    {
      BST bst = new BST();
      bst.insert(11);
      bst.insert(6);
      bst.insert(8);
      bst.insert(19);
      bst.insert(4);

      bst.delete(11);

      bst.preorderTraversal();
      System.out.println();



    }
}
