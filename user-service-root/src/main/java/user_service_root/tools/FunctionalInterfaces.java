package user_service_root.tools;

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
