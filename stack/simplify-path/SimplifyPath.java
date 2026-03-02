// https://leetcode.com/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public String simplifyPath(String path) {

        LinkedList<String> outputDeque = new LinkedList<>();
        int index = 0;
        String currString = "";

        while(index < path.length()) {

            char val = path.charAt(index);
            index = index + 1;

            System.out.println("current value is: " + val);
            System.out.println("current index here: " + index);

            // my idea is to only insert things to the queue when I see a forward slash
            if(val == '/') {

                if (index!=1 && currString.length()!=0) {

                    if(currString.equals(".")) {
                        currString = "";
                    } else if(currString.equals("..")) {
                        currString = "";
                        System.out.println("removing last two insertions");
                        outputDeque.pollLast();
                        outputDeque.pollLast();
                    } else {
                        System.out.println("inserting currString: " + currString);
                        outputDeque.add(currString);
                    }
                }

                if(outputDeque.peekLast()!= null && outputDeque.peekLast().equals("/")) {
                    continue;
                }

                // System.out.println("I'm adding a forward slash here");
                outputDeque.add("/");
                currString = "";
                continue;
            }

            currString = currString + val;
        }

        if(currString!="") {
            outputDeque.add(currString);
        }

        if(outputDeque.peekLast()!=null && outputDeque.peekLast().equals("/") && outputDeque.size()!=1) {
            outputDeque.pollLast();
        }

        return convertDequeToString(outputDeque);
    }

    private String convertDequeToString(LinkedList<String> deque) {
        String output = "";

        for(String element: deque) {
            System.out.println("current element is: " + element);
            output = output + element;
        }

        return output;
    }
}