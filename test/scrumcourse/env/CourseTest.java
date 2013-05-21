package scrumcourse.env;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CourseTest {

	@Test
	public void createSimpleClass() throws Exception {
		Course course = new Course("maths");
		assertEquals("maths", course.getName());
	}

	// Needs env.college environment property with college name string
	// This test needs to be run with -Denv.college=Standford
	@Test
	public void collegeName() throws Exception {
		Course course = new Course("maths");
		assertEquals("Standford", course.getCollege());
		Course courseBerkeley = new Course("Berkeley", "maths");
		assertEquals("Berkeley", courseBerkeley.getCollege());
	}

	// A Short course has length less than 2 hours
	@Test
	public void shortCourse() throws Exception {
		Course course = new Course("maths");
		course.start();
		course.setTimeProvider(new Proveedor() {
			@Override
			public long getTime() {
				// TODO Auto-generated method stub
				return super.getTime() + 1_000_000_000L * 15;
			}
		});
		course.end();
		assertTrue(course.isShort());
		assertTrue(course.getDurationSeconds() > 10);
		assertTrue(course.getDurationSeconds() < 20);
	}

	// A long course has length greater than 2 hours
	@Test
	public void longCourse() throws Exception {
		Course course = new Course("maths");
		course.start();
		course.setTimeProvider(new Proveedor() {
			@Override
			public long getTime() {
				// TODO Auto-generated method stub
				return super.getTime() + 1_000_000_000L * 3600 * 2 + 1;
			}
		});
		course.end();
		assertTrue(course.isLong());
	}

	void sleepSeconds(long seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		}
	}
}
