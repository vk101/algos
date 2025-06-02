from TreeNode import TreeNode

class TreeBuilder:

    def build(self, array) -> TreeNode:

        nodes = []
        for node in array:
            nodes.append(TreeNode(node))
        
        for i in range(len(nodes)):
            if nodes[i] is not None:
                left = i*2+1
                right = i*2+2

                if left < len(nodes) and nodes[left]:
                    nodes[i].left = nodes[left]
                if right < len(nodes) and nodes[right]:
                    nodes[i].right = nodes[right]
        
        return nodes[0]