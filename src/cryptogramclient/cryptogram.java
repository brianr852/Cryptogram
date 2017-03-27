/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptogramclient;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author brian
 */
public class cryptogram {
     private final char [] ALPHABET = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 
    'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
    'w', 'x', 'y', 'z' } ;
  
  private char [] cryptCode ;
  private int [] letterCounter ; 
  
  
  
  //default constructor
  public cryptogram ( )
  {
    this.cryptCode = new char [this.ALPHABET.length] ;
    this.letterCounter = new int [this.ALPHABET.length] ;
    
    setCryptCode() ;
  }
  
  //mutator
  public void setCryptCode ( )
  {
    for ( int i = 0 ; i < this.cryptCode.length ; i++ )
    {
      this.cryptCode[i] = this.ALPHABET[i] ;
    }
    
    Random rand = new Random() ;
    
    char temp ;
    
    for ( int i = 0 ; i < this.cryptCode.length ; i++ )
    {
      int randIndex = rand.nextInt(this.cryptCode.length) ;
      temp = this.cryptCode[i] ;
      this.cryptCode[i] = this.cryptCode[randIndex] ;
      this.cryptCode[randIndex] = temp ;
    }
  }
  
  //takes char passed from encrypt and returns the index of that char
  //in ALPHABET
  public int findLetterInAlphabet ( char letter )
  {
    final int NOT_FOUND = -1 ;
    int index = NOT_FOUND ;
    for ( int i = 0 ; i < this.ALPHABET.length && index == NOT_FOUND; i++ )
    {
      if ( this.ALPHABET[i] == letter )
      {
        index = i ;
      }
    } 
    return index ;
  }
  
  //encrypts string passed from client
  public String encrypt ( String encode )
  {
    String input = "" + encode ;
    String output = "" ;
    
    for ( int i = 0 ; i < input.length() ; i++ )
    {
      int index = findLetterInAlphabet(input.charAt(i)) ;
      
      if ( index == -1 )
        output += input.charAt(i) ;
      else
      {
        output += this.cryptCode[index] ; 
        this.letterCounter[index] += 1 ;
      }
    }
    return output;
  }
  
  //takes char passed from decrypt and returns the index of that char
  //in cryptCode
  public int findLetterInCryptCode ( char letter )
  {
    final int NOT_FOUND = -1 ;
    int index = NOT_FOUND ;
    for ( int i = 0; i < this.cryptCode.length && index == NOT_FOUND; i++ )
    {
      if ( this.cryptCode[i] == letter )
      {
        index = i ;
      }
    } 
    return index ;
  }
  
  //decrypts string passed from client
  public String decrypt ( String decode )
  {
    String input = "" + decode ;
    String output = "" ;
    
    for ( int i = 0 ; i < input.length() ; i++ )
    {
      int index = findLetterInCryptCode(input.charAt(i)) ;
      
      if ( index == -1 )
        output += input.charAt(i) ;
      else
        output += this.ALPHABET[index] ; 
    }
    return output;
  } 
  
  //displays the number of occurrences of each leter
  public void displayStatistics ( )
  {
    DecimalFormat percentPattern = new DecimalFormat ( "#0.0%" ) ;
    
    int total = 0 ;
    for ( int i =  0 ; i < this.letterCounter.length ; i++ )
    {
      total += this.letterCounter[i] ;
    }    
    
    System.out.println( "*** The following are frequencies of each letter in the file ***"
                      + total ) ;
    
    for ( int i =  0 ; i < this.letterCounter.length ; i++ )
    {
      double percent = ( double )( this.letterCounter[i] ) / total ;
      System.out.print( this.ALPHABET[i] + " -> " + this.letterCounter[i] + " -> " 
                         + percentPattern.format(percent) ) ;
      System.out.println() ;
    }
  }
  
  //toString method
  public String toString ( )
  {
    String alphabet = "" ;
    String cryptCode = "" ;
    
    for ( int i = 0 ; i < this.ALPHABET.length ; i++ )
    {
      alphabet += this.ALPHABET[i] + " " ;
    }
    
    for ( int i = 0 ; i < this.cryptCode.length ; i++ )
    {
      cryptCode += this.cryptCode[i] + " " ;
    }
    return "Alphabet  : " + alphabet 
      + "\nCryptcode : " + cryptCode ;
  }  
    
}
