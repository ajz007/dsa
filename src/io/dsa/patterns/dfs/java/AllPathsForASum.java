package io.dsa.patterns.dfs.java;

import java.util.*;

/**
 * https://leetcode.com/problems/path-sum-ii/
 *
 * Given a binary tree and a number S, find all paths from root-to-leaf such that the sum of all the node values of each path equals S.
 *
 * This problem follows the Binary Tree Path Sum pattern. We can follow the same DFS approach. There will be two differences:
 *
 * Every time we find a root-to-leaf path , we will store it in a list.
 * We will traverse all paths and will not stop processing after finding the first path.
 *
 */
public class AllPathsForASum {

    public static List list = new ArrayList<List<Integer>>();
    public static void main(String args[]) {
            findAllPaths(createTree(), 10, new ArrayDeque<>());
            System.out.println("Total paths: "+list.size());
    }

    private static void findAllPaths(Node root, int remainingSum, ArrayDeque<Integer> stack){
        if(root == null) {
            return;
        }
        stack.push(root.data);

        if (remainingSum == root.data) {
            addToList(stack);
            stack.pop();
            return;
        }
        findAllPaths(root.left, remainingSum - root.data, stack);
        findAllPaths(root.right, remainingSum - root.data, stack);
        stack.pop();
    }

    private static void addToList(ArrayDeque<Integer> stack) {
        var iterator = stack.iterator();
        var locallist = new ArrayList<Integer>();
        while(iterator.hasNext()){
            locallist.add(iterator.next());
        }
        list.add(locallist);
    }

    private static Node createTree() {

        var root = new Node(1);
        root.left = new Node(7);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.right.left = new Node(1);
        root.right.right = new Node(5);
        return root;
    }

}



