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
            return @one
          end
          
        end
      end
    end
  end
end

require 'simple'

module Ext
  Simple = Edu::Umich::Lib::Trying::Simple
end



s = Ext::Simple.new
puts s.hello('Bill')
puts s.one
puts s.one_value
puts s.hi("William John")