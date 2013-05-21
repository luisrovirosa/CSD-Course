package scrumcourse.env;

public class Course {

	private static final long NANOS_PER_SECONDS = 1_000_000_000L;

	private static final long SECONDS_PER_HOUR = 3600;

	private final String name;

	private long startTime, endTime;

	private long durationSeconds;

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getCollege() {
		return System.getProperty("env.college");
	}

	public void start() {
		start(System.nanoTime());
	}

	public void start(long _startTime) {
		startTime = _startTime;
	}

	public void end() {
		end(System.nanoTime());
	}

	public void end(long endTime) {
		durationSeconds = (endTime - startTime) / NANOS_PER_SECONDS;
	}

	public boolean isShort() {
		return durationSeconds < 2 * SECONDS_PER_HOUR;
	}

	public boolean isLong() {
		return !isShort();
	}

	public long getDurationSeconds() {
		return durationSeconds;
	}

}
