package compiler.entities;

import java.util.*;

public class Function {
    private Type returnType;
    private String identifier;
    private List<Type> paramTypes;
    
    public Function(Type ret, String id) {
        this(ret, id, new ArrayList<Type>());
    }
    
    public Function(Type returnType, String identifier, List<Type> paramTypes) {
        this.returnType = returnType;
        this.identifier = identifier;
        this.paramTypes = new ArrayList<>(paramTypes);
    }
    
    public Type getReturnType() {
        return returnType;
    }
    
    public String getIdentifier() {
        return identifier;
    }
    
    public List<Type> getParamTypes() {
        return paramTypes;
    }
    
    public List<Type> getPrototype() {
        List<Type> proto = new ArrayList<>(paramTypes);
        proto.add(0, returnType);
        return proto;
    }
    
    public Type checkParamTypes(List<Type> params) throws Exception {
        if (!paramTypes.equals(params)) {
            throw new Exception("Type mismatch resolving parameters on function call statement");
        }
        return returnType;
    }
}
