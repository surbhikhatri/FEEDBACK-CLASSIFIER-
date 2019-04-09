/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysringtree;

import java.util.Scanner;

/**
 *
 * @author Surbhi
 */

class demo {
    public static void main(String[] args)  {
        
        String[] adjs1={"good" , "punchy" , "unsatisfactory"  ,"beautifull", "rambling" , "vague",  "eloquent","bad"};
       
        Scanner sc=new Scanner(System.in);
        System.out.println("enter your comment");
        String input=sc.nextLine();
        
        
        binaryst dictionary =
                binaryst.createTree("good punchy unsatisfactory rambling vague eloquent bad beautifull");
        
        decisionlogic d=new decisionlogic();
        if((dictionary.adj_in_string(input,adjs1))==1){
            System.out.println("word present"); 
        }
        
        dictionary.InOrder();
        System.out.println("RESULT");
        dictionary.decide(input);
        dictionary.printLevelOrder(dictionary);
    }
}