import student.TestCase;
/**
 * a testcase to test the MemmangerTest
 * 
 * @author Xianwei Wu/Jiren Wang
 * @version September 2023, updated September 2023
 */
public class MemManagerTest extends TestCase {
    /**
     * Sets up the tests that follow. In general, used for 
     * initialization
     */
    public void setUp() {
        // Nothing here
    }

    /**
     * Get code coverage of the class declaration.
     */
    public void testPrintMemManager() {
        MemManager memManager2 = new MemManager();
        memManager2.initializeMemManger(512);
        memManager2.getDummyNode().setNext(null);
        assertEquals(false, memManager2.printMemManager());

        MemManager memManager = new MemManager();
        MyHashTable myHashTable = new MyHashTable(4);
        memManager.initializeMemManger(512);
        String title = "";
        String dateTime = "";
        int length = -1;
        short x = 10;
        short y = 10;
        int cost = -1;
        int id = 1;
        String desc = "This seminar will present "
                + "an overview of HCI research at VT";
        String[] keywordList = {};
        FreeList tmp = memManager.getDummyNode().getNext();
        memManager.getDummyNode().setNext(null);
        assertEquals(false, memManager.printMemManager());
        memManager.getDummyNode().setNext(tmp);
        Seminar s1 = new Seminar(1, "Overview of HCI Research at VT", 
                "0610051600", 90, x, y, 45,
                new String[] { "HCI", "Computer_Science", ""
                        + "VT", "Virginia_Tech" }, desc);
        x = 20;
        y = 10;
        desc = "Introduction to   bioinformatics " 
            + "and computation biology";
        Seminar s2 = new Seminar(2, "Computational Biology "
                + "and Bioinformatics in CS at Virginia Tech",
                "0610071600", 60,
                x, y, 30, new String[] { ""
                        + "Bioinformatics", "computation_biology", 
                    "Biology", "Computer_Science", ""
                            + "VT", "Virginia_Tech" }, desc);
        x = 30;
        y = 10;
        desc = "Seminar about the      Computing systems "
                + "research at      VT";
        Seminar s3 = new Seminar(3, "Computing Systems Research at VT",
                "0701250830", 30, x, y, cost,
                new String[] { "high_performance_computing", "grids", "VT", 
                    "computer", "science" }, desc);
        x = 0;
        y = 0;
        desc = "Learn what kind of    research is done on HPC  "
                + "and CSE at VT";
        Seminar s4 = new Seminar(10, "Overview of HPC "
                + "and CSE Research at VT", 
                "0703301125", 35, x, y, 25,
                new String[] { "HPC", "CSE", "Computer_Science" }, desc);
        x = 20;
        y = 10;
        desc = "Introduction to bioinformatics "
                + "and lots of computation biology";
        Seminar s5 = new Seminar(2, "Much More Computational "
                + "Biology and Bioinformatics in CS at Virginia Tech",
                "0610071600", 60, x, y, 30, new String[] { "Bioinformatics"
                        + "", "computation_biology", "Biology", ""
                            + "Computer_Science", "VT", "Virginia_Tech" },
                desc);
        Seminar s6 = new Seminar(4, "Much More Computational "
                + "Biology and Bioinformatics in CS at Virginia Tech",
                "0610071600", 60, x, y, 30, new String[] { "Bioinformatics", ""
                        + "computation_biology", "Biology", ""
                                + "Computer_Science", "VT", "Virginia_Tech" },
                desc);
        myHashTable.insert(memManager, 1, s1);
        assertEquals(true, memManager.printMemManager());
        myHashTable.insert(memManager, 2, s2);
        assertEquals(false, memManager.printMemManager());
        myHashTable.insert(memManager, 3, s3);
        assertEquals(true, memManager.printMemManager());
        myHashTable.insert(memManager, 10, s4);
        assertEquals(false, memManager.printMemManager());
        myHashTable.delete(memManager, 2);
        assertEquals(true, memManager.printMemManager());
        myHashTable.insert(memManager, 2, s5);
        assertEquals(true, memManager.printMemManager());
        myHashTable.insert(memManager, 4, s6);
        assertEquals(true, memManager.printMemManager());
        myHashTable.delete(memManager, 10);
        assertEquals(true, memManager.printMemManager());
        myHashTable.delete(memManager, 2);
        assertEquals(true, memManager.printMemManager());

        MemManager memManager3 = new MemManager();
        memManager3.initializeMemManger(0);
        FreeList tmp1 = new FreeList(64, 0);
        FreeList tmp2 = new FreeList(32, 64);
        FreeList tmp3 = new FreeList(64, 96);
        FreeList tmp4 = new FreeList(128, 128);
        assertEquals(true, memManager3.printMemManager());
        memManager3.getDummyNode().setNext(tmp1);
        assertEquals(true, memManager3.printMemManager());
        tmp1.setNext(tmp2);
        assertEquals(true, memManager3.printMemManager());
        tmp2.setNext(tmp3);
        assertEquals(true, memManager3.printMemManager());
        tmp3.setNext(tmp4);
        assertEquals(true, memManager3.printMemManager());
    
        MemManager memManager4 = new MemManager();
        memManager4.initializeMemManger(0); 
        memManager4.getDummyNode().setNext(null);
        assertEquals(false, memManager4.printMemManager());
    }
    
    /**
     * Test assertEqualsCustom test if two FreeList[] are equal 
     * 
     * @param arr1 input arr1
     * @param arr2 input arr2
     * @param arr1Length input arr1 length
     * @param arr2Length input arr2 length
     * @return return if these two FreeList[] are equal
     */
    public boolean assertEqualsCustom(FreeList[] arr1, 
            int arr1Length, FreeList[] arr2, int arr2Length) {
        if (arr1Length != arr2Length) {
            return false;
        }

        for (int i = 0; i < arr1Length; i++) {
            FreeList list1 = arr1[i];
            FreeList list2 = arr2[i];

            while (list1 != null && list2 != null) {
                if (list1.getVal() != list2.getVal()) {              
                    return false;
                }
                list1 = list1.getNext();
                list2 = list2.getNext();
            }
        }
        return true;
    }
    
    /**
     * Test insertionSort function
     */
    public void testInsertionSort() {
        MemManager memManager = new MemManager();
        memManager.initializeMemManger(0); 
        FreeList[] tmp1 = new FreeList[5];
        tmp1[0] = new FreeList(1, 0);
        tmp1[1] = new FreeList(2, 0);
        tmp1[2] = new FreeList(3, 0);
        tmp1[3] = new FreeList(5, 0);
        tmp1[4] = new FreeList(4, 0);
        FreeList[] tmp2 = new FreeList[5];
        tmp2[0] = new FreeList(1, 0);
        tmp2[1] = new FreeList(2, 0);
        tmp2[2] = new FreeList(3, 0);
        tmp2[3] = new FreeList(4, 0);
        tmp2[4] = new FreeList(5, 0);
        memManager.insertionSort(tmp1, 5);
        assertTrue(assertEqualsCustom(tmp1, 5, tmp2, 5));
        
        FreeList[] tmp3 = new FreeList[5];
        tmp3[0] = new FreeList(-6, 0);
        tmp3[1] = new FreeList(-5, 0);
        tmp3[2] = new FreeList(-4, 0);
        tmp3[3] = new FreeList(-3, 0);
        tmp3[4] = new FreeList(-10, 0);
        FreeList[] tmp4 = new FreeList[5];
        tmp4[0] = new FreeList(-10, 0);
        tmp4[1] = new FreeList(-6, 0);
        tmp4[2] = new FreeList(-5, 0);
        tmp4[3] = new FreeList(-4, 0);
        tmp4[4] = new FreeList(-3, 0);
        memManager.insertionSort(tmp3, 5);
        assertTrue(assertEqualsCustom(tmp3, 5, tmp4, 5));
        
        FreeList[] tmp5 = new FreeList[0];
        FreeList[] tmp6 = new FreeList[0];
        memManager.insertionSort(tmp5, 5);
        assertTrue(assertEqualsCustom(tmp5, 0, tmp6, 0));
        
        FreeList[] tmp7 = new FreeList[5];
        tmp7[0] = new FreeList(1, 0);
        tmp7[1] = new FreeList(1, 0);
        tmp7[2] = new FreeList(1, 0);
        tmp7[3] = new FreeList(1, 0);
        tmp7[4] = new FreeList(1, 0);
        FreeList[] tmp8 = new FreeList[5];
        tmp8[0] = new FreeList(1, 0);
        tmp8[1] = new FreeList(1, 0);
        tmp8[2] = new FreeList(1, 0);
        tmp8[3] = new FreeList(1, 0);
        tmp8[4] = new FreeList(1, 0);
        memManager.insertionSort(tmp7, 5);
        assertTrue(assertEqualsCustom(tmp7, 5, tmp8, 5));
        
        
        FreeList[] tmp9 = new FreeList[5];
        tmp9[0] = new FreeList(2, 0);
        FreeList[] tmp10 = new FreeList[5];
        tmp10[0] = new FreeList(2, 0);
        memManager.insertionSort(tmp9, 1);
        assertTrue(assertEqualsCustom(tmp9, 5, tmp10, 5));  
        
        FreeList[] tmp11 = new FreeList[4];
        tmp9[0] = new FreeList(2, 0);
        FreeList[] tmp12 = new FreeList[5];
        tmp10[0] = new FreeList(2, 0);
        memManager.insertionSort(tmp9, 1);
        assertEquals(false, assertEqualsCustom(tmp11, 4, tmp12, 5));  
    }   
    
    /**
     * Test printOut function
     */
    public void testPrintOut() {
        MemManager memManager = new MemManager();
        memManager.initializeMemManger(0); 
        FreeList[] tmp0 = new FreeList[0];
        assertEquals(false, memManager.printOut(tmp0, -1));
        
        FreeList[] tmp1 = new FreeList[0];
        assertEquals(false, memManager.printOut(tmp1, 0));
        
        FreeList[] tmp2 = new FreeList[1];
        tmp2[0] = new FreeList(-1, -1);
        assertEquals(true, memManager.printOut(tmp2, 1));
        
        FreeList[] tmp3 = new FreeList[1];
        tmp3[0] = new FreeList(1, 0);
        tmp3[0].setNext(new FreeList(1, 1));
        tmp3[0].getNext().setNext(new FreeList(1, 2));
        assertEquals(true, memManager.printOut(tmp3, 1));
        
        FreeList[] tmp4 = new FreeList[2];
        tmp4[0] = new FreeList(-1, -1);
        tmp4[1] = new FreeList(1, 0);
        tmp4[1].setNext(new FreeList(1, 1));
        tmp4[1].getNext().setNext(new FreeList(1, 2));
        assertEquals(true, memManager.printOut(tmp4, 1));
    }
    
    /**
     * Test ProcessFreeList
     */
    public void testProcessFreeList() {
        FreeList curPosition = new FreeList(1, 1);
        MemManager memManager = new MemManager();
        memManager.initializeMemManger(0);
        
        FreeList[] tmp0 = new FreeList[0];
        assertEquals(false, 
                memManager.processFreeList(curPosition, tmp0, -1));
        
        FreeList[] tmp1 = new FreeList[0];
        assertEquals(false, 
                memManager.processFreeList(curPosition, tmp1, 0));
        
        FreeList[] tmp2 = new FreeList[1];
        tmp2[0] = new FreeList(-1, -1);
        assertEquals(true, 
                memManager.processFreeList(curPosition, tmp2, 1));
        
        FreeList[] tmp3 = new FreeList[1];
        tmp3[0] = new FreeList(1, 0);
        tmp3[0].setNext(new FreeList(1, 1));
        tmp3[0].getNext().setNext(new FreeList(1, 2));
        assertEquals(true, 
                memManager.processFreeList(curPosition, tmp3, 1));
        
        FreeList[] tmp4 = new FreeList[2];
        tmp4[0] = new FreeList(-1, -1);
        tmp4[1] = new FreeList(1, 0);
        tmp4[1].setNext(new FreeList(1, 1));
        tmp4[1].getNext().setNext(new FreeList(1, 2));
        assertEquals(true, 
                memManager.processFreeList(curPosition, tmp4, 1));

        curPosition = new FreeList(-1, -1);
        FreeList[] tmp5 = new FreeList[0];
        assertEquals(false, 
                memManager.processFreeList(curPosition, tmp5, 0));
        
        FreeList[] tmp6 = new FreeList[1];
        tmp6[0] = new FreeList(-1, -1);
        assertEquals(true, 
                memManager.processFreeList(curPosition, tmp6, 1));
        
        FreeList[] tmp7 = new FreeList[1];
        tmp7[0] = new FreeList(1, 0);
        tmp7[0].setNext(new FreeList(1, 1));
        tmp7[0].getNext().setNext(new FreeList(1, 2));
        assertEquals(true, 
                memManager.processFreeList(curPosition, tmp7, 1));
        
        FreeList[] tmp8 = new FreeList[2];
        tmp8[0] = new FreeList(-1, -1);
        tmp8[1] = new FreeList(1, 0);
        tmp8[1].setNext(new FreeList(1, 1));
        tmp8[1].getNext().setNext(new FreeList(1, 2));
        assertEquals(true, 
                memManager.processFreeList(curPosition, tmp8, 1));
    }
    
    /**
     * Test the `doubleSize` method when the initial size is 0.
     * It should return a new `MemManager` with a value of 0 
     * and a size of 0.
     */
    public void testdoublesize() {
        MemManager memManager = new MemManager();
        memManager.initializeMemManger(0);

        assertEquals(0, memManager.doubleSize().getVal());
        assertEquals(0, memManager.getSize());

        MemManager memManager2 = new MemManager();
        memManager2.initializeMemManger(1);

        assertEquals(1, memManager2.doubleSize().getNext().getVal());
        assertEquals(2, memManager2.getSize());

        MemManager memManager3 = new MemManager();
        memManager3.initializeMemManger(2);

        assertEquals(2, memManager3.doubleSize().getNext().getVal());
        assertEquals(4, memManager3.getSize());
        assertEquals(2, memManager3.getDoubleSizeTest());
        MemManager memManager4 = new MemManager();
        memManager4.initializeMemManger(2);
        memManager4.setDummy(null);
        assertEquals(null, memManager4.doubleSize());

    }
    
    /**
     * Test the `FindSpaceAvailable` method with different scenarios.
     */
    public void testFindSpaceAvailable() {
        MemManager memManager = new MemManager();
        memManager.initializeMemManger(1);
        memManager.setDummy(null);
        assertEquals(null, memManager.findSpaceAvailable(0));

        MemManager memManager2 = new MemManager();
        memManager2.initializeMemManger(1);
        assertEquals(null, memManager2.findSpaceAvailable(3));

        MemManager memManager3 = new MemManager();
        memManager3.initializeMemManger(1);
        memManager3.getDummyNode().getNext().setVal(Integer.MAX_VALUE);
        assertEquals(null, memManager3.findSpaceAvailable(3));

    }
    
    /**
     * Test the `getNearestPowerOfTwo` method with various inputs.
     */
    public void testgetNearestPowerOfTwo() {
        MemManager memManager = new MemManager();
        memManager.initializeMemManger(0);

        assertEquals(2, memManager.getNearestPowerOfTwo(2));
        assertEquals(4, memManager.getNearestPowerOfTwo(3));
        assertEquals(1, memManager.getNearestPowerOfTwo(0));
    }
    
    /**
     * Test the `splitMemoryPool` method with specific 
     * input conditions.
     */
    public void testsplitMemoryPool() {
        MemManager memManager = new MemManager();
        memManager.initializeMemManger(2);
        assertEquals(null, memManager.splitMemoryPool(
                2, memManager.getDummyNode().getNext()).getNext().getNext());
    }
    
    /**
     * Test the `delete` method with various scenarios.
     */
    public void testdelete() {
        MemManager memManager = new MemManager();
        memManager.initializeMemManger(2);
        assertEquals(false, memManager.delete(new Handle(-1, -1, -1)));

        memManager.delete(new Handle(1, 1, 1));
        memManager.getDummyNode().setIndex(10);
        assertEquals(true, memManager.delete(new Handle(1, 1, 1)));
        memManager.getDummyNode().setPrev(new FreeList(-1, -1));
        memManager.delete(new Handle(1, 1, 1));

        memManager.insert(new byte[1], 2);
        assertEquals(true, memManager.delete(new Handle(1, 1, 2)));

    }
    
    /**
     * Test mergeMemeoryPool method
     */
    public void testMergeMemeoryPool() {
        MemManager memManager = new MemManager();
        memManager.initializeMemManger(2);
        memManager.setDummy(null);
        assertEquals(false, memManager.mergeMemoryPool());

        MemManager memManager2 = new MemManager();
        memManager2.initializeMemManger(2);
        memManager2.getDummyNode().getNext().setNext(new FreeList(2, 2));
        assertEquals(true, memManager2.mergeMemoryPool());
    }
    
    /**
     * Test the `mergeMain` method with various scenarios.
     */
    public void testmergeMain() {
        MemManager memManager = new MemManager();
        memManager.initializeMemManger(2);
        assertEquals(2, memManager.mergeMain().getVal());
        memManager.getDummyNode().getNext().setVal(1);
        memManager.getDummyNode().getNext().setIndex(0);
        memManager.getDummyNode().getNext().setNext(new FreeList(1, 1));
        assertEquals(2, memManager.mergeMain().getVal());

        MemManager memManager2 = new MemManager();
        memManager2.initializeMemManger(2);
        assertEquals(2, memManager2.mergeMain().getVal());
        memManager2.getDummyNode().getNext().setVal(2);
        memManager2.getDummyNode().getNext().setIndex(0);
        memManager2.getDummyNode().getNext().setNext(new FreeList(1, 1));
        assertEquals(1, memManager2.mergeMain().getVal());

        MemManager memManager3 = new MemManager();
        memManager3.initializeMemManger(2);
        assertEquals(1, memManager2.mergeMain().getVal());
        memManager3.getDummyNode().getNext().setVal(1);
        memManager3.getDummyNode().getNext().setIndex(-1);
        memManager3.getDummyNode().getNext().setNext(new FreeList(1, 1));
        assertEquals(1, memManager3.mergeMain().getVal());

        MemManager memManager4 = new MemManager();
        memManager4.initializeMemManger(2);
        assertEquals(1, memManager2.mergeMain().getVal());
        memManager4.getDummyNode().getNext().setVal(1);
        memManager4.getDummyNode().getNext().setIndex(0);
        FreeList tmp1 = new FreeList(1, 1);
        FreeList tmp2 = new FreeList(1, 2);
        tmp1.setPrev(memManager4.getDummyNode().getNext());
        tmp2.setPrev(tmp1);
        memManager4.getDummyNode().getNext().setNext(tmp1);
        memManager4.getDummyNode().getNext().getNext().setNext(tmp2);
        assertEquals(1, memManager4.mergeMain().getVal());

    }

}
