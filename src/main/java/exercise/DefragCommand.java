package exercise;

import java.io.BufferedReader;
import java.io.IOException;

public class DefragCommand implements Command{
	private BufferedReader bufferedReader;
	private Defragger defragger;

	public DefragCommand(BufferedReader bufferedReader, Defragger defragger) {
		this.bufferedReader = bufferedReader;
		this.defragger = defragger;
	}

	@Override
	public void execute() {
		DiskUtils.getInstance();
		String pn = "";
		System.out.println("Enter name of partition to defrag");
		try {
			pn = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (defragger.canDefrag(pn)) {
			DiskUtils.getInstance().defrag(defragger, pn);
		}

	}
}
