package example;

public interface Example {
	static Example newInstance() {
		return new example.internal.ExampleImpl();
	}

	String msg(String message);
}