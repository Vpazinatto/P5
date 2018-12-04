var mssql = require('mssql');

module.exports = function(app) {
    app.get('/projetos', function(req, res) {
        var requestGetAll = new mssql.Request();   
        requestGetAll.query('SELECT * FROM projeto', function (err, results) {
            
            console.log('Consultando projetos...');

            if (err) {
                res.status(500).send(err);
                return;
            }

            res.status(200).send(results);
        });
    });
}