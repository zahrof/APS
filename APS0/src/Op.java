
public enum Op {
	ADD("add"),// calls constructor with value "add"
	SUB("sub"),// calls constructor with value "sub"
	MUL("mul"),// calls constructor with value "mul"
	DIV("div"),// calls constructor with value "div"
	NOT("not"),
	AND("and"),
	OR("or"),
	EQ("eq"),
	LT("lt");

	public String getStr() {
		return str;
	}

	private String str;
	
	Op(String str) { 
		this.str = str;
	}
	
	public String toString() {
		return this.str;
	}
}
