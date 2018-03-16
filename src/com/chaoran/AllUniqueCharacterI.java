package com.chaoran;

/**
 * Created by chaoranli on 3/11/18.
 * using very bit of a integer to record the "a" - "z"
 * get the index i of char in ASCII
 * shift bit_setter right for i position and & 1
 * case 1 : the res is 0, set i position in bit to 1
 * case 2 : return false
 * time comlexity: O(n);
 *space complexity: O(1);
 */
public class AllUniqueCharacterI {

    public boolean isUnique(String word) {
        /**

         */
        int bitMap = 0;
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (((bitMap >> k) & 1) == 0) {
                bitMap = 1 << k | bitMap;
            } else {
                return false;
            }
        }
        return true;
    }
}
