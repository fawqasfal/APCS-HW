require './node.rb'

class BST
  private 
  attr_accessor :root, :size, :arr_build #used for building tree traversal

  def arr_builder!(currnode: @root)
		@arr_build = [] if currnode == @root
		return if currnode.nil?
		@arr_build += [currnode.data]
		arr_builder!(currnode: currnode.left)
		arr_builder!(currnode: currnode.right)
	end

  def del_with_1_or_0_children!(node, parent)
  	#given a node with 1/0 children, and the parent of the node, delete the node
  	if !node.left.nil? #has small child : replace node.data with small.data, remove connection to small
			node.data = node.left.data; node.left = nil; @size -= 1; return
		elsif !node.right.nil? #has big child
			node.data = node.right.data; node.right = nil; @size -= 1; return
		else #has 0 children : is a leaf
			if parent.nil? #has 0 children and has no parent : its a BST with just root, and user wants to make BST empty
				@root = nil; @size -= 1; return
			else #has 0 children, just cut off connection from parent, no copying of data needed
				parent.left = nil if parent.left == node #if parents small child is the target leaf, cut connection to small child
				parent.right = nil if parent.right == node #or else its the parents big child 
				@size -= 1; return
			end
		end
	end

	def find_first_1_or_0_children!(node)
		##given a node with 2 children, finds the first child with 1/0 children (subleaf-w-one-child or leaf) on the left subtree, and its parent
		#each time, copies the value from the left child to the parent; as this is used in delete() where were trying to get rid of the parent
		while not node.left.nil? and not node.right.nil?
			node.data = node.left.data
			parent ||= node
			node = node.left
		end
		return {node: node, parent: parent}
	end

	def node_parent_search(data, currnode: @root, parent: nil)
		##returns hash : {node: node if found; nil if not found
		# parent: node's parent if found; closest leaf/subleaf-with-one-child if not found and not empty} 
		#these params are used in insert() and delete(), only node param is used in actual search
		return {node: nil, parent: nil} if empty?
		if currnode == @root #first call on the recursive stack -- user just tried adding
			currnode.data < data rescue return nil #if datatypes of root.data and data are incomparable, delete them
		end
		if currnode.data < data
		  return {node: nil, parent: currnode} if currnode.right.nil? #if currnode.right is nil, means no bigger leaf, means no possible answer. quit.
		  node_parent_search(data, currnode: currnode.right, parent: currnode)
		elsif currnode.data > data
	 	 return {node: nil, parent: currnode} if currnode.left.nil? #if currnode.left is nil, means no smaller leaf, means no possible answer. quit. 
	 	 node_parent_search(data, currnode: currnode.left, parent: currnode)
		else
	 	 return {node: currnode, parent: parent}
		end
	end
	
end