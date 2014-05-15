##
# Node class for binary trees. 
# variables : left node pointer, right node pointer, data
# methods (other than attr_reader) : 
# Node initialize(left = nil, right = nil, data) -> constructor. left/right must be Nodes.
# void left=(node) -> sets left child. left child is either nil or a Node whose data is of the same type as self.data's.
# void right=(node) -> sets right child. same rules as left=.
# void data=(dt) -> sets data to dt. If left and/or right exist, must be same type as either/both, else raises ArgumentError.
# string inspect -> gets datas inspect			 


class Node
  attr_reader :left, :right, :data
  
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
    @left = newnode
  end
  
  def right=(newnode)
  	not_even_node = "Your right child assigned to #{inspect} isnt't a node, it's a #{newnode.class}." 
  	raise(ArgumentError, not_even_node) unless newnode.class == Node or newnode.nil?
  	@right = newnode
  end

  def data=(dt) 
    dt_break_l = "You tried giving node #{inspect} data #{dt.inspect} -- left child data type is #{left.data.class}." if not left.nil?
    dt_break_r = "You tried giving node #{inspect} data #{dt.inspect} -- right child data type is #{right.data.class}." if not right.nil?
    raise(ArgumentError, dt_break_l) if not dt_break_l.nil? and left.data.class != dt.class
    raise(ArgumentError,dt_break_r) if not dt_break_r.nil? and right.data.class != dt.class
    @data = dt 
  end


  def nil?; return @data == nil; end
  def inspect;to_s;end
  def to_s;@data.inspect;end

  

end
