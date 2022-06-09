package search;

import java.util.*;

/**
 * An implementation of a Searcher that performs an iterative search,
 * storing the list of next states in a Queue. This results in a
 * breadth-first search.
 * 
 */
public class QueueBasedBreadthFirstSearcher<T> extends Searcher<T> {

	public QueueBasedBreadthFirstSearcher(SearchProblem<T> searchProblem) {
		super(searchProblem);
	}

	@Override
	public List<T> solve() {

		if (solution != null) {
			return solution;
		}


		Queue<T> path = new LinkedList<T>();
		iterativeBFS(path);
		List<T> pather = new ArrayList<T>(); 
		while (!path.isEmpty()) {
			pather.add(path.remove()); 
		}

		if (path.size() > 0) {
			if (!isValid(pather)) {
				throw new RuntimeException(
						"searcher should never find an invalid solution!");
			}
		}
		return pather;

	}

	private void iterativeBFS(Queue<T> path) {
		path.add(searchProblem.getInitialState());
		if (searchProblem.isGoalState(searchProblem.getInitialState())) {
			return;
		}

		visitedStates.add(searchProblem.getInitialState());

		T newNode = null;
		List<T> stor;
		while (!path.isEmpty() || !searchProblem.isGoalState(newNode)){
			stor = searchProblem.getSuccessors(path.peek()); 
			for (int i = 0; i < stor.size(); i++) {
				if (!visitedStates.contains(stor.get(i))) {
					newNode = stor.get(i);
				}	
			}	 

			if (newNode == null) {
				path.remove();
				continue; 
			} 

			visitedStates.add(newNode);
			path.add(newNode);
			newNode = null;
	}
}

}
