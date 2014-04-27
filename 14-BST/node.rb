##
# Node class for binary trees. 
# variables : left node pointer, right node pointer, data
# methods (other than attr_reader) : 
# Node initialize(left = nil, right = nil, data) -> constructor. left/right must be Nodes.
# void left=(node) -> sets left child. left child is either nil or a Node whose data is of the same type as self.data's.
# void right=(node) -> sets right child. same rules as left=.
# string inspect -> gets datas inspect			 


class Node
  attr_reader :left, :right
  attr_accessor :data
  def initialize(data, left: nil, right: nil)
  	@left = left
  	@right = right
  	not_even_node = ""
  	not_node += "NOT NODE : Your child assigned to #{inspect} aren't nodes, it's a left child with {left.class}. " unless left.nil?
  	not_node += "\n NOT NODE : Your child assigned to #{inspect} aren't nodes, it's a right child with {left.class}. " unless right.nil?
  	raise(ArgumentError, not_even_node) unless ((left.nil? or left.class == Node) and (right.nil? or right.class == Node))
  	#everything fine?
  	@data = data
  end

  def left=(newnode)
  	not_even_node = "Your left child assigned to #{inspect} isnt't a node, it's a #{newnode.class}." 
  	raise(ArgumentError, not_even_node) unless newnode.class == Node or newnode.nil?
  	bad_set = "You tried setting #{inspect}'s left child to #{newnode.inspect}, but your node requires type #{@data.class}," +
  	"and the left child's data type is #{newnode.data.class}."
  	raise(ArgumentError, bad_set) unless newnode.nil? or newnode.data.class == @data.class
  	@left = newnode
  end
  
  def right=(newnode)
  	not_even_node = "Your right child assigned to #{inspect} isnt't a node, it's a #{newnode.class}." 
  	raise(ArgumentError, not_even_node) unless newnode.class == Node or newnode.nil?
  	@right = newnode
  end

  def nil?
  	return @data == nil
  end

  def inspect
  	@data.inspect
  end
end
