import java.util.Scanner;

public class BellmanFord {
    private int distances[];
    private int numberofvertices;
    public static final int MAX_VALUE = 999;

    public BellmanFord(int numberofvertices) {
        super();
        this.numberofvertices = numberofvertices;
        distances = new int[numberofvertices + 1];
    }

    public void BellmanFordEvaluation(int source, int adjacencymatrix[][]) {
        for (int node = 1; node <= numberofvertices; node++) {
            distances[node] = MAX_VALUE;
        }
        distances[source] = 0;

        for (int node = 1; node <= numberofvertices - 1; node++) {
            for (int sourcenode = 1; sourcenode <= numberofvertices; sourcenode++) {
                for (int destinationnode = 1; destinationnode <= numberofvertices; destinationnode++) {
                    if (adjacencymatrix[sourcenode][destinationnode] != MAX_VALUE) {
                        if (distances[destinationnode] > distances[sourcenode] + adjacencymatrix[sourcenode][destinationnode]) {
                            distances[destinationnode] = distances[sourcenode] + adjacencymatrix[sourcenode][destinationnode];
                        }
                    }
                }
            }
        }

        for (int vertex = 1; vertex <= numberofvertices; vertex++) {
            System.out.println("Distance of " + source + " to " + vertex + " is: " + distances[vertex]);
        }
    }

    public static void main(String[] args) throws Exception {
        int numberofvertices = 0;
        int source, destination;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        numberofvertices = scanner.nextInt();
        int[][] adjacencymatrix = new int[numberofvertices + 1][numberofvertices + 1];
        System.out.println("Enter adjacency matrix:");
        for (source = 1; source <= numberofvertices; source++) {
            for (destination = 1; destination <= numberofvertices; destination++) {
                adjacencymatrix[source][destination] = scanner.nextInt();
                if (source == destination) {
                    adjacencymatrix[source][destination] = 0;
                    continue;
                }
                if (adjacencymatrix[source][destination] == 0) {
                    adjacencymatrix[source][destination] = MAX_VALUE;
                }
            }
        }
        System.out.println("Enter source vertex");
        source = scanner.nextInt();
        BellmanFord bellmanford = new BellmanFord(numberofvertices);
        bellmanford.BellmanFordEvaluation(source, adjacencymatrix);
        scanner.close();
    }
}
