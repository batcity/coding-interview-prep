
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

    BinaryTree<Integer> myBTree = new BinaryTree<Integer>();

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

  }
}
