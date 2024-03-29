import student.TestCase;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
/**
 * Test the SemManager class
 * 
 * @author Xianwei Wu/Jiren Wang
 * @version September 2023, updated September 2023
 */
public class SemManagerTest extends TestCase {
    /**
     * Sets up the tests that follow. 
     * In general, used for initialization
     */
    public void setUp() {
        // Nothing here
    }

    /**
     * Get code coverage of the class declaration.
     */
    public void testMInitx() {
        SemManager sem = new SemManager();
        assertNotNull(sem);
        SemManager.main(null);
        
        String filePath = "src/P1Sample_output.txt"; 

        String refOut = "";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            refOut = new String(bytes, StandardCharsets.UTF_8);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
        SemManager.main(new String[]{"512", "4", "src/P1Sample_input.txt"});
        String printOut = systemOut().getHistory();
        assertFuzzyEquals(printOut, refOut);
        
        filePath = "src/P1Sample_output2.txt"; 

        refOut = "";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filePath));
            refOut = new String(bytes, StandardCharsets.UTF_8);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        
        systemOut().clearHistory();
        SemManager.main(new String[]{"64", "4", "src/P1Sample_input.txt"});
        printOut = systemOut().getHistory();
        assertFuzzyEquals(printOut, refOut);
    }
}