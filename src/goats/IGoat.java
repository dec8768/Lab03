package goats;

/**
 * Interface for the goats.
 *
 * @author Bruce Herring
 */
public interface IGoat {

   /**
    * Goat conversation as it approaches the troll bridge.
    *
    * @return String containing the goats conversation.
    */
   String approach ();

   /**
    * Method which will be called when the goat interacts with
    * the troll.
    *
    * @return Goat interaction impact on the troll.
    */
   int interact ();
}