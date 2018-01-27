import queues.IQueue;
import queues.ArrayQueue;
import queues.LinkedQueue;

import trolls.ITroll;
import trolls.CuteTroll;
import trolls.BattleTroll;

import goats.IGoat;
import goats.CuteGoat;
import goats.BattleGoat;

/**
 * @author Bruce Herring
 *
 * Main class for the goats Vs Troll demo. Creates the goats' queue,
 * the troll, and the bridge. Simulates the goats trying to cross
 * the bridge.

 * Usage: (Cute Version)   - java bridge
 *        (Battle Version) - java bridge <num goats>
 */
public class Bridge <T extends IGoat> {
    private IQueue<T> goatQueue;
    private ITroll<T> troll;
    private enum GameType {
        CUTE, BATTLE
    }

    private final GameType type;
    private static final int CUTE_SIZE = 10;
    private static final int GOAT_MAX_DAMAGE = 100;

    // The modifier should cause the troll to defeat 2/3rds of the goats
    // on average.
    private static final int TROLL_HP_MODIFIER = GOAT_MAX_DAMAGE * 2 / 6;

    /**
     * Constructor for cute game bridge.
     */
    private Bridge ()
    {
        type = GameType.CUTE;
        goatQueue = new ArrayQueue<>(CUTE_SIZE);
        troll = new CuteTroll<> (CUTE_SIZE * TROLL_HP_MODIFIER);
    }

    /**
     * Constructor for battle game bridge.
     * @param size Number of goats that are trying to cross the bridge.
     */
    private Bridge (int size) {
        type= GameType.BATTLE;
        goatQueue = new LinkedQueue<>();
        troll = new BattleTroll<>(size * TROLL_HP_MODIFIER);
    }


    /**
     * Adds a goat to the waiting line for crossing the bridge.
     *
     * @param goat Name of the goat that will be added to the line
     */
    private void addGoat (T goat) {
        goatQueue.enqueue(goat);
    }


    /**
     * Simulates goats trying to cross a bridge that is guarded by
     * a troll.
     */
    private void runSimulation () {
        System.out.println("Welcome to Goats Vs Troll - " + type + " Edition!");

        while (!goatQueue.isEmpty()) {
            T goat = goatQueue.front();

            System.out.println (goat.approach ());

            if (troll.isActive()) {
                System.out.println("A troll stands guard.");

                troll.adjustPower(goat.interact ());

                if (troll.isActive()) {
                    troll.interact(goat);
                } else {
                    troll.finished(goat);
                }
            } else {
                System.out.println("The path is clear and " + goat + " crosses the bridge.");
            }

            goatQueue.dequeue();
        }

        System.out.println("Simulation complete.");
    }

    /**
     * Main method. Creates the bridges, populates them with goats,
     * and runs the simulation.
     *
     * @param args Array of command line arguments.
     */
    public static void main (String[] args) {

        java.util.Random ran = new java.util.Random();
        
        // Based on the game type, execute the correct version.

        if (args.length == 1) {
            int size = Integer.parseInt(args[0]);

            Bridge<IGoat> myBridge = new Bridge<>(size);

            // For the battle version, give the goats string names.
            for (char c = 'A'; c < size + 'A'; c++) {
                int damage = ran.nextInt (GOAT_MAX_DAMAGE);
                IGoat bg = new BattleGoat (c + "opsy", damage);
                myBridge.addGoat(bg);
            }

            myBridge.runSimulation();
        }
        else {
            Bridge<IGoat> myBridge = new Bridge<> ();

            // For the cute version, name the goats after integers.
            for (int i = 1; i <= CUTE_SIZE; i++) {
                int happiness = ran.nextInt (GOAT_MAX_DAMAGE);
                IGoat cg = new CuteGoat (i, happiness);
                myBridge.addGoat(cg);
            }

            myBridge.runSimulation ();
        }

    }
}
