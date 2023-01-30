package chapter8;

class SuperBoxWeight extends Box {
    double weight;

    SuperBoxWeight(double w, double h, double d, double m) {
        super(w, h, d);
        weight = m;
    }
}
