import java.util.ArrayList;

public class AstPrim implements Ast{
	Op op;
	ArrayList<Ast> opands;
	
	AstPrim(Op op, ArrayList<Ast> es) {
		this.op = op;
		this.opands = es;
	}
	
	@Override
	public String toPrologString() {
		String r = "";
		r = op.toString()+"([";

		if (op.getStr()== "not"){
			r +=opands.get(0).toPrologString();
			r += "])";
			return r;
		}

		for(int i=0; i < opands.size()-1; i++)
			r += opands.get(i).toPrologString()+",";
			r += opands.get(opands.size()-1).toPrologString();
			r += "])";
			return r;
	}

}
