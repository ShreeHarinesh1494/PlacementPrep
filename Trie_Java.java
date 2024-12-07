Online GDP : - https://onlinegdb.com/6QHJvHQsB

import java.util.*;
public class Main
{
    static class Node
    {
        Node children[];
        boolean eow;
        
        public Node()
        {
            children = new Node[26];
            for(int i=0;i<26;i++)
            {
                children[i] = null;
            }
            eow = false;
        }
        
    }
        static Node root = new Node();
    
    static public void insert(String word)
    {
        Node curr = root;
        for(int i=0;i<word.length();i++)
        {
            int index = word.charAt(i) -'a';
            
            if(curr.children[index] == null)
            {
                curr.children[index] = new Node();
            }
            
            if(i == word.length()-1)
            {
                curr.eow = true;
            }
            
            curr = curr.children[index];
        }
    }
    
    static public boolean search(String word)
    {
        Node curr = root;
        for(int i=0;i<word.length();i++)
        {
            int index = word.charAt(i)-'a';
            
            if(curr.children[index]==null)
            {
                return false;
            }

            if(i==word.length()-1 && curr.eow == false)
            {
                return false;
            }
            
            curr = curr.children[index];
            
        }
        
        return true;
    }
    
    static public boolean wordbreak(String word)
    {
        if(word.length()==0)
        {
            return true;
        }
        
        for(int i=1;i<=word.length();i++)
        {
            String firstpart = word.substring(0,i);
            String secondpart = word.substring(i,word.length());
            
            if(search(firstpart) && wordbreak(secondpart))
            {
                return true;
            }
        }
        
        return false;
    }
    
    static boolean startswith(String word)
    {
        // if(word.length()==0)
        // {
        //     return true;
        // }
        
        // for(int i=1;i<=word.length();i++)
        // {
        //     String firstpart = word.substring(0,i);
            
        //     if(!search(firstpart))
        //     {
        //         return false;
        //     }
        // }
        
        // return true;
        
        Node curr = root;
        if(word.length() == 0)
        {
            return true;
        }
        
        for(int i=0;i<word.length();i++)
        {
            int index = word.charAt(i) - 'a';
            
            if(curr.children[index] == null)
            {
                return false;
            }
            
            curr = curr.children[index];
        }
        
        return true;
    }
    
	public static void main(String[] args) 
	{
		String words[] = {"the","a","there","their","any"};
		for(int i=0;i<words.length;i++)
		{
		    insert(words[i]);
		}
		
		System.out.println("Word exists : "+search("thes"));
		System.out.println("Word exists : "+wordbreak("thereanyw"));
		System.out.println("Word exists : "+startswith("an"));
	}
}
