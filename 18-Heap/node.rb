##
# Node class for binary trees. 
# variables : left node pointer, right node pointer, data
# methods (other than attr_reader) : 
# Node initialize(left = nil, right = nil, data) -> constructor. left/right must be Nodes.
## node add(dt) -> adds dt to node's children. if @data is different than dt's type, raise argumenterror. return node. 
# node delete(dt) -> gets rid of dt from node's childrne. if dt not found, just return the node.
# void data=(dt) -> sets data to dt. If left and/or right exist, must be same type as either/both, else raises ArgumentError.
# array children_data() -> gets data from all children
# string inspect -> gets datas inspect			 


class Node
  attr_reader :children, :data

  def initialize(data)
  	@data = data
    @children = []
  end

  def add_child(dt)
    raise ArgumentError, "wrong datatype:tried adding #{dt.inspect} to node with data class #{@data.class}." if dt.class != @data.class
    @children += [Node.new(dt)]
    return self
  end

  def remove_child(dt)
    return nil if not @children.include? dt
    children -= [Node.new(dt)]
    return self
  end

  def children_data()
    ans = []
    @children.each{|x| ans += [x.data]}
    return ans
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
