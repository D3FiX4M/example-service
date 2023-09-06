package user_service_root.util;

public class FunctionalInterfaces {
	@FunctionalInterface
	public interface Setter<IN> {
		void action(IN in);
	}

	@FunctionalInterface
	public interface Getter<OUT> {
		OUT action();
	}
}
