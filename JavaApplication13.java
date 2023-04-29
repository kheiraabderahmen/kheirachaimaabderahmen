/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication81;
import java.util.*;
 

/**
 *
 * @author Dell
 */

    


  
import java.util.*;
       

public class JavaApplication13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Lecture du nombre de devises
        int R = scanner.nextInt();

        // Initialisation du graphe avec les taux de change
        double[][] graph = new double[R][R];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < R; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = -Math.log(scanner.nextDouble());
                }
            }
        }

        // Détection des cycles absorbants avec l'algorithme de Bellman-Ford
        int[][] predecessors = new int[R][R];
        double[][] distances = new double[R][R];
        for (int i = 0; i < R; i++) {
            Arrays.fill(distances[i], Double.POSITIVE_INFINITY);
            distances[i][i] = 0;
        }
        for (int k = 0; k < R; k++) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < R; j++) {
                    if (distances[i][j] > distances[i][k] + distances[k][j]) {
                        distances[i][j] = distances[i][k] + distances[k][j];
                        predecessors[i][j] = k;
                    }
                }
            }
        }
        boolean hasArbitrage = false;
        for (int i = 0; i < R; i++) {
            if (distances[i][i] < 0) {
                hasArbitrage = true;
                int j = i;
                List<Integer> path = new ArrayList<>();
                do {
                    path.add(j);
                    j = predecessors[i][j];
                } while (j != i && !path.contains(j));
                path.add(j);
                Collections.reverse(path);
                System.out.print("Opportunité d'arbitrage : ");
                for (int k = 0; k < path.size(); k++) {
                    System.out.print("Devise " + (path.get(k) + 1));
                    if (k < path.size() - 1) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }
        }
        if (!hasArbitrage) {
            System.out.println("Pas d'opportunité d'arbitrage.");
        }
        scanner.close();
    }
}

