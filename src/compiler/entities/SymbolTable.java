package compiler.entities;

import java.util.*;

public class SymbolTable {
    private static SymbolTable instance;
    
    private Map<String, Function> functions;
    
    private Stack<Map<String, Type>> variables;
    
    public static SymbolTable getInstance() {
        return instance == null ? instance = new SymbolTable() : instance;
    }
    
    private SymbolTable() {
        functions = new HashMap<>();
        variables = new Stack<>();
        variables.push(new HashMap<String, Type>());
    }
    
    public void declareFunction(String ident, Function func) 
            throws Exception {
        if (functions.containsKey(ident)) {
            throw new Exception("Identifier already in use : function <" + ident + ">");
        }
        functions.put(ident, func);
    }
    
    public Function getFunction(String ident) throws Exception {
        if (!functions.containsKey(ident)) {
            throw new Exception("Undefined identifier : function <" + ident + ">");
        }
        return functions.get(ident);
    }
    
    public List<Function> getFunctions() {
        return new ArrayList<>(functions.values());
    }
    
    public void openNewScope() {
        variables.push(new HashMap<String, Type>());
    }
    
    public void closeTopScope() {
        variables.pop();
    }
    
    public void declareSymbol(String ident, Type type) 
            throws Exception {
        if (variables.lastElement().containsKey(ident)) {
            throw new Exception("Identifier already in use : symbol <" + ident + ">");
        }
        variables.lastElement().put(ident, type);
    }
    
    public Type getType(String ident) throws Exception {
        for (int i = variables.size() - 1; i >= 0; i--) {
            if (variables.get(i).containsKey(ident)) {
                return variables.get(i).get(ident);
            }
        }
        throw new Exception("Undefined identifier : symbol <" + ident + ">");
    }
}
