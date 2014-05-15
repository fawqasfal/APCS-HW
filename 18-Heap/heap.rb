##min-heap data structure and heapsort.
# constructor (root ) -> if root.class is not node, raise ArgumentError 
#

require './node.rb'
class Heap
	attr_reader :root 

	def initialize(root: nil )
		not_node = "You tried making a heap with root node #{root} which is #{root.class}, not node."
		raise ArgumentError, not_node if not root.nil? and root.class != Node 
		@root = root 
	end

	def self.make_heap arr
		ans = Heap.new
		arr.each{|el| ans.insert el}
		return ans
	end 

	def insert data
		if (data < @root.data)
			cp = @root.data.dup
			@root.data = data
			insert(cp)
		end
		curr_parent = @root; curr_check = curr_parent.children_data.min
		while (data >= curr_check)
			curr_parent.children.each{ |x| 
				curr_parent = x if x.data == curr_check
			}	
			curr_check = curr_parent.children_data.min
		end
		curr_parent.add_child(data) 
	end

	def delete data	
	end

	def find data
		curr = @root.data
		while (curr)
	end

end
