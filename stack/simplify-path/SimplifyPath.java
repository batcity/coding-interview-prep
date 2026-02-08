// https://leetcode.com/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public String simplifyPath(String path) {

        LinkedList<String> outputDeque = new LinkedList<>();
        int index = 0;
        String currString = "";

        while(index < path.length()) {

            char val = path.charAt(index);
            index++;

            if(val == '.') {

                if(outputDeque.peek()!= null && outputDeque.peek().equals("/")) {
                    continue;
                }
            }

            if(val == '/') {

                if(outputDeque.peek()!= null && outputDeque.peek().equals("/")) {
                    continue;
                }

                if (index!=1) {
                    outputDeque.add(currString);
                }

                outputDeque.add("/");
                currString = "";
                continue;
            }

            currString = currString + val;
        }

        if(outputDeque.peek().equals("/")) {
            System.out.println("am i hitting this");
            outputDeque.pop();
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