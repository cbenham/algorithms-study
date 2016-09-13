require_relative 'double_linked_list'

list = DoubleLinkedList.new

puts 'Empty list!'
puts "list.empty = #{list.empty?}"

list.append(3)
list.prepend(2)
list.append(4)
list.append(5)
list.append(6)
list.prepend(1)
list.prepend(0)
list.prepend(-1)
list.append(nil)

puts "\nWith data!"
puts "list = #{list}"
puts "list.isEmpty() = #{list.empty?}"
puts "list.size() = #{list.size}"
puts "list.indexOf(0) = #{list.index_of(0)}"
puts "list.indexOf(5) = #{list.index_of(5)}"
puts "list.indexOf(null) = #{list.index_of(nil)}"
puts "list.get(1) = #{list[1]}"
puts "list.get(5) = #{list[5]}"
puts "list.indexOf(99999) = #{list.index_of(99999)}"

puts "\nReplace data in the 8th position"
list[8] = 7
puts "list = #{list}"
puts "list.first() = #{list.first}"
puts "list.last() = #{list.last}"

puts "\nRemove first item"
puts "list.remove(0) = #{list.remove(0)}"
puts "list.size() = #{list.size}"
puts "list = #{list}"

puts "\nRemove last item"
puts "list.remove(list.size() - 1) = #{list.remove(list.size - 1)}"
puts "list.size() = #{list.size}"
puts list

puts "\nClearing list"
list.clear
puts "list = #{list}"
