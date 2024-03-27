STUDENT MANAGEMENT SYSTEM

INTRODUCTION:
 A Student Management System is a software application designed to efficiently handle various aspects of managing students, address, courses, library resources, and staff in educational institutions such as schools, colleges, and universities. This system involves various database tables and their relationships to facilitate the management of students, address, courses, library resources, and staff. A key relationship in this system includes one-to-one relations between students and their addresses, one-to-one relations between staff and their addresses, many-to-one relations between courses and staff, and many-to-one relations between book issued and students, as well as book receives and students.

SYSTEM OVERVIEW:

•	Student: This stores information about each student including personal details and contact information. It has one-to-one relationship with the Address table to associate each student with their address.
•	Address: This contains data related to the address which stores the locations of both staff members and students.it facilitates the one-to-one relationships between staff and students, and their respective addresses.  
•	Course: This contains data related to the courses offered by the institution, such as course names, descriptions, and instructors. It has a many-to-one relationship with staff, as one staff member can be responsible for teaching multiple courses.
•	Library: Information regarding the books and other materials available at the library is kept on this table.
•	Book Issue: This record the book issued to students and has a many-to-one relationship with both the Student and Library tables, indicating that multiple books can be issued to a student from the library.
•	Book Reserve: This keeps track of books returned by students and also has a many-to-one relationship with both the Student and Library tables. 
•	Staff: Information about staff members, such as teachers and administrators, is stored in this table. Staff members are responsible for teaching courses and have a one-to-one relationship with the Address table to associate each staff member with their address, ensuring accurate address data for each staff member.

RESTFUL SERVICE:

1.	Student:
•	GET /studentList: Retrieves a list of all students.
•	GET /getStudentById/{studentId}: Retrieves information about a specific student by Id.
•	POST /saveStudent: Creates a new student.
•	DELETE /deleteStudentById/{studentId}: Delete student by Id.
•	UPDATE /updateStudentById/{studentId}: Update student by Id.

2.	Address:
•	GET /addressList: Retrieves a list of all address.
•	GET /getAddressById/{addressId}: Retrieves information about a specific address.
•	POST /saveAddress: Creates a new address.
•	DELETE /deleteAddressById/{addressId}: Delete address by Id.
•	UPDATE /updateAddressById/{addressId}: Update address by Id.

3.	Course:
•	GET /courseList: Retrieves a list of all courses.
•	GET /getCourseById/{courseId}: Retrieves information about a specific course.
•	POST /saveCourse: Creates a new course.
•	DELETE /deleteCourseById/{courseId}: Delete course by Id.
•	UPDATE /updateCourseById/{courseId}: Update course by Id.

4.	Book Issue:
•	GET / bookIssueList: Retrieves a list of all book Issue.
•	GET /getBookIssueById/{bookIssueId}: Retrieves information about a specific book Issue.
•	POST /saveBookIssue: Creates a new book Issue.
•	DELETE /deleteBookIssueById: Delete Book Issue by Id.
•	UPDATE /updateBookIssueById: Update Book Issue by Id.

5.	Book Receive:
•	GET /bookRecieveList: Retrieves a list of all books receive.
•	GET /getBookReceiveById/{bookReceiveId}: Retrieves information about a specific book recieve.
•	POST /saveBookReceive: Creates a new book receive.
•	DELETE /deleteBookReceiveById/{bookReceiveId}: Delete book receive by Id.
•	UPDATE /updateBookReceiveById/{bookReceiveId}: Update book receive by Id.
6.	Student Course:
•	GET/studentCourseList: Retrieves a list of all student courses.
•	GET/getStudentCourseById/ {studentCourseId}: Retrieves information about a specific student course.
•	POST/saveStudent: Creates a new student course
•	DELETE/deleteStudentCourseById/ {studentCourseId}: Delete student course by Id.
•	UPDATE /updateStudentCourseById/ {studentCourseId}: Update student course by Id.

7.	Staff:
•	GET /staffList: Retrieves a list of all staffs.
•	GET /getStaffById/{staffId}: Retrieves information about a specific staff.
•	POST /saveStaff: Creates a new staff.
•	DELETE /deleteStaffById/{staffId}: Delete staff by  Id.
•	UPDATE /updateStaffById/{staffId}: Update staff by  Id.

8.	Library:
•	GET /libraryList: Retrieves a list of all librarys.
•	GET /getLibraryById/{ibraryId}: Retrieves information about a specific library.
•	POST /saveLibrary: Creates a new library.
•	DELETE /deleteLibraryById/{ibraryId}: Delete library by Id.
•	UPDATE /updateLibraryById/{ibraryId}: Update library by Id.
      
TOOLS AND TECHNOLOGY:

•	Java Spring Boot: For building the backend server.
•	MySQL: As the database management system (MySQL Workbench).
•	Postman: To test API endpoints.
•	IntelliJ IDEA: As the Integrated Development Environment (IDE). 
