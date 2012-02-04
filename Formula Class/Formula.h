// Formula.h
// Clayven Anderson 2/3/12
// Represents a physics Fomula. Allows you the create new formulas as well as edit existing formulas.
// Also stores in formation about the function in the form of a short descripition and "tags"
// A Formula object consist of a linked list of Term objects
//Notes: 

#ifndef FORMULA_H
#define FORMULA_H

class Formula {

public:
	Formula(); //default constructor
	
	~Formula(); //destuctor
	
	void setName(); // change the name of the function
	
	string getName(); // returns the name of the formula
	
	void setInfo(); // set a string describing the formula
	
	string getInfo(); //return a string describing the formula
	
	void addTag(); // adds a tag
	
	void deleteTag(string badTag) //removes a selected tag
	
	string returnTags(); //returns all tags associated with the formula
	
	void addTerm(TermObj T); //appends a new term to formula @@@TODO:not sure if passing right argument here@@@
	
	void deleteTerm(TermObj T); //removes a selected term in the formula @@@TODO:still not sure if passing right argument here@@@
	
	string returnFormula(); // return the function as string(?)
	
private:
string FormulaName;
string info;

//Linked list containing Term objects
struct TermObj {
        Term data; //TODO: find out how to pass instances of a class into a linked list. May replace Term class entirely. 
        TermObj *next;
        TerObj(Term n = NULL) : data(n), next(0) {} // node constructor
    };
    Node *front, *rear;  // pointers to keep track of front and rear
    int size;            // number of items in the queue
};

//linked list containing strings that represent "tags"
struct Tags {
        int tag;
        Tags *next;
        Tags(tag n = NULL) : data(n), next(0) {} // node constructor
    };
    Node *front, *rear;  // pointers to keep track of front and rear
    int size;            // number of items in the queue
};
#endif
