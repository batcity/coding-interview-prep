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

      if(root==null){
          TreeNode<E> newNode = new TreeNode<E>(value,null);
          root = newNode;
          inserted=true;
      }else if(value.compareTo(curr.getValue())<0){
        if(curr.getLeft()==null){
          TreeNode<E> newNode = new TreeNode<E>(value,curr);
          curr.addLeft(newNode);
          inserted=true;
        }else{
          curr = curr.getLeft();
        }
      }else if(value.compareTo(curr.getValue())>0){
        if(curr.getRight()==null){
          TreeNode<E> newNode = new TreeNode<E>(value,curr);
          curr.addRight(newNode);
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
        node = node.getLeft();
      }
      else{
        node = node.getRight();
      }
    }

    // case where node to be deleted is a leaf node

    if(node.getValue()==value && node.isLeaf()){

        if(node==root){
          root = null;
        }

        if(value.compareTo(parent.getValue())>0) {
          parent.addRight(null);}
        else parent.addLeft(null);
        System.out.println("Element " + value + " deleted");
        return;
      }

    // case where node to be deleted has only one child

    if(node.getLeft()==null){

      if(node==root){
        root = root.getRight();
      }

      if(value.compareTo(parent.getValue())>0) parent.addRight(node.getRight());
      else parent.addLeft(node.getRight());
      System.out.println("Element " + value + " deleted");
      return;
    }else if(node.getRight()==null){

      if(node==root){
        root = root.getLeft();
      }

      if(value.compareTo(parent.getValue())>0) parent.addRight(node.getLeft());
      else parent.addLeft(node.getLeft());
      System.out.println("Element " + value + " deleted");
      return;
    }else {
    // case where node to be deleted has two children

    E minChild = findMinChild(node.getRight());

    if(node==root){
      TreeNode<E> replacement = new TreeNode<E>(minChild,null);
      root = replacement;
      delete(minChild,node);
      replacement.addRight(node.getRight());
      replacement.addLeft(node.getLeft());
    }
    else if(value.compareTo(parent.getValue())>0) {
      TreeNode<E> replacement = new TreeNode<E>(minChild,parent);
      parent.addRight(replacement);
      delete(minChild,node);
      replacement.addRight(node.getRight());
      replacement.addLeft(node.getLeft());
    }else{
      TreeNode<E> replacement = new TreeNode<E>(minChild,parent);
      parent.addLeft(replacement);
      delete(minChild,node);
      replacement.addRight(node.getRight());
      replacement.addLeft(node.getLeft());
    }

    System.out.println("Element " + value + " deleted");
    return;
  }

  }

  private E findMinChild(TreeNode<E> node){
    while(node.getLeft()!=null){
      node = node.getLeft();
    }

    return node.getValue();
  }

}
