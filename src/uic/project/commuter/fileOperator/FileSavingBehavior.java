package uic.project.commuter.fileOperator;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import uic.project.commuter.carPoolData.*;

public class FileSavingBehavior implements FileOpBehavior {

	/**
	 * This function will save the information from the tree and place it into the file.
	 * 
	 * @param tree
	 *            this is the data structure that holds all the commuters and their relevant information.
	 * @param file
	 *            this is the file to perform the file operation upon.
	 * @return if the operation was successful.
	 */
	@Override
	public boolean doFileOperation(CarPoolComponent tree, File file) {

		// Check to see if the tree has actually been created.
		if (tree == null || tree.getTree() == null) {
			System.err.println("There is no data to be saved. No file will be created."); //$NON-NLS-1$
			return false;
		}

		// Make sure the file object is not null.
		if (file == null) {
			System.err.println("The file can not be saved. No file will be created."); //$NON-NLS-1$
		}

		// Warn the user if the an existing file will be over-written.
		if (file.exists()) {
			System.err.println("Warning a file with the same name already exists and will be over-written."); //$NON-NLS-1$
		}

		// TODO: Finish remaining error checking above.

		// Save the file here.
		final Path path = Paths.get(file.getAbsolutePath());

		try (final BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE);) {

			// tree.getTree().get(0).

			for (int i = 0; i < tree.getTree().size(); i++) {

				if (tree.getTree().get(i) instanceof CarPoolComposite) {

					/*
					 * CarPoolIterator carPoolIterator = tree.getIterator(); CarPoolComponent carPoolComponent = tree.getTree().get(i);
					 * 
					 * while(carPoolIterator.hasNext(carPoolComponent)) { CarPoolComponent currentObject = carPoolIterator.next(carPoolComponent); currentObject.printSelf();
					 * CarPoolIterator tier2Iter = this.getIterator(); //As this class is a CarPoolComposite, I can use this class for ensuring I further operate on
					 * CarPoolComposites. if(currentObject.getClass() == this.getClass()) { while(tier2Iter.hasNext(currentObject)) { System.out.print("     ");
					 * tier2Iter.next(currentObject).printSelf(); } } }
					 */

				} else if (tree.getTree().get(i) instanceof CommuterElement) {

					writer.write("M, " + ((CommuterElement) tree.getTree().get(i)).getName() + ", " + ((CommuterElement) tree.getTree().get(i)).getStatus() + ", " + ((CommuterElement) tree.getTree().get(i)).getDistanceTraveled()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

					writer.flush();

				}

			}

			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

}
