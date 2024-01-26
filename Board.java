

public class Board {
    private int numRows, numCols;
    private Cell cells[], rows[], cols[], blocks[];

    public String toString() {
        String res = "";
        for (int r = 0; r < numRows * numCols; r++) {
            if (r % numRows == 0) {
                res += horizLine() + "\n";
            }
            for (int c = 0; c < numRows * numCols; c++) {
                if (c % numCols == 0) {
                    res += "|";
                }
                res += cells[r * numRows * numCols + c];
            }
            res += "|\n";
        }

        res += horizLine();
        return res;
    }

    public String horizLine() {
        String res = "";
        for (int i = 0; i < numRows + 1 + (numRows * numCols * (String.valueOf(numRows * numCols).length() + 2)); i++) {
            res += "-";
        }
        return res;
    }

    public void testLinks() {
        System.out.println("Rows forward");

        for (int r = 0; r < numRows * numCols; r++) {
            System.out.print("Row " + r + "\t");
            Cell ptr = rows[r];
            while (ptr != null) {
                System.out.print(indexOf(ptr) + " ");
                ptr = ptr.right;
            }
            System.out.println();
        }

        System.out.println("Cols forward");

        for (int c = 0; c < numRows * numCols; c++) {
            System.out.print("Col " + c + "\t");
            Cell ptr = cols[c];
            while (ptr != null) {
                System.out.print(indexOf(ptr) + " ");
                ptr = ptr.below;
            }
            System.out.println();
        }

        System.out.println("Blocks");
        for (int b = 0; b < numRows * numCols; b++) {
            System.out.print("Block " + b + "\t");
            Cell ptr = blocks[b];
            while (ptr != null) {
                System.out.print(indexOf(ptr) + " ");
                ptr = ptr.block;
            }
            System.out.println();
        }
    }

    public void testCells() {
        System.out.println("Cell\tCoord\tBlock\ttoString");
        for (Cell c : cells) {
            System.out.println(indexOf(c) + "\t(" + c.r + "," + c.c + ")\t" + c.b + "\t" + c);
        }
    }

    public int indexOf(Cell c) {
        for (int i = 0; i < numRows * numRows * numCols * numCols; i++) {
            if (cells[i].equals(c)) {
                return i;
            }
        }
        return -1;
    }

    public Cell cellAt(int r, int c) {
        if (r < 0 || r >= numRows * numCols || c < 0 || c >= numRows * numCols) {
            return null;
        }
        return cells[r * numRows * numCols + c];
    }

    /*
     * Don't change anything above this line
     */

    public Board(int r, int c, String boardString) 
    {
        numCols=c;
        numRows=r;
        cells=new Cell[(numCols*numRows)*(numCols*numRows) ];
        SetCells(boardString);
        setLinks();
        SetCellProperties();
    }

    public void PrintRow()
    {
        Cell temp;
        for(int c=0; c<(numCols*numRows); c++)
        {
            temp=rows[c];
            while(temp != null)
            {
                System.out.print(temp.toString() + " ");
                temp=temp.right;
            }
            System.out.println(" ");

        }
    }
    public void PrintCol()
    {
        Cell temp;
        for(int c=0; c<(numCols*numRows); c++)
        {
            temp=cols[c];
            while(temp != null)
            {
                System.out.print(temp.toString() + " ");
                temp=temp.below;
            }
            System.out.println(" ");

        }
    }

    public void PrintBlock()
    {
        Cell temp;
        for(int c=0; c<(numCols*numRows); c++)
        {
            temp=blocks[c];
            while(temp != null)
            {
                System.out.print(temp.toString() + " ");
                temp=temp.block;
            }
            System.out.println(" ");

        }
    }


    public void SetCells(String boardString)
    {
        int NumberOfCells=(numCols*numRows)*(numCols*numRows);
        //int BoardStringIndex=0;
        String[] arr=boardString.split(" ");

        for(int c=0; c<NumberOfCells; c++)
        {
            cells[c]=new Cell(numRows,numCols,arr[c]);
        }
    }
    public  void SetCellProperties()
    {
        int index=0;
        int col=0;
     
        for(int c=0; c<(numCols*numRows)*(numCols*numRows); c+=(numCols*numRows))
        {
       
            for(int i=0; i<(numCols*numRows); i++)
            {
                cells[index].r=col;
                cells[index].c=i;
                index++;

            }
            col++;
        }
       Cell B;
        for(int c=0; c<(numCols*numRows); c++)
        {
            B=blocks[c];
            for(int z=0; z<(numCols*numRows); z++)
            {
               B.b=(c);
               B=B.block;
            }
        }


    }

    public int DetermineBlockMin(int row)
    {
        return 1;
    }
    public int DetermineBlockMax(int row)
    {
        return 41;
    }


    public void setLinks() {
        rows=new Cell[(numCols*numRows)];
        cols=new Cell[(numCols*numRows)];
        blocks=new Cell[(numCols*numRows)];
        int RowIndex=0;
        //setting rows heads
        for(int c=0; c<(numCols*numRows)*(numCols*numRows); c+=(numCols*numRows))
        {
            rows[RowIndex]=cells[c];//
            Cell R=rows[RowIndex];
            RowIndex++;
            for(int i=1; i<(numCols*numRows); i++)
            {
                R.right=cells[c+i];
                R=R.right;
            }
            
        }//done

        //seting cols heads
        for(int c=0; c<(numCols*numRows); c++){
            cols[c]=cells[c];
            Cell C=cols[c];
            for(int i=1; i<(numCols*numRows); i++)
            {
                C.below=cells[c+ (i*numCols*numRows)];
                C=C.below;
            }

        
        }//done

        //setting block via cell
        Boolean enter;
        for(int c=0; c<(numCols*numRows)*(numCols*numRows); c+=(numCols*numRows))
        {

            for(int z=0; z<(numCols*numRows); z++)
            {

                if( (c +(numCols*numRows)) % (numRows*(numCols*numRows)) == 0 )
                {
                    enter=true;
                }
                else
                {
                    enter=false;
                }
                if((z+1)%numCols == 0)
                {
                    if((c+z+(numCols*numRows)) < (numCols*numRows)*(numCols*numRows))
                    {
                       if(enter)
                       {
                            //cells[c+z].block=null;
                       }
                       else
                       {
                        cells[c+z].block=cells[ c+z +(numCols*numRows)-numCols+1];
                       }
                    }
                    //cells[c+z].block=null;

                }
                else
                {
                    cells[c+z].block=cells[c+z +1];
                }
        
            }

        }


        int blockIndex=0;
        for(int c=0; c<(numCols*numRows)*(numCols*numRows); c+=numRows*(numCols*numRows))
        {
            for(int i=0; i<(numCols*numRows); i+=numCols)
            {
                blocks[blockIndex]=cells[c+i];
                blockIndex++;
            }
        }
        //SetCellProperties();

    }


 

    public void fullProp() {
        
        int NumberOfCells=(numCols*numRows)*(numCols*numRows);

        for(int c=0; c<NumberOfCells; c++)
        {
           propCell(cells[c]);
        }
    }

    public void propCell(Cell cell) {

        if(cell==null)
            return ;

        if(cell.value==null)
            return ;


        Cell RowTraverse=this.rows[cell.r];
        while(RowTraverse !=null)
        {
            if(!RowTraverse.equals(cell))
            {
                RowTraverse.removeVal(cell.value);
            }
            RowTraverse=RowTraverse.right;
        }

        Cell CoTraverse=this.cols[cell.c];
        while(CoTraverse !=null)
        {
            if(!CoTraverse.equals(cell))
            {
                CoTraverse.removeVal(cell.value);
            }
            CoTraverse=CoTraverse.below;
        }

        Cell BlockTraverse=this.blocks[cell.b];
        while(BlockTraverse != null)
        {
            if(!BlockTraverse.equals(cell))
            {
                BlockTraverse.removeVal(cell.value);
            }
            BlockTraverse=BlockTraverse.block;
        }


    }

    public void solve() {
        int counter=0;

        while( soleCandidate())
        {
            counter+=1;
        }
        while(uniqueCandidate() )
        {
            counter+=1;
        }
        while( duplicateCells())
        {
            counter+=1;
        }
        System.out.println("Number of moves : { "+counter+" }");

    }

    public boolean soleCandidate() {

        //Boolean change=false;
        for(int c=0; c<(numCols*numRows)*(numCols*numRows); c++)
        {
            if(cells[c].possibleValues!= null &&cells[c].possibleValues.length==1)
            {
                cells[c].setVal(cells[c].possibleValues.head.data);
                propCell(cells[c]);
                return true;
            }
        }
        return false;
    }

    public boolean uniqueCandidate()
    {
        for(int c=0; c< (numCols*numRows); c++)
        {
            int[] count= new int[(numCols*numRows)];
            //for(int o=0; o<(numCols*numRows); o++)
              //  count[o]=0;
            Cell rowPtr=rows[c];
            while(rowPtr != null)
            {
                if(rowPtr.possibleValues != null)
                {
                    Node<Integer> nodePtr=rowPtr.possibleValues.head;
                    while(nodePtr != null)
                    {
                        ++(count[nodePtr.data-1]);
                        nodePtr=nodePtr.next;
                    }
                }
                rowPtr=rowPtr.right;
            }

            for(int i=0; i<(numCols*numRows); i++ )//range
            {
                if(count[i]==1)
                {
                    rowPtr=rows[c];
                    while(rowPtr != null)
                    {
                        if(rowPtr.possibleValues != null && rowPtr.possibleValues.contains(1+i))
                        {
                            rowPtr.setVal(i+1);
                            propCell(rowPtr);
                        }
                        rowPtr=rowPtr.right;
                    }
                    return true;
                }
            }
        }


        for(int c=0; c< (numCols*numRows); c++)
        {
            int[] count= new int[(numCols*numRows)];
            Cell rowPtr=cols[c];
            while(rowPtr != null)
            {
                if(rowPtr.possibleValues != null)
                {
                    Node<Integer> nodePtr=rowPtr.possibleValues.head;
                    while(nodePtr != null)
                    {
                        ++(count[nodePtr.data-1]);
                        nodePtr=nodePtr.next;
                    }
                }
                rowPtr=rowPtr.below;
            }

            for(int i=0; i<(numCols*numRows); i++ )//range
            {
                if(count[i]==1)
                {
                    rowPtr=cols[c];
                    while(rowPtr != null)
                    {
                        if(rowPtr.possibleValues != null && rowPtr.possibleValues.contains(1+i))
                        {
                            rowPtr.setVal(i+1);
                            propCell(rowPtr);
                        }
                        rowPtr=rowPtr.below;
                    }
                    return true;
                }
            }
        }
        
        
        for(int c=0; c< (numCols*numRows); c++)
        {
            int[] count= new int[(numCols*numRows)];
            Cell rowPtr=blocks[c];
            while(rowPtr != null)
            {
                if(rowPtr.possibleValues != null)
                {
                    Node<Integer> nodePtr=rowPtr.possibleValues.head;
                    while(nodePtr != null)
                    {
                        ++(count[nodePtr.data-1]);
                        nodePtr=nodePtr.next;
                    }
                }
                rowPtr=rowPtr.block;
            }

            for(int i=0; i<(numCols*numRows); i++ )//range
            {
                if(count[i]==1)
                {
                    rowPtr=blocks[c];
                    while(rowPtr != null)
                    {
                        if(rowPtr.possibleValues != null && rowPtr.possibleValues.contains(1+i))
                        {
                            rowPtr.setVal(i+1);
                            propCell(rowPtr);
                        }
                        rowPtr=rowPtr.block;
                    }
                    return true;
                }
            }
        }        

        return false;
    }

    public boolean duplicateCells() {
        for(int c=0; c< (numCols*numRows); c++)
        {
            Cell rowPtr=rows[c];
            while(rowPtr != null)
            {
                if(rowPtr.possibleValues != null && rowPtr.possibleValues.length==2)
                {
                    Cell secondPtr=rowPtr.right;
                    while(secondPtr != null)
                    {
                        if(rowPtr.possibleValues.equals(secondPtr.possibleValues))// possible mistage
                        {
                            Cell thirdPtr=rows[c];
                            Boolean change=false;
                            while(thirdPtr != null)
                            {
                                if(!thirdPtr.equals(secondPtr) && !thirdPtr.equals(rowPtr)&& thirdPtr.possibleValues!= null)
                                {
                                    change= change || thirdPtr.possibleValues.remove(rowPtr.possibleValues);
                                }
                                thirdPtr=thirdPtr.right;
                            }
                            if(change)
                            {
                                return true;
                            }
                        }
                        secondPtr=secondPtr.right;
                    }
                }
                rowPtr=rowPtr.right;
            }
        }

        for(int c=0; c< (numCols*numRows); c++)
        {
            Cell rowPtr=cols[c];
            while(rowPtr != null)
            {
                if(rowPtr.possibleValues != null && rowPtr.possibleValues.length==2)
                {
                    Cell secondPtr=rowPtr.below;
                    while(secondPtr != null)
                    {
                        if(rowPtr.possibleValues.equals(secondPtr.possibleValues))
                        {
                            Cell thirdPtr=cols[c];
                            Boolean change=false;
                            while(thirdPtr != null)
                            {
                                if(!thirdPtr.equals(secondPtr) && !thirdPtr.equals(rowPtr)&& thirdPtr.possibleValues!= null)
                                {
                                    change= change || thirdPtr.possibleValues.remove(rowPtr.possibleValues);
                                }
                                thirdPtr=thirdPtr.below;
                            }
                            if(change)
                            {
                                return true;
                            }
                        }
                        secondPtr=secondPtr.below;
                    }
                }
                rowPtr=rowPtr.below;
            }
        }

        for(int c=0; c< (numCols*numRows); c++)
        {
            Cell rowPtr=blocks[c];
            while(rowPtr != null)
            {
                if(rowPtr.possibleValues != null && rowPtr.possibleValues.length==2)
                {
                    Cell secondPtr=rowPtr.block;
                    while(secondPtr != null)
                    {
                        if(rowPtr.possibleValues.equals(secondPtr.possibleValues))
                        {
                            Cell thirdPtr=blocks[c];
                            Boolean change=false;
                            while(thirdPtr != null)
                            {
                                if(!thirdPtr.equals(secondPtr) && !thirdPtr.equals(rowPtr)&& thirdPtr.possibleValues!= null)
                                {
                                    change= change || thirdPtr.possibleValues.remove(rowPtr.possibleValues);
                                }
                                thirdPtr=thirdPtr.block;
                            }
                            if(change)
                            {
                                return true;
                            }
                        }
                        secondPtr=secondPtr.block;
                    }
                }
                rowPtr=rowPtr.block;
            }
        }


        return false;
    }
}