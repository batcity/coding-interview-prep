public class TreeNode<E>{


private E value;
private TreeNode<E> left;
private TreeNode<E> right;
private TreeNode<E> parent;

public TreeNode(E value,TreeNode<E> parent){
  this.value = value;
  this.parent = parent;
}

public void addLeft(E value){
  this.left = new TreeNode<E>(value,this);
}

public void addRight(E value){
  this.right = new TreeNode<E>(value,this);
}

public E getLeft(){
  return this.left.value;
}

}
