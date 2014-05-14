require './privates_bst.rb'
##
# Binary Search Tree implementation
#variables : root, size
#methods:
#bst initialize( root: root_var ) -> returns bst. initial root node optional
#root_var is DATA that gets passed in; the constructor takes that data and turns it into the root instance variable NODE.
#node search ( data ) -> searches tree for data and returns first node found containing data, nil otherwise.
#BST + ( data ) -> duplicates tree. inserts node into dup'd tree. returns dup'd tree. 
#catches duplicate entries (just returns dup'd tree) and trying to add incomparable data (also just returns dup'd tree)
#BST - ( data ) -> dup's tree. deletes node containing data if such node exists, does nothing otherwise. returns dup'd tree
#array to_a() -> traverses bst and inserts elements in array. 
#String to_s () -> returns string interpretation of tree. pretty ugly cause all the levels start at the same horizontal point

class BST
	public
	attr_reader :root, :size

	def empty?; return @size == 0; end
	def to_a; return arr_builder!; end
	def inspect; return to_s; end

  def initialize(root: nil)
  	@root = Node.new(root)
  	@size = @root.nil? ? 0 : 1 #if root is nil, then size is 0; else its 1
  end

  def to_s
  	#pretty 2d string
  	return "" if empty?; return [@root].to_s if size == 1  
  	#get 2d arr formatted as [level arr.index[subarr]'s elements ] foreach level; amount of levels; final ans
  	init = str_builder!; lvls = init.size; ans = "\n"
  	(0..(lvls - 1)).each do |x|
  		space_num = (2**(lvls - x)) - 1
  		init_space = " " * space_num  #"center" the level; the higher the level, the fewer the elements, the more spaces you need to center
  		elem_space = " " * (2 * (space_num + 1) - 1) #spaces between elements
  		ans += init_space
  		init[x].each{|y|; ans += y.to_s + elem_space}
  		ans += init_space + "\n"
  	end
  	return ans
  end

	def search(data)
		ans = node_parent_search(data)
		return ans[:node] unless ans.nil?
		return nil
	end
	
	def + data
		ans = dup #duplicates BST -- we dont want this function to alter the state of the tree, just return (tree + data)
		node = ans.send(:node_parent_search , data) #see privates_bst.rb for what node_parent_search does in detail
		return ans if node.nil? or not node[:node].nil?  #if node has been found by node_parent_search then data already exists. no dup nodes allowed
		ans.send(:size= , ans.size + 1) #"private" function -- have to tell Ruby I know what I'm doing by using send
		if node[:parent].nil? #if node and parent are nil, then its empty
			ans.send(:root=, Node.new(data))
			return ans
		end
		#otherwhise, you have node[:parent] as the closest leaf/subleaf-with-one-child. now just determine the correct child for that parent
		node[:parent].right = Node.new(data) if node[:parent].data < data 
		node[:parent].left = Node.new(data) if node[:parent].data > data
		return ans
	end

	def - data
		ans = dup
		node = ans.send(:node_parent_search , data)
		return ans if node.nil? or node[:node].nil? #node hasnt been found -- return self
		currnode = node[:node]; parent = node[:parent] #node found
		ans.send(:del_with_1_or_0_children! , currnode, parent) if currnode.left.nil? or currnode.right.nil? #has one or zero children
		if not currnode.left.nil? and not currnode.right.nil? #two children
			del_node = ans.send(:find_first_1_or_0_children! , currnode)
			ans.send(:del_with_1_or_0_children! , del_node[:node], del_node[:parent]) 
		end
		return ans
	end

end