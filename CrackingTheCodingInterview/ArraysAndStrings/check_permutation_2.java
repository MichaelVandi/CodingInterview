public static boolean isPermutation(String a, String b) {
    char[] charactersInA = a.toCharArray();
    char[] charactersInB = b.toCharArray();

    Arrays.sort(charactersInA);
    Arrays.sort(charactersInB);

    String sortedA = charArrayToString(charactersInA);
    String sortedB = charArrayToString(charactersInB);

    return sortedA.equals(sortedB);


}
public static String charArrayToString(char[] array) {
    StringBuilder sb = new StringBuilder();
    for (char c : array) {
        sb.add(c);
    }
    return sb.toString();
}

// A more optimal approach

public static boolean isPermutation2(String a, String b) {
    // Count the characters at each ascii index
    boolean[] ascii = new boolean[128];
    for (char ca : a.toCharArray()) {
        int asciiVal = (int) ca;
        ascii[asciiVal]++;
    }
    // Now iterate through ascii with b and subtract
    for (char cb : b.toCharArray()) {
        int asciiVal = (int) cb;
        ascii[asciiVal]--;
        if (ascii[asciiVal] < 0) return false;
    }
    return true;
}

