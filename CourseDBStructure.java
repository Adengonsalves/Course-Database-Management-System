import java.util.ArrayList;
import java.util.LinkedList;
import java.io.*;


public class CourseDBStructure implements CourseDBStructureInterface {
	
	//this is an array of linked list
	 private LinkedList<CourseDBElement>[] table;
	 private int size;
	 private final double loadFactor = 1.5;
	 private String testing;
	 

	
	 public CourseDBStructure(int n)
	 {
		 //calculates the size of the array. 
		 int result = (int)(n/loadFactor);
		 size = nextPrime(result);
		 //sets the size of the array
		 table = new LinkedList[size];
	 }
	 
	 public CourseDBStructure(String testing,int n)
	 {
		 //TESTING PURPOSE
		 this.testing = testing;
		 int result = (int)(n/loadFactor);
		 size = nextPrime(result);
		 table = new LinkedList[size];
	 }
	 
	 
	 
	@Override
	public void add(CourseDBElement element) {
		
		//finds the hash of the crn for this element 
		int index = hashIndex(element.getCRN());
		
		//if array index is null, you create a new linked list at that index, and add the element
		if(table[index] == null)
		{
			 table[index] = new LinkedList<CourseDBElement>();
			 table[index].add(element);
			 return;
		}
		
		//when the array at the index already has a linked list and element,
		//this checks to see if the there already a class with the same crn, if not it adds the course
		for(CourseDBElement e: table[index])
		{
			if(element.getCRN() == e.getCRN())
			{
				//exit quietly tehe
				return;
			}
		}
		//adds the element to the end of the linked list
		table[index].add(element);
		
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		//finds the hash index
		int index = hashIndex(crn);
		if(table[index] == null)
		{
			 throw new IOException();
		}
		
		//loops through the linked list at that index, and checks each crn.
		for(CourseDBElement e: table[index])
		{
			if(crn == e.getCRN())
			{
				return e;
			}
		}
		//if nothing is found, throw execption, free throw that execption. 
		 throw new IOException();
		
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> arry = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			//if the index doenst have a linked list, move on!!!!! continue is a nice way of saying it in java 
		    if (table[i] == null) {
		        continue;
		    } else {
		        for (CourseDBElement e: table[i]) {
		            String temp = e.toString();
		            arry.add(temp);
		        }
		    }
		}
		return arry;

	}

	@Override
	public int getTableSize() {
		return size;
	}
	
	
	
	
	public int hashIndex(int crn)
	{
		//this method makes my life more simple. 
		//returns the hash index. String value mod by the size of the array
		int index = String.valueOf(crn).hashCode() % size;
		//if negiitive returns positive number
		return Math.abs(index);
	}
	
	
	 //calculates and finds the next 4k+3 prime number 
	public int nextPrime(int n) {
        int test = 4 * ((n + 3) / 4) + 3;
        while (!isPrime(test)) {
            test += 4;
        }
        return test;
    }

    //checks if is prime number, helps the method nextPrime
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
	 
	 
	 
	
	
	
	
	
	
	
	
	
	

}
