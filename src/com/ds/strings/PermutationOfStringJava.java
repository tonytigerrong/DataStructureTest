package com.ds.strings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
 
public class PermutationOfStringJava {
 // 1 2 3  4  5  6 
 //   3 6 10 15 21
 public static void main(String[] args) {
 
     Set set=permutationOfString("ABC");
     System.out.println("Permutations of String ABC are:");
     for (Iterator iterator = set.iterator(); iterator.hasNext();) {
   String string = (String) iterator.next();
   System.out.println(string);   
  }
 }
 
 public static Set permutationOfString(String str)
 {
  Set permutationSet=new HashSet();
  
  if(str.length()==0)
  {
   permutationSet.add("");
            return permutationSet;
  }
   
  // take out first character of String
  char c=str.charAt(0);
  // Remaining String
  String rem=str.substring(1);
  
  
  Set permutatedSetForRemainingString=permutationOfString(rem);
  for (Object permutedString: permutatedSetForRemainingString) {
	  String permutedStr = (String) permutedString;
   for (int j = 0; j <= permutedStr.length(); j++) {
    String permutation=insertFirstCharAtDiffPlaces(permutedStr,c,j);
    permutationSet.add(permutation);
   }
    
  }
  return permutationSet;
  
 }
 public static String insertFirstCharAtDiffPlaces(String perm,char firstChar,int index)
 {
  // Inserting firstCharacter of orig String at difference places based on index
  return perm.substring(0,index)+firstChar+perm.substring(index);
 }
 
}
 