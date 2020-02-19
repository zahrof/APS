public enum FuncionType {
    CONST("const"),// calls constructor with value "add"
    FUN("fun");// calls constructor with value "sub"
    REC("fun rec")

    public String getStr() {
        return str;
    }

    private String str;

    FuncionType(String str) {
        this.str = str;
    }

    public String toString() {
        return this.str;
    }
}
