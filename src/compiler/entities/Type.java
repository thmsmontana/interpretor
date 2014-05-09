package compiler.entities;

public enum Type {
    BOOLEAN,
    INTEGER,
    FLOAT,
    STRING
}


public String toString() {
	switch (type) {
	case BOOLEAN:
		return "bool";
	case INTEGER:
		return "int";
	case FLOAT:
		return "float";
	case STRING:
		return "str";
	default:
		return "unknown";
	}
}