package co.com.sisapco.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.util.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import co.com.sisapco.util.GoogleDriveUtils;
import co.com.sisapco.util.DriveQuickstart;

import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.Permission;
//import com.google.api.services.drive.model.

//// librerias google droc
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;


import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.*;



public class CreateGoogleFileDoc {

    // PRIVATE!
    private static File _createGoogleFile(String googleFolderIdParent, String contentType, //
            String customFileName, AbstractInputStreamContent uploadStreamContent) throws IOException {

        File fileMetadata = new File();
        fileMetadata.setName(customFileName);

        List<String> parents = Arrays.asList(googleFolderIdParent);
        fileMetadata.setParents(parents);
        //
        Drive driveService = GoogleDriveUtils.getDriveService();

        File file = driveService.files().create(fileMetadata, uploadStreamContent)
                .setFields("id, webContentLink, webViewLink, parents").execute();

        return file;
    }
    
    //UPDATE PERMISSION FILE
    private static Permission updateGoogleFilePermission(String codigoGoogleActa) throws IOException {
        Drive driveService = GoogleDriveUtils.getDriveService();
        
        try {
	
	       //File ddd = driveService.files().get("1ejhLBSRsp6crbLkr28932fCBCv-W_Nk8").execute();
	       
	       Permission domainPermission = new Permission()
	    	          .setType("anyone")
	    	          .setRole("reader");
	       return driveService.permissions().create(codigoGoogleActa, domainPermission).execute();
          
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
          return null;
    }

    // Create Google File from byte[]
    public static File createGoogleFile(String googleFolderIdParent, String contentType, //
            String customFileName, byte[] uploadData) throws IOException {
        //
        AbstractInputStreamContent uploadStreamContent = new ByteArrayContent(contentType, uploadData);
        //
        return _createGoogleFile(googleFolderIdParent, contentType, customFileName, uploadStreamContent);
    }

    // Create Google File from java.io.File
    public static File createGoogleFile(String googleFolderIdParent, String contentType, //
            String customFileName, java.io.File uploadFile) throws IOException {

        //
         AbstractInputStreamContent uploadStreamContent = new FileContent(contentType, uploadFile);
        //
        return _createGoogleFile(googleFolderIdParent, contentType, customFileName, uploadStreamContent);
    }
    
    
    // Create Google File from java.io.File
    public static File createGoogleFileGoogle(String googleFolderIdParent, String contentType, //
            String customFileName, java.io.File uploadFile) throws IOException {

        //
        AbstractInputStreamContent uploadStreamContent = new FileContent(contentType, uploadFile);
        //
        return _createGoogleFile(googleFolderIdParent, contentType, customFileName, uploadStreamContent);
    }

    // Create Google File from InputStream
    public static File createGoogleFile(String googleFolderIdParent, String contentType, //
            String customFileName, InputStream inputStream) throws IOException {

        //
        AbstractInputStreamContent uploadStreamContent = new InputStreamContent(contentType, inputStream);
        //
        return _createGoogleFile(googleFolderIdParent, contentType, customFileName, uploadStreamContent);
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
    	
        //java.io.File uploadFile = new java.io.File("/Users/nitro/tokens/prueba.txt");
    	java.io.File uploadFile = new java.io.File("/Users/nitro/tokens/plantilla_mod.docx");
    	
    	
    	Drive driveService = GoogleDriveUtils.getDriveService();
    	
    	/*OutputStream outputStream = new ByteArrayOutputStream();
    	driveService.files().get("1fvN7QKD9qNO084v8xts3yfa6VSlgf2oM0b8uyCiXrFM").executeAndDownloadTo(outputStream);
    	File mediadd = driveService.files().get("1fvN7QKD9qNO084v8xts3yfa6VSlgf2oM0b8uyCiXrFM").execute();
    	InputStream in = new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray());
    	*/ 
    	
///////////
        /*updateDocument2(
                  "c:\\test\\template.docx",
                  "c:\\test\\output.docx",
                  "mkyong"); */
        
        updateDocumentTexto("/Users/nitro/tokens/plantilla2.docx","/Users/nitro/tokens/plantilla_mod.docx","hola mundo");
    	
    	/////////////

         

        // Create Google File:
       // File googleFile = createGoogleFile("1xkULj5s-u1xzMybXFz9foXvvuWnQTYi-", "text/plain", "prueba.docx", uploadFile);
        File googleFile = createGoogleFile("1xkULj5s-u1xzMybXFz9foXvvuWnQTYi-", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "Acta No 57.docx", uploadFile);
    	
        System.out.println("Created Google file!");
        System.out.println("WebContentLink: " + googleFile.getWebContentLink() );
        System.out.println("WebViewLink: " + googleFile.getWebViewLink() );
        
        updateGoogleFilePermission(googleFile.getId());

        System.out.println("Done!");
        
        
    }
    
    public File cargarArchivoGoogleActa(String codigoGoogle, String numeroActa, String rutaAbsolutaPlantillaActas,String rutaAbsolutaPlantillaMod) throws IOException, InvalidFormatException {
    	
    	updateDocumentTexto(rutaAbsolutaPlantillaActas,rutaAbsolutaPlantillaMod,numeroActa);    	
    	java.io.File uploadFile = new java.io.File(rutaAbsolutaPlantillaMod);    	
    	
    	File googleFile = createGoogleFile(codigoGoogle, "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "Acta No "+numeroActa+".docx", uploadFile);
    	return googleFile;
    	
    }
    
    public File cargarArchivoGoogleActaMovil(String codigoGoogle, String numeroActa,String fechaActa,
    		String horaActa, String reunion, String convoca, String municipio,
    		String lugar, String asistentes, String ordenDelDia,String desarrolloDia,
    		MultipartFile[] firmaPresidente,MultipartFile[] firmaSecretario, String rutaAbsolutaPlantillaActas,String rutaAbsolutaPlantillaMod) throws IOException, InvalidFormatException {
    	
    	updateDocumentTextoMovil(rutaAbsolutaPlantillaActas,rutaAbsolutaPlantillaMod,
    			numeroActa,fechaActa,horaActa,reunion,convoca,municipio,lugar,asistentes,
    			ordenDelDia,desarrolloDia,firmaPresidente,firmaSecretario);
    	
    	java.io.File uploadFile = new java.io.File(rutaAbsolutaPlantillaMod);
    	
    	File googleFile = createGoogleFile(codigoGoogle, "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "Acta No "+numeroActa+".docx", uploadFile);
    	
    	updateGoogleFilePermission(googleFile.getId());
    	
    	return googleFile;
    }
    
    
    public File cargarArchivoGoogle(String codigoGoogle, String tipoArchivo, String nombreArchivo, byte[] bytes) throws IOException {
    	
    	File googleFile = createGoogleFile(codigoGoogle, tipoArchivo, nombreArchivo, bytes);
    	
    	return googleFile;
    }
    
    
    
    //Actualizamos el texto del acta
    private static void updateDocumentTexto(String input, String output, String numeroActa)
            throws IOException, InvalidFormatException {

            try (XWPFDocument doc = new XWPFDocument(
                    Files.newInputStream(Paths.get(input)))
            ) {

                List<XWPFParagraph> xwpfParagraphList = doc.getParagraphs();
                //Iterate over paragraph list and check for the replaceable text in each paragraph
                for (XWPFParagraph xwpfParagraph : xwpfParagraphList) {
                    for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
                        String docText = xwpfRun.getText(0);
                        //replacement and setting position
                        if(docText != null) {
	                        docText = docText.replace("${numeroacta}", numeroActa);
	                        xwpfRun.setText(docText, 0);
                        }
                        if(docText != null) {
	                        docText = docText.replace("numeroacta", numeroActa);
	                        xwpfRun.setText(docText, 0);
                        }
                    }
                      
                }
                doc.write(new FileOutputStream(output));               
            }
            catch (Exception ex){ 
            	
            }

        }
    
  //Actualizamos el texto del acta movil
    private static void updateDocumentTextoMovil(String input, String output, 
    		String numeroActa,String fechaActa, String horaActa, String reunion, String convoca,
    		String municipio,String lugar, String asistentes,
			String ordenDelDia,String desarrolloDia, MultipartFile[] firmaPresidente,MultipartFile[] firmaSecretario)
            throws IOException, InvalidFormatException {

            try (XWPFDocument doc = new XWPFDocument(
                    Files.newInputStream(Paths.get(input)))
            ) {

                List<XWPFParagraph> xwpfParagraphList = doc.getParagraphs();
                //Iterate over paragraph list and check for the replaceable text in each paragraph
                for (XWPFParagraph xwpfParagraph : xwpfParagraphList) {
                    for (XWPFRun xwpfRun : xwpfParagraph.getRuns()) {
                        String docText = xwpfRun.getText(0);
                        //replacement and setting position
                        if(docText != null) {
	                        docText = docText.replace("numeroacta", numeroActa);
	                        xwpfRun.setText(docText, 0);
                        }
                        if(docText != null && docText.equals("reunionacta") ) {
	                        docText = docText.replace("reunionacta", reunion);
	                        xwpfRun.setText(docText, 0);
                        }
                        if(docText != null && docText.equals("fechaacta")) {
	                        docText = docText.replace("fechaacta", fechaActa);
	                        xwpfRun.setText(docText, 0);
                        }
                        if(docText != null && docText.equals("convocaacta")) {
	                        docText = docText.replace("convocaacta", convoca);
	                        xwpfRun.setText(docText, 0);
                        }
                        if(docText != null && docText.equals("municipioacta")) {
	                        docText = docText.replace("municipioacta", municipio);
	                        xwpfRun.setText(docText, 0);
                        }
                        if(docText != null && docText.equals("lugaracta")) {
	                        docText = docText.replace("lugaracta", lugar);
	                        xwpfRun.setText(docText, 0);
                        }
                        if(docText != null && docText.equals("horainicioacta")) {
	                        docText = docText.replace("horainicioacta", horaActa);
	                        xwpfRun.setText(docText, 0);
                        }
                        if(docText != null && docText.equals("asistentesconsejo")) {
                        	
	                        docText = docText.replace("asistentesconsejo", asistentes);
	                        //Limpiamos el campo	
	                        xwpfRun.setText("",0);
                        	
	                        //Se realiza el recorrido para hacer el salto de linea en el archivo de word
	                        String[] lineas = docText.split("\n");
                        	int contador = lineas.length;
                        	int i = 0;
	                        while(i < contador) {
	                            xwpfRun.setText(lineas[i]);
	                            if (i < (contador - 1)) {
	                            	xwpfRun.addBreak();
	                            }
	                            i=i+1;
	                        }  
                        }
                        if(docText != null && docText.equals("ordendeldia")) {

	                        docText = docText.replace("ordendeldia", ordenDelDia);
	                        //Limpiamos el campo	
	                        xwpfRun.setText("",0);
                        	
	                        //Se realiza el recorrido para hacer el salto de linea en el archivo de word
	                        String[] lineas = docText.split("\n");
                        	int contador = lineas.length;
                        	int i = 0;
	                        while(i < contador) {
	                            xwpfRun.setText(lineas[i]);
	                            if (i < (contador - 1)) {
	                            	xwpfRun.addBreak();
	                            }
	                            i=i+1;
	                        }  
                        }
                        if(docText != null && docText.equals("desarrollodia")) {
	                        
	                        docText = docText.replace("desarrollodia", desarrolloDia);
	                        //Limpiamos el campo	
	                        xwpfRun.setText("",0);
                        	
	                        //Se realiza el recorrido para hacer el salto de linea en el archivo de word
	                        String[] lineas = docText.split("\n");
                        	int contador = lineas.length;
                        	int i = 0;
	                        while(i < contador) {
	                            xwpfRun.setText(lineas[i]);
	                            if (i < (contador - 1)) {
	                            	xwpfRun.addBreak();
	                            }
	                            i=i+1;
	                        }  
                        }
                    }                  
                }
                
                ////////////////
                //Cargamos las firmas de los secretarios
                    for (XWPFPictureData pictureData : doc.getAllPictures()) {
                     String fileName =  pictureData.getFileName();
                     System.out.println(fileName);
                     if(fileName.equals("image1.png")) {
	                     if (pictureData.getPictureType() == Document.PICTURE_TYPE_PNG) {
		                      MultipartFile file = firmaPresidente[0];
		                      byte[] bytes = file.getBytes();
		                      replacePictureData(pictureData, bytes);
		                      System.out.println(fileName + " replaced by stackoverflowLogo.jpg");
	                     }
                     }
                     if(fileName.equals("image2.png")) {
	                     if (pictureData.getPictureType() == Document.PICTURE_TYPE_PNG) {
		                      MultipartFile file = firmaSecretario[0];
		                      byte[] bytes = file.getBytes();
		                      replacePictureData(pictureData, bytes);
		                      System.out.println(fileName + " replaced by stackoverflowLogo.jpg");
	                     }
                     }
                    }  
                
                doc.write(new FileOutputStream(output));               
            }
            catch (Exception ex){ 
            	ex.printStackTrace();
            	ex.getCause();
            	ex.getStackTrace();
            	ex.getLocalizedMessage();
            }

        }
    
        static void replacePictureData(XWPFPictureData source, byte[] data) {
    	  try ( ByteArrayInputStream in = new ByteArrayInputStream(data); 
    	        OutputStream out = source.getPackagePart().getOutputStream();
    	       ) {
    	   byte[] buffer = new byte[2048];
    	   int length;
    	   while ((length = in.read(buffer)) > 0) {
    	    out.write(buffer, 0, length);
    	   }
    	  } catch (Exception ex) {
    	   ex.printStackTrace();  
    	  }
    	 }
    
}