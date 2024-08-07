

/*
 * THIS IS A CLASS THAT IS THE DATA STRUCTURE OF THE COURSE DATABASE, THIS IS A ARRAY LINKED LIST, WHCIH USES HASHING TO ADD THE 
 * COURES IN THE ARRAY, THE METHOD OF HASHING IS SEPREATE CHAINING. YOU CAN ADD AND GET BY CRN AND ALSO GET AN ARRAY LIST OF ALL THE 
 * COURSES
 * HI MY NAME IS ADEN :) I AM THE AUTHOR 
 */






public class CourseDBElement implements Comparable {

	
	private String id;
	private int CRN;
	private int credits;
	private String roomNumber;
	private String instructorName;
	
	


	public CourseDBElement()
	{
		
	}



	public CourseDBElement(String id, int CRN, int credits, String roomNumber, String instructorName )
	{
		this.id = id;
		this.CRN = CRN;
		this.credits = credits;
		this.roomNumber = roomNumber;
		this.instructorName = instructorName;
	}
	
	
	

	public String toString()
	{
		return "Course:" + id + " CRN:" + CRN + " Instructor:" + instructorName + " Room:" + roomNumber;
	}
	
	
	
	



	@Override
	public int compareTo(Object o) {
		//Compared the crn, its the only one that make sense to compare. 
		 CourseDBElement other = (CourseDBElement) o;
		 if (this.CRN == other.getCRN())
		 {
			 return 0;
		 } 
		 else 
		 {
		    return -1;
		 }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//boring getters and setters club here far away from the cool class:
	public String getId() {
		return id;
	}


	public int getCRN() {
		return CRN;
	}


	public int getCredits() {
		return credits;
	}


	public String getRoomNumber() {
		return roomNumber;
	}

	public String getInstructorName() {
		return instructorName;
	}


	public void setCRN(int crn)
	{
		this.CRN = crn;
	}


	public void setId(String id) {
		this.id = id;
	}


	public void setCredits(int credits) {
		this.credits = credits;
	}


	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}


	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	

}
