package zain_new;

import java.util.HashSet;
import java.util.Set;

public class MovieBST {
	private Movie first;
	
	// This is the function to recursively search for movie titles for the given range
	public void subSetRec(Set<String> s, Movie node, String start, String end) {
		
		if (node == null) { 
            return; 
        } 
		
		/* Since the desired o/p is sorted, recurse for left subtree first 
        If node's movie title is greater than start, then only we can get o/p keys 
        in left subtree */
		if (start.compareTo(node.getTitle()) < 0) {
			subSetRec(s, node.getLeft(), start, end);
		}
		
		/* if node's movie title is lies in range, then add to the set */
		if (start.compareTo(node.getTitle()) <= 0 && end.compareTo(node.getTitle()) >=0) { 
			s.add(node.getTitle());
        } 
  
        /* If node's movie title is smaller than end, then only we add to the set 
         in right subtree */
        if (end.compareTo(node.getTitle()) > 0) { 
        	subSetRec(s, node.getRight(), start, end); 
        } 
	}
	
	// This is the function which will be invoked from main function
	public Set<String> subSet(String start, String end) {
		// Create a new Set and fill it recursively
		Set<String> s = new HashSet<String>();
		subSetRec(s, this.first, start, end);
		return s;
	}
	
	public Movie getFirst() {
		return first;
	}
	public void setFirst(Movie first) {
		this.first = first;
	}
	
	public void addNode(String title, int releaseYear, int movieId, String[] genres) {
		// Fill the info for movie
		this.first = addNodeRec(this.first, title);
		this.first.setReleaseYear(releaseYear);
		this.first.setMovieId(movieId);
		this.first.setGenres(genres);
	}
	
	// This is the utility function to add Node in BST.
	public Movie addNodeRec(Movie root, String title) {
		// Base case
		if (root == null) {
            root = new Movie(title);
            return root;
        } 
		
		// Compare the titles to place it in left or right subtree.
		if (title.compareTo(root.getTitle()) < 0) {
            root.setLeft(addNodeRec(root.getLeft(), title));
		}
        else if (title.compareTo(root.getTitle()) > 0)  {
            root.setRight(addNodeRec(root.getRight(), title));
        }
  
        /* return the (unchanged) node pointer */
        return root; 
    }
	
	// Function to traverse the BST
	public void traverseInOrder() {
		traverseInOrderRec(this.first);
	}
	public void traverseInOrderRec(Movie root) {
        
        if (root.getLeft() != null) {
            traverseInOrderRec(root.getLeft());
        }
        System.out.println(root.getTitle());
        if (root.getRight() != null) {
            traverseInOrderRec(root.getRight());
        }
    }
		
}

