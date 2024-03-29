/**
 * The `WorldDataBase` class represents a database that processes commands and
 * interacts with a hashtable and a seminar manager.
 * 
 * @author Jiren&xianwei
 * @version September 2023, updated September 2023
 */
public class WorldDataBase {
    private MemManager memManager;
    private MyHashTable hashTable;

    /**
     * Constructs a new `WorldDataBase` 
     * object with the specified seminar manager
     * and hashTable.
     *
     * @param memManager a memory manager reference
     * @param hashTable  a hashTable class reference
     */
    public WorldDataBase(MemManager memManager, MyHashTable hashTable) {
        this.memManager = memManager;
        this.hashTable = hashTable;
    }

    /**
     * Processes a command based on the given instruction, key, and seminar.
     *
     * @param instruction The instruction code for the command.
     * @param key         The key associated with the command.
     * @param seminar     The seminar object associated with the command.
     */
    public void processCommand(int instruction, int key, Seminar seminar) {
        switch (instruction) {
            case 1:
                hashTable.insert(memManager, key, seminar);
                break;
            case 2:
                hashTable.search(memManager, key);
                break;
            case 3:
                hashTable.printHashtable();
                break;
            case 4:
                memManager.printMemManager();
                break;
            case 5:
                hashTable.delete(memManager, key);
                break;
            default:
                break;
        }
    }
}