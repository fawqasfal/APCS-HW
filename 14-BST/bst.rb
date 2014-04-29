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
#array to_a() -> traverses bst and inserts elements in array. array is unsorted
#String to_s () -> returns string interpretation of tree. pretty ugly cause all the levels start at the same horizontal point

class BST
	public
	attr_reader :root, :size

	def empty?; return @size == 0; end
	def to_a; arr_builder!; return @arr_build; end
	def inspect; return to_s; end

  def initialize root: nil
  	@root = Node.new(root)
  	@size = @root.nil? ? 0 : 1 #if root is nil, then size is 0; else its 1
  end

 	def to_s()
 		#breadth-first search to distinguish tree by levels 
 		return "" if empty?
 		levels = Math.log(@size, 2).floor
 		ans = [[@root]] #2d arr with each arr representing a level; sorted by levels
 		fin = ""
 		(1..levels).each do
 			|x|
 			new_level = []
 			ans[x - 1].each do
 				|y| 
 				new_level += [y.left] if not y.left.nil?
 				new_level += [y.right] if not y.right.nil?
 				#add all children from level before
 			end
 			ans += [new_level] #add new level to final answer
 		end 		
 		ans.each{|x|; x.size.times{|y|  x[y] = x[y].to_s} } #convert Nodes into their string reps
 		ans.each{|x|; x.each{|y|; fin += y + " "}; fin += "\n"} #convert arr to final string
 		return fin
 	end

	def search(data)
		ans = node_parent_search(data)
		return ans[:node] unless ans.nil?
		return nil
	end
	
	def +(data)
		ans = dup #duplicates BST -- we dont want this function to alter the state of the tree, just return (tree + data)
		node = ans.send(:node_parent_search , data) #see privates_bst.rb for what node_parent_search does in detail
		return ans if node.nil? or not node[:node].nil?  #if node has been found by node_parent_search then data already exists. no dup nodes allowed
		ans.send(:size= , ans.size + 1) #"private" function -- have to tell Ruby I know what I'm doing by using send
		if node[:parent].nil? #if node and parent are nil, then its empty
			ans.root = Node.new(data)
			return ans
		end
		#otherwhise, you have node[:parent] as the closest leaf/subleaf-with-one-child. now just determine the correct child for that parent
		node[:parent].right = Node.new(data) if node[:parent].data < data 
		node[:parent].left = Node.new(data) if node[:parent].data > data
		return ans
	end

	def -(data)
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