#!/usr/bin/env ruby
require './bst.rb'
puts "code first, expected result printed next"
test = BST.new
puts "empty BST"; puts test.to_s; puts test.size; puts test.root; p test.to_a
test = BST.new(root: 10)
puts test.class
puts "BST with root 10"; puts test.to_s; puts test.size; puts test.root; p test.to_a
test += 5
puts test.class
puts "BST with root 10, then 5"; puts test.to_s; puts test.size; puts test.root; p test.to_a
test += 4
puts "10, then 5, then 4"; puts test.to_s; puts test.size; puts test.root; p test.to_a
test += 6
puts "10, then 5, then 4, then 6"; puts test.to_s; puts test.size; puts test.root; p test.to_a
test += 3
puts "10, then 5, then 4, then 6, then 3"; puts test.to_s; puts test.size; puts test.root; p test.to_a
test += 20
puts "10, then 5, then 4, then 6, then 3, then 20"; puts test.to_s; puts test.size; puts test.root; p test.to_a
puts test += 15
puts "10, then 5, then 4, then 6, then 3, then 20, then 15"; puts test.to_s; puts test.size; puts test.root; p test.to_a
test -= 20 
puts "deleted 20"; puts test.to_s; puts test.size; puts test.root; p test.to_a
test -= 10
puts "deleted ROOT"; puts test.to_s; puts test.size; puts test.root; p test.to_a; p test.to_a
test += test.root.data
puts "tried to insert existing node"; puts test.to_s; puts test.size; puts test.root; p test.to_a; p test.to_a
test += "BREAK"
puts "tried to insert uncomparable data"
test.search test.root.data
puts "searched for root"
test.search 15 
puts "searched for 15"

test.search "BREAK"
puts "searched for nonexisting element"

test -= "sdfsdf"
puts "deleted nonexisting element"

p test.to_a; puts test.to_s; puts test.size; puts test.root;

#finally, get rid of test ... by deleting root recursively !
while test.size != 0
  test -= test.root.data
  puts test.to_s
end
puts test.to_s
