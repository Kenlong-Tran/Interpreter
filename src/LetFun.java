
public class LetFun implements Expression {
	String functionName;
	String parameter;
	Expression functionBody;
	Expression letBody;
	
	public LetFun(String functionName, String parameter, Expression functionBody,
			Expression letBody) {
		// TODO Auto-generated constructor stub
		this.functionName = functionName;
		this.parameter = parameter;
		this.functionBody = functionBody;
		this.letBody = letBody;
	}

	@Override
	public Value eval(Environment env) {
		// TODO Auto-generated method stub
		//letFun = new LetFun("f", "n", fBody, fFive);
		//env3 = new ActivationRecord("five",sixMinusOne.eval(env0),env0);
		Environment env2 = new ActivationRecord(this.functionName, this.parameter,this.functionBody, env);
        return letBody.eval(env2);
        }
	public String toString()
	{
		return "let fun " + functionName + " "
				+ parameter + " = " + functionBody.toString() + " in " + letBody.toString() + " end";
	}

}
