package internalformatting;
//import gui.GUIMain;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Creates an ArrayList of Strings that will describe certain attributes of various objects in the system.
 * will assist in the search process
 */

/**
 * @author Clayven Anderson
 * @author May Camp (edited addTag)
 * @version 2/15/12 for cs48 W12
 */

public class Tags extends ArrayList<String> implements Serializable{
	final private static long serialVersionUID = 1670087L;
	/**
	 * creates an empty Arraylist of tags
	 */
	//default constructor
	public Tags() {
		super(1);// calls superclass's constructor to make and empty ArrayList
	}

	public int getSize() {return this.size();}

	/**
	 * returns the tag at position i
	 * @param i i is the index of the desired tag
	 * @return 
	 */
	public String getTag(int i){return this.get(i);}

	/** Appends a new "tag" to the end of the ArrayList 
	 * will also delete duplicate tags
	 * @param newTag New tag to be appended to list
	 */
	public void addTag(String newTag) {
		if(!(exists(newTag))) {	
			this.ensureCapacity(this.size() + 1);
			newTag.toLowerCase();
			this.add(newTag);
		}
		deleteDuplicateTags();
	}

	/**
	 * deletes duplicate tags
	 */
	public void deleteDuplicateTags() {
		int aSize = this.size();
		for(int i=0; i<aSize-1; i++) {
			for(int j=i+1; j<aSize; j++) {
				if( !(getTag(j).equals(getTag(i))) )
					continue;
				remove(j);
				j--;
				aSize--;
			}
		}
	}

	/** removes a specified tag from the list
	 * @param BadTag the tag the must be removed
	 */
	public void deleteTag(String BadTag) {
		for(int i=0; i<this.size(); i++ ) {
			if(this.get(i).equals(BadTag) ) {
				this.remove(i);
				break;
			}
			else {
				continue;
			}
		}
	}

	/** clears all tags*/
	public void clearTags(){this.clear();}

	/**
	 * A method to check if the tag exists in the ArrayList of tags
	 * @param tag       a tag to check the existance of
	 * @return boolean  true if tag exists in array, false if tag DNE in array
	 */
	public boolean exists(String tag) {
		for(int i=0; i<this.size(); i++){
			if ( tag.equals(this.getTag(i)) ){
				return true;
			}
		}
		return false;
	}

	/** returns all of the tags in the array list as a single string (just for the moment, most likely will change)*/
	public String returnAllTags() {
		String AllTags = "";
		if(this.isEmpty() == true ) {
			AllTags = AllTags + "No tags Available";
		}
		else {
			for(int i=0; i<this.size(); i++){
				AllTags = AllTags + this.get(i);
				if(!(i==this.size()-1)) {
					AllTags = AllTags + ",";
				}
			}
		}
		return AllTags;
	}

	public static Tags convertToTags(String tagString) {
		tagString.replaceAll( ", " , "," );
		tagString.replaceAll( " " , "," );
		String[] tagsTemp = tagString.split(",");
		Tags formattedTags = new Tags();
		for(int i=0;i<tagsTemp.length;i++){
			formattedTags.add(tagsTemp[i]);
		}
		return formattedTags;
	}
} // class Tags

