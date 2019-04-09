package binarysringtree;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Author Surbhi khatri
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class binaryst  {
    decisionlogic d=new decisionlogic ();
    public String data;
    static int pscore=0,nscore=0;
    static String root;
    static ArrayList<String> value=new ArrayList<>();
    public binaryst left,right;
    static Queue<binaryst> q =new LinkedList<binaryst>(); 
          
        // Enqueue Root and initialize height 
        
    
 
    public binaryst() {
        this.data = null;
        this.left = null;
        this.right = null;
    }
     
    public binaryst(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
 
    public static binaryst createTree( String content ) {
        binaryst bstree = new binaryst();
        if( content != null ) {
           
            String[] words = content.split( " " );
            bstree = new binaryst();
            int i;
            for( i = 0; i< words.length; i++ ) { 
                bstree.addNode( words[i]);   
            }
        } 
        return bstree;
    }
    public void addNode(String data) {
        HashSet<String> neg=new HashSet<>();
        neg.add("bad");neg.add("rambling");neg.add("vague");neg.add("unsatisfactory");
        HashSet<String> pos=new HashSet<>();
        pos.add("good");pos.add("punchy");
        pos.add("beautifull");
        pos.add("eloquent");
        int n=0,p=0;
        if (this.data == null) {
            this.data = data;
            root=this.data;
        } 
        else{
            if(adj_in_dict(data,neg)==1){
                n++;
            }
            

            if(adj_in_dict(data,pos)==1){
                p++;
            }
            if(n>=1){
                if (this.left != null) {
                    this.left.addNode(data);
                } 
                else {
                    this.left = new binaryst(data);
                }
                
                
              
            }
            else 
                if(p>=1){
                    if (this.right != null) {
                        this.right.addNode(data);
                    } else {
                        this.right = new binaryst(data);
                    }
                    
               }
           
            else
                System.out.println("neither positive nor negative word");
             
           
        }
    }
    
    
        
    
    
    
    public void InOrder() {
        if (this.left != null) {
            this.left.InOrder();
            for(int k=0;k<value.size();k++){
                if(this.data.equals(value.get(k)) && !this.data.equals(root)){
                    nscore++;
                }
            }
        }

        if(this.left==null && this.right==null) { 
            for(int k=0;k<value.size();k++){
                if(this.data.equals(value.get(k))){
                    nscore=nscore+1;
                }
            }

        }
       
        if (this.right != null) {
            this.right.InOrder();
            for(int k=0;k<value.size();k++){
                if(this.data.equals(value.get(k))){
                    pscore++;
                }
            }
        }
        
    }
    
    public void decide(String content){
        if(d.findnot(content)==1){
            pscore--;
            nscore++;
        }
        
        System.out.println("positive score: " +pscore);
        System.out.println("negative score " +nscore);
        
        if(pscore>nscore)
            System.out.println("positive comment");
        else if(nscore>pscore)
            System.out.println("negative comment");
        else
            System.out.println("partial comment");
    }
 
 
    
    public int adj_in_dict(String content,HashSet<String> adjs){
        return d.adj_in_dict(content, adjs);
    }
    

    public int adj_in_string(String content,String[] adjs){
        return d.adj_in_string(content, adjs);
    }
  
    void printLevelOrder(binaryst root) {
        print p=new print();
        p.printLevelOrder(this);

    }
    
    
 }




