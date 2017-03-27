/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptogramclient;

import java.util.*;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author brian
 */
public class CryptogramClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
    cryptogram code = new cryptogram() ;
    
    File inputFile = new File("wish.txt");
    Scanner scan = new Scanner(inputFile);
    
    System.out.println(code) ;
    System.out.println() ;
    
    String line = "" ;
    String encodedLine = "" ;
    String decodedLine = "" ;
    
    while ( scan.hasNext() )
    {
      line = scan.nextLine() ;
      encodedLine = code.encrypt(line.toLowerCase() ) ;
      decodedLine = code.decrypt(encodedLine) ;
      
      System.out.println( "The original line is   \"" + line + "\"" ) ;
      
      System.out.println( "The encrypted phrase is\t \"" 
                           + encodedLine + "\"" ) ;
      System.out.println( "The decrypted phrase is\t \"" 
                           + decodedLine + "\"" ) ;
      System.out.println() ;
    }
    
    code.displayStatistics() ;
    }
    
}
