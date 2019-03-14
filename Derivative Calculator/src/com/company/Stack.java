package com.company;

public class Stack {
        static final int size = 100;
        int top;
        Node[] a = new Node[size];

        Stack()
        {
            top = -1;
        }

        boolean push(Node x)
        {
            if (top >= (size -1))
            {
                System.out.println("Stack Overflow");
                return false;
            }
            else
            {
                a[++top] = x;
                System.out.println(x + " pushed into stack");
                return true;
            }
        }

        Node pop() {
            if (top < 0) {
                System.out.println("Stack Underflow");
                return null;
            } else {
                 Node x = a[top--];
                return x;
            }
        }

        Node peek(){
            return a[top];
        }

}