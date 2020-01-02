# 第10章 Trie字典树
> 也称前缀树prefix tree
## 10.1 什么是Trie字典树
+ 也称字典树Digital Tree；前缀树Prefix Tree
+ Trie是一个多叉树，通常只用来处理字符串
+ 前面几章我们一直在用的都是二叉树

### Trie与字典在字符串查找中的性能比较
> trie添加和查询字符串只与字符串的长度有关，与有多少个字符串无关
![Trie与字典在字符串查找中的性能比较](images/第10章_Trie字典树/Trie与字典在字符串查找中的性能比较.png)

### Trie的结构
> 注意根节点不存储任何字符
![Trie的表示](images/第10章_Trie字典树/Trie的表示.png)

