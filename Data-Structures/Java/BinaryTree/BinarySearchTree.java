public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E>{

  public void search(E value){
    search(value,root);
  }

  private void search(E value,TreeNode<E> node){

    if(node==null){
      System.out.println("Element " + value + " does not exist");
      return;
    }

    if(node.getValue()==value){
      System.out.println("Element " + value + " found");
      return;
    }
    else if(value.compareTo(node.getValue())<0){
      search(value,node.getLeft());
    }else{
      search(value,node.getRight());
    }
  }

}
