package edu.umich.lib.jrextentiontest;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyFixnum;
import org.jruby.RubyString;
import org.jruby.RubyObject;
import org.jruby.anno.JRubyClass;
import org.jruby.anno.JRubyMethod;
import org.jruby.runtime.ThreadContext;
import org.jruby.runtime.builtin.IRubyObject;

/**
 * This class implements the logic of the Ruby <code>Fibonacci</code> class by
 * using the JRuby annotations.
 * 
 * @author Sébastien Le Callonnec
 */
@JRubyClass(name = "Edu::Umich::Lib::Jrextentiontest::Simple")
public class Simple extends RubyObject {
    public Simple(Ruby runtime, RubyClass metaClass) {
        super(runtime, metaClass);        
    }

    @JRubyMethod(name = "new", meta = true, rest = true)
    public static IRubyObject rbNew(ThreadContext context, IRubyObject klazz, IRubyObject[] args) {
        Simple simple = (Simple) ((RubyClass) klazz).allocate();
        return simple;
    }

    // Move it to the ruby impl
    // @JRubyMethod(name="one")
    // public IRubyObject one(ThreadContext context) {
    //   return this.getInstanceVariable("one");
    // }
    
    @JRubyMethod(name = "call_hi")
    public IRubyObject call_hi(ThreadContext context) {
      Ruby runtime = context.getRuntime();
      RubyString str = RubyString.newString(runtime,  "...from Java land");
      return this.callMethod("hi", str);
    }

    @JRubyMethod(name = "hello")
    public IRubyObject hello(ThreadContext context, IRubyObject other) {

        Ruby runtime = context.getRuntime();
        RubyString str = (RubyString) other;
        this.setInstanceVariable("@one", RubyString.newString(runtime, "two"));
        return str.append(str);
    }
    
    @JRubyMethod(name="one_value")
    public IRubyObject one_value(ThreadContext context) {
      Ruby runtime = context.getRuntime();
      return RubyString.newString(runtime, "...redefined in Java code");
    }

}
