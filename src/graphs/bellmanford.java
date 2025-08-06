import java.util.Arrays;

public class bellmanford {
    static class Edge {
        int source, destination, weight;
        Edge() { source = destination = weight = 0; }
    }

    int V, E;
    Edge edge[];

    bellmanford(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < E; i++)
            edge[i] = new Edge();
    }

    void BellmanFordAlgo(BellmanFord graph, int src) {
        int V = graph.V, E = graph.E;
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges V‑1 times
        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
                int u = graph.edge[j].source;
                int v = graph.edge[j].destination;
                int w = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v])
                    dist[v] = dist[u] + w;
            }
        }

        // Check for negative‑weight cycles
        for (int j = 0; j < E; j++) {
            int u = graph.edge[j].source;
            int v = graph.edge[j].destination;
            int w = graph.edge[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }

        // Print distances
        printDistances(dist, V);
    }

    void printDistances(int dist[], int V) {
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {
        int V = 5, E = 8;
        BellmanFord graph = new BellmanFord(V, E);

        graph.edge[0].source = 0; graph.edge[0].destination = 1; graph.edge[0].weight = -1;
        graph.edge[1].source = 0; graph.edge[1].destination = 2; graph.edge[1].weight = 4;
        graph.edge[2].source = 1; graph.edge[2].destination = 2; graph.edge[2].weight = 3;
        graph.edge[3].source = 1; graph.edge[3].destination = 3; graph.edge[3].weight = 2;
        graph.edge[4].source = 1; graph.edge[4].destination = 4; graph.edge[4].weight = 2;
        graph.edge[5].source = 3; graph.edge[5].destination = 2; graph.edge[5].weight = 5;
        graph.edge[6].source = 3; graph.edge[6].destination = 1; graph.edge[6].weight = 1;
        graph.edge[7].source = 4; graph.edge[7].destination = 3; graph.edge[7].weight = -3;

        graph.BellmanFordAlgo(graph, 0);
    }
}
