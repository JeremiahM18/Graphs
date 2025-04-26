/*
    Write a program that takes as input an array of size n and creates an image of the directed graph
    defined by that array, as explained below.
    Each vertex is defined by a letter (name of the vertex) and an integer x which determines that exists
    one edge between that vertex and the vertex that is x positions to its right and the vertex that is
    x positions to its left in the initial array, the array is considered circular.
 */

import java.util.ArrayList;
import java.util.List;

public class DrawGraph {

    private static List<Vertex> parseInput(String input){
        List<Vertex> list = new ArrayList<>();
        input = input.replaceAll("[\\[\\]()]","");
        String[] tokens = input.split(",");

        for(int i = 0; i < tokens.length; i += 2){
            String name = tokens[i].trim();
            int dist = Integer.parseInt(tokens[i+1].trim());
            list.add(new Vertex(name, dist));
        }
        return list;
    }
}
