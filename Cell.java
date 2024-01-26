public class Cell {
    public int numRows, numCols, r, c, b;
    public Cell below, right, block;
    public Integer value;
    public List<Integer> possibleValues;

    public String toString() {
        if (value == null) {

            String res = " ";
            for (int i = 0; i < String.valueOf(numRows * numCols).length(); i++) {
                res += "-";
            }
            res += " ";
            return res;
        }
        return " " + String.format("%" + String.valueOf(numRows * numCols).length() + "d", value).replace(" ", "0")
                + " ";
    }

    /*
     * Don't change anything above this line
     */

    public Cell(int nR, int nC, String inp) {
        numRows=nR;
        numCols=nC;
        below=right=block=null;
        
        if(inp.contains("-"))
        {
            value=null;
            possibleValues=new List<Integer>();
            for(int c=1; c<=(nR*nC); c++)
            {
                possibleValues.append(c);
            }
        }
        else{
           // System.out.print(inp);
            possibleValues=null;
            value=Integer.parseInt(inp);
        }
    }

    public void removeVal(int val) {
        if(possibleValues != null)
        {
            possibleValues.remove(val);
        }
    }

    public void setVal(int val) {
        value=val;
        possibleValues=null;
    }

}
