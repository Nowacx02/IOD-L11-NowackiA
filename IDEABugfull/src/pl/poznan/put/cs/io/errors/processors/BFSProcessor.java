package pl.poznan.put.cs.io.errors.processors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFSProcessor {

    List<Integer> list = new ArrayList<Integer>();
    Set<Integer> visitedNodes = new HashSet<Integer>();
    Queue<Integer> queue = new LinkedList<Integer>();
    List<Integer> result = new ArrayList<Integer>();
    int[][] matrix;

    /**
     * Adam Nowacki
     * Ta klasa służy do zastosowania metody BFS dla wyszukiwania wszerz dla grafu opisanego
     * macierzą sąsiedztwa. Przeszukiwanie rozpoczyna się od węzła o najniższym indeksie, który posiada przynajmniej jednego sąsiada.
     * Klasa wykorzystuje kolejkę FIFO do odwiedzania kolejnych węzłów, a także przechowuje informacje
     * o odwiedzonych węzłach.
     *
     * @param matrix zawiera macierz sasiedztwa
     * @return lista sasiednich wierzcholkow
     */
    public List<Integer> process(int[][] matrix) {
        this.matrix = matrix;
        int beginningNode = getBeginningNode();
        if (beginningNode == -1) {
            return null;
        }
        queue.add(new Integer(beginningNode));
        search(beginningNode);
        result.addAll(findNodesWthoutNeighbors());
        return result;
    }

    /**
     * Runs the BFS algorithm for the given node
     *
     * @param nodeNo number of the node
     */
    private void search(int nodeNo) {
        visitedNodes.add(new Integer(nodeNo));
        List<Integer> allValidNeighbors = getAllValidNeighbors(nodeNo);
        queue.addAll(allValidNeighbors);
        visitedNodes.addAll(allValidNeighbors);
        Integer head = queue.poll();
        if (head == null) {
            return;
        }
        result.add(new Integer(nodeNo));
        if (queue.peek() == null) {
            return;
        }
        search(head);
    }

    /**
     * Looks for the node with the lowest index number, which has got at least
     * one neighbor
     *
     * @return the lowest possible index of the node, which has got at least one
     * neighbor
     */
    private int getBeginningNode() {
        for (int i = 0; i < matrix.length; i++) {
            if (getAllValidNeighbors(i).size() != 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Adam Nowacki
     * W tej metodzie poprzedni warunek sprawdzał czy węzeł został już odwiedzony, a następnie dodawał go jako sąsiada, co było błędne.Zamiast tego powinno być sprawdzane,czy węzeł nie został odwiedzony przed dodaniem go do listy sąsiadów.Zmieniłem warunek na !visitedNodes.contains(i).
     *
     * @param nodeNo indeks węzła
     * @return lista indeksów(sąsiadów)
     */
    private List<Integer> getAllValidNeighbors(int nodeNo) {
        List<Integer> neighbors = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[nodeNo][i] == 1 && !visitedNodes.contains(i)) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }


    /**
     * Finds all nodes without neighbors
     *
     * @return list of nodes indexes without neighbors
     */
    private List<Integer> findNodesWthoutNeighbors() {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            if (!visitedNodes.contains(new Integer(i))) {
                result.add(new Integer(i));
            }
        }
        return result;
    }
}
