package internalformatting;

/**
 * This class allows the formula class to hold both Term and Operator objects.
 * @author Clayven Anderson
 *
 */
abstract public class Component {
  /**
   * Does nothing, just allows the formula class to hold operators and terms.
   * Also alerts us of a possible error
   */
  byte getType(){
    return -1;
  }
  
}
