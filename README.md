# AVLTree
self-balancing binary search tree implementation.  
AVLTree is slow in insertions and deletions, but extremely fast in lookups/search.  
AVLTree will balance itself on insertion and deletion of nodes. this will make the height of the tree to be O(log n) which the normal Binary tree will fail to do.  
## Test AVLTree vs ArrayList

results
```
AVLTree: Log(n)= 23.25349666421154 ,height=27 ,size=10000000 ,insertions=10000000 ,time=37793ms ,insertions-per-second=264000 insertions/s
AVLTree: size=10000000 ,tests=500000 ,time=51ms ,tests-per-second=9803000 tests/s
ArrayList: size=10000000 ,tests=100 ,time=1945ms ,tests-per-second=51 tests/s
```
AVL: 9,803,000 operations per second.  
ArrayList: 51 operations per second.  
as you can see, AVLTree is faster in levels of magnitude against ArrayList on `contains()` operations

# AVL and Hashmap
AVL is slightly better on modifying operations than HashMap. but hashmap is faster in lookups O(1) better than O(log n).
