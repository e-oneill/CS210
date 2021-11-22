

public class Grid {
    public static void main(String[] args) {
        
    }

    public Grid(int x, int y)
    {
        int z = Math.max(x, y);
        for (int i = 0; i < x; i++)
        {
            for (int j=0; j < y; j++)
            {
                GridNode node = new GridNode(i, j);
            }
        }
    }

    

    


}



class GridNode {
    private int x;
    private int y;
     

    GridNode()
    {
        x = 0;
        y = 0;
    }

    GridNode(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}