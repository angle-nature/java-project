package pojo;

public class InputOptionValue<E> {
    private String str=null;
    private E value;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public InputOptionValue(String str, E value) {
        this.str = str;
        this.value = value;
    }
}
