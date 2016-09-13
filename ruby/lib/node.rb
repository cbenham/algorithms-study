class Node
  attr_accessor :before, :after, :data

  def initialize(before, after, data)
    @before = before
    @after = after
    @data = data
  end

  def to_s
    data.nil? ? 'nil' : data.to_s
  end
end