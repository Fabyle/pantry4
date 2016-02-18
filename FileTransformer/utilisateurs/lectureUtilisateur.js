/**
 * http://usejsdoc.org/
 */

var Transform = require('stream').Transform
, csv = require('csv-streamify')
, JSONStream = require('JSONStream')
, fs= require('fs');


// le stream du fichier
var dataFile = fs.createReadStream('utilisateurs.csv', { encoding: 'binary' });
//var dataFile = fs.createReadStream('toto.txt');
var write = fs.createWriteStream('utilisateurs.json');

// csvToJson 
var csvToJson = csv({objectMode: true,delimiter: ';' });// comma, semicolon, whatever

// un transformer 
var parser = new Transform({objectMode: true, delimiter: ';'});
parser._transform = function(data, encoding, done) {
	
	var utilisateur = {
			loginMetier 			:	data[0],
			loginGroupe				:	data[1],
			prenom					:	data[2],
			nom						:	data[3],
			civilite				:	data[4],
			codeCellule				:	data[5],
			libelleCellule			:	data[6],
			compteWindowsAG2R	 	:	data[7],
			compteWindowsGED		:	data[8],
			machine					:	data[9]
	};
	
	if (utilisateur.nom != "" && utilisateur.nom != "Nom utilisateur") 
		this.push(utilisateur);
  done();
};

// json to string
var jsonToStrings = JSONStream.stringify(false);

dataFile
.pipe(csvToJson)
.pipe(parser)
.pipe(jsonToStrings)
//.pipe(process.stdout);
.pipe(write);


