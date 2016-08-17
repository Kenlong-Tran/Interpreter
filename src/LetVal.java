
public class LetVal implements Expression {
	String name;
	Expression valueExpr;
	Expression bodyExpr;
	public LetVal(String name, Expression valueExpr, Expression bodyExpr) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.valueExpr = valueExpr;
		this.bodyExpr = bodyExpr;
	}

	@Override
	public Value eval(Environment env) {
		// TODO Auto-generated method stub
		//letVal = new LetVal("five", sixMinusOne, fFive);
		//env1 = new ActivationRecord("f", "n", fBody, env0);
		//1st parameter is five
		//2nd parameter is 5
		//3rd parameter is f, n, fbody, env0
		Environment env2 = new ActivationRecord (this.name, valueExpr.eval(env) ,env);
        return bodyExpr.eval(env2);
	}
	public String toString()
	{
		return "let val " + name.toString() + " = "
				+ valueExpr.toString() + " in " + bodyExpr.toString() + " end";
	}

}
