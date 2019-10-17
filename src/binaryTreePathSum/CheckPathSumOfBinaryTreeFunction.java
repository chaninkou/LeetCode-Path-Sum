package binaryTreePathSum;

import java.util.Stack;

public class CheckPathSumOfBinaryTreeFunction {
	public boolean hasPathSum(TreeNode root, int sum){
		if(root == null){
			return false;
		}
		
		Stack<TreeNode> nodeStack = new Stack<>();
		
		Stack<Integer> sumStack = new Stack<>();
		
		nodeStack.add(root);
		sumStack.add(sum - root.val);
		
		while(!nodeStack.isEmpty()){
			TreeNode currentNode = nodeStack.pop();
			
			int currentSum = sumStack.pop();
			
			// If it is the leaf and the sum is 0, that means we got the target sum
			if(currentNode.left == null && currentNode.right == null && currentSum == 0){
				return true;
			}
			
			if(currentNode.left != null){
				nodeStack.add(currentNode.left);
				
				sumStack.add(currentSum - currentNode.left.val);
			}
			
			if(currentNode.right != null){
				nodeStack.add(currentNode.right);
				
				sumStack.add(currentSum - currentNode.right.val);
			}
			
		}
		
		
		return false;
	}
}
