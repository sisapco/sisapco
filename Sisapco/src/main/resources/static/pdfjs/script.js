function btnCrearPdfBody(){
	
	//document.querySelectorAll('img').forEach(image => { image.crossOrigin = 'Anonymous'; image.src += ' '; });
	

	
	
	const $elementoParaConvertir = document.body; // <-- Aquí puedes elegir cualquier elemento del DOM
        html2pdf()
            .set({
                margin: 1,
                filename: 'Acta.pdf',
                image: {
                    type: 'png',
                    quality: 0.99
                },
                html2canvas: {
                    scale: 3, // A mayor escala, mejores gráficos, pero más peso
                    letterRendering: true,
                    useCORS: true
                },
                jsPDF: {
                    unit: "in",
                    format: "a3",
                    orientation: 'portrait' // landscape o portrait
                }
            })
            .from($elementoParaConvertir)
            .save()
            .catch(err => console.log(err));
}

function exportToPDF() {
   
	var element = document.getElementById('element-to-print');

	var opt = {
	     margin: 1, 
	     filename: 'userCard.pdf', 
	     image: {type: 'jpg', quality: 0.99}, 
	     html2canvas: {dpi: 192, letterRendering: true, useCORS: true}, 
	     jsPDF: {unit: 'pt', format: 'letter', orientation: 'portrait'
	}};
	  html2pdf().from(element).set(opt).save();
}


function convertToPdf()
{ 
    html2canvas(document.body, {useCORS: true}).then(function(canvas) {
      let img = new Image();
      img.src = canvas.toDataURL('image/png');
      img.onload = function () {
        let pdf = new jsPDF('landscape', 'mm', 'a4');
        pdf.addImage(img, 0, 0, pdf.internal.pageSize.width, pdf.internal.pageSize.height);
        pdf.save('certificate.pdf');
      };
    });
}