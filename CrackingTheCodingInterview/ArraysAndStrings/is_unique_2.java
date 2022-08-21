// First algo: increment a certain number



public static boolean isUnique(String str) {
    Set<Character> mySet = new HashSet<>();
    for (int i = 0; i < str.length; i++) {
        char ch = str.charAt(i);
        if (mySet.contains(ch)) return false;
        mySet.add(ch);
    }
    return true;
}

public static boolean isUnique(String str) {
    Set<Character> mySet = new HashSet<>();
    int stringLength = str.length();
    int counter = stringLength;
    for (int i = 0; i < str.length; i++) {
        char ch = str.charAt(i);
        if (mySet.contains(ch)) counter--;
        mySet.add(ch);
    }
    return counter == stringLength;
}

public static boolean isUnique(String str) {
    boolean[] contains = new boolean[128];
    for (int i = 0; i < str.length; i++) {
        int ascValue = str.charAt(i);
        if (contains[ascValue]) return false;
        contains[ascValue] = true;
    }
    return true;

}