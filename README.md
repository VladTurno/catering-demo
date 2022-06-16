# catering-demo
demo del progetto catering
[Giugno2022] Turno 535396

MALFUNZIONAMENTI NOTI: 
SpringSecurity) purtroppo tutta la parte relativa a spring security e all'autenticazione mi ha creato seri problemi e non sono riuscito a venirne a capo.
                ho quindi dovuto rifare da 0 un progetto demo senza la parte di login utente/admin
Css) non so per quale motivo ma non riesco a legare lo stylesheet css a pagine html della forma "/oggetto/id", ovvero le singole schede di chef, buffet, 
     piatti, ingredienti le relative shede di delete. Le pagine di index, form, elenchi e la prima visalizzazione di un oggetto dopo la creazione risultano
     stilizzate correttamente.
   
CASI D'USO FINORA IMPLEMENTATI: 

a) un utente può creare un ingrediente, visualizzare la lista degli ingredienti creati e per ogni ingrediente può vederne i dettagli o eliminarlo.
b) un utente può creare un piatto, visualizzare la lista dei piatti creati e per ogni piatto può vederne i dettagli o eliminarlo.
c) un utente può creare un chef, visualizzare la lista degli chef creati e per ogni chef può vederne i dettagli o eliminarlo.
d) un utente può creare un buffet, visualizzare la lista dei buffet creati e per ogni buffet può vederne i dettagli o eliminarlo.
   N.B. durante la creazione di un buffet è possibile inserire lo chef che lo ha creato tramite id a patto che esista uno chef con tale id. 
   purtroppo non sono riuscito a implementare un menù a tendina che mi facesse scegliere uno chef tra quelli già creati.
e) un utente può navigare le liste degli chef, dei buffet, degli ingredienti e dei piatti creati.
          
