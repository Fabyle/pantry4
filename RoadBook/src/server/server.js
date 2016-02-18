var express        =         require("express");
var bodyParser     =         require("body-parser");
var app            =         express();
var googlemap      =         require('../google/googlemap');

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(express.static('public'));


app.get('/',function(req,res){
  res.sendFile("index.html");
});
app.post('/login',function(req,res){
  var origine=req.body.origine;
  var destination=req.body.destination;
  googlemap.distanceEntreDeuxPoints(origine,destination,
    function(retour){
      res.end("Julie, ton trajet est calculé :"+retour.temps+" - "+retour.distance);
      });
  });



app.listen(3000,function(){
  console.log("Started on PORT 3000");
});
