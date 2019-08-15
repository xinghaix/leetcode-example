package leetcode.example;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree
 *
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 * 1. 节点的左子树只包含小于当前节点的数。
 * 2. 节点的右子树只包含大于当前节点的数。
 * 3. 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * @author luxin
 */
@SuppressWarnings("WeakerAccess")
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        boolean isBST = false;
        if (root != null && root.right != null) {
            isBST = root.right.val > root.val;
            if (root.left != null) {
                isBST = isBST && root.left.val > root.val;
            }
        }
        return isBST;
    }

    /**
     * 二叉树
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            List<String> result = new ArrayList<>();
            TreeNode tmpNode = this;
            result.add(String.valueOf(tmpNode.val));
            while (tmpNode.left != null || tmpNode.right != null) {
                List<List<String>> twoList1 = toList(tmpNode.left);
                List<List<String>> twoList2 = toList(tmpNode.right);
                result.addAll(twoList1.get(0));
                result.addAll(twoList2.get(0));
                result.addAll(twoList1.get(1));
                result.addAll(twoList2.get(1));
                tmpNode = tmpNode.left;
            }
            return result.toString();
        }

        public static List<List<String>> toList(TreeNode treeNode) {
            List<List<String>> twoList = new ArrayList<>();
            List<String> list1 = new ArrayList<>();
            List<String> list2 = new ArrayList<>();
            twoList.add(list1);
            twoList.add(list2);
            if (treeNode != null) {
                list1.add(String.valueOf(treeNode.val));
                String leftVal = treeNode.left != null ? String.valueOf(treeNode.left.val) : null;
                list2.add(leftVal);
                String rightVal = treeNode.right != null ? String.valueOf(treeNode.right.val) : null;
                list2.add(rightVal);
            }
            return twoList;
        }

        public static TreeNode create(String[] values) {
            TreeNode treeNode = null;
            int total = 1, current = 1;
            if (values != null && values.length > 0) {
                List<TreeNode> subNodes = new ArrayList<>();
                while (values.length >= total*2 - 1) {
                    for (int i = total-1; i < total*2 -1; i++) {
                        String value = values[i];
                        subNodes.add(new TreeNode(Integer.parseInt(value)));
                        System.out.println(value);
                        total *= 2;
                        current++;
                    }
                }
                treeNode = subNodes.get(0);
            }
            return treeNode;
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeNode.create(new String[]{"1", "2", "3"});
        TreeNode treeNode2 = TreeNode.create(new String[]{"5", "1", "4", null, null, "3", "6"});
        System.out.println(treeNode1);
        System.out.println(treeNode2);
//        System.out.println(treeNode1 + ": " + new IsValidBST().isValidBST(treeNode1));
//        System.out.println(treeNode2 + ": " + new IsValidBST().isValidBST(treeNode2));
    }

}
