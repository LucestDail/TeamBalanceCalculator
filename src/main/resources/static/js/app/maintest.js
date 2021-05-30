/**
 * 
 */

main = {
    init : function () {
    	console.log("init activated");
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
        $('#btn-update').on('click', function () {
            _this.update();
        });

    },
    save : function () {
    	console.log("save activated");
        var data = {
            title: $('#savetitle').val(),
            author: $('#saveauthor').val(),
            content: $('#savecontent').val()
        };
		console.log(data);
        $.ajax({
            type: 'POST',
            url: '/posts',
            dataType: "text",
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
        })
        .done(function() {
        	console.log("save done");
            alert('save success');
            location.reload();
        })
        .fail(function (error) {
        	console.log("save fail");
        	console.log(JSON.stringify(error));
            alert(JSON.stringify(error));
        });
    },
	delete : function(){
		console.log("delete activated");
		var data = {
			id: $('#deleteid').val()	
		};
		console.log(data);
		$.ajax({
			type: 'POST',
			url: '/delete',
			dataType: "text",
			contentType:'application/json; charset=utf-8',
			data: JSON.stringify(data),
		})
		.done(function(){
			console.log("delete done");
			alert('delete success');
			location.reload();
		})
		.fail(function(error){
			console.log("delete fail");
			console.log(JSON.stringify(error));
			alert(JSON.stringify(error));
		})
	},
	update : function () {
    	console.log("update activated");
        var data = {
			id: $('#updateid').val(),
            title: $('#updatetitle').val(),
            author: $('#updateauthor').val(),
            content: $('#updatecontent').val()
        };
		console.log(data);
        $.ajax({
            type: 'POST',
            url: '/update',
            dataType: "text",
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
        })
        .done(function() {
        	console.log("update done");
            alert('save success');
            location.reload();
        })
        .fail(function (error) {
        	console.log("update fail");
        	console.log(JSON.stringify(error));
            alert(JSON.stringify(error));
        });
	}
};


main.init();
