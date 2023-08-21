/** **************************************************************************
 *                     The  generic Binary Search Tree class.
 *
 * V.S.Adamchik 2010
 *****************************************************************************/

import java.util.*;

public class BST
{
   public static void main(String[] args)
   {

      BST bst = new BST();
      bst.insert(11);
      bst.insert(6);
      bst.insert(8);
      bst.insert(19);
      bst.insert(4);
      bst.insert(10);
      bst.insert(5);
      bst.insert(17);
      bst.insert(43);
      bst.insert(49);
      bst.insert(31);

      System.out.println("The values in the tree with a preorder traversal are: ");
      bst.preOrderTraversal();
      System.out.println();
      System.out.println("The values in the tree after deletion are: ");
      bst.deleteleftinright(11);
      bst.preOrderTraversal();
      System.out.println();

      System.out.println("The number of values in the range is: " + bst.count(7,33));
      bst.inOrderTraversal();
      System.out.println();


   }


   private Node root;

   private class Node {
      Node left;
      Node right;
      int data;
      Node(int newData) {
        left = null;
        right = null;
        data = newData;
     }
   }

   public BST()
   {
      root = null;
   }





/*****************************************************
*
*            INSERT
*
******************************************************/
   public void insert(int data)
   {
      root = insert(root, data);
   }
   private Node insert(Node p, int key)
   {
      if (p == null)
         return new Node(key);

      if (key == p.data)
      	return p;

      if (key <= p.data)
         p.left = insert(p.left, key);
      else
         p.right = insert(p.right, key);

      return p;
   }

/*****************************************************
*
*            SEARCH
*
******************************************************/
   public boolean search(int key)
   {
      return search(root, key);
   }
   private boolean search(Node p, int key)
   {
      if (p == null)
         return false;
      else
      if (key == p.data)
      	return true;
      else
      if (key <= p.data)
         return search(p.left, key);
      else
         return search(p.right, key);
   }

/*****************************************************
*
*            DELETE
*
******************************************************/

   public void delete(int key)
   {
      root = delete(root, key);
   }
   private Node delete(Node p, int key)
   {
      if (p == null)  throw new RuntimeException("cannot delete.");
      else
      if (key < p.data)
        p.left = delete (p.left, key);
        else if (key > p.data)
        p.right = delete (p.right, key);
        else
        {
          if (p.left == null) return p.right;
          else
            if (p.right == null) return p.left;
            else
            {
              // get data from the rightmost node in the left subtree
                p.data = retrieveData(p.left);
                // delete the rightmost node in the left subtree
                p.left =  delete(p.left, p.data) ;
            }
          }
        return p;
   }



   public void deleteleftinright(int key)
   {
     root = deleteleftinright(root, key);
   }
   private Node deleteleftinright(Node p, int key)
   {
     if (p == null) throw new RuntimeException("cannot delete.");
     else
     if (key < p.data)
      p.left = deleteleftinright(p.left, key);
      else if (key > p.data)
      p.right = deleteleftinright(p.right, key);
      else
      {
          if (p.left == null) return p.right;
          else
            if (p.right == null) return p.left;
            else
            {
              // get data from the leftmost node in the right subtree
              p.data = retrieveDataleft(p.right);
              // delete the leftmost node in the right subtree
              p.right = deleteleftinright(p.right, p.data);
            }
        }
      return p;
   }




   private int retrieveData(Node p)
   {
      while (p.right != null) p = p.right;

      return p.data;
   }



   private int retrieveDataleft(Node p)
   {
     while (p.left != null) p = p.left;

     return p.data;
   }



/*************************************************
 *
 *            TRAVERSAL
 *
 **************************************************/

   public void preOrderTraversal()
   {
      preOrderHelper(root);
   }
   private void preOrderHelper(Node r)
   {
      if (r != null)
      {
         System.out.print(r.data + " ");
         preOrderHelper(r.left);
         preOrderHelper(r.right);
      }
   }


   public void inOrderTraversal()
   {
      inOrderHelper(root);
   }
   private void inOrderHelper(Node r)
   {
      if (r != null)
      {
         inOrderHelper(r.left);
         System.out.print(r.data + " ");
         inOrderHelper(r.right);
      }
   }


  public int count(int lo, int hi)
  {
    return inOrderCount(root, lo, hi);
  }
  private int inOrderCount(Node r, int lo, int hi)
  {
    int counter = 0;
    if (r != null)
    {
      counter = counter + inOrderCount(r.left, lo, hi);
      if ((r.data >= lo) && (r.data <= hi))
        counter++;
      counter = counter + inOrderCount(r.right, lo, hi);

    }
    return counter;
  }

}


public int countleaves()
{
  return countleaves(root);
}

private int countleaves(Node p)
{
  if (p == null) return 0;

  else if (p.left == null && p.right == null)
    return 1;

  else
  {
    return countleaves(p.left) + countleaves(p.right);
  }
}

public int height()
{
  return height(root);
}

private int height(Node p)
{
  if (p == null) return -1;

  else
    return 1 + Math.max(height(p.left),height(p.right));
}
