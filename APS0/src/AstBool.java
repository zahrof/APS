import java.util.ArrayList;

public class AstBool implements Ast{
    	cBool name;

    	AstBool(cBool x){
    		name = x;
    	}

    	@Override
    	public String toPrologString() {
    		return "bool("+name+")";
    	}

}
