import java.util.ArrayList;

public class AstType implements Ast{
	TPrim tprim;
	ArrayList<Ast> opands;

	AstType(Tprim tprim, ArrayList<Ast> es) {
		this.tprim = tprim;
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
