/**
 * http://usejsdoc.org/
 */
/*
 * ------------------------------------- 
 * Fonction de insertion
 * --------------------------------------
 */
function selectDocuments(db, callback) {
    // Get the documents collection
    var collection = db.collection('personnes');
    // Insert some documents
    // Find some documents
    collection.find({}).toArray(function(err, docs) {
      	  //console.log("Found the following records");
    	  console.dir(docs);
    	  callback(docs);
    });
  };


//les exports
exports.selectDocuments = selectDocuments;


