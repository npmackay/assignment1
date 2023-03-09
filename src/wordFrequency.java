
public class wordFrequency implements Comparable<wordFrequency> {
    //steps 8
    String curWord;
    Integer frequencyCounter;
/**
 * 
 * @param word
 * @param frequency
 */
    public wordFrequency(String word , Integer frequency )
    {
       curWord = word;
       frequencyCounter = frequency;

       
    }

    @Override 
    public String toString()
        {
            return " <tr><td>" +curWord + "</td><td> " + frequencyCounter +"</td></tr>" ;
        };
    /**
     * 
     * @return
     */
    public String getCurWord() {
        return curWord;
    }
    /**
     * 
     * @param curWord
     */
    public void setCurWord(String curWord) {
        this.curWord = curWord;
    }
    /**
     * 
     * @return
     */
    public Integer getFrequencyCounter() {
        return frequencyCounter;
    }
    /**
     * 
     * @param frequencyCounter
     */
    public void setFrequencyCounter(Integer frequencyCounter) {
        this.frequencyCounter = frequencyCounter;
    }

    @Override
    public int compareTo(wordFrequency nextWord)
    { // step 10
         int result = Integer.compare(this.frequencyCounter, nextWord.frequencyCounter);
        // If ages are equal, compare by name
        if (result == 0) {
            result = this.frequencyCounter.compareTo(nextWord.frequencyCounter);
        }
        return result;
        
    }
    
   
}
