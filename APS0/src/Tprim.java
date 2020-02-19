public enum Tprim {
    BOOL("bool"),// calls constructor with value "add"
    INT("int");// calls constructor with value "sub"

    public String getStr() {
        return str;
    }

    private String str;

    Tprim(String str) {
        this.str = str;
    }

    public String toString() {
        return this.str;
    }
}
