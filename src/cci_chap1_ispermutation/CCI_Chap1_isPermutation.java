/*
 *  Check Permutation: Given two strings, write a method to decide if one is a 
    permutation of the other.
 */
package cci_chap1_ispermutation;

import java.util.*;

/**
 *
 * @author Ali
 */
public class CCI_Chap1_isPermutation 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        System.out.println(isPermutation("Ali Hassan", "Hassan Ali"));
    }
    
    private static boolean isPermutation(String str1, String str2)
    {
        Map<Character, Integer> map = new HashMap<>();
        
        str1 = str1.replaceAll("[^A-Za-z]+", "").toLowerCase();
        str2 = str2.replaceAll("[^A-Za-z]+", "").toLowerCase();
        int count = 0;
        
        if(str1.length() != str2.length())
            return false;
        
        for(int i=0; i<str1.length(); i++)
        {
            if(map.get(str1.charAt(i)) != null)
            {
                count = map.get(str1.charAt(i));
                count++;
                map.put(str1.charAt(i), count);
            }
            else
                map.put(str1.charAt(i), 1);
        }
        
        for(int i=0; i<str2.length(); i++)
        {
            if(map.get(str2.charAt(i)) == null)
                return false;
            count = map.get(str2.charAt(i));
            count--;
            map.put(str2.charAt(i), count);
        }
        
        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > 0)
                return false;
        }
        
        return true;
    }
    
}
