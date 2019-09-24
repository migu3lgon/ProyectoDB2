$(document).ready(
        function() {
            
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8082/proyectoDB2-Hospital1/TypeSeguro',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#typeAseg');
                    $pData.empty();
                    for (var i = 0; i < data.length; i++) {
                        $pData.append("<option value="+data[i].id+">"+data[i].asegType+"</option>");
                    }
                    if(data.length==0){
                        $pData.append("<p>No hay datos disponibles</p>");
                    }
                },
                error : function() {
                    var $pData = $('#typeAseg');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});












