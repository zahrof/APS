public enum cBool {
    TRUE("true"),// calls constructor with value "add"
    FALSE("false");// calls constructor with value "sub"

    private String str;

    cBool(String str) {
        this.str = str;
    }

    public String toString() {
        return this.str;
    }
}
