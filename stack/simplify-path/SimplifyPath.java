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

            if(val == '.') {

                if(outputDeque.peekLast()!= null && outputDeque.peekLast().equals("/")) {
                    continue;
                }

                if (index!=1) {
                    System.out.println("inserting currString: " + currString);
                    outputDeque.add(currString);
                }
            }

            if(val == '/') {

                System.out.println("current value is a forward slash");

                if (index!=1 && currString.length()!=0) {
                    System.out.println("inserting currString: " + currString);
                    outputDeque.add(currString);
                }

                if(outputDeque.peekLast()!= null && outputDeque.peekLast().equals("/")) {
                    continue;
                }

                System.out.println("I'm adding a forward slash here");
                outputDeque.add("/");
                currString = "";
                continue;
            }

            currString = currString + val;
        }

        if(outputDeque.peekLast().equals("/")) {
            outputDeque.removeLast();
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