package filesystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import structures.Queue;



/**
 * An iterator to perform a level order traversal of part of a
 * filesystem.
 */
public class LevelOrderIterator extends FileIterator<File> {

Queue<File> queueIter = new Queue<>();

/**
* Instantiate a new LevelOrderIterator, rooted at the rootNode.
* @param rootNode
* @throws FileNotFoundException if the rootNode does not exist
*/
public LevelOrderIterator(File rootNode) throws FileNotFoundException {
        // TODO 1
	if (!rootNode.isDirectory() && !rootNode.isFile()) {
		throw new FileNotFoundException();
		}
	queueIter.enqueue(rootNode);
}

@Override
public boolean hasNext() {
        // TODO 2
    return !queueIter.isEmpty();
}

@Override
public File next() throws NoSuchElementException {
        // TODO 3
if (!hasNext()) {
	throw new NoSuchElementException();
}

	if (queueIter.peek().isDirectory()){
		File inside = queueIter.dequeue();
		File[] insideListFiles = inside.listFiles();
		Arrays.sort(insideListFiles);
		for (int i = 0; i < insideListFiles.length; i++){
			queueIter.enqueue(insideListFiles[i]);
		}
	return inside;
	}
return queueIter.dequeue();

}

@Override
public void remove() {
// Leave this one alone.
throw new UnsupportedOperationException();
}

}
