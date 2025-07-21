interface ICertifiable {
    String generateCertificate();
}

abstract class User {
    protected String name;
    protected String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public abstract void displayProfile();
}

class Student extends User {
    private int progress; // percentage
    private char grade;

    public Student(String name, String email) {
        super(name, email);
        this.progress = 0;
    }

    public void updateProgress(int percent) {
        this.progress = Math.min(100, progress + percent);
    }

    public void assignGrade(char grade) {
        this.grade = grade;
    }

    public int getProgress() {
        return progress;
    }

    public char getGrade() {
        return grade;
    }

    @Override
    public void displayProfile() {
        System.out.println("Student: " + name + ", Email: " + email);
    }
}

class Instructor extends User {
    private String expertise;

    public Instructor(String name, String email, String expertise) {
        super(name, email);
        this.expertise = expertise;
    }

    public String getExpertise() {
        return expertise;
    }

    @Override
    public void displayProfile() {
        System.out.println("Instructor: " + name + ", Expertise: " + expertise);
    }
}


import java.util.*;

abstract class Course implements ICertifiable {
    protected String title;
    protected Instructor instructor;
    protected List<String> modules;
    private double rating;
    private final List<String> internalReviews; // read-only outside

    // Default modules constructor
    public Course(String title, Instructor instructor) {
        this.title = title;
        this.instructor = instructor;
        this.modules = Arrays.asList("Introduction", "Core Concepts", "Final Project");
        this.internalReviews = new ArrayList<>();
        this.rating = 0.0;
    }

    // Custom modules constructor
    public Course(String title, Instructor instructor, List<String> modules) {
        this.title = title;
        this.instructor = instructor;
        this.modules = modules;
        this.internalReviews = new ArrayList<>();
        this.rating = 0.0;
    }

    // Encapsulation for rating logic
    public void addRating(double newRating) {
        if (newRating >= 0 && newRating <= 5) {
            this.rating = (this.rating + newRating) / 2.0;
        }
    }

    public double getRating() {
        return rating;
    }

    // Read-only access to internal reviews
    public List<String> getInternalReviews() {
        return Collections.unmodifiableList(internalReviews);
    }

    protected void addInternalReview(String review) {
        internalReviews.add(review);
    }

    // Abstract method for polymorphism
    public abstract String generateCertificate();
}

class BeginnerCourse extends Course {
    public BeginnerCourse(String title, Instructor instructor, List<String> modules) {
        super(title, instructor, modules);
    }

    @Override
    public String generateCertificate() {
        return "Certificate of Completion - Beginner Level\nCourse: " + title;
    }
}

class AdvancedCourse extends Course {
    public AdvancedCourse(String title, Instructor instructor, List<String> modules) {
        super(title, instructor, modules);
    }

    @Override
    public String generateCertificate() {
        return "Certificate of Mastery - Advanced Level\nCourse: " + title;
    }
}

public class SkillForgeApp {
    public static void main(String[] args) {
        Instructor instructor = new Instructor("Dr. Sharma", "sharma@skillforge.com", "AI/ML");

        List<String> advModules = Arrays.asList("Neural Networks", "CNNs", "RNNs");
        Course advancedCourse = new AdvancedCourse("Deep Learning", instructor, advModules);

        Student student = new Student("Piyush", "piyush@student.com");
        student.updateProgress(40);
        student.updateProgress(60); // now 100%
        student.assignGrade('A');

        advancedCourse.addRating(4.5);
        advancedCourse.addRating(5.0);
        advancedCourse.addInternalReview("Well structured and hands-on!");

        System.out.println("Course: " + advancedCourse.title);
        System.out.println("Instructor: " + advancedCourse.instructor.name);
        System.out.println("Modules: " + advancedCourse.modules);
        System.out.println("Rating: " + advancedCourse.getRating());
        System.out.println("Reviews: " + advancedCourse.getInternalReviews());
        System.out.println();

        student.displayProfile();
        System.out.println("Progress: " + student.getProgress() + "%");
        System.out.println("Grade: " + student.getGrade());
        System.out.println();

        // Polymorphic certificate
        System.out.println(advancedCourse.generateCertificate());
    }
}

