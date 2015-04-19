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

	// First push. Will be finalized on Sunday.
	// First push. Will be finalized on Sunday.
	// First push. Will be finalized on Sunday.
	
	/**
	 * @param tree The tree data structure that contains all the data.
	 * @param file The file to be saved.
	 */
	@Override
	public boolean doFileOp(CarPoolComponent tree, File file) {

		System.out.println("This function was called!");

		// Check to see if the tree has actually been created.
		if (tree == null) {
			System.err
					.println("There is no data to be saved. No file will be created.");
			return false;
		}

		// Check to see if the contents of the tree have been created.
		if (tree.getTree() == null) {
			System.err
					.println("There is no data to be saved. No file will be created.");
			return false;
		}
		
		// TODO: Finish remaining error checking above.
		
		// Save the file here.
		final Path path = Paths.get(file.getAbsolutePath());

		try (final BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE);) {
			
			//tree.getTree().get(0).
			
			for (int i = 0; i < tree.getTree().size(); i++) {
				
				if (tree.getTree().get(i) instanceof CarPoolComposite) {
					
					/*
					CarPoolIterator carPoolIterator = tree.getIterator();
					CarPoolComponent carPoolComponent = tree.getTree().get(i);
					
					while(carPoolIterator.hasNext(carPoolComponent)) {
						CarPoolComponent currentObject = carPoolIterator.next(carPoolComponent);
						currentObject.printSelf();
						CarPoolIterator tier2Iter = this.getIterator();
						//As this class is a CarPoolComposite, I can use this class for ensuring I further operate on CarPoolComposites.
						if(currentObject.getClass() == this.getClass()) {
							while(tier2Iter.hasNext(currentObject)) {
								System.out.print("     ");
								tier2Iter.next(currentObject).printSelf();
							}
						}
					}
					*/
					
				} else if (tree.getTree().get(i) instanceof CommuterElement) {
					
					writer.write("M, " + ((CommuterElement) tree.getTree().get(i)).getName() + 
							", " + ((CommuterElement) tree.getTree().get(i)).getStatus() +
							", " + ((CommuterElement) tree.getTree().get(i)).getDistanceTraveled());
					
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
