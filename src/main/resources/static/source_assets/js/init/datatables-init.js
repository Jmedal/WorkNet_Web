(function ($) {
    //    "use strict";


    /*  Data Table
    -------------*/




    $('#bootstrap-data-table').DataTable({
        lengthMenu: [[10, 20, 50, -1], [10, 20, 50, "All"]],
        lengthChange:false,
        serverSide : true,
		// aoColumns: [
        //     {"data": "string"}
        // ],
		ajax:{
        	url:'/test/data',
			data: function (param) {
        		console.log(param);
                return param;
            },
            //用于处理服务器端返回的数据。 dataSrc是DataTable特有的
            dataSrc: function (myJson) {
        		console.log(myJson);
                return myJson.data;
            }
		}
    });



    $('#bootstrap-data-table-export').DataTable({
        dom: 'lBfrtip',
        lengthChange : false,
        // lengthMenu: [[10, 25, 50, -1], [10, 25, 50, "All"]],
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    });

	$('#row-select').DataTable( {
			initComplete: function () {
				this.api().columns().every( function () {
					var column = this;
					var select = $('<select class="form-control"><option value=""></option></select>')
						.appendTo( $(column.footer()).empty() )
						.on( 'change', function () {
							var val = $.fn.dataTable.util.escapeRegex(
								$(this).val()
							);

							column
								.search( val ? '^'+val+'$' : '', true, false )
								.draw();
						} );

					column.data().unique().sort().each( function ( d, j ) {
						select.append( '<option value="'+d+'">'+d+'</option>' )
					} );
				} );
			}
		} );






})(jQuery);
