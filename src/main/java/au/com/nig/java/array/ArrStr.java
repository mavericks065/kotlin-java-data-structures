package au.com.nig.java.array;

public class ArrStr {
    public static String reverse(String input) {
        if (input == null) return "";

        var strBuf = new StringBuffer();
        String[] decomposedString = input.split("");
        for (int i = decomposedString.length - 1; i >= 0; i--) {
            strBuf.append(decomposedString[i]);
        }
        return strBuf.toString();
    }

    public static String reverseUsingJava(String input) {
        if (input == null) return "";
        return new StringBuffer(input).reverse().toString();
    }
}
