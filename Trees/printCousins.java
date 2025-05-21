/* Question: Given a binary tree and a key value from this tree, print all the cousins of this node separated by space. If no cousin exists print -1.
 Cousins of a node: Are at the same level as the target node k. 
                    Do not share the same parent.
 Approach: We’ll use Level Order Traversal (BFS) because it processes nodes level by level, which is perfect for finding cousins.
 Edge Case: If the tree is empty (root == null), or the root itself is k, print -1 and return because the root has no cousins.
 Step1: Initialize a Queue and add root node to it.
 Step2: While the queue is not empty:
        Get the number of nodes at the current level (size = queue.size()).
 Step3: Create an empty list cousins to store possible cousins.
        For each node at this level: Check if this node is the parent of node k. 
                                     If yes, set a flag found = true and do not enqueue its children (they are siblings).
        Otherwise: Add its children (if any) to the queue and to the cousins list.
 Step4: If found is true, this means the next level would contain the siblings of k.so, we don’t enqueue them, but we print the rest of the nodes
        at this level (which are cousins).
  */
import java.util.*;
class Result {
    static void printCousins(Node root, int k) {
        if (root == null || root.data == k) {
            System.out.println(-1);
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            List<Integer> cousins = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                // Check if this node's child is the target node
                if ((node.leftChild != null && node.leftChild.data == k) ||
                    (node.rightChild != null && node.rightChild.data == k)) {
                    found = true;
                } else {
                    // Add children to the cousins list
                    if (node.leftChild != null) cousins.add(node.leftChild.data);
                    if (node.rightChild != null) cousins.add(node.rightChild.data);
                    if (node.leftChild != null) queue.add(node.leftChild);
                    if (node.rightChild != null) queue.add(node.rightChild);
                }
            }
            // If we found the target's parent in this level, print the collected cousins
            if (found) {
                if (cousins.isEmpty()) System.out.println(-1);
                else {
                    for (int cousin : cousins) {
                        System.out.print(cousin + " ");
                    }
                    System.out.println();
                }
                return;
            }
        }
        System.out.println(-1);
    }
}
/*class Node
{
  int data; // data used as key value
  Node leftChild;
  Node rightChild;
  public Node()
  {
    data=0;
  }
  public Node(int d)
  {
    data=d;
  }
}

class Main
{
  static void inOrder(Node root)
  {
    if (root != null)
    {
      inOrder(root.leftChild);
      System.out.print(root.data + " ");
      inOrder(root.rightChild);
    }
  }
  static Node insertLevelOrder(int arr[], Node root, int i, int n)
  {
    if (i < n)
    {
      Node temp = new Node(arr[i]);
      root = temp;
      root.leftChild = insertLevelOrder(arr, root.leftChild, 2 * i + 1, n);
      root.rightChild = insertLevelOrder(arr, root.rightChild, 2 * i + 2, n);
    }
    return root;
  }

  static Node buildTree(int t[], int n)
  {
    Node node = null;
    node = insertLevelOrder(t, node, 0, n);
    return node;
  }
  public static void main(String[] args)
  {
    int a[]=new int[50];
    int n, i;
    Scanner s=new Scanner(System.in);
    n = Integer.parseInt(s.nextLine());
    for(i=0;i<n;i++)
      a[i] = s.nextInt();
    i = s.nextInt();
    Node root = null;
    if(n!=0)
      root = buildTree(a, n);
    Result.printCousins(root, i);
  }
}
*/
