package scrumcourse.env;

public class Course {

	private static final long NANOS_PER_SECONDS = 1_000_000_000L;

	private static final long SECONDS_PER_HOUR = 3600;

	private final String name;

	private long startTime, endTime;

	private long durationSeconds;

	Proveedor proveedor;

	public Course(String name) {
		this.name = name;
		proveedor = new Proveedor();
	}

	public String getName() {
		return name;
	}

	public String getCollege() {
		return System.getProperty("env.college");
	}

	public void start() {
		startTime = proveedor.getTime();
	}

	public void end() {
		endTime = proveedor.getTime();
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

	public void setTimeProvider(Proveedor _proveedor) {
		proveedor = _proveedor;
	}
}
