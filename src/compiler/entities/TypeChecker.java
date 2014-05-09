package compiler.entities;

import java.util.*;

import static compiler.entities.Type.*;

public class TypeChecker {
    public static final String EQU_COMPARATOR = "EQU_COMPARATOR";
    public static final String ORDER_COMPARATOR = "ORDER_COMPARATOR";
    public static final String CALC_OPERATOR = "CALC_OPERATOR";
    
    private static TypeChecker instance;
    
    private List<TypeOperation> allowed;
    
    public TypeChecker() {
        allowed = new ArrayList<>();
        allowed.add(new TypeOperation("=", BOOLEAN, BOOLEAN, BOOLEAN));
        allowed.add(new TypeOperation("=", INTEGER, INTEGER, INTEGER));
        allowed.add(new TypeOperation("=", INTEGER, FLOAT, INTEGER));
        allowed.add(new TypeOperation("=", FLOAT, FLOAT, FLOAT));
        allowed.add(new TypeOperation("=", FLOAT, INTEGER, FLOAT));
        allowed.add(new TypeOperation("=", STRING, STRING, STRING));
        
        allowed.add(new TypeOperation(EQU_COMPARATOR, BOOLEAN, BOOLEAN, BOOLEAN));
        allowed.add(new TypeOperation(EQU_COMPARATOR, INTEGER, INTEGER, BOOLEAN));
        allowed.add(new TypeOperation(EQU_COMPARATOR, INTEGER, FLOAT, BOOLEAN));
        allowed.add(new TypeOperation(EQU_COMPARATOR, FLOAT, FLOAT, BOOLEAN));
        allowed.add(new TypeOperation(EQU_COMPARATOR, FLOAT, INTEGER, BOOLEAN));
        allowed.add(new TypeOperation(EQU_COMPARATOR, STRING, STRING, BOOLEAN));
        
        allowed.add(new TypeOperation(ORDER_COMPARATOR, INTEGER, INTEGER, BOOLEAN));
        allowed.add(new TypeOperation(ORDER_COMPARATOR, INTEGER, FLOAT, BOOLEAN));
        allowed.add(new TypeOperation(ORDER_COMPARATOR, FLOAT, FLOAT, BOOLEAN));
        allowed.add(new TypeOperation(ORDER_COMPARATOR, FLOAT, INTEGER, BOOLEAN));
        
        allowed.add(new TypeOperation("+", INTEGER, INTEGER, INTEGER));
        allowed.add(new TypeOperation("+", INTEGER, FLOAT, FLOAT));
        allowed.add(new TypeOperation("+", FLOAT, FLOAT, FLOAT));
        allowed.add(new TypeOperation("+", FLOAT, INTEGER, FLOAT));
        allowed.add(new TypeOperation("+", STRING, STRING, STRING));
        
        allowed.add(new TypeOperation(CALC_OPERATOR, INTEGER, INTEGER, INTEGER));
        allowed.add(new TypeOperation(CALC_OPERATOR, INTEGER, FLOAT, FLOAT));
        allowed.add(new TypeOperation(CALC_OPERATOR, FLOAT, FLOAT, FLOAT));
        allowed.add(new TypeOperation(CALC_OPERATOR, FLOAT, INTEGER, FLOAT));
    }
    
    public static TypeChecker getInstance() {
        return instance == null ? instance = new TypeChecker() : instance;
    }
    
    public Type checkOperation(String op, Type t1, Type t2) throws Exception {
        TypeOperation toCheck = new TypeOperation(op, t1, t2);
        for (TypeOperation to : allowed) {
            if (to.equals(toCheck)) {
                return to.returnType;
            }
        }
        throw new Exception("Type mismatch on " + op + " operation");
    }
    
    private static class TypeOperation {
        private String operator;
        private Type type1;
        private Type type2;
        private Type returnType;
        
        public TypeOperation(String operator, Type t1, Type t2) {
            this(operator, t1, t2, null);
        }
        
        public TypeOperation(String operator, Type t1, Type t2, Type ret) {
            this.operator = operator;
            this.type1 = t1;
            this.type2 = t2;
            this.returnType = ret;
        }
        
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof TypeOperation)) {
                return false;
            }
            TypeOperation to = (TypeOperation) o;
            return operator.equals(to.operator)
                && type1 == to.type1
                && type2 == to.type2;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 59 * hash + Objects.hashCode(this.operator);
            hash = 59 * hash + Objects.hashCode(this.type1);
            hash = 59 * hash + Objects.hashCode(this.type2);
            return hash;
        }
    }
}
