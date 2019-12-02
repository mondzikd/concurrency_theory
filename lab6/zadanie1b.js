//import waterfall from 'node_modules/async';

const async = require('async');

function loop(n) {
	if(n == 0){
		console.log('done!');
	}
	else{
		async.waterfall([
                function(callback) {
                    var delay = Math.floor((Math.random()*1000)+500);
                    setTimeout(function() {
                        console.log("1");
                        callback(null);
                    }, delay);
                    
			},
    			function(callback) {
                    var delay = Math.floor((Math.random()*1000)+500);
                    setTimeout(function() {
                        console.log("2");
                        callback(null);
                    }, delay);			    
    			},
    			function(callback) {
                    var delay = Math.floor((Math.random()*1000)+500);
                    setTimeout(function() {
                        console.log("3");
                        callback(null);
                    }, delay);
			}
		], function (err, result) {
            	loop(n-1);
		});
	}
}

loop(4);

