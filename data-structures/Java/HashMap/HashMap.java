
import java.util.LinkedList;
import java.util.Vector;

class HashMap<k,v>{

// static Node[] nodeArray = new Node[20];
// int load_factor = nodeArray.size();
Vector<LinkedList<Node>> nodeArray = new Vector<LinkedList<Node>>();
int actSize;

/* The constructor sets the intitial size of the nodeArray
*/
public HashMap(){
  nodeArray.setSize(5);
  actSize = 0;
}

private static class Node<k,v>{
    k key;
    v value;
}

public void set(k key, v value){


  if(actSize>=nodeArray.size()*.75){
    //System.out.println(actSize+" greater than or equal to " + nodeArray.size()/2);
    //System.out.println("At this point before rehash act size of hashtable is" + actSize + "fake size of hashtable is" + nodeArray.size());

    nodeArray.setSize(nodeArray.size()*2);
    rehash();

    //System.out.println("At this point act size of hashtable is" + actSize + "fake size of hashtable is" + nodeArray.size());
  }


  Node node = new Node();
  node.key = key;
  node.value = value;
  // System.out.println("load factor:" + load_factor);
  int simplifiedHash = Math.abs(key.hashCode()) % nodeArray.size();
  if(nodeArray.get(simplifiedHash)==null){
  LinkedList<Node> temp = new LinkedList<Node>();
  temp.add(node);
  nodeArray.set(simplifiedHash,temp);
  System.out.println("setting key:" + node.key + "to index" + simplifiedHash);
actSize++;}else{
    nodeArray.get(simplifiedHash).add(node);
    System.out.println("clash");
    System.out.println(node.key + " is gonna disappear");
    System.out.println("setting key:" + node.key + "to index" + simplifiedHash);
  }


   System.out.println("At this point size of hashtable is" + actSize);

  // System.out.println("The size of the array now is" + nodeArray.size());
}

public Node get(k key){
  int simplifiedHash = Math.abs(key.hashCode()) % nodeArray.size();
  LinkedList<Node> curList = nodeArray.get(simplifiedHash);

  for(Node node: curList){
    if(node!=null & node.key==key){
      return node;
    }
  }
  System.out.println("The simplified hash is: " + simplifiedHash);
  return null;
}

public void rehash(){

  actSize = 0;
  int transferCount = 0;
  System.out.println("Rehash started");
  Vector<LinkedList<Node>> tempArray = new Vector<LinkedList<Node>>();
  tempArray.setSize(nodeArray.size());

  for(int i=0;i<nodeArray.size();i++){
    LinkedList<Node> nodeList = nodeArray.get(i);


    if(nodeList!=null){

      for(Node node:nodeList){
      nodeArray.set(i,null);
      System.out.println("setting index: " + i + "to null");
      k key = (k)node.key;
      v value = (v)node.value;

      int simplifiedHash = Math.abs(key.hashCode()) % nodeArray.size();

      if(tempArray.get(simplifiedHash)==null){
      LinkedList<Node> temp = new LinkedList<Node>();
      temp.add(node);
      tempArray.set(simplifiedHash,temp);
      System.out.println("setting key:" + node.key + "to index" + simplifiedHash);
    actSize++;}else{
        tempArray.get(simplifiedHash).add(node);
        System.out.println("clash");
        System.out.println(node.key + " is gonna disappear");
         }
       }
     }
      transferCount++;
    }


  nodeArray = tempArray;
  System.out.println("Rehash done");

  //System.out.println("Transfer count" + transferCount);
}

public int size(){
  return actSize;
}

public void print(){

  for( int i=0;i<nodeArray.size();i++){

    if(nodeArray.get(i)!=null){
      for(Node node:nodeArray.get(i)){
    System.out.println("index:" + i + " value:" + node.key);
  }
  }else{
    System.out.println("index:" + i + "value is null");
  }
  }

  return;
}



public static void main(String args[]){

       HashMap<String,Integer> myHashMap = new HashMap<String,Integer>();
       myHashMap.set("two", 2);
       myHashMap.set("one", 1);
       myHashMap.set("threero", 3);
       myHashMap.set("fourth", 4);
       myHashMap.set("fiver", 5);
       myHashMap.set("sixobr", 6);
       myHashMap.set("sevenreyr", 7);
       myHashMap.set("eightyseven", 8);
       myHashMap.set("ninetytwo", 9);
       myHashMap.print();

       System.out.println("The value of the node inserted in the hashmap is");

       System.out.println(myHashMap.get("one").key);
       System.out.println(myHashMap.get("one").value);
       System.out.println(myHashMap.get("two").key);
       System.out.println(myHashMap.get("two").value);
       System.out.println(myHashMap.get("threero").key);
       System.out.println(myHashMap.get("threero").value);
       System.out.println(myHashMap.get("fourth").key);
       System.out.println(myHashMap.get("fourth").value);
       System.out.println(myHashMap.get("fiver").key);
       System.out.println(myHashMap.get("fiver").value);
       System.out.println(myHashMap.get("sixobr").key);
       System.out.println(myHashMap.get("sixobr").value);
       System.out.println(myHashMap.get("sevenreyr").key);
       System.out.println(myHashMap.get("sevenreyr").value);
       System.out.println(myHashMap.get("eightyseven").key);
       System.out.println(myHashMap.get("eightyseven").value);
       System.out.println(myHashMap.get("ninetytwo").key);
       System.out.println(myHashMap.get("ninetytwo").value);

       System.out.println("Size of the hashtable" + myHashMap.size());


     }
}
