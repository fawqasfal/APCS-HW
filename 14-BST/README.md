Binary Search Tree in Ruby


variables : root, size

methods:

bst initialize( root: root_var ) -> returns bst. initial root node optional

root_var is DATA that gets passed in; the constructor takes that data and turns it into the root instance variable NODE. 

node search ( data ) -> searches tree for data and returns first node found containing data, nil otherwise.

node insert ( data ) -> inserts node into tree. if already exists, return nil. if not comparable with other data, ArgumentError raised.

void delete ( data ) -> deletes node containing data if such node exists, does nothing and returns nil otherwise.

array to_a() -> traverses bst and inserts elements in array. array is unsorted

String to_s () -> returns string interpretation of tree. pretty ugly cause all the levels start at the same start point