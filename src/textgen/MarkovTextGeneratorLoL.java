package textgen;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		if(!sourceText.isEmpty())
		{
		String[] words =sourceText.split("[\\s]+");
		starter= words[0];
		String prevword=starter;
		
		ListNode fw= new ListNode(starter);
		wordList.add(fw);
		for(int i=1;i<words.length;i++)
		{
			ListNode n=findWord(prevword);
			if(n!=null)
			{
				//System.out.println(n.toString());
				n.addNextWord(words[i]);
			}
			else
			{
				ListNode w= new ListNode(prevword);
			    wordList.add(w);
			    w.addNextWord(words[i]);
			}
			prevword= words[i];
		}
		ListNode w= new ListNode(prevword);
	    wordList.add(w);

		((LinkedList<ListNode>) wordList).getLast().addNextWord(starter);
		}
		//for(ListNode n: wordList)
		//	System.out.println(n.toString());
		// TODO: Implement this method
	}
	
	private ListNode findWord(String word)
	{
		for(ListNode n: wordList)
		{
			if(n.getWord().equals(word))
				return n;
		}
		return null;
	}
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
		String output="";
		if(starter=="" || wordList.isEmpty() || numWords==0)
			return output;
		String curWord= starter;
		
		output+=curWord;
		numWords--;
		while(numWords>0)
		{
			ListNode w= findWord(curWord);
			String nw=w.getRandomNextWord(rnGenerator);
			output+=" "+ nw;
			curWord=nw;
			numWords--;
		}
	    // TODO: Implement this method
		return output;
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		String[] words =sourceText.split("[[\\s]+]+");
		starter= words[0];
		String prevword=starter;
		
		ListNode fw= new ListNode(starter);
		wordList.add(fw);
		for(int i=1;i<words.length;i++)
		{
			ListNode n=findWord(prevword);
			if(n!=null)
			{
				//System.out.println(n.toString());
				n.addNextWord(words[i]);
			}
			else
			{
				ListNode w= new ListNode(prevword);
			    wordList.add(w);
			    w.addNextWord(words[i]);
			}
			prevword= words[i];
		}
		ListNode w= new ListNode(prevword);
	    wordList.add(w);

		((LinkedList<ListNode>) wordList).getLast().addNextWord(starter);

		// TODO: Implement this method.
	}
	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		System.out.println(textString);
		gen.train(textString);
		System.out.println(gen);
	    System.out.println(gen.generateText(0));
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		System.out.println(textString2);
		gen.retrain(textString2);
		System.out.println(gen);
		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		//int s=0;
		int e=nextWords.size();
		int range=e;
		int frac=(int)(range* generator.nextDouble());
		int randomno=(int)(frac);
		
		
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
	    return nextWords.get(randomno);
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


