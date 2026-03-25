// https://leetcode.com/problems/simplify-path/?envType=study-plan-v2&envId=top-interview-150

// Time complexity = O(n) + O(k) where n is the number of characters in the path and k is the number of directories
// Space complexity = O(n) where n is the number of characters in the string

// Note: It might be cleaner to use path.split on "/" and then join directories with "/" appended -> so try that next time

class Solution {
    public String simplifyPath(String path) {

        LinkedList<String> outputDeque = new LinkedList<>();
        int index = 0;
        StringBuilder sb = new StringBuilder();
        String currString = "";

        while(index < path.length()) {

            char val = path.charAt(index);
            index = index + 1;

            if(val == '/') {

                if (index!=1 && sb.length()!=0) {

                    currString = sb.toString();

                    if(currString.equals("..")) {
                        sb = new StringBuilder();
                        outputDeque.pollLast();
                        outputDeque.pollLast();
                    } else if(!currString.equals(".")){
                        outputDeque.add(currString);
                    }
                }

                sb = new StringBuilder();

                if(outputDeque.peekLast()!= null && outputDeque.peekLast().equals("/")) {
                    continue;
                }

                outputDeque.add("/");
                continue;
            }

            sb.append(val);
        }

        currString = sb.toString();
        if(!currString.isEmpty() && !currString.equals(".")) {

            if(currString.equals("..")) {
                outputDeque.pollLast();
                outputDeque.pollLast();
            } else {
                outputDeque.add(currString);
            }
        }

        if(outputDeque.peekLast()!=null && outputDeque.peekLast().equals("/") && outputDeque.size()!=1) {
            outputDeque.pollLast();
        }

        String output = convertDequeToString(outputDeque);

        if(output.length()!=0) {
            return output;
        }

        return "/";
    }

    private String convertDequeToString(LinkedList<String> deque) {
        StringBuilder sb = new StringBuilder();

        for(String element: deque) {
            sb.append(element);
        }

        return sb.toString();
    }
}