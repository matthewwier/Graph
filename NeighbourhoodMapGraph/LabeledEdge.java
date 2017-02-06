/**
 * Created by Maciej on 2016-12-13.
 */
public interface LabeledEdge<LabelType, NodeLabelType> {

    LabeledVertex<NodeLabelType> getFrom();

    LabeledVertex<NodeLabelType> getTo();

    LabelType getLabel();

    void setLabel(LabelType label);

}