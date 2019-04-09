/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysringtree;

/**
 *
 * @author Surbhi
 */
class Kmpads { 
 int match(String pat, String txt) 
    { 
        int M = pat.length(); 
        int N = txt.length(); 
  
        int pretab[] = new int[M]; 
        int j = 0; 
        int i = 0;
        while (i < N) { 
            if (pat.charAt(j) == txt.charAt(i)) { 
                j++; 
                i++; 
            } 
            if (j == M) { 
//                System.out.println("\n\nFound pattern "
//                                   + "at index " + (i - j)); 
                j = pretab[j - 1]; 
                return 1;
            } 
            else if (i < N && pat.charAt(j) != txt.charAt(i)) { 
 
                if (j != 0) 
                    j = pretab[j - 1]; 
                else
                    i = i + 1; 
            } 
        }
        return 0;
    } 
   
}