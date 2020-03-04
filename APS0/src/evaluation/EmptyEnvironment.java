package evaluation;

import interfaces.IEnvironment;

public class EmptyEnvironment implements IEnvironment {


    public EmptyEnvironment() {
    }


    public Environment extend(String varName, Value value){
        return  new Environment(varName, value,this);
    }

    public Value find(String varName) throws Exception {
        throw new Exception(varName+ "is not in the environment");
    }


}
