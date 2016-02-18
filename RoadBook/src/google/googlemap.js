var http = require("http");

function Resultat () {
  this.temps = 0;
  this.distance = 0;;
}



//----------------------------------------------------------------------------
//  Fonction qui donne la distance en voiture entre deux points.
//----------------------------------------------------------------------------
var distanceEntreDeuxPoints = function(origine, destination, callbalck) {
  url = 'http://maps.googleapis.com/maps/api/directions/json?origin='+origine+
  '&destination='+destination+'&sensor=false&mode=driving';

  // Appel de la requete
  var request = http.get(url, function (response) {
    //-------------------------------------------------------------------------
    //  Fonction de traitement de la requete
    //-------------------------------------------------------------------------
    var buffer = "",
        data,
        route;

    // event "data"
    response.on("data", function (chunk) {
      //-------------------------------------------------------------------------
      //  Fonction de traitement des data
      //-------------------------------------------------------------------------
      buffer += chunk;
    });// end event "data"

    // event "end"
    response.on("end", function (err) {

      //-------------------------------------------------------------------------
      //  Fonction fin de traitement des datas
      //-------------------------------------------------------------------------
        //console.log(buffer);
        //console.log("\n");
        data = JSON.parse(buffer);
        route = data.routes[0];

        // extract the distance and time
        //console.log("Distance: " + route.legs[0].distance.text);
        //console.log("Time: " + route.legs[0].duration.text);

        var retour = new Resultat;
        retour.origine = origine;
        retour.destination = destination;
        retour.distance = route.legs[0].distance.text;
        retour.temps = route.legs[0].duration.text;
        callbalck(retour);


    });// end event "end"
  });// end request.

  // event error sur la request
  request.on('error', function(err){
    console.log('Anomalie lors du lancement de la requête');
    console.log(err);
  });// end event error sur la request

};



// les exports
exports.distanceEntreDeuxPoints = distanceEntreDeuxPoints;
exports.EventEmitter
