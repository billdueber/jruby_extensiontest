$: << File.join(File.dirname(__FILE__), "target")

#Edu::Umich::Lib::Trying::Simple

module Edu
  module Umich
    module Lib
      module Trying
        class Simple
          def hi(who='Bill')
            return "Hi there, #{who}"
          end
          
          def one_value
            return "Origianl ruby definition"
          end
          
        end
      end
    end
  end
end

puts Edu::Umich::Lib::Trying::Simple.new.one_value

require 'simple'

module Ext
  Simple = Edu::Umich::Lib::Trying::Simple
end


s = Ext::Simple.new
puts s.hello('Bill')
puts s.one
puts s.one_value

module Ext
  class Simple
    def one_value
      return "And changed it back again"
    end
  end
end

puts s.one_value



puts s.hi("William John")