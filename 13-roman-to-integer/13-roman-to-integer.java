import java.util.HashMap;

class Solution {
    
    private final HashMap<Character, Integer> romanValueMap = newRomanMap();
    private int currentRomanValue;
    private int nextRomanValue;
    
    public int romanToInt(String s) {
        int output = 0;
        if (s.length() == 1) {
            setCurrentRomanValue(s.charAt(0));
            return currentRomanValue;
        }
        for (int i = 0; i < s.length(); i++) {
            setCurrentRomanValue(s.charAt(i));
            if (i != s.length() - 1) {
                setNextRomanValue(s.charAt(i+1));
            }
            if (this.currentRomanValue < this.nextRomanValue) {
                output -= currentRomanValue;
            } else {
                output += currentRomanValue;
            }
        }
        return output;
    }
    
    private void setCurrentRomanValue(char c) {
        this.currentRomanValue = this.romanValueMap.get(c);
    }
    
    private void setNextRomanValue(char c) {
        this.nextRomanValue = this.romanValueMap.get(c);
    }
    
    private HashMap<Character, Integer> newRomanMap() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }
    
}