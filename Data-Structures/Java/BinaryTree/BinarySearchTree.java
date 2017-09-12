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

  public void insert(E value){

    TreeNode<E> curr = root;
    boolean inserted = false;

    while(!inserted){
      if(value.compareTo(curr.getValue())<0){
        if(curr.getLeft()==null){
          curr.addLeft(value);
          inserted=true;
        }else{
          curr = curr.getLeft();
        }
      }else if(value.compareTo(curr.getValue())>0){
        if(curr.getRight()==null){
          curr.addRight(value);
          inserted=true;
        }else{
          curr = curr.getRight();
        }
      }else{
        //do nothing
        System.out.println("Element already exists");
        return;
      }
    }

    return;
  }

  public void delete(E value){
    delete(value,root);
  }


  // only deletes leaf nodes for now
  private void delete(E value,TreeNode<E> node){

    if(node==null){
      System.out.println("Element " + value + " does not exist");
      return;
    }

    TreeNode<E> parent = null;

    while(node.getValue()!=value){
      if(node == null) {
        System.out.println("The element " + value + " does not exist");
        return;
      }
      parent = node;
      if(value.compareTo(node.getValue())<0){
        System.out.println("going left");
        node = node.getLeft();
      }
      else{
        node = node.getRight();
        System.out.println("going right");
      }
    }

    // case where node to be deleted is a leaf node

    if(node.getValue()==value && node.isLeaf()){
        if(value.compareTo(parent.getValue())>0) parent.addRight(null);
        else parent.addLeft(null);
        System.out.println("Element " + value + " deleted");
        return;
      }

    // case where node to be deleted has only one child

    if(node.getLeft()==null){
      if(value.compareTo(parent.getValue())>0) parent.addRight(node.getRight().getValue());
      else parent.addLeft(node.getRight().getValue());
      System.out.println("Element " + value + " deleted");
      return;
    }else if(node.getRight()==null){
      if(value.compareTo(parent.getValue())>0) parent.addRight(node.getLeft().getValue());
      else parent.addLeft(node.getLeft().getValue());
      System.out.println("Element " + value + " deleted");
      return;
    }else {
    System.out.println("Element " + value + " is the exceptional case with two child nodes");
    return;
  }

  }

}
