import java.util.Iterator;

/**
 * Created by Maciej on 2016-12-27.
 */
public class LabeledGraphDescriptor<NodeLabelType, EdgeLabelType> {
    EditableGraph<NodeLabelType, EdgeLabelType> graph;
    String separator;

    public LabeledGraphDescriptor(EditableGraph g, String separator) {
        graph = g;
        this.separator = separator;
    }


    public String toString() {
        String stringGraph = "";
        Iterator<? extends LabeledVertex<NodeLabelType>> iteratorVertex = graph.vertexIterator();
        while (iteratorVertex.hasNext()) {
            LabeledVertex<NodeLabelType> nextVertex = iteratorVertex.next();
            stringGraph += "{" + nextVertex.getLabel() + "->";
            Iterator<? extends LabeledEdge> iteratorEdge = graph.edgeIterator(nextVertex);
            while (iteratorEdge.hasNext()) {
                LabeledEdge<EdgeLabelType, NodeLabelType> nextEdge = iteratorEdge.next();
                stringGraph += nextEdge.getTo().getLabel() + ": " + nextEdge.getLabel() + "|";
            }
            stringGraph += "}" + separator;
        }
        return stringGraph;
    }
}
