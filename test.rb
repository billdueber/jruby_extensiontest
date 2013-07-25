$: << File.join(File.dirname(__FILE__), "target")

#Edu::Umich::Lib::Trying::Simple
puts

module Edu
  module Umich
    module Lib
      module Jrextentiontest
        class Simple
          def hi(who='Bill')
            return "Hi there, #{who}"
          end
          
          def one_value
            return "..defined in rubyland"
          end
          
        end
      end
    end
  end
end

puts "Original one_value is " + Edu::Umich::Lib::Jrextentiontest::Simple.new.one_value

require 'simple-jrubyext.jar'
require 'edu/umich/lib/jrextentiontest/simple'

module Ext
  Simple = Edu::Umich::Lib::Jrextentiontest::Simple
end


s = Ext::Simple.new
# puts s.hello('Bill')
# puts s.one
puts "New one_value is " + s.one_value


module Ext
  class Simple
    def one_value
      return "...re-redefined in rubyland"
    end
  end
end

puts "Final one_value is " +  s.one_value
# 
# 
# 
# puts s.hi("William John")


puts "Calling ruby method 'hi' " + s.call_hi


puts