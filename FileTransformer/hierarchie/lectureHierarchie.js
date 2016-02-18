/**
 * http://usejsdoc.org/
 */

var Transform = require('stream').Transform
, csv = require('csv-streamify')
, JSONStream = require('JSONStream')
, fs= require('fs');


// le stream du fichier
var dataFile = fs.createReadStream('hierarchie.csv', { encoding: 'binary' });
//var dataFile = fs.createReadStream('toto.txt');
var write = fs.createWriteStream('hierarchie.json');

// csvToJson 
var csvToJson = csv({objectMode: true,delimiter: ';' });// comma, semicolon, whatever

// un transformer 
var parser = new Transform({objectMode: true, delimiter: ';'});
parser._transform = function(data, encoding, done) {
	
	var hierarchie = {
			codification 			:	data[0],
			type					:	data[1],
			libelle					:	data[2],
			site					:	data[3],
			loginResponsable		:	data[4],
			structureRattachement	:	data[5],
			activiteMetier			:	data[6],
			identiteResponsable 	:	data[7],
			libelleStructureMere	:	data[8],
	};
	
	if (hierarchie.codification != "" && hierarchie.codification != "Structure") 
		this.push(hierarchie);
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


