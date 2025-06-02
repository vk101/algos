from TreeNode import TreeNode
from typing import Optional
from lowest_common_ancestor import LCA
from TreeBuilder import TreeBuilder

class Solution:

    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:

        def findPath(root: TreeNode, nodeVal: int, path):

            if root.val == nodeVal:
                return True

            if root.left:
                path.append('L')
                if(findPath(root.left, nodeVal, path)): return True
                path.pop()

            if root.right:
                path.append('R')
                if(findPath(root.right, nodeVal, path)): return True 
                path.pop()
            
            return False
        
        lca = LCA()
        common = lca.lowestCommonAncestor(root, TreeNode(startValue), TreeNode(destValue))
        spath = []
        findPath(common, startValue, spath)    
        # print(f'Path for {startValue}: {spath}')

        dpath = []
        findPath(common, destValue, dpath)
        # print(f'Path for {destValue}: {dpath}')

        result = ''.join(['U'*len(spath)]) + ''.join(dpath)

        return result

s = Solution()
arr = [5,1,2,3,None,6,4]
builder = TreeBuilder()
root = builder.build(arr) 
startValue = 3
destValue = 6
path = s.getDirections(root, startValue, destValue)
print(f"Shortest path: {path}")

