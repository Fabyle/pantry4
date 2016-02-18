/**
 * http://usejsdoc.org/
 */
/*
 * ------------------------------------- 
 * Fonction de insertion
 * --------------------------------------
 */
function insertDocuments(db, callback) {
    // Get the documents collection
    var collection = db.collection('personnes');
    // Insert some documents
    collection.insertMany([
       { "nom" : "LEMOINE", "Prénom" : "Sophie"},{ "nom" : "LEMOINE", "Prénom" : "Fabien"} ]
      , function(err, result) {
//      assert.equal(err, null);
//      assert.equal(3, result.result.n);
//      assert.equal(3, result.ops.length);
      console.log("Insered");
      callback(result);
    });
  }

//les exports
exports.insertDocuments = insertDocuments;