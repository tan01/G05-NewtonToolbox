import java.util.ArrayList;

/**
 * Creates an ArrayList of Strings that will describe certain attributes of various objects in the system.
 * will assist in the search process.
 */

/**
 * @author Clayven Anderson
 * @version 2/15/12 for cs48 W12
 */
public class Tags extends ArrayList<String>{
  Tags(){
    super(1);// calls superclass's constructor to make and empty ArrayList

  }
  
  /** Appends a new "tag" to the end of the ArrayList 
   * @param newTag New tag to be appended to list
   * */
  void AddTag(String newTag){
    this.ensureCapacity(this.size() + 1);
    this.add(newTag);
  }

  /** removes a specified tag from the list
   * @param BadTag the tag the must be removed
   * */
  void deleteTag(String BadTag){
    for(int i=0; i>=this.size();i++ ){
      if(this.get(i) ==BadTag ){
        this.remove(i);
        break;
      }
      else{
        continue;
      }
      }
    }
  
  /** clears all tags*/
  void clearTags(){
    this.clear();
  }
  /** returns all of the tags in the array list as a single string (just ofr the moment, most likely will change)*/
  String returnAllTags(){
    String AllTags = "";
    if(this.isEmpty() == true ){
      AllTags = AllTags + "No tags Availiable";
    }
    else{
      for(int i=0; i>=this.size(); i++){
        AllTags = AllTags + " " + this.get(i); //***TODO format this a bit better***
      }
    }
    return AllTags;
  }
    
    
  
  }

