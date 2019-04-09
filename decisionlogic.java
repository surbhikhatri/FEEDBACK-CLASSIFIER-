/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysringtree;

import static binarysringtree.binaryst.value;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author Surbhis
 */
public class decisionlogic implements Comparator<String>{
    public static int flag=0;

     
    public int findnot(String content){
        Kmpads kmp=new Kmpads();
        if(kmp.match("not",content)==1)
            flag=1;
        return flag;
    }
  
     public int compare(String a, String b) 
    { 
        if(a.compareTo(b)==0){
           return 1;
        }
        else
           return 0;
    } 
    
     
    public int adj_in_dict(String content,HashSet<String> adjs){
        
        int p=0,n=0;
        Iterator itr=adjs.iterator();
        while(itr.hasNext()){
            p=compare((String)itr.next(),content);
            if(p==1){
               return 1;
            }
        }
        return 0;
    }
     
    public int adj_in_string(String content,String[] adjs){
        Kmpads kmp=new Kmpads();
        int p=0,n=0;
        for(int i=0;i<adjs.length;i++){
            p=kmp.match(adjs[i],content);
            if(p==1){      
                value.add(adjs[i]);
            }
        }

        if(p>0)
            return 1;
        else
           return 0;
    
    }
}
