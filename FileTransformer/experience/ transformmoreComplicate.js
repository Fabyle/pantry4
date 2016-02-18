/**
 * http://usejsdoc.org/
 */

var Transform = require('stream').Transform
, csv = require('csv-streamify')
, JSONStream = require('JSONStream')
, fs= require('fs');


// le stream du fichier
var dataFile = fs.createReadStream('chartres.csv', { encoding: 'binary' });
//var dataFile = fs.createReadStream('toto.txt');
var write = fs.createWriteStream('result.txt');

// csvToJson 
var csvToJson = csv({objectMode: true,delimiter: ';' });// comma, semicolon, whatever

// un transformer 
var parser = new Transform({objectMode: true, delimiter: ';'});
parser._transform = function(data, encoding, done) {
	
	data[0]= 'Login metier='+data[0];	
	data[1]= '"utilisateur"=""'+data[1]+'"';	
	data[2]= '"prénom"=""'+data[2]+'"';	
	data[3]= '"nom"=""'+data[3]+'"';	
	data[4]= '"civilité"=""'+data[4]+'"';	
	data[5]= '"code cellule"=""'+data[5]+'"';	
	data[6]= '"libellé cellule"=""'+data[6]+'"';	
	data[7]= '"compte windows AG2R"=""'+data[7]+'"';	
	data[8]= '"compte GED AG2R metier"=""'+data[8]+'"';	
	if(data[9].indexOf('\r') > 0){
		
		data[9]= '"invMachine"=""'+data[9].replace('\r', '')+'"';
	}
	else {
		
		data[9]= '"invMachine"="vide"';
	}
		
		
	this.push(data);
  done();
};

// json to string
var jsonToStrings = JSONStream.stringify(false);

dataFile
.pipe(csvToJson)
//.pipe(parser)
.pipe(jsonToStrings)
//.pipe(process.stdout);
.pipe(write);


