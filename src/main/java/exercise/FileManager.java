package exercise;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {
	private static Defragger df;
	private static String[] myPartitions;
	private String input = null;
	public BufferedReader br = null;

	public static void run() {
		FileManager fm = new FileManager();
		System.out.println("Enter disk command:");
		System.out.println("* format");
		System.out.println("* print");
		System.out.println("* defrag");
		System.out.println("* quit");
		if (fm.input == null) {
			String result = "";
			if (fm.br == null) {
				fm.br = new BufferedReader(new InputStreamReader(System.in));
			}
			try {
				result = fm.br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fm.input = result;
		}
		while (!fm.input.equals("quit")) {
			if (fm.input.equals("format")) {
				String result = "";
				System.out.println("Enter name of partition to format");
				if (fm.br == null) {
					fm.br = new BufferedReader(new InputStreamReader(System.in));
				}
				try {
					result = fm.br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				for(String n : myPartitions){
					if (n.equals(result)){
						DiskUtils.getInstance().format(result);
					}
				}
			} else if (fm.input.equals("print")) {
				String fn = "";
				System.out.println("Enter name of file to print");
				if (fm.br == null) {
					fm.br = new BufferedReader(new InputStreamReader(System.in));
				}
				try {
					fn = fm.br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				File file = new File(fn);
				FilePrinter fp = new FilePrinter(file);
				fp.print();
			} else if (fm.input.equals("defrag")) {
				DiskUtils.getInstance();
				String pn = "";
				System.out.println("Enter name of partition to defrag");
				if (fm.br == null) {
					fm.br = new BufferedReader(new InputStreamReader(System.in));
				}
				try {
					pn = fm.br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				if (df.canDefrag(pn)) {
					DiskUtils.getInstance().defrag(df, pn);
				}
			}
			System.out.println("Enter disk command:");
			System.out.println("* format");
			System.out.println("* print");
			System.out.println("* defrag");
			System.out.println("* quit");
			String result = "";
			if (fm.br == null) {
				fm.br = new BufferedReader(new InputStreamReader(System.in));
			}
			try {
				result = fm.br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			fm.input = result;
		}
	}

	public static void init(String[] partitions) {
		myPartitions = partitions;
		df = new Defragger(partitions);
	}
}