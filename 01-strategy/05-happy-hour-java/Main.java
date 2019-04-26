import java.lang.String;
import java.lang.System;


class Beer {
  private Double price;
  private String brand;

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Beer(String brand, Double price) {
    this.price = price;
    this.brand = brand;
  }
}

interface HappyHourStrategy {
  public double calculateNewPrice(Beer beer);
}

class NoDiscount implements HappyHourStrategy {
  private double discount = 1.;

  public double calculateNewPrice(Beer beer) {
    return beer.getPrice() * this.discount;
  }
}

class TenPercent implements HappyHourStrategy {
  private double discount = 0.9;

  public double calculateNewPrice(Beer beer) {
    return beer.getPrice() * this.discount;
  }
}

class TwentyFivePercent implements HappyHourStrategy {
  private double discount = 0.75;

  public double calculateNewPrice(Beer beer) {
    return beer.getPrice() * this.discount;
  }
}

class PubWaiter {
  private String name ;
  private HappyHourStrategy strategy;

  public PubWaiter(String name){
    this.name = name;
  }

  public void setStrategy(HappyHourStrategy strategy){
    this.strategy = strategy;
  }

  public double calculatePrice(Beer beer){
      return this.strategy.calculateNewPrice(beer);
  }
}


public class Main {
  public static void main(String[] args) {

    /* initialize strategy */
    HappyHourStrategy noDiscount = new NoDiscount();
    HappyHourStrategy tenPercent = new TenPercent();
    HappyHourStrategy twentyFivePercent = new TwentyFivePercent();

    /* initialize Beers */
    Beer chouffe = new Beer("Chouffe", 3.0);
    Beer paleAle = new Beer("Pale Ale", 4.0);
    Beer ipa = new Beer("IPA", 5.0);

    /* waiter */
    PubWaiter bob = new PubWaiter("Bob");

    /* orders */
    bob.setStrategy(noDiscount);
    Double paleAlePrice = bob.calculatePrice(paleAle);

    bob.setStrategy(tenPercent);
    Double chouffePrice = bob.calculatePrice(chouffe);

    bob.setStrategy(twentyFivePercent);
    Double ipaPrice = bob.calculatePrice(ipa);

    if(paleAlePrice.equals(4.0)) {
      System.out.println("paleAlePrice ok");
    } else {
      System.out.println("paleAlePrice ko");
    };

    if(chouffePrice.equals(2.7)) {
      System.out.println("chouffePrice ok");
    } else {
      System.out.println("chouffePrice ko");
    };

    if(ipaPrice.equals(3.75)) {
      System.out.println("ipaPrice ok");
    } else {
      System.out.println("ipaPrice ko");
    };

  }
}