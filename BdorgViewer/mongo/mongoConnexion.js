/* -------------------------------------
 * Les imports
 --------------------------------------*/
var mongoClient = require('mongodb').MongoClient
, events = require('events');

// evenement à transmettre 

var evenementConnexion = new events.EventEmitter();

var dbase;

/*
 * ------------------------------------- 
 * Fonction database
 * --------------------------------------
 */
function database(){
	return dbase;
}


/*
 * ------------------------------------- 
 * Fonction de connexion
 * --------------------------------------
 */
function connexion(urlConnexion) {
	// var url = 'mongodb://localhost:27017/myproject';
	mongoClient.connect(urlConnexion, function(err, db) {
		if(err != null){
			evenementConnexion.emit("erreur");
		}
		else {
			dbase = db;
			evenementConnexion.emit("connexion");
		}
	});
};
	// les exports
	exports.connexion = connexion;
	exports.evenementConnexion = evenementConnexion;
	exports.database = database

	
