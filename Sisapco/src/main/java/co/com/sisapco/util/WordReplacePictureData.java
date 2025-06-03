<<<<<<< HEAD
package co.com.sisapco.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.xwpf.usermodel.*;

public class WordReplacePictureData {
    
	 static org.apache.xmlbeans.XmlObject getInlineOrAnchor(org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture ctPictureToFind, org.apache.xmlbeans.XmlObject inlineOrAnchor) {
	  String declareNameSpaces = "declare namespace pic='http://schemas.openxmlformats.org/drawingml/2006/picture'; ";
	  org.apache.xmlbeans.XmlObject[] selectedObjects = inlineOrAnchor.selectPath(
	   declareNameSpaces 
	   + "$this//pic:pic");
	  for (org.apache.xmlbeans.XmlObject selectedObject : selectedObjects) {
	   if (selectedObject instanceof org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture) {
	    org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture ctPicture = (org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture)selectedObject;
	    if (ctPictureToFind.equals(ctPicture)) {
	     // this is the inlineOrAnchor for that picture   
	     return inlineOrAnchor;
	    }        
	   }          
	  }
	  return null;
	 }
	                
	 static org.apache.xmlbeans.XmlObject getInlineOrAnchor(XWPFRun run, XWPFPicture picture) {
	  org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture ctPictureToFind = picture.getCTPicture();
	  for (org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing drawing : run.getCTR().getDrawingList()) {
	   for (org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline inline : drawing.getInlineList()) {
	    org.apache.xmlbeans.XmlObject inlineOrAnchor = getInlineOrAnchor(ctPictureToFind, inline);
	    // if inlineOrAnchor is not null, then this is the inline for that picture
	    if (inlineOrAnchor != null) return inlineOrAnchor;
	   }
	   for (org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor anchor : drawing.getAnchorList()) {
	    org.apache.xmlbeans.XmlObject inlineOrAnchor = getInlineOrAnchor(ctPictureToFind, anchor);
	    // if inlineOrAnchor is not null, then this is the anchor for that picture
	    if (inlineOrAnchor != null) return inlineOrAnchor;
	   }
	  }
	  return null;
	 }

	 static org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps getNonVisualDrawingProps(org.apache.xmlbeans.XmlObject inlineOrAnchor) {
	  if (inlineOrAnchor == null) return null;
	  if (inlineOrAnchor instanceof org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline) {
	   org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline inline = (org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline)inlineOrAnchor;
	   return inline.getDocPr();    
	  } else if (inlineOrAnchor instanceof org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor) {
	   org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor anchor = (org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor)inlineOrAnchor;
	   return anchor.getDocPr();
	  }
	  return null;
	 }

	 static String getSummary(org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps nonVisualDrawingProps) {
	  if (nonVisualDrawingProps == null) return "";
	  String summary = "Id:=" + nonVisualDrawingProps.getId();
	  summary += " Name:=" + nonVisualDrawingProps.getName();
	  //summary += " Title:=" + nonVisualDrawingProps.getTitle();
	  summary += " Descr:=" + nonVisualDrawingProps.getDescr();
	  return summary;
	 }
	    
	 static XWPFPicture getPictureByAltText(XWPFRun run, String altText) {
	  if (altText == null) return null;
	  for (XWPFPicture picture : run.getEmbeddedPictures()) {
	   String altTextSummary = getSummary(getNonVisualDrawingProps(getInlineOrAnchor(run, picture)));
	   System.out.println(altTextSummary);
	   if (altTextSummary.contains(altText)) {
	    return picture;   
	   }
	  }
	  return null;
	 }
	 
	 static void replacePictureData(XWPFPictureData source, String pictureResultPath) {
	  /*try ( FileInputStream in = new FileInputStream(pictureResultPath); 
	        OutputStream out = source.getPackagePart().getOutputStream();
	       ) {*/
		 
		 try {
			 
			    InputStream inputStream = new URL("https://drive.google.com/file/d/13uK7dStLtsDVzZlvSaTtq8cTTJZdmdCf/view").openStream(); // o bien puede ser un InputStream de una URL u otra fuente
	            BufferedImage bufferedImage = ImageIO.read(inputStream);
	            File tempFile = File.createTempFile("imagen", ".jpg");
	            ImageIO.write(bufferedImage, "jpg", tempFile);
	            FileInputStream in = new FileInputStream(tempFile);
			 
			  //InputStream in = new URL(pictureResultPath).openStream();  
			  //FileInputStream in = (FileInputStream) ins;
			  
			  OutputStream out = source.getPackagePart().getOutputStream();
		  
	   byte[] buffer = new byte[2048];
	   int length;
	   while ((length = in.read(buffer)) > 0) {
	    out.write(buffer, 0, length);
	   }
	  } catch (Exception ex) {
	   ex.printStackTrace();  
	  }
	 }
	 
	 static void replacePicture(XWPFRun run, String altText, String pictureResultPath) {
	  XWPFPicture picture = getPictureByAltText(run, altText);
	  if (picture != null) {
	   XWPFPictureData source = picture.getPictureData();
	   replacePictureData(source, pictureResultPath);
	  }   
	 }

	 /*public static void main(String[] args) throws Exception {
	  String templatePath = "/Users/nitro/tokens/plantilla2.docx";
	  String resultPath = "/Users/nitro/tokens/plantilla_mod.docx";
	  String altText = "Placeholder QR-Code";
	  String pictureResultPath = "https://drive.google.com/file/d/1OijfyWJYG_eURikIoYO45x7BFiy_4H3t/view";
	  
	  try ( XWPFDocument document = new XWPFDocument(new FileInputStream(templatePath));
	        FileOutputStream out = new FileOutputStream(resultPath);
	       ) {
	   
	   for (IBodyElement bodyElement : document.getBodyElements()) {
	    if (bodyElement instanceof XWPFParagraph) {
	     XWPFParagraph paragraph = (XWPFParagraph)bodyElement;
	     for (XWPFRun run : paragraph.getRuns()) {
	      replacePicture(run, altText, pictureResultPath);
	     }
	    }
	   }       
	   document.write(out);
	  }    
	 }
	 */
	 
	 
=======
package co.com.sisapco.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;

import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.xwpf.usermodel.*;

public class WordReplacePictureData {
    
	 static org.apache.xmlbeans.XmlObject getInlineOrAnchor(org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture ctPictureToFind, org.apache.xmlbeans.XmlObject inlineOrAnchor) {
	  String declareNameSpaces = "declare namespace pic='http://schemas.openxmlformats.org/drawingml/2006/picture'; ";
	  org.apache.xmlbeans.XmlObject[] selectedObjects = inlineOrAnchor.selectPath(
	   declareNameSpaces 
	   + "$this//pic:pic");
	  for (org.apache.xmlbeans.XmlObject selectedObject : selectedObjects) {
	   if (selectedObject instanceof org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture) {
	    org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture ctPicture = (org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture)selectedObject;
	    if (ctPictureToFind.equals(ctPicture)) {
	     // this is the inlineOrAnchor for that picture   
	     return inlineOrAnchor;
	    }        
	   }          
	  }
	  return null;
	 }
	                
	 static org.apache.xmlbeans.XmlObject getInlineOrAnchor(XWPFRun run, XWPFPicture picture) {
	  org.openxmlformats.schemas.drawingml.x2006.picture.CTPicture ctPictureToFind = picture.getCTPicture();
	  for (org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDrawing drawing : run.getCTR().getDrawingList()) {
	   for (org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline inline : drawing.getInlineList()) {
	    org.apache.xmlbeans.XmlObject inlineOrAnchor = getInlineOrAnchor(ctPictureToFind, inline);
	    // if inlineOrAnchor is not null, then this is the inline for that picture
	    if (inlineOrAnchor != null) return inlineOrAnchor;
	   }
	   for (org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor anchor : drawing.getAnchorList()) {
	    org.apache.xmlbeans.XmlObject inlineOrAnchor = getInlineOrAnchor(ctPictureToFind, anchor);
	    // if inlineOrAnchor is not null, then this is the anchor for that picture
	    if (inlineOrAnchor != null) return inlineOrAnchor;
	   }
	  }
	  return null;
	 }

	 static org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps getNonVisualDrawingProps(org.apache.xmlbeans.XmlObject inlineOrAnchor) {
	  if (inlineOrAnchor == null) return null;
	  if (inlineOrAnchor instanceof org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline) {
	   org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline inline = (org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline)inlineOrAnchor;
	   return inline.getDocPr();    
	  } else if (inlineOrAnchor instanceof org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor) {
	   org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor anchor = (org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTAnchor)inlineOrAnchor;
	   return anchor.getDocPr();
	  }
	  return null;
	 }

	 static String getSummary(org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps nonVisualDrawingProps) {
	  if (nonVisualDrawingProps == null) return "";
	  String summary = "Id:=" + nonVisualDrawingProps.getId();
	  summary += " Name:=" + nonVisualDrawingProps.getName();
	  //summary += " Title:=" + nonVisualDrawingProps.getTitle();
	  summary += " Descr:=" + nonVisualDrawingProps.getDescr();
	  return summary;
	 }
	    
	 static XWPFPicture getPictureByAltText(XWPFRun run, String altText) {
	  if (altText == null) return null;
	  for (XWPFPicture picture : run.getEmbeddedPictures()) {
	   String altTextSummary = getSummary(getNonVisualDrawingProps(getInlineOrAnchor(run, picture)));
	   System.out.println(altTextSummary);
	   if (altTextSummary.contains(altText)) {
	    return picture;   
	   }
	  }
	  return null;
	 }
	 
	 static void replacePictureData(XWPFPictureData source, String pictureResultPath) {
	  /*try ( FileInputStream in = new FileInputStream(pictureResultPath); 
	        OutputStream out = source.getPackagePart().getOutputStream();
	       ) {*/
		 
		 try {
			 
			    InputStream inputStream = new URL("https://drive.google.com/file/d/13uK7dStLtsDVzZlvSaTtq8cTTJZdmdCf/view").openStream(); // o bien puede ser un InputStream de una URL u otra fuente
	            BufferedImage bufferedImage = ImageIO.read(inputStream);
	            File tempFile = File.createTempFile("imagen", ".jpg");
	            ImageIO.write(bufferedImage, "jpg", tempFile);
	            FileInputStream in = new FileInputStream(tempFile);
			 
			  //InputStream in = new URL(pictureResultPath).openStream();  
			  //FileInputStream in = (FileInputStream) ins;
			  
			  OutputStream out = source.getPackagePart().getOutputStream();
		  
	   byte[] buffer = new byte[2048];
	   int length;
	   while ((length = in.read(buffer)) > 0) {
	    out.write(buffer, 0, length);
	   }
	  } catch (Exception ex) {
	   ex.printStackTrace();  
	  }
	 }
	 
	 static void replacePicture(XWPFRun run, String altText, String pictureResultPath) {
	  XWPFPicture picture = getPictureByAltText(run, altText);
	  if (picture != null) {
	   XWPFPictureData source = picture.getPictureData();
	   replacePictureData(source, pictureResultPath);
	  }   
	 }

	 /*public static void main(String[] args) throws Exception {
	  String templatePath = "/Users/nitro/tokens/plantilla2.docx";
	  String resultPath = "/Users/nitro/tokens/plantilla_mod.docx";
	  String altText = "Placeholder QR-Code";
	  String pictureResultPath = "https://drive.google.com/file/d/1OijfyWJYG_eURikIoYO45x7BFiy_4H3t/view";
	  
	  try ( XWPFDocument document = new XWPFDocument(new FileInputStream(templatePath));
	        FileOutputStream out = new FileOutputStream(resultPath);
	       ) {
	   
	   for (IBodyElement bodyElement : document.getBodyElements()) {
	    if (bodyElement instanceof XWPFParagraph) {
	     XWPFParagraph paragraph = (XWPFParagraph)bodyElement;
	     for (XWPFRun run : paragraph.getRuns()) {
	      replacePicture(run, altText, pictureResultPath);
	     }
	    }
	   }       
	   document.write(out);
	  }    
	 }
	 */
	 
	 
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
	}