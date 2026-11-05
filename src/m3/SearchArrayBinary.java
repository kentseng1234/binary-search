package m3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

// coursesupport timing libraries
import timing.ExecuteAlgorithm;
import timing.quiet.QuietAlgorithm;
import timing.Ticker;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class SearchArrayBinary extends SearchArrayBase {

    public SearchArrayBinary() {
    	Arrays.sort(this.array);
    }

    public SearchArrayBinary(int arraySize) {
    	super(arraySize);
    	Arrays.sort(this.array);
    }
    
    public SearchArrayBinary(int[] initArray) {
    	super(initArray);
    	Arrays.sort(this.array);
    }
    
	@Override
	public void reset(Ticker ticker) {
		this.ticker = ticker;
		this.array = generateRandomArray(this.n);
	   	numQueries = this.n * NUM_QUERIES_FACTOR;
    	Arrays.sort(this.array);
}
	
    @Override
    public String toString()  {
    	return "SearchArrayBinary object, n= " + this.n 
    			+ " numQueries=" + this.numQueries;
    }

    // return value: index of query in array if found, else -1
	@Override
	public int search(int query) {
		return binsearch(query,0, array.length-1);
	} 

	public int binsearch(int query, int low, int high){
		ticker.tick();
		if(low > high){
			return -1;
		}
		int mid = (low + high) / 2;
		if (array[mid] == query){
			return mid;
		}
		else if (array[mid] > query){
			return binsearch(query, low, mid-1);
		}
		else {
			return binsearch(query, mid+1, high);
		}
	}
		
		
		
		// TODO: Fill in code here to perform a binary search for
		//       the query in the array.
        

    public static void main(String[] args) {

    	GenSizes sizes = GenSizes.arithmetic(0, 200001, 20000);
//   	GenSizes sizes = GenSizes.geometric(1, 500001, 5);

    	ExecuteAlgorithm.timeAlgorithm("array-binary-search",
    			"m3.SearchArrayBinary",
    			new IntArrayGenerator(),
    			sizes);
    }
}
