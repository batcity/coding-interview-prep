
public class TreeNodeTester{

  public static void main(String args[]){

    TreeNode<Integer> myTreeNode = new TreeNode<Integer>(2,null);

    myTreeNode.addLeft(1);
    myTreeNode.addRight(3);
    System.out.println("my treenode's value is: " + myTreeNode.getValue());
    System.out.println("The left node of my tree node is: " + myTreeNode.getLeft().getValue());
    System.out.println("The right node of my tree node is: " + myTreeNode.getRight().getValue());
    myTreeNode.getLeft().addLeft(0);

    System.out.println("-----------------------------------");
    System.out.println("My binary tree's pre order traversal");

    BinarySearchTree<Integer> myBTree = new BinarySearchTree<Integer>();

    myBTree.root = myTreeNode;
    myBTree.preOrder();

    System.out.println("-----------------------------------");
    System.out.println("My binary tree's in order traversal");

    myBTree.inOrder();

    System.out.println("-----------------------------------");
    System.out.println("My binary tree's post order traversal");

    myBTree.postOrder();

    System.out.println("-----------------------------------");
    System.out.println("My binary tree's level order traversal");

    myBTree.levelOrder();

   System.out.println("-----------------------------------");
   System.out.println("stuff that exists");
   System.out.println();
   System.out.println("searching for element " + "0");
   myBTree.search(0);
   System.out.println("searching for element " + "1");
   myBTree.search(1);
   System.out.println("searching for element " + "2");
   myBTree.search(2);
   System.out.println("searching for element " + "3");
   myBTree.search(3);
   System.out.println("-----------------------------------");
   System.out.println("stuff that doesn't exist");
   System.out.println();
   System.out.println("searching for element " + "4");
   myBTree.search(4);
   System.out.println("searching for element " + "5");
   myBTree.search(5);
   System.out.println("searching for element " + "-1");
   myBTree.search(-1);

   System.out.println("-----------------------------------");
   System.out.println("Inserting element 5");
   myBTree.insert(5);
   System.out.println("searching for element " + "5");
   myBTree.search(5);

   System.out.println("-----------------------------------");
   System.out.println("My binary tree's in order traversal after inserting 5");

   myBTree.inOrder();


   System.out.println("-----------------------------------");
   System.out.println("Inserting element 4");
   myBTree.insert(4);

   System.out.println("-----------------------------------");
   System.out.println("Inserting element 6");
   myBTree.insert(6);

   System.out.println("-----------------------------------");
   System.out.println("deleting element 5");
   myBTree.delete(5);
   System.out.println("searching for element " + "5");
   myBTree.search(5);

   System.out.println("-----------------------------------");
   System.out.println("My binary tree's in order traversal after deleting 5");

   myBTree.inOrder();

   System.out.println("-----------------------------------");
   System.out.println("deleting element 2");
   myBTree.delete(2);

   System.out.println("-----------------------------------");
   System.out.println("deleting element 1");
   myBTree.delete(1);

   System.out.println("-----------------------------------");
   System.out.println("My binary tree's in order traversal after deleting 1");

   myBTree.inOrder();



  }
}
