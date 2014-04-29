Binary Search Tree in Ruby


variables : root, size

methods:

bst initialize( root: root_var ) -> returns bst. initial root node optional

root_var is DATA that gets passed in; the constructor takes that data and turns it into the root instance variable NODE.

node search ( data ) -> searches tree for data and returns first node found containing data, nil otherwise.

BST + ( data ) -> inserts node into tree. returns self. catches duplicate entries (just returns self) and trying to add incomparable data, like , string into a BST of ints, for example (also just returns self) 

BST - ( data ) -> deletes node containing data if such node exists, does nothing otherwise. returns self

array to_a() -> traverses bst and inserts elements in array. array is unsorted

String to_s () -> returns string interpretation of tree. pretty ugly cause all the levels start at the same horizontal point


TODO : pretty to_s() and sorted to_a()
