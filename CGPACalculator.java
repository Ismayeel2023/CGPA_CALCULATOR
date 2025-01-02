import java.util.*;

public class CGPACalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = sc.nextInt();

        System.out.print("Enter the number of subjects: ");
        int numSubjects = sc.nextInt();

        int[][] marks = new int[numStudents][numSubjects];
        int[] credits = new int[numSubjects];
        String[][] grades = new String[numStudents][numSubjects];
        float[] cgpa = new float[numStudents];

        System.out.println("\nEnter credits for each subject:");
        for (int j = 0; j < numSubjects; j++) {
            System.out.print("Enter credits for Subject " + (j + 1) + ": ");
            credits[j] = sc.nextInt();
        }

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter marks for Subject " + (j + 1) + " (out of 100): ");
                marks[i][j] = sc.nextInt();
            }
        }

        for (int j = 0; j < numSubjects; j++) {
            int[] subjectMarks = new int[numStudents];
            for (int i = 0; i < numStudents; i++) {
                subjectMarks[i] = marks[i][j];
            }
            Arrays.sort(subjectMarks);
            int median = subjectMarks[numStudents / 2];

            for (int i = 0; i < numStudents; i++) {
                grades[i][j] = calculateRelativeGrade(marks[i][j], median);
            }
        }

        for (int i = 0; i < numStudents; i++) {
            float totalGradePoints = 0;
            int totalCredits = 0;
            for (int j = 0; j < numSubjects; j++) {
                int gradePoint = calculateGradePoint(grades[i][j]);
                totalGradePoints += gradePoint * credits[j];
                totalCredits += credits[j];
            }
            cgpa[i] = totalCredits > 0 ? totalGradePoints / totalCredits : 0;
        }

        System.out.println("\nFinal Results");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + " Results:");
            for (int j = 0; j < numSubjects; j++) {
                System.out.println("Subject " + (j + 1) + " | Credits: " + credits[j] + " | Grade: " + grades[i][j]);
            }
            System.out.printf("CGPA: %.2f\n", cgpa[i]);
            if (hasArrear(grades[i])) {
                System.out.println("Result: FAIL (Arrears Present)");
            } else {
                System.out.println("Result: PASS");
            }
        }

        System.out.println("\n Grade Points Reference ");
        System.out.println("O: 10");
        System.out.println("A+: 9");
        System.out.println("A: 8");
        System.out.println("B+: 7");
        System.out.println("B: 6");
        System.out.println("C: 5");
        System.out.println("U/R: 0");

        sc.close();
    }

    public static String calculateRelativeGrade(int marks, int median) {
        if (marks >= median + 20) return "O";
        if (marks >= median + 10) return "A+";
        if (marks >= median) return "A";
        if (marks >= median - 10) return "B+";
        if (marks >= median - 20) return "B";
        if (marks >= median - 30) return "C";
        return "U/R";
    }

    public static int calculateGradePoint(String grade) {
        switch (grade) {
            case "O": return 10;
            case "A+": return 9;
            case "A": return 8;
            case "B+": return 7;
            case "B": return 6;
            case "C": return 5;
            default: return 0;
        }
    }

    public static boolean hasArrear(String[] grades) {
        for (String grade : grades) {
            if (grade.equals("U/R")) {
                return true;
            }
        }
        return false;
    }
}
