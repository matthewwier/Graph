import javafx.scene.shape.VertexFormat;

import javax.swing.text.html.HTMLDocument;
import java.util.*;

/**
 * Created by Maciej on 2016-12-13.
 */
class Vertex<NodeLabelType> implements LabeledVertex<NodeLabelType> {
    NodeLabelType label;

    public Vertex(NodeLabelType label) {
        this.label = label;
    }

    @Override
    public NodeLabelType getLabel() {
        return this.label;
    }

    @Override
    public void setLabel(NodeLabelType label) {
        this.label = label;
    }
}

class Edge<EdgeLabelType, NodeLabelType> implements LabeledEdge<EdgeLabelType, NodeLabelType> {
    LabeledVertex<NodeLabelType> from;
    LabeledVertex<NodeLabelType> to;
    EdgeLabelType edgeLabel;

    public Edge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to, EdgeLabelType edgeLabel) {
        this.from = from;
        this.to = to;
        this.edgeLabel = edgeLabel;
    }

    @Override
    public LabeledVertex<NodeLabelType> getFrom() {
        return from;
    }

    @Override
    public LabeledVertex<NodeLabelType> getTo() {
        return to;
    }

    @Override
    public EdgeLabelType getLabel() {
        return edgeLabel;
    }

    @Override
    public void setLabel(EdgeLabelType label) {
        edgeLabel = label;
    }
}

class NeighbourhoodMapGraph<NodeLabelType, EdgeLabelType> implements EditableGraph<NodeLabelType, EdgeLabelType> {

    List<LabeledVertex<NodeLabelType>> vertices;
    Map<LabeledVertex<NodeLabelType>, List<LabeledEdge<EdgeLabelType, NodeLabelType>>> neighbourhood;

    public NeighbourhoodMapGraph() {
        vertices = new LinkedList<LabeledVertex<NodeLabelType>>();
        neighbourhood = new LinkedHashMap<LabeledVertex<NodeLabelType>, List<LabeledEdge<EdgeLabelType, NodeLabelType>>>();
    }

    @Override
    public Iterator<? extends LabeledVertex<NodeLabelType>> vertexIterator() {
        return this.vertices.iterator();
    }

    @Override
    public Iterator<? extends LabeledEdge<EdgeLabelType, NodeLabelType>> edgeIterator(LabeledVertex<NodeLabelType> vertex) {
        return this.neighbourhood.get(vertex).iterator();
    }

    @Override
    public LabeledEdge<EdgeLabelType, NodeLabelType> getEdge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to) {
        while (edgeIterator(from).hasNext()) {
            LabeledEdge<EdgeLabelType, NodeLabelType> edge = edgeIterator(from).next();
            if (edge.getTo().equals(to)) {
                return edge;
            }
        }
        return null;
    }

    @Override
    public LabeledVertex<NodeLabelType> addVertex(NodeLabelType label) {
        LabeledVertex<NodeLabelType> vertex = new Vertex<NodeLabelType>(label);
        vertices.add(vertex);
        neighbourhood.put(vertex, new LinkedList<LabeledEdge<EdgeLabelType, NodeLabelType>>());
        return vertex;
    }

    @Override
    public LabeledEdge<EdgeLabelType, NodeLabelType> addEdge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to, EdgeLabelType label) {
        LabeledEdge<EdgeLabelType, NodeLabelType> edge = new Edge<EdgeLabelType, NodeLabelType>(from, to, label);
        neighbourhood.get(from).add(edge);
        return edge;
    }

    @Override
    public void removeVertex(LabeledVertex<NodeLabelType> v) {
        Iterator<? extends LabeledVertex<NodeLabelType>> iterator = vertexIterator();
        while (iterator.hasNext()) {
            LabeledVertex<NodeLabelType> next = iterator.next();
            if (next.equals(v)) {
                vertices.remove(v);
                neighbourhood.remove(v);
                return;
            }
        }
    }

    @Override
    public LabeledEdge<EdgeLabelType, NodeLabelType> removeEdge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to) {
        Iterator<? extends LabeledEdge<EdgeLabelType, NodeLabelType>> iteratorFrom = edgeIterator(from);
        while (iteratorFrom.hasNext()) {
            Edge<EdgeLabelType, NodeLabelType> next = (Edge<EdgeLabelType, NodeLabelType>) iteratorFrom.next();
            if (next.getTo().equals(to)) {
                neighbourhood.remove(from, next);
                return next;
            }
        }
        return null;
    }
}
