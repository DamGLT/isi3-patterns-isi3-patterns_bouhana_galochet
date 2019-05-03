import java.lang.String;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;

interface Visitor {
  public void visit(Visitable v);
}

interface Visitable{
  public void accept(Visitor v);
}


class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");
  }
}