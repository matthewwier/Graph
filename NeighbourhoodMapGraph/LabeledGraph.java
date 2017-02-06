import java.util.Iterator;

/**
 * Created by Maciej on 2016-12-13.
 */
public interface LabeledGraph<NodeLabelType, EdgeLabelType> {

    Iterator<? extends LabeledVertex<NodeLabelType>> vertexIterator();

    Iterator<? extends LabeledEdge<EdgeLabelType, NodeLabelType>> edgeIterator(LabeledVertex<NodeLabelType> vertex);

    LabeledEdge<EdgeLabelType, NodeLabelType> getEdge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to);

}
