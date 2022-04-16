package Problems.Array;

import Common.Problem;

import java.util.ArrayList;

public class NDimensionalList extends Problem {
    @Override
    public void run() {
        System.out.println("Running N Dimensional Integer List");
        int n;
        n = 3;
        this.initNDimensionalList(n);
    }

    private class NDimension {
        int dimension;
        //ArrayList<T> intList;
        public NDimension(int n) {
            dimension = n;
        }

        public void initNDimension() {
            if (this.dimension == 1) {

            }
        }

        public void initNDimension(int level, ArrayList<ArrayList<Integer>> input) {
            if (level == this.dimension) {
                // Do something
                return;
            }
            for (int i = 0; i < this.dimension; i++) {
                ArrayList<ArrayList<Integer>> newList = new ArrayList<>();
                this.initNDimension(level + 1, newList);
            }
        }
    }

    private void initNDimensionalList(int n) {
        NDimension nDimension = new NDimension(n);
    }
}
