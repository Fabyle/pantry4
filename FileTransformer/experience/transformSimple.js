/**
 * http://usejsdoc.org/
 */

var 
fs = require('fs'),
parse = require('csv-parse'),
Transform = require('stream').Transform
  
// le stream du fichier
  var dataFile = fs.createReadStream('toto.txt');
var write = fs.createWriteStream('result.txt');

//un transformateur
var transform = new Transform({objectMode: true});

//on implémente une méthode de son interface la méthode _transform
transform._transform = function(data, encoding, done) {
	for(var i= 0; i < data.length; i++)
	{
	     this.push(data[i]);
	     this.push("--");
	}
   
  done();
};

//parser csv
var parser = parse({delimiter: ','});

dataFile
.pipe(parser)
.pipe(transform)
.pipe(process.stdout)