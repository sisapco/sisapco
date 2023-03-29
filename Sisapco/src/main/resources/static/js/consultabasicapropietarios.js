function consultaBasicaPropietarios(){
	
			var cedula=document.getElementById("proCc").value;
			
    	    $.ajax({
    	        type:"post",
    	        //contentType: "application/json",
    	        data: { cedula: cedula },//send data directly
    	        url: './consultaPropietario',
    	        asynch: false,
    	        dataType:'json',
    	        success: function(data) {
    	        		    	     
    	            if(data[0] != null){
    	            	document.getElementById("proNombres").value=data[0].proNombres;
    	            	document.getElementById("proApellidos").value=data[0].proApellidos;
    	            	document.getElementById("proNumeroResidencia").value=data[0].proNumeroResidencia;
    	            	document.getElementById("pqrsTelefono").value=data[0].proTelefono;
    	            	document.getElementById("pqrsEmail").value=data[0].proEmail;
    	            	document.getElementById("pqrsDireccionCorrespondecia").value=data[0].proDireccionCorrespondencia;  	            	
    	            }
    	            else{
    	            	document.getElementById("proNombres").value="";
    	            	document.getElementById("proApellidos").value="";
    	            	document.getElementById("proNumeroResidencia").value="";
    	            	document.getElementById("pqrsTelefono").value="";
    	            	document.getElementById("pqrsEmail").value="";
    	            	document.getElementById("pqrsDireccionCorrespondecia").value=""; 
    	            }
    	        },
    	        error : function(request,error)
    	        {
    	            //alert("Request: "+JSON.stringify(request));
    	        }

    	    });
	                
}

function consultaBasicaPropietariosSanciones(){
	
	var cedula=document.getElementById("proCc").value;
	
    $.ajax({
        type:"post",
        //contentType: "application/json",
        data: { cedula: cedula },//send data directly
        url: './consultaPropietario',
        asynch: false,
        dataType:'json',
        success: function(data) {
        		    	     
            if(data[0] != null){
            	document.getElementById("proNombres").value=data[0].proNombres;
            	document.getElementById("proApellidos").value=data[0].proApellidos;
            	document.getElementById("proNumeroResidencia").value=data[0].proNumeroResidencia; 
            	document.getElementById("proEmail").value=data[0].proEmail;             	
            	document.getElementById("proDireccionCorrespondencia").value=data[0].proDireccionCorrespondencia;
            	document.getElementById("cedulaNoExiste").style.display="none";
            }
            else{
            	document.getElementById("proNombres").value="";
            	document.getElementById("proApellidos").value="";
            	document.getElementById("proNumeroResidencia").value="";
            	document.getElementById("proEmail").value="";
            	document.getElementById("proDireccionCorrespondencia").value="";
            	document.getElementById("proCc").value="";
            	document.getElementById("cedulaNoExiste").style.display="Block";
            }
        },
        error : function(request,error)
        {
            //alert("Request: "+JSON.stringify(request));
        }

    });
            
}