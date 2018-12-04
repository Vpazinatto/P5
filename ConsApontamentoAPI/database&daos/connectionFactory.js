var mssql = require('mssql');

var config = {
    user: 'BDApontamento',
    password: 'BDApontamento',
    server: 'regulus.cotuca.unicamp.br',
    database: 'BDApontamento'
};

var con = mssql.connect(config, function(err) {
    if (err) {
        console.log("Error: " + err);
        return;
    }

    global.con = con;
    
    console.log("Conectado ao banco");
});