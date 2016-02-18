/**
 * http://usejsdoc.org/
 */
var mongoClient = require('mongodb').MongoClient, 
mongoInsert = require('../mongoInsert'),
mongoSelect = require('../mongoSelect'),
assert = require('assert'),
events = require('events');

var event = new events.EventEmitter();
var dbase;

/*
 * ------------------------------------- 
 * Fonction database qui permet de fournir la database
 * --------------------------------------
 */
function database(){
	return dbase;
}

/*
* ------------------------------------- 
* Fonction pour se connecter à la database
* --------------------------------------
*/
var connect = function(){
	mongoClient.connect('mongodb://localhost:27017/myproject',function(err, db) {
		if(err != null){
			console.log("Erreur de connexion");
			event.emit("erreur");
		}
		else {
			dbase = db;
			console.log("Connected");
			event.emit("connected");
		}
	});
}

/*
* ------------------------------------- 
* Fonction pour inserer
* --------------------------------------
*/
var select = function() {
	console.log("select");
	mongoSelect.selectDocuments(database(), function() {
	event.emit("selected");
		});
};

/*
* ------------------------------------- 
* Fonction pour select
* --------------------------------------
*/
var insert = function() {
	console.log("insert");
	mongoInsert.insertDocuments(database(), function() {
	event.emit("insered")});
};


/*
* ------------------------------------- 
* Fonction pour drop
* --------------------------------------
*/
var drop = function() {
	console.log("drop");
	var collection = database().collection('personnes');
	collection.drop(function(err, reply){
		assert.equal(null, err);
		console.log("dropped");
	});
};

connect();
// Dans l'event ne pas mettre les parenthèse sur la fonction. 
event.on("connected", drop);

// ou
/*
event.on("connected", insert);
event.on("insered", select);

*/



