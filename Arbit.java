/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */

    public class Arbit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // nombre de devises dans le graphe
        int r = scanner.nextInt();
        double[][] GRAPH = new double[r][r];

        //  # Entrée des arcs entre les sommets avec leur poids
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                double poids = scanner.nextDouble();          
                GRAPH[i][j] = -Math.log(poids);                
                 
            }
       }
       



//Exécution de l'algorithme de Bellman-Ford
        boolean arbitrage = false;
        int[] predecessor = new int[r];
        double[] distance = new double[r];
        Arrays.fill(distance, Double.POSITIVE_INFINITY);
        distance[0] = 0;

        for (int i = 0; i < r; i++) {
            for (int u = 0; u < r; u++) {
                for (int v = 0; v < r; v++) {
                    if (distance[v] > distance[u] + GRAPH[u][v]) {
                        distance[v] = distance[u] + GRAPH[u][v];
                        predecessor[v] = u;
                       
                    }
                }
            }
        }




// Affichage des arcs entre les sommets et leur poids
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {

               // # GRAPH[i][j] represente le taux de change entre la devise i et la devise j.
                  double x = -GRAPH[i][j];
                 double expen_x = Math.exp(x);

                                                                                           
                System.out.printf("(%d, %d) :  i, j,expen_x);

            }
        }




 // Affichage des opportunités d'arbitrage
       
  if (arbitrage) {
Set<Integer> DevicesArbitrage = new HashSet<>();
      int v = j;
for (int i = 0; i < r; i++) {
  for (int j = 0; j < r; j++) {
    if (distance[j] > distance[i] + GRAPH[i][j]) {
      distance[j] = distance[i] + GRAPH[i][j]
      predecessor[v]=i;
  }
}
System.out.println(" il ya Opportunités d'arbitrage );
}

else {
System.out.println("Pas d'opportunité d'arbitrage.");
}

    
}
