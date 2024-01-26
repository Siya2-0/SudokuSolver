public class Main {
    /*
     * Tips for using this Main
     * 
     * The output is in out.txt
     * 
     * Comment the tasks you are not currently testing
     * 
     * Look up "Text Comparison" for your IDE of choice. This way you can save your
     * output to a txt file and use that to see if there are differences between
     * your output and my output.
     * 
     * THESE TESTS ARE TRIVIAL. Make sure you expand and do more testing
     */
    public static void main(String[] args) {
        task1();
        task2();
        task3();

    /*/    List<Integer> zama= new List<>();
        System.out.println(zama.toString());
        zama.append(5);
        zama.append(8);
        zama.append(13);
        zama.append(18);
        System.out.println(zama.toString());
        System.out.println(zama.contains(7));
        System.out.println(zama.contains(5));
        System.out.println(zama.contains(18));
        zama.remove(18);
        System.out.println(zama.toString());
        zama.remove(8);
        System.out.println(zama.toString());
        List<Integer> cap=new List<>();
        cap.append(5);
        cap.append(13);
        List<Integer> zembe=new List<>();
        zembe.append(5);
        zembe.append(12);
        System.out.println(cap.equals(cap));
        System.out.println(cap.equals(zama));
        System.out.println(cap.equals(zembe));

        //Cell

        Cell tembe=new Cell(3, 3, "5");
        Cell tembe2=new Cell(3, 3, "-");
        System.out.println(tembe.toString());
        System.out.println(tembe2.toString());
        try{
        System.out.println(tembe.possibleValues.toString());
        }
        catch(Exception E){
            System.out.println("possible values==null");
        }
        System.out.println(tembe2.possibleValues.toString());*/

      //  String boString="- - 7 9 - 3 - 6 8 1 - 5 - - - - 4 2 8 6 - 2 - - 1 9 7 - - - - - 5 - 2 - - - - 7 - 6 - - 1 - 2 - 8 - 1 4 - - 9 - - - - 2 - 3 - - 7 4 - - 8 - - 9 3 1 2 4 7 9 - - 5";
       /* String boString="-";
      Board test= new Board(1, 1, boString);
        System.out.println(test.toString());
        System.out.println("Printing rows");
        test.PrintRow();
        System.out.println("print cols");
        test.PrintCol();
        System.out.println("print blocks");
        test.PrintBlock();
        test.solve();*/




    }

    public static void task1() {
        System.out.println("==========\nTask1\n==========");
        List<Integer> l = new List<>();

        for (int i = 1; i <= 9; i++) {
            l.append(i);
        }

        System.out.println(l.length + "\t" + l);
        l.remove(2);
        System.out.println(l.length + "\t" + l);
        l.remove(1);
        System.out.println(l.length + "\t" + l);
        l.remove(9);
        System.out.println(l.length + "\t" + l);
        l.remove(4);
        System.out.println(l.length + "\t" + l);
    }

    public static void task2() {
        System.out.println("==========\nTask2\n==========");
        SudokuSolver s1 = new SudokuSolver("2x3.txt");
        System.out.println("### Print Board ###");
        System.out.println(s1.board());
        System.out.println("### testLinks ###");
        s1.board().testLinks();
        System.out.println("### testCells ###");
        s1.board().testCells();
    }

    public static void task3() {
        System.out.println("==========\nTask3\n==========");
        SudokuSolver s1 = new SudokuSolver("2x3.txt");
        s1.solveBoard();
    }
}
