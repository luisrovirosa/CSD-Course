package scrumcourse.env;

public class Course {

	private static final long NANOS_PER_SECONDS = 1_000_000_000L;

	private static final long SECONDS_PER_HOUR = 3600;

	private String name;

	private long startTime, endTime;

	private long durationSeconds;

	Proveedor proveedor;

	private String college;

	public Course(String college, String name) {
		this.college = college;
		this.name = name;
		proveedor = new Proveedor();
	}

	public Course(String _name) {
		new Course(System.getProperty("env.college"), _name);
	}

	public String getName() {
		return name;
	}

	public String getCollege() {
		return college;
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
