int LCS( int i, int j, String x, String y )
   {
      int sol1, sol2, sol3;

      if ( i == 0 || j == 0 )
      {
         /* -------------- ----------------------------
	    One of the strings has 0 character 
	      => no match possible
	    Longest common subsequence = 0 characters
	    ------------------------------------------- */       
         return(0);
          

      /* -------------------------------------------------
         Check if we have a Memoized solution *********
	 ------------------------------------------------- */
      if ( L[i][j] >= 0 )
                    
         return( L[i][j] );    // Return stored solution !!!
      }

      /* ------------------------------------------------------
         We wil l only   ru n   th e re cursive solver if we don't
         have the solution LCS(i,j) stored...
	 ------------------------------------------------------ */

      if ( x[
                    
         sol1 = LCS(i-1, j-1, x, y);
                  
         L[i][j] = sol1 + 1;      //
                  
      else
      {
         sol2 = LCS(i-1, j, x, y);
	 sol3 = LCS(i,  j-1,  x ,  y ) ;  
  
	 if ( sol2 >= sol3 )
	 {

            L[i][j] = sol2;       // SAVE the solution ******** 

	    return(sol2);
	 }
	 else
	 {

            L[i][j] = sol3;       // SAVE the solution ******** 

	    return(sol3);
	 }
      }
   }
