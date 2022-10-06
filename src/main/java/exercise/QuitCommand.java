package exercise;

public class QuitCommand implements Command {
	private boolean shouldQuit = false;

	@Override
	public void execute() {
		shouldQuit = true;
	}

	public boolean now() {
		return shouldQuit;
	}
}
