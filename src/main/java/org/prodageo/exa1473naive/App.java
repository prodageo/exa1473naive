package org.prodageo.exa1473naive;
  
  public class App {
  
     static WordData[] words;
     static int wordCount;

     public static void main(String[] args) {
        words = new WordData[10];  // Start with space for 10 words.
        wordCount = 0;
        String[] in = { "Bus", "Car", "Train", "Train", "Plane" , "Car", "Bus", "Bus", "Plane"} ;
        
        for ( String a : in ) {
            insertWord(a);
        }
                
        /* Output the words in alphabetical order. */
        System.out.println("Words in alphabetical order, with the number of occurrences:");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
        
        displayWordList();
    }
  
     static void insertWord(String w) {
        int pos = 0;
        w = w.toLowerCase();
        
        while (pos < wordCount && words[pos].word.compareTo(w) < 0)
           pos++;
        if (pos < wordCount && words[pos].word.equals(w)) {
           words[pos].count++;
           return;
        }
        if (wordCount == words.length) {
           WordData[] newWords = new WordData[words.length*2];
           System.arraycopy(words,0,newWords,0,wordCount);
           words = newWords;
        }
        for (int i = wordCount; i > pos; i--)
           words[i] = words[i-1];
        words[pos] = new WordData(w);
        wordCount++;
     }
     
     static void displayWordList() {
         for (int i = 0; i < wordCount; i++) {
            System.out.print("   ");
            System.out.print(words[i].word);
            for (int space = words[i].word.length(); space < 15; space++)
            System.out.print(" ");
            System.out.print(" ");
            System.out.println(words[i].count);
         }
     }
  }

  class WordData {
     String word;   // The word (in lower case letters).
    int count;     // The number of times the word has been found.
    WordData(String w) {
        word = w;
        count = 1;
    }
  }
