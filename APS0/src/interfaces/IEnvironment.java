package interfaces;

import evaluation.Value;

public interface IEnvironment {
    IEnvironment extend(String varName, Value value);
    Value find(String varName) throws Exception;
}
