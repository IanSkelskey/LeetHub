import java.util.HashMap;
import java.lang.StringBuilder;

class Solution {
    private final HashMap<Integer, Character> romanValueMap = newRomanMap();
    
    private final StringBuilder roman = new StringBuilder();
    
    public String intToRoman(int num) {
        
        int count = 1;
        
        while(num > 0) {
            
            int currentDigit = num % 10;
            
            String temp = "";
            
            if (currentDigit % 5 == 0 && currentDigit != 0) {
                roman.insert(0, romanValueMap.get(count*5));
            } else if (currentDigit % 5 < 4) {
                for (int i = 0; i < currentDigit % 5; i ++) {
                    roman.insert(0, romanValueMap.get(count));
                }
                if (currentDigit > 5) {
                    roman.insert(0, romanValueMap.get(count*5));
                }
            } else if (currentDigit % 5 == 4) {
                if (currentDigit > 5) {
                    roman.insert(0, romanValueMap.get(count*10));
                } else {
                    roman.insert(0, romanValueMap.get(count*5));
                }
                roman.insert(0, romanValueMap.get(count));
            } 
            num /= 10;
            count *= 10;   
        }
        return roman.toString();
    }
    
    private HashMap<Integer, Character> newRomanMap() {
        HashMap<Integer, Character> map = new HashMap<>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');
        return map;
    }
}