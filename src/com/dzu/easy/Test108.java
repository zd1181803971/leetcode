package com.dzu.easy;

/**
 * @author ZhaoDong
 * @date 2022/5/24 9:59
 * @description 108. 将有序数组转换为二叉搜索树
 * <p>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Test108 {
    public static void main(String[] args) {
        TreeNode treeNode = sortedArrayToBST(new int[]{1, 2, 3});
        System.out.println(treeNode);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return test1(nums, 0, nums.length - 1);
    }

    public static TreeNode test1(int[] nums, int left, int right) {
        if (right - left < 0) {
            return null;
        }


        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = test1(nums, left, mid - 1);
        root.right = test1(nums, mid + 1, right);
        return root;

    }

}


