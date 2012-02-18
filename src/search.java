//trying to do search algorithm
//May Camp

public class search(ArrayList<Formula> formulas, String searchTerm) { // for a one word search term
    //assuming we store all formulas in ArrayList<Formula> 
    //and enter that as teh first argument
    //and there are tags in ArrayList<Tag> under each formula

    int fsize = formulas.size(); //size of formula arraylist
    ArrayList<String> strings = new ArrayList<String>; //make a new arraylist of strings
    String currentTag;


    for(int i=0; i<fsize; i++) { // loop through formulas
	int tsize = forumulas.getTags().size(); //size of tag arraylist
	for(int j=0; j<tsize; j++) { // loop through tags
	    currentTag = formulas.get(i).get(j);
	    if(searchTerm == currentTag) {
		strings.add(formulas.get(i).toString();)
	    }


	}
    }
    
    


    public static void main(String[] args) { // for testing
	
    }
}