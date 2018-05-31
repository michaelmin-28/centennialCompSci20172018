package work08CircuitTracer;
import java.awt.Point;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import work08CircuitTracer.Storage.DataStructure;



/**
 * Search for shortest paths between start and end points on a circuit board
 * as read from an input file using either a stack or queue as the underlying
 * search state storage structure and displaying output to the console or to
 * a GUI according to options specified via command-line arguments.
 * 
 * @author mvail
 */
public class CircuitTracer {
	private CircuitBoard board;
	private Storage<TraceState> stateStore;
	private ArrayList<TraceState> bestPaths;

	/** launch the program
	 * @param args three required arguments:
	 *  first arg: -s for stack or -q for queue
	 *  second arg: -c for console output or -g for GUI output
	 *  third arg: input file name 
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			printUsage();
			System.exit(1);
		}
		try {
			new CircuitTracer(args); //create this with args
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/** Print instructions for running CircuitTracer from the command line. */
	private static void printUsage() {
		//TODO: print out clear usage instructions when there are problems with
		// any command line args
		System.out.println("You seem to have an error with your argument. Please write: ");
		System.out.println("first arg: -s for stack or -q for queue");
		System.out.println("second arg: -c for console output or -g for GUI output");
		System.out.println("third arg: input file name");
	}
	
	/** 
	 * Set up the CircuitBoard and all other components based on command
	 * line arguments.
	 * 
	 * @param args command line arguments passed through from main()
	 * @throws InvalidFileFormatException 
	 * @throws FileNotFoundException 
	 */
	private CircuitTracer(String[] args) throws FileNotFoundException, InvalidFileFormatException {
		//TODO: parse command line args
		String arg1 = args[0];
		String arg2 = args[1];
		String arg3 = args[2];
		//TODO: initialize the Storage to use either a stack or queue
		if (arg1 == "-q") {
			DataStructure dataStructure = DataStructure.queue;
			Storage<TraceState> stateStore = new Storage<TraceState>(dataStructure);
			this.stateStore = stateStore;
		}
		else if (arg1 == "-s") {
			DataStructure dataStructure = DataStructure.stack;
			Storage<TraceState> stateStore = new Storage<TraceState>(dataStructure);
			this.stateStore = stateStore;
		}
		this.bestPaths = new ArrayList<TraceState>();
		//TODO: read in the CircuitBoard from the given file
		CircuitBoard board = new CircuitBoard(arg3);
		//TODO: run the search for best paths
		for (int i = 0; i < board.numRows(); i++) {
			for (int j = 0; j < board.numCols(); j++) {
				if (board.charAt(i, j) == 1) {
					if (board.isOpen(i - 1, j)) {
						stateStore.store(new TraceState(board, i - 1, j));
					}
					if (board.isOpen(i + 1, j)) {
						stateStore.store(new TraceState(board, i + 1, j));
					}
					if (board.isOpen(i, j - 1)) {
						stateStore.store(new TraceState(board, i, j - 1));
					}
					if (board.isOpen(i, j + 1)) {
						stateStore.store(new TraceState(board, i, j + 1));
					}
				}
			}
		}
		
		if (arg2 == "-c") {
			System.out.println(board.toString());
		}
		if (arg2 == "-g") {
			System.out.println("Sorry can't do that");
		}
		while(!stateStore.isEmpty()) {
			TraceState kappa = stateStore.retrieve();
			int length = Integer.MAX_VALUE;
			for (TraceState lmao : bestPaths) {
				if (lmao.pathLength() < length) {
					length = lmao.pathLength();
				}
			}
			if (kappa.isComplete()) {
				if (kappa.pathLength() == length) {
					bestPaths.add(kappa);
				}
				else if (kappa.pathLength() < length) {
					bestPaths.clear();
					bestPaths.add(kappa);
				}
			}
			else {
				for (int i = 0; i < board.numRows(); i++) {
					for (int j = 0; j < board.numCols(); j++) {
						if (i == kappa.getRow() && j == kappa.getCol()) {
							if (board.isOpen(i - 1, j)) {
								stateStore.store(new TraceState(kappa, i - 1, j));
							}
							if (board.isOpen(i + 1, j)) {
								stateStore.store(new TraceState(kappa, i + 1, j));
							}
							if (board.isOpen(i, j - 1)) {
								stateStore.store(new TraceState(kappa, i, j - 1));
							}
							if (board.isOpen(i, j + 1)) {
								stateStore.store(new TraceState(kappa, i, j + 1));
							}
						}
					}
				}
			}
		}
		//TODO: output results to console or GUI, according to specified choice
	}
} // class CircuitTracer
