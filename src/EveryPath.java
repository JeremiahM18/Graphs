/*
        Every path: Write a program that takes as input a directed weighted graph and to of its vertices,
        u and w and prints every simple path that goes from u to w with a length of 7.
 */

import java.util.*;

public class EveryPath {

    static Map<Integer, List<Edge>> graph = new HashMap<>();

    static void dfs(int current, int target, int totalCost, List<Integer> path, Set<Integer> visited) {

        if(current == target && totalCost == 7) {
            System.out.println(path);
            return;
        }

        if(totalCost >= 7) {
            return;
        }

        if(graph.containsKey(current)) {
            for(Edge e : graph.get(current)) {
                if(!visited.contains(e.dest)){
                    path.add(e.dest);
                    visited.add(e.dest);
                    dfs(e.dest, target, totalCost + e.weight, path, visited);

                    path.remove(path.size() - 1);
                    visited.remove(e.dest);
                }
            }
        }

    }

    public static void main(String[] args) {
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(new Edge(2,2));
        graph.computeIfAbsent(2, k -> new ArrayList<>()).add(new Edge(3,4));
        graph.computeIfAbsent(1, k -> new ArrayList<>()).add(new Edge(3,4));
        graph.computeIfAbsent(3, k -> new ArrayList<>()).add(new Edge(4,2));
        graph.computeIfAbsent(2, k -> new ArrayList<>()).add(new Edge(4,5));
        graph.computeIfAbsent(4, k -> new ArrayList<>()).add(new Edge(5,1));
        graph.computeIfAbsent(2, k -> new ArrayList<>()).add(new Edge(5,5));
        graph.computeIfAbsent(3, k -> new ArrayList<>()).add(new Edge(5,3));

        int u = 1;
        int w = 5;

        List<Integer> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        path.add(u);
        visited.add(u);

        System.out.println("Path from " + u + " to " + w + " with total cost of 7:");
        dfs(u, w, 0, path, visited);
    }

}
