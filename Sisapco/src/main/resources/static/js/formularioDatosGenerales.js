function validarUsuarioDatosGenerales(){
	
	        var tipoResidente = document.getElementById("datosperTipoResidente").value;
	        var proUsser="";
	        
	        if(tipoResidente==15){
	        	  var proUsser=document.getElementById("proUsser").value;
			}
	        else if(tipoResidente==12){
				  var proUsser=document.getElementById("inquilinoUsser").value;
			}
	        else if(tipoResidente==16){
				  var proUsser=document.getElementById("administradorUsser").value;
			}
	        else if(tipoResidente==17){
				  var proUsser=document.getElementById("guardaUsser").value;
			}
	        else if(tipoResidente==18){
				  var proUsser=document.getElementById("contadorUsser").value;
			}
	        else if(tipoResidente==19){
				  var proUsser=document.getElementById("revisorUsser").value;
			}
			else{
				document.getElementById("proUsser").value="";
				document.getElementById("inquilinoUsser").value="";
				document.getElementById("administradorUsser").value="";
				document.getElementById("guardaUsser").value="";
				document.getElementById("contadorUsser").value="";
				document.getElementById("revisorUsser").value="";
			}
	        			
    	    $.ajax({
    	        type:"post",
    	        //contentType: "application/json",
    	        data: { prousser: proUsser },//send data directly
    	        url: './consultaUsuarioDatosGenerales',
    	        asynch: false,
    	        dataType:'json',
    	        success: function(data) {
	     
    	            if(data[0] != null){   	            	
    	            	if(tipoResidente==15){
    	            	   document.getElementById("proUsser").value="";
    	            	   document.getElementById("mensajeProUsser").innerHTML = "El usuario ya existe, por favor ingresa un usuario diferente";
    	            	}
    	            	if(tipoResidente==12){
    	            		document.getElementById("inquilinoUsser").value="";
    	            		document.getElementById("mensajeProUsserInquilino").innerHTML = "El usuario ya existe, por favor ingresa un usuario diferente";
    	            	}
    	            	if(tipoResidente==16){
    	            		document.getElementById("administradorUsser").value="";
    	            		document.getElementById("mensajeProUsserAdministrador").innerHTML = "El usuario ya existe, por favor ingresa un usuario diferente";
    	            	}
    	            	if(tipoResidente==17){
    	            		document.getElementById("guardaUsser").value="";
    	            		document.getElementById("mensajeProUsserGuarda").innerHTML = "El usuario ya existe, por favor ingresa un usuario diferente";
    	            	}
    	            	if(tipoResidente==18){
    	            		document.getElementById("contadorUsser").value="";
    	            		document.getElementById("mensajeProUsserContador").innerHTML = "El usuario ya existe, por favor ingresa un usuario diferente";
    	            	}
    	            	if(tipoResidente==19){
    	            		document.getElementById("revisorUsser").value="";
    	            		document.getElementById("mensajeProUsserRevisor").innerHTML = "El usuario ya existe, por favor ingresa un usuario diferente";
    	            	}
    	            }
    	            else{
    	            	document.getElementById("mensajeProUsser").innerHTML = "";
    	            	document.getElementById("mensajeProUsserInquilino").innerHTML = "";
    	            	document.getElementById("mensajeProUsserAdministrador").innerHTML = "";
    	            	document.getElementById("mensajeProUsserGuarda").innerHTML = "";
    	            	document.getElementById("mensajeProUsserContador").innerHTML = "";
    	            	document.getElementById("mensajeProUsserRevisor").innerHTML = "";
    	            }
    	        },
    	        error : function(request,error)
    	        {
    	            //alert("Request: "+JSON.stringify(request));
    	        }

    	    });
	                
}