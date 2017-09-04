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
    //super hacky right here,gotta fix this and add a proper comparator or something
    else if((Integer)value<(Integer)node.getValue()){
      search(value,node.getLeft());
    }else{
      search(value,node.getRight());
    }
  }

}
