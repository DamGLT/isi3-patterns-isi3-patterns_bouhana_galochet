import java.lang.String;
import java.lang.System;
import java.util.ArrayList;
import java.util.List;

interface Visitor {
  public void visit(Visitable visitable);
}

interface Visitable{
  public void accept(Visitor visitor);
}


class Kebab implements Visitable{
  public List<Garniture> garniture = new ArrayList<>();
  public boolean isVG = true;

  public Kebab(List<Garniture> garnitures){
    this.garniture = garnitures;
  }

  public void accept(Visitor visitor){
    for(Garniture item : this.garniture){
      item.accept(visitor);
    }
  }
}

class Garniture implements Visitable{
  public String name;
  public boolean isVege;

  public Garniture(String name){
    this.name = name;
  }

  public void accept(Visitor visitor){
    visitor.visit(this);
  }
}

class VG implements Visitor{

  public VG(){

  }

  public void visit(Garniture item){
    switch(item.name){
      case "viande":
      case "veau":
      case "boeuf":
        item.isVege = false;
        break;
      default:
        item.isVege = true;
        break;
    }
  }
}


class Main {
  public static void main(String[] args) {
    List<Garniture> garniture = new ArrayList<>();
    garniture.add(new Garniture("veau"));
    garniture.add(new Garniture("salade"));
    garniture.add(new Garniture("viande"));
    garniture.add(new Garniture("tomate"));
    garniture.add(new Garniture("oignons"));
    Kebab sandwich = new Kebab(garniture);

    for(Garniture garn : sandwich.garniture){
      System.out.println(garn.name);
      System.out.println(garn.isVege);
    }
  }
}