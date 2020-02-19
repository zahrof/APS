import java.util.ArrayList;

public class AstType implements Ast{
	Tprim tprim;
	ArrayList<Ast> opands;

		AstType(Tprim tprim) {
    		this.tprim = tprim;
    		this.opands = new ArrayList<Ast>();
    	}

	AstType(Tprim tprim, ArrayList<Ast> es) {
		this.tprim = tprim;
		this.opands = es;
	}

	@Override
	public String toPrologString() {
		String r = "";
		if (this.opands.isEmpty())
		r = tprim.toString();

		else
            r = tprim.toString()+"([";
            return r;
    }

}
