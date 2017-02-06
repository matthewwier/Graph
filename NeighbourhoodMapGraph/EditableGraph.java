/**
 * Created by Maciej on 2016-12-13.
 */
public interface EditableGraph<NodeLabelType, EdgeLabelType> extends LabeledGraph<NodeLabelType, EdgeLabelType> {

    LabeledVertex<NodeLabelType> addVertex(NodeLabelType label);

    LabeledEdge<EdgeLabelType, NodeLabelType> addEdge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to, EdgeLabelType label);

    void removeVertex(LabeledVertex<NodeLabelType> v);

    LabeledEdge<EdgeLabelType, NodeLabelType> removeEdge(LabeledVertex<NodeLabelType> from, LabeledVertex<NodeLabelType> to);

}
