from TreeNode import TreeNode
from TreeBuilder import TreeBuilder

class LCA:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        
        if not root:
            return None
        if root.val == p.val or root.val == q.val:
            return root
        
        left = right = None
        if root.left:
            left = self.lowestCommonAncestor(root.left, p, q)
        if root.right:
            right = self.lowestCommonAncestor(root.right, p, q)

        if left and right:
            return root
        # why this - if one out of left and right has been found, then the other should be the child
        if left and not right:
            return left
        if right and not left:
            return right
        
s = LCA()
arr = [3,5,1,6,2,0,8,None,None,7,4]
p=TreeNode(5)
q=TreeNode(7)

builder = TreeBuilder()
root = builder.build(arr)
node = s.lowestCommonAncestor(root, p, q)
print(node.val)