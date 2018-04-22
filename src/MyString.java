
public class MyString {
    private char[] value;   // characters
    private int offset;     // index of first char in array
    private int length;     // length of string
    private int hash;       // cache of hashCode()
    
    public int length() {
        return length;
    }
    
    public char charAt(int i) {
        return value[i + offset];
    }
    
    private MyString(int offset, int length, char[] value) {
        this.offset = offset;
        this.length = length;
        this.value = value;
    }
    
    public MyString substring(int from, int to) {
        return new MyString(offset + from, to - from, value);
    }
}
