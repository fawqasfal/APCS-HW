require './node.rb'

##
# Binary Search Tree implementation
# variables : root, size
# methods:
# bst initialize( root: root ) -> returns bst. initial root node optional
#root parameter for constructor == data; root instance variable == node.
# node search ( data ) -> searches tree for data and returns first node found containing data, nil otherwise.
# node insert ( data ) -> inserts node into tree. node's data must be comparalbe with tree data (is there a method to check for comparability in ruby?
#	oh, well, im sure interpreter will catch that -- maybe print out a less detailed/tree-specific error message, though). return newly made node
# void delete ( data ) -> deletes node containing data if such node exists, does nothing and returns nil otherwise.
# array traverse () -> traverses bst and inserts elements in array. array is unsorted
# String dumb_inspect -> returns stupid String interpretation of tree, where each node is represented by it's data prefixed by 
# the chronological 'route' required to go through in order to get to that node ('S' for a 'left' traversal, 'B' for a 'right' traversal)
# String inspect () -> returns good string interpretation of tree (2d visualization with '/'s and '\'s,)

class BST
  attr_accessor :root, :size

  private 
  def dumb_inspect(ans: "", currnode: @root, prefix: "")
  	#returns poor String interpretation 
  	ans +=  "#{prefix}::#{currnode.data.inspect}\n"
  	dumb_inspect(ans: ans, currnode: currnode.left, prefix: prefix + "S") if currnode.left
  	dumb_inspect(ans: ans, currnode: currnode.left, prefix: prefix + "B") if currnode.right
  end

  def del_with_1_or_0_children(node, parent)
  	if node.left #has small child : replace node.data with small.data, remove connection to small
			node.data = node.left.data
			node.left = nil
			size -= 1
		elsif node.right #has big child
			node.data = node.right.data
			node.right = nil
			size -= 1
		else #has 0 children : is a leaf
			if parent == nil #has 0 children and has no parent : its a BST with just root, and user wants to make BST empty
				@root = nil
				size -= 1
			else
				parent.left = nil if parent.left == node #if parents small child is the target leaf, cut connection to small child
				parent.right = nil if parent.right == node #or else its the parents big child 
				size -= 1
			end
		end
	end

	def find_first_1_or_0_children(node)
		while node.left and node.right
			ansnode ||= node.left #arbitrarly chose to go down the smaller path 
		return ansnode
	end

	def priv_search(data, currnode: @root)
		return nil if empty?
		if currnode.data < data
		  return nil unless currnode.right #if currnode.rightger is nil, means no bigger leaf, means no possible answer. quit.
		  priv_search(data, currnode: currnode.right)
		elsif currnode.data > data
	 	 return nil unless currnode.left #if currnode.left is nil, means no smaller leaf, means no possible answer. quit. 
	 	 priv_search(data, currnode: currnode.left)
		else
	 	 return currnode
		end
	end

	def priv_insert(data, currnode: @root)
		if empty?
			size += 1
			return (@root = Node.new(data))
		end
		if currnode == nil #if current node is empty, then weve reached the right potential leaf -- set it to data
			size += 1
			return (currnode = Node.new(data))
		end 
		bad_insert = "The data you tried to insert, #{data.inspect}, already exists in this BST :\n #{dumb_inspect}."
		raise(ArgumentError, bad_insert) if currnode.data == data
		priv_insert(data, currnode.right) if currnode.data < data 
		priv_insert(data, currnode.left) if currnode.data > data 
	end

	def priv_delete (data, parent: nil, currnode: @root)
		bad_delete = "The data you tried to insert, #{data.inspect} does not exist in this tree : \n #{dumb_inspect}" 
		raise( ArgumentError, bad_delete) if empty?
		#finding node for deletion
		if currnode.data < data
			priv_delete(data, parent: currnode, currnode: currnode.right ) if currnode.right 
			raise(ArgumentError, bad_delete) if currnode.right == nil
		elsif currnode.data > data
			priv_delete(data, parent: currnode, currnode: currnode.left) if currnode.left
			raise(ArgumentError, bad_delete) if currnode.left == nil
		else #data == currnode.data -  this means our node has been found 
			del_with_1_or_0_children(currnode, parent) if not (currnode.left and currnode.right) #has one or zero children
			if currnode.left and currnode.right #two children
				currnode.data = currnode.left.data #arbitrarily chose to go down currnode's small path until i find a node with 1/0 children
				priv_delete(currnode.left.data, parent: currnode, currnode: currnode.left)
			end
		end
	end

	def priv_traverse(currnode: @root, ans: [])
		return [] if empty?
		ans += [currnode.data]
		priv_traverse(currnode: currnode.left, ans: ans) if currnode.left
		priv_traverse(currnode: currnode.right, ans: ans) if currnode.right
	end	


	public

  def initialize root: nil
  	@root = Node.new(root)
  	@size = (not @root) ? 0 : 1 #if root is nil, then size is 0; else its 1
  end

  def inspect
  	return "" if empty?
  	ans = ""
  	init = dumb_inspect.split '\n'
  	init.sort! do 
  		|x, y| 
  		x.slice![0 : x.index("::")].size > y.slice![0, y.index("::")].size
  	end #sort by prefix length -- smaller the prefix, higher the level; also get rid of prefix
  	levels = Math.log(@size, 2).ceil #how many levels there are
  	ind = 0 #current index
  	(1..levels).each do
  		|x|
  		if 2**x >= size #this is last level
  			ind_range = ind..(size - 1)
  		else
  			ind_range = ind..(ind + (2 ** (x - 1)) - 1) #determining the range of indices for each level. 
  			ind += 2 ** (x - 1) 
  		end	
  		ans += init_str[ind_range].to_s + "\n"
  	end
  	return ans
  end
 	
	
	def empty?; return size == 0; end
	def search(data); return priv_search(data); end
 	def insert(data); return priv_insert(data);	end
 	def delete(data); return priv_delete(data); end
 	def traverse; return priv_traverse; end


  #so many private methods because i used recursion in all of them and i dont user to have access to the parameters i used in the private methods  

end