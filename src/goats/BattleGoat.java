package goats;

/**
 * Class that represents the hardened battle goats.
 * 
 * @author Bruce Herring
 */
public class BattleGoat implements IGoat
{
   /**
    * Name of the goat.
    */
   private final String name;

   /**
    * Damage the goat inflicts on other entities.
    */
   private final int damage;

   /**
    * Constructor
    *
    * @param name The goats name
    * @param damage The damage amount the goat inflicts 
    */
   public BattleGoat (String name, int damage) {
      this.name = name;
      this.damage = damage;
   }

   /**
    * The conversation the goat displays when approaching the
    * troll bridge.
    *
    * @return The goats conversation string
    */
   public String approach () {
      return name + " cautiously approaches the bridge.";
   }

      /**
    * Action which should be used when the goat interacts with
    * another entity.
    *
    * @return The damage the goat will impart on the other entity
    */
   public int interact () {
      return damage;
   }

   /**
    * String representation of the goat.
    *
    * @return The goats name.
    */
   public String toString () {
      return name;
   }
}