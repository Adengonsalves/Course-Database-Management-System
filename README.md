# Course-Database-Management-System
This project is a detailed course database management system built in Java. It efficiently manages course information using linked lists and hash tables, allowing for quick addition, retrieval, and display of course data. The system supports dynamic array sizing based on load factor, file input for bulk course data entry, and robust error handling for invalid data and file issues.

Key Features:
* Efficient Data Storage and Retrieval: Utilizes a hash table with separate chaining for quick and efficient storage and retrieval, dynamically adjusting the hash table size to maintain optimal performance.
  
* Robust File Handling: Reads and parses course information from text files accurately, adding it to the database with error handling to ensure reliability.
  
* User-Friendly Interface: Provides intuitive methods for adding courses, retrieving course details by CRN, and displaying all stored courses, making it accessible for all users.

* Scalability: Handles a large number of courses efficiently, suitable for institutions of all sizes, ensuring data integrity and quick access times.

Technical Highlights:

* Prime Number Utilization: Ensures efficient hash table sizing using prime numbers to reduce collisions and enhance performance.

* Separate Chaining: Uses separate chaining for collision handling in hash tables, simplifying the handling of hash conflicts.

* Comprehensive Data Parsing: Efficiently parses and processes input data, accommodating variations in input format.
