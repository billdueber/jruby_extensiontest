package edu.umich.lib.trying;

import java.io.IOException;

import org.jruby.Ruby;
import org.jruby.RubyClass;
import org.jruby.RubyModule;
import org.jruby.runtime.ObjectAllocator;
import org.jruby.runtime.builtin.IRubyObject;
import org.jruby.runtime.load.BasicLibraryService;
import org.jruby.runtime.ThreadContext;

/**
 * Service defining the module and loading the {@link Fibonacci} class.
 * 
 * @author Sébastien Le Callonnec
 */
public class SimpleService implements BasicLibraryService {

    // The allocator instantiates the {@link Fibonacci} object.
    private final static ObjectAllocator SIMPLE_ALLOCATOR = new ObjectAllocator() {
        @Override
        public IRubyObject allocate(Ruby runtime, RubyClass klass) {
            return new Simple(runtime, klass);
        }
    };

    @Override
    public boolean basicLoad(Ruby runtime) throws IOException {
        ThreadContext ctx = runtime.getCurrentContext();
      
        // The Ruby module structure must mirror the Java package name.
        // Note that the class can already exist -- you can build
        // part of the class functionality in Ruby and then
        // load up your java class to extend it
        RubyModule edu = runtime.defineModule("Edu");
        RubyModule umich = edu.defineModuleUnder("Umich");
        RubyModule lib = umich.defineModuleUnder("Lib");
        RubyModule trying = lib.defineModuleUnder("Trying");
        RubyClass simpleclass = trying.defineClassUnder("Simple", runtime.getObject(), SIMPLE_ALLOCATOR);
        simpleclass.addReadWriteAttribute(ctx, "one");

        simpleclass.defineAnnotatedMethods(Simple.class);
        

        return true;
    }
}