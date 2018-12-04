var mssql = require('mssql');

module.exports = function(app) {
    app.get('/apontamentos', function(req, res) {
        var requestGetAll = new mssql.Request();   
        requestGetAll.query('SELECT * FROM apontamento', function (err, results) {
            
            console.log('Consultando apontamentos...');

            if (err) {
                res.status(500).send(err);
                return;
            }

            res.status(200).send(results);
        });
    });
}