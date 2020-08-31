import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CourseTest {

	@Test
	void getNumAssignmentsTest() {
		Course science = new Course(7);
		if (science.getNumAssignments() != 7) {
			fail("Expected number of assignments to be 7, got " + science.getNumAssignments());
		}
		Course math = new Course(0);
		if (math.getNumAssignments() != -1) {
			fail("Assignments must be atleast 1, therefore expected -1, got " + math.getNumAssignments());

		}

	}

	@Test
	void addStudentTest() {
		Course cpsc211 = new Course(5);
		cpsc211.addStudent("Bill");
		cpsc211.addStudent("Ted");
		if (cpsc211.addStudent("Frank") != true) {
			fail("Expected true, Frank was not added yet, got " + cpsc211.addStudent("Frank"));
		}
		if (cpsc211.addStudent("Bill") != false) {
			fail("Bill was already added to the class, expected false, got " + cpsc211.addStudent("Bill"));
		}

	}

	@Test
	void removeStudentTest() {
		Course math = new Course(11);
		math.addStudent("Bill");
		math.addStudent("Ted");
		math.addStudent("Rufus");
		math.addStudent("Ferris");
		if (math.removeStudent("Bill") != true) {
			fail("Bill was enrolled in math class, therefore true was expected, got " + math.removeStudent("Bill"));

		}
		if (math.removeStudent("Cameron") != false) {
			fail("Cameron was not enrolled in math, therefore false was expected, got "
					+ math.removeStudent("Cameron"));
		}

	}

	@Test
	void isStudentEnrolledTest() {
		Course history = new Course(4);
		history.addStudent("Mike");
		if (history.isStudentEnrolled("Mike") != true) {
			fail("Mike was added to history, therefore true was expected, got " + history.isStudentEnrolled("Mike"));
		}
		if (history.isStudentEnrolled("Bill") != false) {
			fail("Bill was not added to history, therefore false was expected, got "
					+ history.isStudentEnrolled("Bill"));
		}

	}

	@Test
	void setStudentAssignmentGradeTest() {
		Course bio = new Course(5);
		if (bio.setStudentAssignmentGrade(3, 75, "Bill") != false) {
			fail("No students were assigned to class, therefore false was expected. Got "
					+ bio.setStudentAssignmentGrade(3, 75, "Bill"));
		}
		bio.addStudent("Ted");
		if (bio.setStudentAssignmentGrade(6, 65, "Ted") != false) {
			fail("Number of assignments was less than the assignment number desired. Expected " + (" false. Got ")
					+ bio.setStudentAssignmentGrade(6, 65, "Ted"));

		}

		if (bio.setStudentAssignmentGrade(0, 65, "Ted") != false) {
			fail("Assignment number was less than one, therfore false was expected. Got "
					+ bio.setStudentAssignmentGrade(0, 65, "Ted"));
		}
		if (bio.setStudentAssignmentGrade(3, -1, "Ted") != false) {
			fail("Grade was less than zero, therfore false was expected. Got "
					+ bio.setStudentAssignmentGrade(3, -1, "Ted"));
		}
		if (bio.setStudentAssignmentGrade(3, 99, "Ted") != true) {
			fail("Expected true. Got " + bio.setStudentAssignmentGrade(3, 99, "Ted"));
		}

	}

	@Test
	void getStudentAssignmentGradeTest() {
		Course science = new Course(8);
		science.addStudent("Steve");
		science.addStudent("Cody");
		science.addStudent("Noel");
		science.setStudentAssignmentGrade(2, 93, "Cody");
		if (science.getStudentAssignmentGrade(2, "Cody") != 93) {
			fail("Expected 93, got " + science.getStudentAssignmentGrade(2, "Cody"));

		}
		science.setStudentAssignmentGrade(2, 75, "Marcus");
		if (science.getStudentAssignmentGrade(2, "Marcus") != -1) {
			fail("Marcus was not enrolled in the class. expected -1 got"
					+ science.getStudentAssignmentGrade(2, "Marcus"));

		}
		science.setStudentAssignmentGrade(9, 69, "Steve");
		if (science.getStudentAssignmentGrade(9, "Steve") != -1) {
			fail("Assignment number greater than assignments. Expected -1 got "
					+ science.getStudentAssignmentGrade(9, "Steve"));
		}

		science.setStudentAssignmentGrade(0, 69, "Steve");
		if (science.getStudentAssignmentGrade(0, "Steve") != -1) {
			fail("Assignment number less than 1. Expected -1 got " + science.getStudentAssignmentGrade(0, "Steve"));
		}

	}

}
