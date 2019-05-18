**Alizée BOUHANA**<br/>
**Damien GALOCHET**

<h1>Conclusion</h1>
<p>
Les design pattern servent de solution d'implémentation pour un problème spécifique. 
Cette méthodologie de conception est une source d'inspiration pour éviter les erreurs de type DRY, 
YAGONI, KISS, SOLID ...
Mais il n'est pas obligatoire d'implémenter un design pattern pour que le code soit considéré comme "bon", 
s'il n'y a pas d'utilité alors il ne sert à rien d'en utiliser un.
</p>
<br/>
<h3>Pattern Strategy</h3>
<p>
Ce pattern sert à modifier dynamiquement le comportement d'une classe suivant les différentes stratégies qui ont 
été implémentées. 
<br/><br/>
  
  **Exemple d'utilisation** :<br/>
<img src="https://github.com/PolytechLyon/isi3-patterns-isi3-patterns_bouhana_galochet/blob/master/Patterns/Rapport/exempleStrategy.png"/>
<br/>
Ici le contexte est de payer le contenu de son panier en ligne. On a plusieurs 
stratégies de paiement, à savoir le paiement par carte ou paypal. Ces deux techniques visent au même but (payer le contenu de son panier) 
mais avec deux méthodes différentes.
</p><br/>
<h3>Pattern Composite</h3>
<p>
Ce pattern sert a gérer un ensemble d'objets en tant qu'un seul et même objet. On décompose notre objet principal (que 
l'on nomme Composite) en plusieurs Composants (qui implémentent l'interface Composant). On peut donc ajouter plusieurs 
composants au composite ou en enlever, et cela permet d'additionner les propriétés des objets ainsi que leurs méthodes.
<br/><br/>
  
  **Exemple d'utilisation** :<br/>
<img src="https://github.com/PolytechLyon/isi3-patterns-isi3-patterns_bouhana_galochet/blob/master/Patterns/Rapport/exempleComposite.png"/>
<br/>
Ici on remarque que notre classe Dessin est considéré comme le composite, et il 
possède des Formes qui sont donc ses composants. Le composite possède les méthodes pour ajouter et enlever des composants 
ainsi qu'une méthode commune de calcul de volume qui ne sera pas la même suivant les composants du dessin.
</p><br/>
<h3>Pattern Visitor</h3>
<p>
Ce pattern sert à centraliser et externaliser (méthodes implémentées en dehors des classes objets) des actions à faire 
sur des objets qui n'ont pas de liens entre eux.
<br/><br/>
  
  **Exemple d'utilisation** :<br/>
  
<img src="https://github.com/PolytechLyon/isi3-patterns-isi3-patterns_bouhana_galochet/blob/master/Patterns/Rapport/exempleVisitor.png"/>
<br/>
Ici notre interface Printer fait office de Visitor et notre interface Forme fait office de Visitable. Donc les méthodes 
accept sont traduites dans notre exemple par les méthodes printOn, et les méthodes visit par print. Ce pattern sert donc 
à centraliser la méthode d'impression (ink ou laser) sans l'implementer directement dans les classes de type Formes.
</p>
