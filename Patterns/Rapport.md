<h6>Alizée BOUHANA</h6>
<h6>Damien GALOCHET</h6>

<h3>Conclusion</h3>
<p>
Les design pattern servent de solution d'implémentation pour un problème spécifique. 
Cette méthodologie de conception est une source d'inspiration pour eviter les erreurs de type DRY, 
YAGONI, KISS, SOLID ...
Mais il n'est pas obligatoire d'implémenter un design pattern pour que son code soit bon, 
s'il n'y en a pas l'utilité alors il ne sert a rien d'en utiliser un.
</p>
<br/>
<h5>Pattern Strategy<h5>
<p>
<br/><br/><u>exemple d'utilisation</u> :
</p><br/>
<h5>Pattern Composite<h5>
<p>
Ce pattern sert a gérer un ensemble d'objets en tant qu'un seul et même objet. On décompose notre objet principal (que 
l'on nomme Composite) en plusieurs Composants (qui implémentent l'interface Composant). On peut donc ajouter plusieurs 
composants au composite ou enlever, et cela permet d'additionner les propriétés des objets ainsi que leurs méthodes.
<br/><br/><u>exemple d'utilisation</u> : Ici on remarque que notre classe Dessin est considéré comme le composite, et il 
possède des Formes qui sont donc ses composants. Le composite possède les méthodes pour ajouter et enlever des composants 
ainsi qu'une méthode commune de calcul de volume qui ne sera pas la meme suivant les composants du dessin.
</p><br/>
<h5>Pattern Visitor<h5>
<p>
<br/><br/><u>exemple d'utilisation</u> :
</p>
