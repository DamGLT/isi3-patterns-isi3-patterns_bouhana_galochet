//👋 Visitor Pattern

interface Visitor {
    visit(item: Visitable):void
}

interface Visitable {
    accept(visitor: Visitor): void
}

class Garniture implements Visitable {
    name: string
    isVege: boolean
    constructor(name: string) {
        this.name = name
        this.isVege = true
    }
    public accept(visitor: Visitor) {
        visitor.visit(this)
    }

}

class VG implements Visitor {
    visit(item: Garniture) {

        switch(item.name) {
            case ("veau" || "boeuf" || "viande"): {
                item.isVege = false
                break;
            }
            default: {
                item.isVege = true
                break;
            }
        }

    }
}

class Kebab implements Visitable {
    garniture: Garniture[] = []
    constructor(garniture: Garniture[]) {
        this.garniture = garniture
    }

    public accept(visitor: Visitor) {
        this.garniture.forEach(garniture => garniture.accept(visitor))
    }
}

const list = new Kebab([
    new Garniture("salade"),
    new Garniture("tomate"),
    new Garniture("oignon"),
    new Garniture("veau")
])

list.accept(new VG())

console.log(list)

/*
HappyHour {
  beers:
   [ Beer { brand: 'Chouffe', price: 3, discountPrice: 2.7 },
     Beer { brand: 'Pale Ale', price: 4, discountPrice: 4 },
     Beer { brand: 'IPA', price: 5, discountPrice: 3.75 } ] }
*/