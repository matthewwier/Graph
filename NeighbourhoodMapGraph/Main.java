import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Maciej on 2016-12-13.
 */
public class Main {
    public static void main(String[] args) {
        EditableGraph<String, Double> g = new NeighbourhoodMapGraph<String, Double>();

        @SuppressWarnings("unchecked") // nie ma tablic generycznych

                LabeledVertex<String>[] vs = new LabeledVertex[]{

                g.addVertex("pierwszy"),

                g.addVertex("następny"),

                g.addVertex("kolejny"),

                g.addVertex("ostatni")

        };

        g.addEdge(vs[0], vs[1], 35.0);

        g.addEdge(vs[0], vs[3], 15.1);

        g.addEdge(vs[1], vs[2], 12.9);

        g.addEdge(vs[3], vs[2], -1.3);

        g.addEdge(vs[3], vs[0], 125.0);

        g.addEdge(vs[2], vs[0], 5.5);

        System.out.println(new LabeledGraphDescriptor<>(g, "\n"));

        System.out.println("-----");


        vs[2].setLabel("zmieniony");


        g.getEdge(vs[2], vs[0]).setLabel(34.0);
        g.removeEdge(vs[3], vs[0]);

        g.removeVertex(vs[1]);
        System.out.println(new LabeledGraphDescriptor<>(g,"\n"));
    }

}
