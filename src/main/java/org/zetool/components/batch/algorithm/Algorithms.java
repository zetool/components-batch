
package org.zetool.components.batch.algorithm;

//import org.zetool.common.algorithm.Algorithm;
//import de.tu_berlin.coga.graph.DefaultDirectedGraph;
//import de.tu_berlin.coga.graph.Edge;
//import de.tu_berlin.coga.graph.Node;
//import de.tu_berlin.coga.graph.structure.Path;
//import de.tu_berlin.coga.graph.util.GraphUtil;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Martin Groß
 */
public class Algorithms {
    
    private static Algorithms instance;

    public static Algorithms getInstance() {
        if (instance == null) {
            instance = new Algorithms();
        }
        return instance;
    }

//    private DefaultDirectedGraph network;
    
//    private HashMap<Edge, Algorithm> algorithmForEdge;
 //   private HashMap<Class, Node> nodeForClass;    
    
    private Algorithms() {
//        algorithmForEdge = new HashMap<>();
 //       nodeForClass = new HashMap<>();        
    }

  //  public List<Algorithm<?,?>> getAlgorithms(Class<?> problem, Class<?> solution) {
   //   Path path = GraphUtil.getPath( network, nodeForClass.get(problem), nodeForClass.get(solution));
   //     if (path == null) {
//            return null;
//        } else {
//            LinkedList<Algorithm<?,?>> result = new LinkedList<>();
//            for (Edge edge : path) {
//                result.add(algorithmForEdge.get(edge));
//            }
//            return result;
//        }
//    }

//    public <P,S> void registerAlgorithm(Algorithm<P,S> algorithm, Class<P> problem, Class<S> solution) {
//        Node problemNode = nodeForClass.get(problem);
//        Node solutionNode = nodeForClass.get(solution);
//        if (problemNode == null) {
//            network.setNodeCapacity(network.getNodeCapacity() + 1);
//            problemNode = network.getNode(network.nodeCount() - 1);
//            nodeForClass.put(problem, problemNode);
//        }
//        if (solutionNode == null) {
//            network.setNodeCapacity(network.getNodeCapacity() + 1);
//            solutionNode = network.getNode(network.nodeCount() - 1);
//            nodeForClass.put(solution, solutionNode);
//        }
//        network.setEdgeCapacity(network.getEdgeCapacity() + 1);
//        Edge edge = network.createAndSetEdge(problemNode, solutionNode);
//        algorithmForEdge.put(edge, algorithm);
//    }
}
