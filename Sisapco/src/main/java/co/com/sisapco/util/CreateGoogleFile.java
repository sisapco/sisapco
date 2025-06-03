<<<<<<< HEAD
package co.com.sisapco.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

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

public class CreateGoogleFile {

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
                .setFields("id, webContentLink, webViewLink, thumbnailLink, parents").execute();

        return file;
    }
    
    //UPDATE PERMISSION FILE
    private static Permission updateGoogleFilePermission() throws IOException {
        Drive driveService = GoogleDriveUtils.getDriveService();
        
        try {
	
	       //File ddd = driveService.files().get("1ejhLBSRsp6crbLkr28932fCBCv-W_Nk8").execute();
	       
	       Permission domainPermission = new Permission()
	    	          .setType("anyone")
	    	          .setRole("reader");
	       return driveService.permissions().create("1nahGXJmc2XICj8zF0Fjm5rNK5KuWypMe", domainPermission).execute();
          
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

    public static void main(String[] args) throws IOException {
    	
        //java.io.File uploadFile = new java.io.File("/Users/nitro/tokens/prueba.txt");
    	java.io.File uploadFile = new java.io.File("/Users/nitro/tokens/plantilla.docx");
    	
    	
    	Drive driveService = GoogleDriveUtils.getDriveService();
    	
    	/*OutputStream outputStream = new ByteArrayOutputStream();
    	driveService.files().get("1fvN7QKD9qNO084v8xts3yfa6VSlgf2oM0b8uyCiXrFM").executeAndDownloadTo(outputStream);
    	File mediadd = driveService.files().get("1fvN7QKD9qNO084v8xts3yfa6VSlgf2oM0b8uyCiXrFM").execute();
    	InputStream in = new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray());
    	*/ 

        // Create Google File:
       // File googleFile = createGoogleFile("1xkULj5s-u1xzMybXFz9foXvvuWnQTYi-", "text/plain", "prueba.docx", uploadFile);
        File googleFile = createGoogleFile("1xkULj5s-u1xzMybXFz9foXvvuWnQTYi-", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "Acta No 57.docx", uploadFile);
    	
        System.out.println("Created Google file!");
        System.out.println("WebContentLink: " + googleFile.getWebContentLink() );
        System.out.println("WebViewLink: " + googleFile.getWebViewLink() );
        
        updateGoogleFilePermission();

        System.out.println("Done!");
        
        
    }
    
    public File cargarArchivoGoogle(String codigoGoogle, String tipoArchivo, String nombreArchivo, byte[] bytes) throws IOException {
    	
    	File googleFile = createGoogleFile(codigoGoogle, tipoArchivo, nombreArchivo, bytes);
    	
    	return googleFile;
    }
    
=======
package co.com.sisapco.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

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

public class CreateGoogleFile {

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
                .setFields("id, webContentLink, webViewLink, thumbnailLink, parents").execute();

        return file;
    }
    
    //UPDATE PERMISSION FILE
    private static Permission updateGoogleFilePermission() throws IOException {
        Drive driveService = GoogleDriveUtils.getDriveService();
        
        try {
	
	       //File ddd = driveService.files().get("1ejhLBSRsp6crbLkr28932fCBCv-W_Nk8").execute();
	       
	       Permission domainPermission = new Permission()
	    	          .setType("anyone")
	    	          .setRole("reader");
	       return driveService.permissions().create("1nahGXJmc2XICj8zF0Fjm5rNK5KuWypMe", domainPermission).execute();
          
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

    public static void main(String[] args) throws IOException {
    	
        //java.io.File uploadFile = new java.io.File("/Users/nitro/tokens/prueba.txt");
    	java.io.File uploadFile = new java.io.File("/Users/nitro/tokens/plantilla.docx");
    	
    	
    	Drive driveService = GoogleDriveUtils.getDriveService();
    	
    	/*OutputStream outputStream = new ByteArrayOutputStream();
    	driveService.files().get("1fvN7QKD9qNO084v8xts3yfa6VSlgf2oM0b8uyCiXrFM").executeAndDownloadTo(outputStream);
    	File mediadd = driveService.files().get("1fvN7QKD9qNO084v8xts3yfa6VSlgf2oM0b8uyCiXrFM").execute();
    	InputStream in = new ByteArrayInputStream(((ByteArrayOutputStream) outputStream).toByteArray());
    	*/ 

        // Create Google File:
       // File googleFile = createGoogleFile("1xkULj5s-u1xzMybXFz9foXvvuWnQTYi-", "text/plain", "prueba.docx", uploadFile);
        File googleFile = createGoogleFile("1xkULj5s-u1xzMybXFz9foXvvuWnQTYi-", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "Acta No 57.docx", uploadFile);
    	
        System.out.println("Created Google file!");
        System.out.println("WebContentLink: " + googleFile.getWebContentLink() );
        System.out.println("WebViewLink: " + googleFile.getWebViewLink() );
        
        updateGoogleFilePermission();

        System.out.println("Done!");
        
        
    }
    
    public File cargarArchivoGoogle(String codigoGoogle, String tipoArchivo, String nombreArchivo, byte[] bytes) throws IOException {
    	
    	File googleFile = createGoogleFile(codigoGoogle, tipoArchivo, nombreArchivo, bytes);
    	
    	return googleFile;
    }
    
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
}