import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface{
	

	private CourseDBStructure data;
	
	public CourseDBManager() {
		//not to sure what size to pick, 22 is a cool number right??? its a seprate chaining, so collisons wont be a problem.
		//the word doc said the interface gives more instruction, but interface dont have anything. might be wrong lol
		data = new CourseDBStructure(22);
	}

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		//since the add method in DS class takes a object, we turn the param into a object. so we can use the DS class.
		CourseDBElement temp = new CourseDBElement(id,crn,credits, roomNum, instructor);
		data.add(temp);
	}

	@Override
	public CourseDBElement get(int crn){
		try {
			//try catch block because the interface class dont have a throw execption
			return data.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		 try {
			 //try catch block incase the file is not found. 
		Scanner scanner = new Scanner(input);
	        while (scanner.hasNextLine()) {
	        	//resets the array.
	        	String[] elements = null;
	        	//takes the first line and turns it into a string.
	            String courseInfo = scanner.nextLine();
	            //creates a string array, and adds each element after the space in the line 
	            elements = courseInfo.split(" ");
	            //if the file has elements in right order, first should be id then so fourth
	            String id = elements[0];
	            int crn = Integer.parseInt(elements[1]);
	            int credits = Integer.parseInt(elements[2]);
	            String roomNumber = elements[3];
	            //adds the first name, 
	            String instructorName = elements[4];
//	            since people can have a middle name or not, this loops, collects the remaining names
//	            that are left in the array. in theory the person can have 
//	            four middle names and the code will still run
	            for (int i = 5; i < elements.length; i++)
	            {
	                instructorName += " " + elements[i];
	            }
	            
	            
	            add(id, crn, credits, roomNumber, instructorName);
	            
	        }
	        scanner.close();
		 }catch(FileNotFoundException e) {
			 //if file is invalid or not found throws exection
	        	throw new FileNotFoundException();
	        }
	        
		
	}

	@Override
	public ArrayList<String> showAll() {
		return data.showAll();
	}

}
