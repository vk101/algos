from collections import defaultdict

# Design a data structure that supports adding new words and finding if a string matches any previously added string.

# Implement the WordDictionary class:

# WordDictionary() Initializes the object.
# void addWord(word) Adds word to the data structure, it can be matched later.
# bool search(word) Returns true if there is any string in the data structure that 
# matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.

class Trie:
    def __init__(self):
        self.children = defaultdict(Trie)
        self.is_terminal = False
class WordDictionary:

    def __init__(self):
        self.root = Trie()

    def addWord(self, word: str):
        node = self.root
        for i,w in enumerate(word): 
            node = node.children[w]
            if i==len(word)-1:
                node.is_terminal = True
    
    def search(self, word: str) -> bool:

        def dfs(node: Trie, start:int) -> bool:
            for i in range(start, len(word)):
                w = word[i]
                if w == '.':
                    for n in node.children.values():
                        if dfs(n, i+1):
                            return True
                    return False
                else:
                    if w not in node.children:
                        return False
                    node = node.children[w]
            return node.is_terminal
        return dfs(self.root, 0)

wdict = WordDictionary()
wdict.addWord('a')
wdict.addWord('a')
wdict.addWord('bad')
wdict.addWord('dad')
wdict.addWord('pad')

res = wdict.search('.')
print(res)
res = wdict.search('aa')
print(res)
res = wdict.search('da.')
print(res)