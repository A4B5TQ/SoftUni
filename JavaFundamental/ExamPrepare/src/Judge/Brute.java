package Judge;

import java.util.Scanner;
class BruteForce
{
    private String t,p;
    private int m, n;
    private static int count;
    public BruteForce(String t, String p)
    {
        this.t=t;
        this.p=p;
        n=t.length( );
        m=p.length( );
    }
    public int getNoOfComparisons( )
    {
        return count;
    }
    public  int bruteForceMatch( )
    {
        int i,j;
        for(i=0; i<=n-m; i++)
        {
            for(j=0;j<m;++j)
            {
                count++;
                if(t.charAt(i+j)!=p.charAt(j))
                    break;
            }
            if(j==m)
                return i;
        }
        return -1;
    }
}
class BruteForceExp
{
    public static void main(String args[])
    {
        Scanner src = new Scanner(System.in);
        String text,pattern;
        System.out.println("Enter Text");
        text=src.nextLine();
        System.out.println("Enter Pattern");
        pattern=src.nextLine();
        BruteForce obj=new BruteForce(text,pattern);
        int z=obj.bruteForceMatch( );
        if(z!=-1)
            System.out.println(pattern+" is present in "+text+" from index "+z+" to "+ (z+pattern.length()-1));
        else
            System.out.println(pattern +" is not present in "+text);
        System.out.println(" No of comparsions = "+ obj.getNoOfComparisons( ));
    }
}  