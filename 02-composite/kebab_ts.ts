interface Component {
    name: string

    isVG(): boolean
    operation(): void
}

class Leaf implements Component {
    isVege: boolean
    name: string

    constructor(name: string, isVege: boolean) {
        this.name = name
        this.isVege = isVege
    }

    operation(){
        console.log(`operation -> ${this.name}`)
    }

    isVG() {
        return this.isVege
    }
}

class Composite implements Component {
    name: string
    composition: Array<Component>

    constructor(name: string){
        this.name = name
        this.composition = []
        console.log(`Composite ${name} created`)
    }

    operation() {
        console.log('Composite Operation for: ' + this.name)
        this.composition.forEach(element => {
            element.operation()
        })
    }

    add(comp: Component) {
        this.composition.push(comp)
    }

    isVG(){
        return this.composition.every(element => element.isVG())
    }

}

let sandwich = new Composite('pain')
let garniture = new Composite('garniture')

garniture.add(new Leaf('salade', true))
garniture.add(new Leaf('tomate', true))
garniture.add(new Leaf('oignons', true))
//garniture.add(new Leaf('veau', false))
garniture.add(new Leaf('steak soja', true))

sandwich.add(garniture)
sandwich.operation()
if(sandwich.isVG()){
    console.log("sandwich VG")
} else {
    console.log("sandwich non VG")
}
