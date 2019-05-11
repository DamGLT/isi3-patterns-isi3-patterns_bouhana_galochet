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
            case ("viande"):
            case ("boeuf"):
            case("veau"): {
                item.isVege = false
                break;
            }
            default: {
                item.isVege = true
                break
            }
        }
    }
}

class Kebab implements Visitable {
    garniture: Garniture[] = []
    isVG: boolean
    constructor(garniture: Garniture[]) {
        this.garniture = garniture
        this.isVG = true
    }

    public accept(visitor: Visitor) {
        this.garniture.forEach(
            item => item.accept(visitor)
        )
        this.garniture.forEach(item => this.isVG =(item.isVege==false)? false : this.isVG )
    }
}

const list = new Kebab([
    new Garniture("salade"),
    new Garniture("tomate"),
    //new Garniture("viande"),
    new Garniture("oignon")

])

list.accept(new VG())

console.log(list)

