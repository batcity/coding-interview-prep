import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<E>{

    public TreeNode<E> root;

    private void preOrder(TreeNode<E> node){
        if(node!=null){
          node.visit();
          preOrder(node.getLeft());
          preOrder(node.getRight());
        }
    }

    private void inOrder(TreeNode<E> node){
        if(node!=null){
          inOrder(node.getLeft());
          node.visit();
          inOrder(node.getRight());
        }
    }

    private void postOrder(TreeNode<E> node){
        if(node!=null){
          postOrder(node.getLeft());
          postOrder(node.getRight());
          node.visit();
        }
    }

    public void preOrder(){
      preOrder(root);
    }

    public void inOrder(){
      inOrder(root);
    }

    public void postOrder(){
      postOrder(root);
    }

    public void levelOrder(){

      Queue<TreeNode<E>> levelQueue = new LinkedList<TreeNode<E>>();
      levelQueue.add(root);

      while(!levelQueue.isEmpty()){
        TreeNode<E> curr = levelQueue.remove();

        if(curr!=null){
          curr.visit();
          levelQueue.add(curr.getLeft());
          levelQueue.add(curr.getRight());
        }
      }
    }



}
