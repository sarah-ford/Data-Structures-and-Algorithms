public class LinkedListdemo
{
  private static class Node{
    private String info;
    private Node next;

    private Node(String s) {
      this.info = s;
      this.next = null;
    }
  }

  public static void main(String[] args)
  {
    Node node1 = new Node("I");
    Node node2 = new Node("admire");
    Node node3 = new Node("Kant");

    node1.next = node2;
    node2.next = node3;

    Node new_node = new Node("strongly");

    node1.next = new_node;
    new_node.next = node2;

    node1.next = node2;
    // can recycle new_node by setting it equal to null //

    for(Node i = node1; i!= null; i = i.next){
      System.out.println(i.info);

    }
  }
}
