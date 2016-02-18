var googlemap = require('../googlemap');

var origine = 'Verneuil sur seine';
var destination = 'Avranches'

console.log("origine :"+origine);
console.log("origine :"+destination);
// test
googlemap.distanceEntreDeuxPoints(origine,destination,function(retour){
  console.log(retour.temps);
  console.log(retour.distance);
});
