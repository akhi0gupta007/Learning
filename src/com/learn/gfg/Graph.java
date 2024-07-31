package com.learn.gfg;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int[][] adjacencyMatrix;
    private int numVertices;

    // Constructor
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    // Add edge
    public void addEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
            adjacencyMatrix[i][j] = 1;
            adjacencyMatrix[j][i] = 1; // For undirected graph
        } else {
            System.out.println("Invalid vertex number.");
        }
    }

    // Breadth-First Search
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            // Visit all the adjacent vertices
            for (int i = 0; i < numVertices; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    // Print the adjacency matrix
    public void printAdjacencyMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        System.out.println("Adjacency Matrix:");
        graph.printAdjacencyMatrix();

        System.out.println("\nBFS starting from vertex 0:");
        graph.bfs(0);
    }
}

