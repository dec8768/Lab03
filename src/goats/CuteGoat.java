package goats;

/**
 * The cute goat class, where everything is happy and rainbows.
 *
 * @author Bruce Herring
 */
public class CuteGoat implements IGoat {

   /**
    * The goats number (name).
    */
   private final int name;

   /**
    * The amount of happiness a goat will impart when it
    * interacts with something.
    */
   private final int happiness;

   /**
    * Constructor
    *
    * @param name The goats name
    * @param happiness The goats happiness power
    */
   public CuteGoat (int name, int happiness) {
      this.name = name;
      this.happiness = happiness;
   }

   /**
    * The conversation the goat displays when approaching the
    * troll bridge.
    *
    * @return The goats conversation string
    */
   public String approach () {
      return name + " hops along the bridge.";
   }

   /**
    * Action which should be used when the goat interacts with
    * another entity.
    *
    * @return The happiness the goat will impart on the other entity
    */
   public int interact () {
      return happiness;
   }

   /**
    * String representation of the goat.
    *
    * @return The goats name.
    */
   public String toString () {
      return "Goat " + name;
   }
}