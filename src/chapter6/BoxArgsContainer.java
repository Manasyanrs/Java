package chapter6;

public class BoxArgsContainer {
    double width;
    double height;
    double depth;

    BoxArgsContainer(double w, double h, double d){
        width = w;
        height = h;
        depth = d;
    }

    double volume(){
        return width * height * depth;
    }
}
