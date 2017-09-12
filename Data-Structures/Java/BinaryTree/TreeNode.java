public class TreeNode<E  extends Comparable<E>>{


private E value;
private TreeNode<E> left;
private TreeNode<E> right;
private TreeNode<E> parent;

public TreeNode(E value,TreeNode<E> parent){
  this.value = value;
  this.parent = parent;
}

public void addLeft(E value){

  if(value==null){
    this.left = null;
    return;
  }
  this.left = new TreeNode<E>(value,this);
}

public void addRight(E value){

  if(value==null){
    this.right = null;
    return;
  }
  this.right = new TreeNode<E>(value,this);
}

public E getValue(){
  return this.value;
}

public TreeNode<E> getLeft(){
  return this.left;
}

public TreeNode<E> getRight(){
  return this.right;
}

public void visit(){
  System.out.println(this.value);
}

public boolean isLeaf(){
  if((this.left==null) && (this.right==null)){
    return true;
  }

  return false;
}

}
