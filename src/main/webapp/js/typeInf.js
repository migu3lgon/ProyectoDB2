$(document).ready(
        function() {
            
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8082/proyectoDB2-Hospital1/SpecialTypeInfo',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#typeData');
                    $pData.empty();
                    for (var i = 0; i < data.length; i++) {
                        $pData.append("<option value="+data[i].idType+">"+data[i].tipo+"</option>");
                    }
                    if(data.length==0){
                        $pData.append("<p>No hay datos disponibles</p>");
                    }
                },
                error : function() {
                    var $pData = $('#doctoresData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});








