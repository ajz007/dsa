package io.dsa.patterns.dfs.java;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/path-sum/
 * <p>
 * Given a binary tree and a number S, find if the tree has a path from root-to-leaf such that the sum of all the node values of that path equals S.
 * S = 8, Answer path : [1,2,5]
 * Ex: -
 * 1
 * 2       3
 * 4     5  6    7
 * 8   9
 */
public class BinaryTreePathSum {

    public static void main(String args[]) {
        var list = new ArrayList<Node>();
        if (findPathWithSum(createTree(), 28, list)) {
            System.out.println("Sum found!! and list size = " + list.size());
        } else {
            System.out.println("Sum Not found!!");
        }
        list.stream().forEach(n -> System.out.println("items = " + n.data));
    }

    private static boolean findPathWithSum(Node root, int sum, List<Node> list) {
        System.out.println("Sum = " + sum);

        if (root == null) return false;
        System.out.println("Node data  = " + root.data);
        if (root.left == null && root.right == null && root.data == sum) {
            list.add(root);
            return true;
        }

        if (findPathWithSum(root.left, sum - root.data, list)
                || findPathWithSum(root.right, sum - root.data, list)) {
            list.add(root);
            return true;
        }
        return false;
    }

    private static Node createTree() {

        var root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        return root;
    }
}


class Node {
    Node left;
    Node right;
    int data;

    public Node() {
    }

    ;

    public Node(int data) {
        this.data = data;
    }
}



