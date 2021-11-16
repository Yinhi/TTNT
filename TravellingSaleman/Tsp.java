import java.util.Scanner;

public class Tsp {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c[][] = new int[10][10], tour[] = new int[10];
        int i, j, cost;        
        System.out.print("Enter the cicy number: ");
        int n = in.nextInt();        
        if(n == 1) {
            System.out.println("Couldn't find the path!");
            System.exit(0);
        }
        System.out.println("Enter cost:");
        for(i=1; i<=n; i++) {
            for(j=1; j<=n; j++) {
                c[i][j] = in.nextInt();  
            }
        }
        for(i=1; i<=n; i++) {
            tour[i]=i;    
        }
        cost = tsp(c, tour, 1, n);        
        System.out.print("The tour: ");        
        for(i=1; i<=n; i++) {
            System.out.print(tour[i]+"->");  
        }
        System.out.println("1");        
        System.out.println("Minimum cost: "+cost);
    }

    public static int tsp(int c[][], int tour[], int start, int n) {
        int min_tour[] = new int[10], temp[] = new int[10], min_cost = 999, ccost, i, j, k;      
        if(start == n-1)
        {
            return (c[tour[n-1]][tour[n]] + c[tour[n]][1]);
        }        
        for(i=start+1; i<=n; i++) {
            for(j=1; j<=n; j++) {
                temp[j] = tour[j];        
                temp[start+1] = tour[i];
                temp[i] = tour[start+1];
            }            
            if((c[tour[start]][tour[i]] + (ccost = tsp(c, temp, start+1, n))) < min_cost)
            {            
                min_cost = c[tour[start]][tour[i]] + ccost;              
                for(k=1; k<=n; k++) {
                    min_tour[k] = temp[k];
                }
            }
        }        
        for(i=1; i<=n; i++) {
            tour[i] = min_tour[i];
        }
        return min_cost;       
    }
}