package com.bash.weekly.contest209;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EvenOddTree {
    
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNodeQueue> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return false;
        }
        TreeNodeQueue nodeQueue = new TreeNodeQueue(root, false);
        queue.add(nodeQueue);

        while (!queue.isEmpty()) {
            TreeNodeQueue node = queue.poll();
            TreeNode treeNode = node.treeNode;
            if (treeNode == null) {
                list.add(null);
                queue.add(new TreeNodeQueue(null, !node.odd));
                queue.add(new TreeNodeQueue(null, !node.odd));
            }else {
                list.add(node.treeNode.val);
                queue.add(new TreeNodeQueue(treeNode.left, !node.odd));
                queue.add(new TreeNodeQueue(treeNode.right, !node.odd));
            }

        }
        System.out.println("list = " + list);

        if (list.get(0) %2 != 1) {
            return false;
        }
        boolean ans = true;

        int levels = (int) (Math.log(list.size()) / Math.log(2));
        for (int i = 1; i < levels; i++) {

            int start = (int) Math.pow((double) 2, (double) (i)) - 1;
            int end = (int) Math.pow((double) 2, (double) i + 1) - 2;
            boolean odd = i % 2 == 1 ? true : false;
            if (odd) {
                Integer lastVal = null;
                for (int j = start; j < end; j++) {
                    if (null == list.get(j)) {
                        continue;
                    }
                    if (null == lastVal) {
                        lastVal = list.get(j);
                        if (lastVal % 2 != 0) {
                            //System.out.println("odd & even");
                            return false;
                        }

                    continue;
                 }
                int currVal = list.get(j);
                if (currVal % 2 != 0) {
                    //System.out.println("odd & even");
                    return false;
                }

                if (lastVal <= currVal) {
                    //System.out.println("odd & even & greater");
                    return false;
                }
            }
        }

        if (!odd) {
            Integer lastVal = null;
            for (int j = start; j < end; j++) {
                if (null == list.get(j)) {
                    continue;
                }
                if (null == lastVal) {
                    lastVal = list.get(j);
                    if (lastVal % 2 == 0) {
                        //System.out.println("odd & even");
                        return false;
                    }
                    continue;
                }
                int currVal = list.get(j);
                if (currVal % 2 == 0) {
                    System.out.println("even & odd ");
                    return false;
                }

                if (lastVal >= currVal) {
                    System.out.println("even & odd & lesser");
                    return false;
                }
            }
        }
    }
        return ans;

    }

    public static void main(String[] ar){
        //[1,14,null,9,null,20,16,null,null,7,11]
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(14);
        root.left= left;
        root.right=null;

        TreeNode rootT = root;
        TreeNode node9 = new TreeNode(9);
        left.left = node9;
        left.right=null;
        TreeNode node20 = new TreeNode(20);
        TreeNode node16 = new TreeNode(16);
        node9.left=node20;
        node9.right=node16;

        TreeNode node7 = new TreeNode(7);
        TreeNode node11 = new TreeNode(11);

        node20.left=null;
        node20.right=null;

        node16.left=node7;
        node16.right=node11;
        
        EvenOddTree tree = new EvenOddTree();

        System.out.println("tree.isEvenOddTree(rootT) = " + tree.isEvenOddTree(rootT));


    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class TreeNodeQueue {
    TreeNode treeNode;
    boolean odd;
    TreeNodeQueue() {}
    TreeNodeQueue(TreeNode node, boolean odd){
        this.treeNode = node;
        this.odd=odd;
    }
}
