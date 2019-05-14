import java.util.ArrayList;

public class Main {

  interface Visitor {
    public boolean visit(Visitable item);
  }

  interface Visitable {
    public boolean accept(Visitor visitor);
  }

  static class Garniture implements Visitable{
    private String name;
    private boolean isVege;

    public Garniture(String name, boolean isVege) {
      this.name=name;
      this.isVege=isVege;
    }

    @Override
    public boolean accept(Visitor visitor) {
      return visitor.visit(this);
    }
  }

  static class Kebab implements Visitable {
    public ArrayList<Garniture> garnitures;

    public Kebab() {
      this.garnitures=new ArrayList<>();
    }

    public void add (Garniture garn) {
      this.garnitures.add(garn);
    }

    public boolean accept(Visitor visitor) {
      return visitor.visit(this);
    }
  }

  static class IsVG implements Visitor {

    public boolean visit(Visitable item) {
      if (item instanceof Garniture) {
        return ((Garniture) item).isVege;
      }
      else if (item instanceof Kebab) {
        for (Garniture garn : ((Kebab)item).garnitures) {
          if (!garn.isVege) {
            return false;
          }
        }
        return true;
      }
      else {
        return false;
      }
    }
  }

  public static void main(String [] args) {
    Kebab sandwich = new Kebab();

    sandwich.add(new Garniture("salade",true));
    sandwich.add(new Garniture("tomate",true));
    sandwich.add(new Garniture("oignons",true));
    sandwich.add(new Garniture("veau",false));
    
    if(sandwich.accept(new IsVG())){
      System.out.println("Kebab VG");
    } else{
      System.out.println("Kebab non VG");
    }

  }
}