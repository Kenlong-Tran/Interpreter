import java.util.HashMap;
import java.util.Map;

/**
 * This is the outermost environment, containing predefined names. The
 * names +, -, *, /, %, =, !=, &lt;, &gt;, &lt;=, and &gt;= are
 * associated with corresponding functions.
 */
public class InitialEnvironment implements Environment {
	
	private Map<String,Value> nameToValue;
	private Map<Value,String> valueToName;
	
	public Value get(String name){
		Value v = nameToValue.get(name);
		if(v == null){
            throw new IllegalArgumentException("Undefined name " + name);
		} else {
			return v;
		}
	}
	
    String getName(Value v){
    	String name = valueToName.get(v);
    	if(name == null){
    		throw new IllegalArgumentException("Interpreter bug: getName called with " + v);
    	} else {
    		return name;
    	}
    }
    
    private void add(String name, Value v){
    	if(nameToValue.containsKey(name)){
    		throw new IllegalArgumentException("Interpeter bug: repeated name: " + name);
    	}
    	nameToValue.put(name, v);
    	valueToName.put(v, name);
    }
    
    // Singleton pattern
    private static InitialEnvironment env = new InitialEnvironment();
    
    public static InitialEnvironment getEnvironment(){
    	return env;
    }

    private InitialEnvironment(){
    	nameToValue = new HashMap<String,Value>();
    	valueToName = new HashMap<Value,String>();
    	
    	add("+", new IntOperation(){
    		public int compute(int i1, int i2){
    			return i1 + i2;
    		}
    	});

    	add("-", new IntOperation(){
    		public int compute(int i1, int i2){
                return i1 - i2;
            }
    	});

        add("*", new IntOperation(){
            public int compute(int i1, int i2){
                return i1 * i2;
            }
        });

        add("/", new IntOperation(){
            public int compute(int i1, int i2){
                return i1 / i2;
            }
        });

        add("%", new IntOperation(){
            public int compute(int i1, int i2){
                return i1 % i2;
            }
        });


        add("=", new IntComparison(){
            public boolean compute(int i1, int i2){
                return i1 == i2;
            }
        });

        add("!=", new IntComparison(){
            public boolean compute(int i1, int i2){
                return i1 != i2;
            }
        });

        add("<", new IntComparison(){
            public boolean compute(int i1, int i2){
                return i1 < i2;
            }
        });

        add("<=", new IntComparison(){
            public boolean compute(int i1, int i2){
                return i1 <= i2;
            }
        });

        add(">", new IntComparison(){
            public boolean compute(int i1, int i2){
                return i1 > i2;
            }
        });

        add(">=", new IntComparison(){
            public boolean compute(int i1, int i2){
                return i1 >= i2;
            }
        });
        
    }
    
}