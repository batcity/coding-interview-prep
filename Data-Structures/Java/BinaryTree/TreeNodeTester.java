
public class TreeNodeTester{

  public static void main(String args[]){

    TreeNode<Integer> myTreeNode = new TreeNode<Integer>(2,null);

    myTreeNode.addLeft(1);

    System.out.println("The left node of my tree node is: " + myTreeNode.getLeft());
  }
}
