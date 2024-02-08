/** Represnts a list of musical tracks. The list has a maximum capacity (int),
 *  and an actual size (number of tracks in the list, an int). */
class PlayList {
    private Track[] tracks;  // Array of tracks (Track objects)   
    private int maxSize;     // Maximum number of tracks in the array
    private int size;        // Actual number of tracks in the array

    /** Constructs an empty play list with a maximum number of tracks. */ 
    public PlayList(int maxSize) {
        this.maxSize = maxSize;
        tracks = new Track[maxSize];
        size = 0;
    }

    /** Returns the maximum size of this play list. */ 
    public int getMaxSize() 
    {
        return maxSize;
    }
    
    /** Returns the current number of tracks in this play list. */ 
    public int getSize() {
        return size;
    }

    /** Method to get a track by index */
    public Track getTrack(int index) {
        if (index >= 0 && index < size) {
            return tracks[index];
        } else {
            return null;
        }
    }
    
    /** Appends the given track to the end of this list. 
     *  If the list is full, does nothing and returns false.
     *  Otherwise, appends the track and returns true. */
    public boolean add(Track track) {
        //// replace the following statement with your code
        if (this.getSize() == this.getMaxSize()) 
        {
            return false;
        }
        else 
        {
            int num = this.getSize(); 
            tracks[num] = track;
            size ++ ;
            return true;
        }
       
    }

    /** Returns the data of this list, as a string. Each track appears in a separate line. */
    //// For an efficient implementation, use StringBuilder.
    public String toString() 
    {
        //// replace the following statement with your code
        String textp = ""; 
        for(int i = 0 ; i < maxSize ; i ++)
        {
            textp =  textp + tracks[i].toString() + "\n" ;
        }
        return textp;
    }

    /** Removes the last track from this list. If the list is empty, does nothing. */
     public void removeLast() 
     {
        //// replace this comment with your code
        if (this.getSize() > 0)
        {
            tracks[this.getSize()-1] = null;
            size -- ;
        }
    }
    
    /** Returns the total duration (in seconds) of all the tracks in this list.*/
    public int totalDuration() 
    {
        //// replace the following statement with your code
        int totalduration = 0 ; 
        for ( int i = 0 ; i < this.getMaxSize() ; i ++)
        {
             totalduration += tracks[i].getDuration() ; 
        }

        return totalduration;
    }

    /** Returns the index of the track with the given title in this list.
     *  If such a track is not found, returns -1. */
    public int indexOf(String title) 
    {
        int indexN = -1 ; 
        for ( int i =0 ; i < this.getMaxSize() ; i ++ )
        {
            if (tracks[i].getTitle().equals(title))
            {
                indexN = i ; 
                return indexN ; 
            } 
        }

        return -1;
    }

    /** Inserts the given track in index i of this list. For example, if the list is
     *  (t5, t3, t1), then just after add(1,t4) the list becomes (t5, t4, t3, t1).
     *  If the list is the empty list (), then just after add(0,t3) it becomes (t3).
     *  If i is negative or greater than the size of this list, or if the list
     *  is full, does nothing and returns false. Otherwise, inserts the track and
     *  returns true. */
    public boolean add(int i, Track track)
     {
        if (this.getSize()== this.getMaxSize() || i < 0 || i >= this.getMaxSize())
        {
            return false;
        }

        if (this.getSize() == 0 )
        {
            tracks[0]= track ; 
            return true; 
        }
        else 
        {

           for ( int j = this.getSize() - 1; j > i ; j --)
           {
                tracks[j+1] = tracks[j]; 
           }
        
            tracks[i]= track; 
            size ++ ;
            return true;
        }
        
       
    }
     
    /** Removes the track in the given index from this list.
     *  If the list is empty, or the given index is negative or too big for this list, 
     *  does nothing and returns -1. */
    public void remove(int i) 
    {
        if ( i > 0 && this.getSize() != 0 && i < this.getMaxSize())
        {
            this.tracks[i] = null;
            size -- ;
        } 
        
    }


    

    /** Removes the first track that has the given title from this list.
     *  If such a track is not found, or the list is empty, or the given index
     *  is negative or too big for this list, does nothing. */
    public void remove(String title) 
    { 
        if ( this.getSize() != 0 && indexOf(title) != -1)
        {

            for ( int i = 0 ; i < this.getMaxSize(); i ++)
                        {
                            if (this.tracks[i].getTitle().equals(title) == true)
                            {
                                this.tracks[i]= null; 
                                size -- ;
                            }
                        }
             
        }
        
    }

    /** Removes the first track from this list. If the list is empty, does nothing. */
    public void removeFirst() 
    {
        if (this.getSize() >0 )
        {
            this.tracks[0]= null; 
            size -- ;
        }
    }
    
    /** Adds all the tracks in the other list to the end of this list. 
     * If the total size of both lists is too large, does nothing. */
    //// An elegant and terribly inefficient implementation.
     public void add(PlayList other) 
    {   
        
        int j = 0; 
        if ( this.getMaxSize() + other.getMaxSize() < this.getMaxSize())
        {
            for ( int i =this.getSize() ; i < this.getMaxSize() ; i ++ )
            { 
              add(i,other.tracks[j]); 
              j ++ ;
            }
        }
    }

    /** Returns the index in this list of the track that has the shortest duration,
     *  starting the search in location start. For example, if the durations are 
     *  7, 1, 6, 7, 5, 8, 7, then min(2) returns 4, since this the index of the 
     *  minimum value (5) when starting the search from index 2.  
     *  If start is negative or greater than size - 1, returns -1.
     */
    private int minIndex(int start) 
    {   
         
        int indexMin = 0; 
        if ( start > 0 && start < this.getMaxSize() )
        {
           int minimum = this.tracks[start].getDuration() ;
           for ( int i = start; i < this.getMaxSize() ; i ++ )
           {
               if (this.tracks[i].getDuration() < minimum)
               {
                  indexMin = i ; 
               }
           }
           return indexMin ; 
        }
        else
        {
            return -1; 
        }
        
    }

    /** Returns the title of the shortest track in this list. 
     *  If the list is empty, returns null. */
    public String titleOfShortestTrack() 
    {   
        
        String nameTitle = ""; 
        if ( this.getSize() != 0 )
        {  
             int lengthTitle = this.tracks[0].getTitle().length() ; 
             for ( int i = 0 ; i < this.getMaxSize(); i ++)
             {
                if ( this.tracks[i].getTitle().length() < lengthTitle)
                {
                   nameTitle = this.tracks[i].getTitle() ; 
                }
             }

             return nameTitle;
        }
         else 
         {
            return null ; 
         }
       
    }

    /** Sorts this list by increasing duration order: Tracks with shorter
     *  durations will appear first. The sort is done in-place. In other words,
     *  rather than returning a new, sorted playlist, the method sorts
     *  the list on which it was called (this list). */
    public void sortedInPlace() 
    {
        // Uses the selection sort algorithm,  
        // calling the minIndex method in each iteration.
        //// replace this statement with your code
        
        int indexNew = 0 ; 
        for ( int i = 0 ; i < this.getMaxSize() ; i ++)
        {   

            for (int j = 0; j < this.getMaxSize(); j ++)
            {
                indexNew = minIndex(j);             
            }
            Track track1 = new Track(this.tracks[i].getTitle(), this.tracks[i].getArtist(), this.tracks[i].getDuration());
            tracks[i] = tracks[indexNew] ; 
            tracks[indexNew] = track1 ;

        }
    
    }
}
