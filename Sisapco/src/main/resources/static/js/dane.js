//Consulta los departamentos
function consultaDepartamentos(){
	
    	    $.ajax({
    	        type:"post",
    	        url: './consultaDepartamentos',
    	        asynch: false,
    	        dataType:'json',
    	        success: function(data) {   	        		  
    	        	
    	            if(data[0][0] != null){
    	            	   	            	
    	                for (i=0; i < data.length; i++) {    	               
    	                    $('#departamento').append(`<option value="${data[i][1]}">${ data[i][0]}</option>`);
    	                }   	            	            	
    	            }
    	            else{
    	            	document.getElementById("departamento").value="";
    	            }
    	        },
    	        error : function(request,error)
    	        {
    	            //alert("Request: "+JSON.stringify(request));
    	        }

    	    });
	                
}

//Consulta los Municipios
function consultaMunicipios(){
	
	var iddepartamento=document.getElementById("departamento").value;

    $.ajax({
        type:"post",
        //contentType: "application/json",
        data: { iddepartamento: iddepartamento },//send data directly
        url: './consultaMunicipios',
        asynch: false,
        dataType:'json',
        success: function(data) {
        		    	     
        	if(data[0] != null){
        		$("#actMunicipio").empty();
        		$('#actMunicipio').append(`<option value="">Seleccione</option>`);	
                for (i=0; i < data.length; i++) {    	               
                    $('#actMunicipio').append(`<option value="${data[i].nombreMunicipio}">${ data[i].nombreMunicipio}</option>`);
                }   	            	            	
            }
            else{
            	document.getElementById("actMunicipio").value="";
            }
        },
        error : function(request,error)
        {
            //alert("Request: "+JSON.stringify(request));
        }

    });
            
}