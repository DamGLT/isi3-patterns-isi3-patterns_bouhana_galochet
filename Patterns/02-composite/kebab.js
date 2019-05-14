class Component {
    constructor() {}
    operation() {}
    add (component) {}
    isVG(){}
}

class Leaf extends Component {
    constructor(name, isVege) {
        super()
        this.name = name
        this.isVege = isVege

        console.log("Leaf " + this.name + " created : " + ((isVege)? "VG" : "non VG"))
    }

    operation (){
        console.log(`operation -> ${this.name}`)
    }

    isVG(){
        return this.isVege
    }
}

class Composite extends Component {
    constructor(name) {
        super()
        this.name = name
        this.children = []
        console.log(`Composite ${name} created`)
    }

    operation() {
        console.log('Composite Operation for: ' + this.name)
        this.children.forEach(element => {
            element.operation()
        })
    }

    add(component) {
        this.children.push(component)
    }

    isVG(component){
        return this.children.every(element =>
            element.isVG()
        )
    }

}

let sandwich = new Composite('pain')
let garniture = new Composite('garniture')

garniture.add(new Leaf('salade', true))
garniture.add(new Leaf('tomate', true))
garniture.add(new Leaf('oignons', true))
garniture.add(new Leaf('veau', false))
garniture.add(new Leaf('steak soja', true))

sandwich.add(garniture)
sandwich.operation()
if(sandwich.isVG()){
    console.log("sandwich VG")
} else {
    console.log("sandwich non VG")
}
