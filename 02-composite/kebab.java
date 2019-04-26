import java.lang.String;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;

interface Component {
  public boolean isVG();
  public void operation();
}

class Leaf implements Component {
  private boolean isVege;
  private String name;

  public Leaf(String name, boolean isVege){
    this.name = name;
    this.isVege = isVege;
  }

  public void operation(){
    System.out.println("operation -> " + this.name);
  }

  public boolean isVG(){
    return this.isVege;
  }

}

class Composite implements Component {
  private String name;
  private List<Component> composition = new ArrayList<>();

  public Composite(String name){
    this.name = name;
  }

  public void operation(){
    System.out.println("Composite Operation for: " + this.name);
    for(Component comp : this.composition){
      comp.operation();
    }
  }

  public void add(Component comp){
    this.composition.add(comp);
  }

  public boolean isVG(){
    return this.composition.stream().allMatch(element -> element.isVG());
  }

}



public class Main {
  public static void main(String[] args) {
Composite sandwich = new Composite("pain");

    Composite garniture = new Composite("garniture");

    garniture.add(new Leaf("salade", true));
    garniture.add(new Leaf("tomate", true));
    garniture.add(new Leaf("oignons", true));
    //garniture.add(new Leaf("veau", false));
    garniture.add(new Leaf("steak soja", true));

    sandwich.add(garniture);
    sandwich.operation();

    if(sandwich.isVG()) {
      System.out.println("Le sandwich est VG");
    }
    else {
      System.out.println("Le sandwich est non VG");
    }
  }
}