package com.company;

public class ExpressionTree {

    boolean isOperator(char c) {
        if (c == '+' || c == '-'
                || c == '*' || c == '/'
                || c == '^') {
            return true;
        }
        return false;
    }

    boolean isNumber(char c){
        return (Character.isDigit(c));
    }

    boolean isVariable(char c){
        return (Character.isLetter(c));
    }


    void inorder(Node t) {
        if (t != null) {
            inorder(t.left);
            System.out.print(t.value + " ");
            inorder(t.right);
        }
    }

    Node constructTree(char Expression[]) {
        Stack nodeStack = new Stack();
        Node t, t1, t2;

        for (int i = 0; i < Expression.length; i++) {

             if (isNumber(Expression[i]) || isVariable(Expression[i])) {
                    t = new Node(Expression[i]);
                    nodeStack.push(t);
                }
            else if (isOperator(Expression[i])){
                t = new Node(Expression[i]);
                t1 = nodeStack.pop();
                t2 = nodeStack.pop();
                t.right = t1;
                 t.left = t2;
                nodeStack.push(t);
            }
        }

        t = nodeStack.peek();
        nodeStack.pop();

        return t;
    }
}
