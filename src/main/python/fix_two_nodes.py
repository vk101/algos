# https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1

'''

 - keep pointer to the predecessor and check with successor value, based on inorder traversal
 - if predecessor is smaller than successor, store parent of predecessor for swapping
 - if successor is smaller than predecessor, store parent of successor for swapping

'''

class Node:
    def __init__(self, data, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right

def swap(first, second):
    fParent = first[0]
    fChild = first[1]

    sParent = second[0]
    sChild = second[1]

    if fParent.right == fChild:
        fParent.right = sChild
        if sParent.right == sChild:
            sParent.right = fChild
        elif sParent.left == sChild:
            sParent.left = fChild
    elif fParent.left == fChild:
        fParent.left = sChild
        if sParent.right == sChild:
            sParent.right = fChild
        elif sParent.left == sChild:
            sParent.left = fChild


def correctBst(node, first=None, second=None):
    
    if node.left is None and node.right is None:
        #print(node.data)
        return [None, node]

    if node.left is not None:
        p = correctBst(node.left)
        if p[0] is None:
            p[0] = node

        pre = p[1]

        if pre.data > node.data:
            if first is None:
                first = p
            else:
                second = p
        
        s = correctBst(node.right, first, second)
        if s[0] is None:
            s[0] = node
        suc = s[1]

        if suc.data < node.data:
            if first is None:
                first = s
            else:
                second = s

        if first is not None and second is not None:
            print('Parent nodes found: %s, %s' % (first[0].data, second[0].data))
            print('Nodes found: %s, %s' % (first[1].data, second[1].data))
            swap(first, second)
        
        return [node, suc]


def dfs(node):
    if node.left is None and node.right is None:
        print(node.data)

    if node.left is not None:
        dfs(node.left)
        print(node.data)
        dfs(node.right)

if __name__ == '__main__':

    n2 = Node(2)
    n20 = Node(20)
    n5 = Node(5, n2, n20)
    n8 = Node(8)
    root = Node(10, n5, n8)

    correctBst(root)
    print('Printing corrected tree::')
    dfs(root)

