<<<<<<< HEAD
package co.com.sisapco.controller;

import java.util.Properties;


import javax.mail.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Store;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


@Controller
public class LeerCorreoController {
	
	
	
	@PostMapping("/leercorreos")
	public String leeerCorreoGmail(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		
		// Se obtiene la Session
		Properties prop = new Properties();
		prop.setProperty("mail.pop3.starttls.enable", "false");
		prop.setProperty(
		"mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.setProperty("mail.pop3.socketFactory.fallback", "false");
		prop.setProperty("mail.pop3.port", "995");
		prop.setProperty("mail.pop3.socketFactory.port", "995");
		Session sesion = Session.getInstance(prop);

		try
		{
			// Se obtiene el Store y el Folder, para poder leer el
			// correo.
			Store store = sesion.getStore("pop3");
			store.connect(
			"pop.gmail.com", "sisapcoprueba@gmail.com", "sisapco2020*");
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
	
			// Se obtienen los mensajes.
			Message[] mensajes = folder.getMessages();
	
			// Se escribe from y subject de cada mensaje
			for (int i = 0; i < mensajes.length; i++)
			{
				System.out.println(
				"From:" + mensajes[i].getFrom()[0].toString());
				System.out.println("Subject:" + mensajes[i].getSubject());
		
				// Se visualiza, si se sabe como, el contenido de cada mensaje
				analizaParteDeMensaje(mensajes[i]);
			}
	
			folder.close(false);
			store.close();
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
		
		
		
		
		
		
		return "";
	}
	
	private static void analizaParteDeMensaje(Part unaParte){
		
		try
		{
			// Si es multipart, se analiza cada una de sus partes recursivamente.
			if (unaParte.isMimeType("multipart/*"))
			{
				Multipart multi;
				multi = (Multipart) unaParte.getContent();
		
				for (int j = 0; j < multi.getCount(); j++)
				{
				analizaParteDeMensaje(multi.getBodyPart(j));
				}
			}
			else
			{
				// Si es texto, se escribe el texto.
				if (unaParte.isMimeType("text/*"))
				{
				System.out.println("Texto " + unaParte.getContentType());
				System.out.println(unaParte.getContent());
				System.out.println("---------------------------------");
				}
			else
			{
				// Si es imagen, se guarda en fichero y se visualiza en JFrame
				if (unaParte.isMimeType("image/*"))
				{
					System.out.println(
					"Imagen " + unaParte.getContentType());
					System.out.println("Fichero=" + unaParte.getFileName());
					System.out.println("---------------------------------");
				
					salvaImagenEnFichero(unaParte);
					visualizaImagenEnJFrame(unaParte);
				}
				else
				{
					// Si no es ninguna de las anteriores, se escribe en pantalla
					// el tipo.
					System.out.println(
					"Recibido " + unaParte.getContentType());
					System.out.println("---------------------------------");
				}
			}
			}
	    }
		catch (Exception e)
		{
	     	e.printStackTrace();
		}
	}
	
	private static void visualizaImagenEnJFrame(Part unaParte)
			throws IOException, MessagingException
			{
			JFrame v = new JFrame();
			ImageIcon icono = new ImageIcon(
			ImageIO.read(unaParte.getInputStream()));
			JLabel l = new JLabel(icono);
			v.getContentPane().add(l);
			v.pack();
			v.setVisible(true);
	}
	
	private static void salvaImagenEnFichero(Part unaParte) throws FileNotFoundException, MessagingException, IOException
	{
			FileOutputStream fichero = new FileOutputStream(
			"d:/" + unaParte.getFileName());
			InputStream imagen = unaParte.getInputStream();
			byte[] bytes = new byte[1000];
			int leidos = 0;

			while ((leidos = imagen.read(bytes)) > 0)
			{
				fichero.write(bytes, 0, leidos);
			}
	}

}
=======
package co.com.sisapco.controller;

import java.util.Properties;


import javax.mail.Session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Store;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


@Controller
public class LeerCorreoController {
	
	
	
	@PostMapping("/leercorreos")
	public String leeerCorreoGmail(Authentication authenticationnn,  ModelMap model, HttpServletRequest req, HttpServletResponse resp) throws Exception {
	
		
		// Se obtiene la Session
		Properties prop = new Properties();
		prop.setProperty("mail.pop3.starttls.enable", "false");
		prop.setProperty(
		"mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.setProperty("mail.pop3.socketFactory.fallback", "false");
		prop.setProperty("mail.pop3.port", "995");
		prop.setProperty("mail.pop3.socketFactory.port", "995");
		Session sesion = Session.getInstance(prop);

		try
		{
			// Se obtiene el Store y el Folder, para poder leer el
			// correo.
			Store store = sesion.getStore("pop3");
			store.connect(
			"pop.gmail.com", "sisapcoprueba@gmail.com", "sisapco2020*");
			Folder folder = store.getFolder("INBOX");
			folder.open(Folder.READ_ONLY);
	
			// Se obtienen los mensajes.
			Message[] mensajes = folder.getMessages();
	
			// Se escribe from y subject de cada mensaje
			for (int i = 0; i < mensajes.length; i++)
			{
				System.out.println(
				"From:" + mensajes[i].getFrom()[0].toString());
				System.out.println("Subject:" + mensajes[i].getSubject());
		
				// Se visualiza, si se sabe como, el contenido de cada mensaje
				analizaParteDeMensaje(mensajes[i]);
			}
	
			folder.close(false);
			store.close();
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
		
		
		
		
		
		
		return "";
	}
	
	private static void analizaParteDeMensaje(Part unaParte){
		
		try
		{
			// Si es multipart, se analiza cada una de sus partes recursivamente.
			if (unaParte.isMimeType("multipart/*"))
			{
				Multipart multi;
				multi = (Multipart) unaParte.getContent();
		
				for (int j = 0; j < multi.getCount(); j++)
				{
				analizaParteDeMensaje(multi.getBodyPart(j));
				}
			}
			else
			{
				// Si es texto, se escribe el texto.
				if (unaParte.isMimeType("text/*"))
				{
				System.out.println("Texto " + unaParte.getContentType());
				System.out.println(unaParte.getContent());
				System.out.println("---------------------------------");
				}
			else
			{
				// Si es imagen, se guarda en fichero y se visualiza en JFrame
				if (unaParte.isMimeType("image/*"))
				{
					System.out.println(
					"Imagen " + unaParte.getContentType());
					System.out.println("Fichero=" + unaParte.getFileName());
					System.out.println("---------------------------------");
				
					salvaImagenEnFichero(unaParte);
					visualizaImagenEnJFrame(unaParte);
				}
				else
				{
					// Si no es ninguna de las anteriores, se escribe en pantalla
					// el tipo.
					System.out.println(
					"Recibido " + unaParte.getContentType());
					System.out.println("---------------------------------");
				}
			}
			}
	    }
		catch (Exception e)
		{
	     	e.printStackTrace();
		}
	}
	
	private static void visualizaImagenEnJFrame(Part unaParte)
			throws IOException, MessagingException
			{
			JFrame v = new JFrame();
			ImageIcon icono = new ImageIcon(
			ImageIO.read(unaParte.getInputStream()));
			JLabel l = new JLabel(icono);
			v.getContentPane().add(l);
			v.pack();
			v.setVisible(true);
	}
	
	private static void salvaImagenEnFichero(Part unaParte) throws FileNotFoundException, MessagingException, IOException
	{
			FileOutputStream fichero = new FileOutputStream(
			"d:/" + unaParte.getFileName());
			InputStream imagen = unaParte.getInputStream();
			byte[] bytes = new byte[1000];
			int leidos = 0;

			while ((leidos = imagen.read(bytes)) > 0)
			{
				fichero.write(bytes, 0, leidos);
			}
	}

}
>>>>>>> branch 'master' of https://github.com/sisapco/sisapco.git
