require './node.rb'

##
# Binary Search Tree implementation
# variables : root, size
# methods:
# bst initialize( root: root ) -> returns bst. initial root node optional
#root parameter for constructor == data; root instance variable == node.
# node search ( data ) -> searches tree for data and returns first node found containing data, nil otherwise.
# node insert ( data ) -> inserts node into tree. if already exists, return nil.
# void delete ( data ) -> deletes node containing data if such node exists, does nothing and returns nil otherwise.
# array traverse () -> traverses bst and inserts elements in array. array is unsorted
# String dumb_inspect -> returns stupid String interpretation of tree, where each node is represented by it's data prefixed by 
# the chronological 'route' required to go through in order to get to that node ('S' for a 'left' traversal, 'B' for a 'right' traversal)
# String inspect () -> returns good string interpretation of tree (2d visualization with '/'s and '\'s,)

class BST
  attr_reader :root, :size

  private 
  def dumb_inspect(ans: "", currnode: @root, prefix: "")
  	#returns poor String interpretation 
  	ans +=  "#{prefix}::#{currnode.data.inspect}\n"
  	return ans if currnode.left.nil? and currnode.right.nil?
  	dumb_inspect(ans: ans, currnode: currnode.left, prefix: prefix + "S") if !currnode.left.nil?
  	dumb_inspect(ans: ans, currnode: currnode.right, prefix: prefix + "B") if !currnode.right.nil?
  end

  def del_with_1_or_0_children(node, parent)
  	if !node.left.nil? #has small child : replace node.data with small.data, remove connection to small
			node.data = node.left.data
			node.left = nil
			size -= 1
		elsif !node.right.nil? #has big child
			node.data = node.right.data
			node.right = nil
			size -= 1
		else #has 0 children : is a leaf
			if parent.nil? #has 0 children and has no parent : its a BST with just root, and user wants to make BST empty
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
		while not node.left.nil? and not node.right.nil?
			ansnode ||= node.left #arbitrarly chose to go down the smaller path 
		end
		return ansnode
	end

	def priv_search(data, currnode: @root)
		return nil if empty?
		if currnode.data < data
		  return nil if currnode.right.nil? #if currnode.rightger is nil, means no bigger leaf, means no possible answer. quit.
		  priv_search(data, currnode: currnode.right)
		elsif currnode.data > data
	 	 return nil if currnode.left.nil? #if currnode.left is nil, means no smaller leaf, means no possible answer. quit. 
	 	 priv_search(data, currnode: currnode.left)
		else
	 	 return currnode
		end
	end

	def priv_insert(data, currnode: @root)
		if empty?
			@size += 1
			return (@root = Node.new(data))
		end		
		if currnode.data < data #the current data is less than data : the correct leaf is on the right side
			if currnode.right.nil? #if the right leaf doesnt exist, then this is the proper leaf to insert data
				@size += 1
				return (currnode.right = Node.new(data))
			else
				priv_insert(data, currnode: currnode.right)  #go to the right child 
			end
		elsif currnode.data > data #the current data is less than data : the correct leaf is on the left side
			if currnode.left.nil?
				@size += 1
				return (currnode.left = Node.new(data))
			else
				priv_insert(data, currnode: currnode.left) unless currnode.left.nil?
				@size += 1
			end
		else #currnode.data = data -- data already exists, no dup nodes allowed, return nil
			return nil
		end
	end

	def priv_delete (data, parent: nil, currnode: @root)
		return nil if empty?
		#finding node for deletion
		if currnode.data < data
			priv_delete(data, parent: currnode, currnode: currnode.right ) unless currnode.right.nil?
			return nil if currnode.right.nil?
		elsif currnode.data > data
			priv_delete(data, parent: currnode, currnode: currnode.left) unless currnode.left.nil?
			return nil if currnode.left.nil?

		else #data == currnode.data -  this means our node has been found 
			del_with_1_or_0_children(currnode, parent) if currnode.left.nil? or currnode.right.nil? #has one or zero children
			if not currnode.left.nil? and not currnode.right.nil? #two children
				currnode.data = currnode.left.data #arbitrarily chose to go down currnode's small path until i find a node with 1/0 children
				priv_delete(currnode.left.data, parent: currnode, currnode: currnode.left)
			end
		end
	end

	def priv_traverse(currnode: @root, ans: [])
		return [] if empty?
		ans += [currnode.data]
		return ans if currnode.left.nil? and currnode.right.nil?
		priv_traverse(currnode: currnode.left, ans: ans) unless currnode.left.nil?
		priv_traverse(currnode: currnode.right, ans: ans) unless currnode.right.nil?
	end	


	public

  def initialize root: nil
  	@root = Node.new(root)
  	@size = @root.nil? ? 0 : 1 #if root is nil, then size is 0; else its 1
  end

  def inspect
  	return dumb_inspect
  	

  end
 	
	
	def empty?; return size == 0; end
	def search(data); return priv_search(data); end
 	def insert(data); return priv_insert(data);	end
 	def delete(data); return priv_delete(data); end
 	def traverse; return priv_traverse; end


  #so many private methods because i used recursion in all of them and i dont want user to have access to the passed parameters used  

end