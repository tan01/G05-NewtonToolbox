//units.cpp by May Camp Feb 3, 2012
//construct without parameter
//or with the full singular name of the unit as the parameter
//ex: "mass" or "gram" or "second"

//NOT SURE IF doing kilograms as the normal unit name, probably not.
class Units {
  ///////////////attributes:///////////
  string name;
  string info;
  string tags;
  string typicalForm;
  ///////////////constructors://///////
  Units ();
  Units (string unitName); //enter in the unit name, ex: "mass"
  ///////////////methods://////////////
  void setName(string);
  void setInfo(string);
  void setTags(string);///////////////not sure
  void setTypicalForm(string);
  string getName();
  string getInfo();
  string getTags();
  string getTypicalForm();
};
Units::Units () {
  name= "unnamed";
  info= "unspecified info";
  tags= "untagged";
  typicalForm= "unset typical physics form";
}
Units::Units (string unitName) {
  name= unitName;
  info= "unspecified info";
  tags= "untagged";
  typicalForm= "unset typical physics form";
}
Units::~Units() {
  delete name;
  delete info;
  delete tags;
  delete typicalForm;
}
void Units::setName(string n) {
  name = n; }
void Units::setInfo(string i) {
  info = i; }
void Units::setTags(string t) {
  tags = t; }
void Units::setTypicalForm(string tf) {
  typicalForm = tf; }
string Units::getName() {
  return name; }
string Units::getInfo() {
  return info; }
string Units::getTags() {
  return tags; }
string Units::getTypicalForm() {
  return typicalForm; }



