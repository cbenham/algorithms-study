require_relative 'node'

class DoubleLinkedList
  attr_reader :size

  def initialize
    @size = 0
  end

  def append(data)
    if empty?
      @head = Node.new(nil, nil, data)
      @tail = @head
    else
      newNode = Node.new(@tail, nil, data)
      @tail.after = newNode
      @tail = newNode
    end
    @size += 1
  end

  def prepend(data)
    if empty?
      @head = Node.new(nil, nil, data)
      @tail = @head
    else
      newNode = Node.new(nil, @head, data)
      @head.before = newNode
      @head = newNode
    end
    @size += 1
  end

  def index_of(data)
    pointer = @head
    result = 0
    found = false

    while pointer.after && !found
      if data.nil? && pointer.data.nil? || data && data == pointer.data
        found = true
      else
        pointer = pointer.after
        result += 1
      end
    end
    found ? result : -1
  end

  def remove(index)
    pointer = node_at(index)

    if pointer == @head
      @head = @head.after
      @head.before = nil unless @head.nil?
    elsif pointer == @tail
      @tail = @tail.before
      @tail.after = nil
    else
      before = pointer.before
      after = pointer.after
      before.after = after if before
      after.before = before if after
    end

    @size -= 1
    pointer.data
  end

  def [](index)
    node_at(index).data
  end

  def []=(index, data)
    node_at(index).data = data
  end

  def clear
    @head = nil
    @tail = nil
    @size = 0
  end

  def empty?
    size.zero?
  end

  def first
    @head.data
  end

  def last
    @tail.data
  end

  def to_s
    result = '['

    pointer = @head
    while pointer
      result << pointer.to_s
      result << ', ' if pointer.after
      pointer = pointer.after
    end

    result << ']'
  end

  private

  def node_at(index)
    validate_range(index)
    pointer = @head
    (index).times { pointer = pointer.after }
    pointer
  end

  def validate_range(index)
    raise ArgumentError.new("Index ${index}, Size #{@size}") if empty? || index < 0 || index > @size - 1
  end
end