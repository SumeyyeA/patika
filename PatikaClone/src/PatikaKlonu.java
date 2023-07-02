import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

public class PatikaKlonu{
	

	class Content {
		private String title;
	    private String description;
	    private String youtubeLink;
	    private List<String> quizQuestions;
	    private String lesson;

	    public Content(String title, String description, String youtubeLink, List<String> quizQuestions, String lesson) {
	        this.title = title;
	        this.description = description;
	        this.youtubeLink = youtubeLink;
	        this.quizQuestions = quizQuestions;
	        this.lesson = lesson;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public String getYoutubeLink() {
	        return youtubeLink;
	    }

	    public List<String> getQuizQuestions() {
	        return quizQuestions;
	    }

	    public String getLesson() {
	        return lesson;
	    }

	}

	class Instructor {
		private String name;
	    private List<Content> assignedContents;

	    public Instructor(String name) {
	        this.name = name;
	        this.assignedContents = new ArrayList<>();
	    }

	    public String getName() {
	        return name;
	    }

	    public List<Content> getAssignedContents() {
	        return assignedContents;
	    }

	    public void addContent(Content content) {
	        assignedContents.add(content);
	    }


	    public List<Content> filterContentsByLesson(String lesson) {
	        List<Content> filteredContents = new ArrayList<>();
	        for (Content content : assignedContents) {
	            if (content.getLesson().equals(lesson)) {
	                filteredContents.add(content);
	            }
	        }
	        return filteredContents;
	    }

	    public List<Content> filterContentsByTitle(String title) {
	        List<Content> filteredContents = new ArrayList<>();
	        for (Content content : assignedContents) {
	            if (content.getTitle().contains(title)) {
	                filteredContents.add(content);
	            }
	        }
	        return filteredContents;
	    }
	    
	    public void deleteContent(Content content) {
	        assignedContents.remove(content);
	    }
	    
	    

	    public void editContent(Content content, String newTitle, String newDescription, String newYoutubeLink, List<String> newQuizQuestions, String newLesson) {
	        content.setTitle(newTitle);
	        content.setDescription(newDescription);
	        content.setYoutubeLink(newYoutubeLink);
	        content.setQuizQuestions(newQuizQuestions);
	        content.setLesson(newLesson);
	    }
	}

	class Student {
		 private String name;
		    private List<String> enrolledCourses;

		    public Student(String name) {
		        this.name = name;
		        this.enrolledCourses = new ArrayList<>();
		    }

		    public String getName() {
		        return name;
		    }

		    public List<String> getEnrolledCourses() {
		        return enrolledCourses;
		    }

		    public void enrollCourse(String course) {
		        enrolledCourses.add(course);
		    }

		    public void viewCourseContents(Instructor instructor) {
		        System.out.println("Enrolled Courses for " + name + ":");
		        for (String course : enrolledCourses) {
		            System.out.println("Course: " + course);
		            System.out.println("Contents:");
		            for (Content content : instructor.getAssignedContents()) {
		                if (content.getLesson().equals(course)) {
		                    System.out.println("Title: " + content.getTitle());
		                    System.out.println("Description: " + content.getDescription());
		                    System.out.println("YouTube Link: " + content.getYoutubeLink());
		                    System.out.println("Quiz Questions: " + content.getQuizQuestions());
		                    System.out.println("-------------------------");
		                }
		            }
		            System.out.println();
		        }
		    }

		    public void evaluateContent(Content content, String evaluation) {
		        System.out.println("Evaluation for Content: " + content.getTitle());
		        System.out.println("Evaluation: " + evaluation);
		        System.out.println("-------------------------");
		    }

		    public void addComment(Content content, String comment) {
		        System.out.println("Comment for Content: " + content.getTitle());
		        System.out.println("Comment: " + comment);
		        System.out.println("-------------------------");
		    }

		    public void solveQuiz(Content content, List<String> answers) {
		        int correctAnswers = 0;
		        List<String> quizQuestions = content.getQuizQuestions();
		        for (int i = 0; i < quizQuestions.size(); i++) {
		            String correctAnswer = "A"; // Assuming the correct answer is always "A"
		            if (answers.get(i).equalsIgnoreCase(correctAnswer)) {
		                correctAnswers++;
		            }
		        }
		        System.out.println("Quiz Result for Content: " + content.getTitle());
		        System.out.println("Correct Answers: " + correctAnswers + "/" + quizQuestions.size());
		        System.out.println("-------------------------");
		    }
	}

	class Operator {
		 private List<Instructor> instructors;
		    private List<String> patikas;

		    public Operator() {
		        this.instructors = new ArrayList<>();
		        this.patikas = new ArrayList<>();
		    }

		    public void addInstructor(Instructor instructor) {
		        instructors.add(instructor);
		    }

		    public void addPatika(String patika) {
		        patikas.add(patika);
		    }

		    public void deleteContent(Content content) {
		        for (Instructor instructor : instructors) {
		            instructor.deleteContent(content);
		        }
		    }

		    public void editContent(Content content, String newTitle, String newDescription, String newYoutubeLink, List<String> newQuizQuestions, String newLesson) {
		        for (Instructor instructor : instructors) {
		            instructor.editContent(content, newTitle, newDescription, newYoutubeLink, newQuizQuestions, newLesson);
		        }
	    }

	    public static void main(String[] args) {
	        
	    	 Operator operator = new Operator();

	         Instructor instructor1 = new Instructor("John Doe");
	         Instructor instructor2 = new Instructor("Jane Smith");

	         operator.addInstructor(instructor1);
	         operator.addInstructor(instructor2);

	         operator.addPatika("Java 101");
	         operator.addPatika("Java 102");

	        Content content1 = new Content(
	                "Java 101 Introduction",
	                "Introduction to Java programming language",
	                "https://youtube.com/java101",
	                List.of("What is Java?", "Basic syntax"),
	                "Java 101"
	        );

	        Content content2 = new Content(
	                "Java 102 Loops",
	                "Introduction to loops in Java",
	                "https://youtube.com/java102",
	                List.of("What are loops?", "For loop example"),
	                "Java 102"
	        );

	        instructor1.addContent(content1);
	        instructor2.addContent(content2);

	        Student student1 = new Student("Alice");
	        Student student2 = new Student("Bob");
	        
	        // Student registration
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Welcome to PatikaKlonu!");

	        System.out.print("Do you have an account? (Y/N): ");
	        String answer = scanner.nextLine();

	        if (answer.equalsIgnoreCase("N")) {
	            System.out.print("Enter your name: ");
	            String name = scanner.nextLine();

	            Student newStudent = new Student(name);
	            patikaKlonu.addStudent(newStudent);
	            System.out.println("Registration successful. Welcome, " + name + "!");
	            System.out.println();
	        } else {
	            System.out.println("Please sign in with your existing account.");
	            System.out.println();
	        }

	        student1.enrollCourse("Java 101");
	        student2.enrollCourse("Java 102");

	        student1.viewCourseContents(instructor1);
	        student2.viewCourseContents(instructor2);

	        student1.evaluateContent(content1, "Good content");
	        student2.addComment(content2, "I found this topic challenging");

	        List<String> quizAnswers = List.of("A", "B"); // Assuming there are 2 quiz questions
	        student1.solveQuiz(content1, quizAnswers);
	        student2.solveQuiz(content2, quizAnswers);
	    }
	}
}
	
