package internalformatting;

/**
 * This class allows the formula class to hold both Term and Operator objects.
 * @author Clayven Anderson
 *
 */
abstract public class Component
{
  /**
   * Does nothing, just allows the formula class to hold operators and terms 
   */
  byte getType(){
    return -1;
  }
  

}
