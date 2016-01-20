package com.coedil99.utilita.impl;

import com.coedil99.utilita.Config;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

/**
 * 
 * @author mw
 * ConfigXml
 * 
 */
public class ConfigXml implements Config {
	
	private Document document;
	
	public ConfigXml(){
		
		loadDocument();
		
	}
	
	protected void loadDocument(){
		File xmlFile = new File("config.xml");
		System.out.println(xmlFile.toURI().toASCIIString());
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		
		//documentFactory.setNamespaceAware(true);
		//documentFactory.setValidating(true);
		
		DocumentBuilder builder;
		
		try {
			
			builder = documentFactory.newDocumentBuilder();
			document = builder.parse(xmlFile);
			
			System.out.println(document);
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	protected void saveDocument(){
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(document);
			
			StreamResult streamResult = new StreamResult(new File("config.xml"));
			transformer.transform(domSource, streamResult);
			System.out.println("The XML File was saved");

			
			
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String get(String name) {
		
		return document.getElementsByTagName(name).item(0).getTextContent();
	}

	@Override
	public void set(String name, String value) {
		
		Element element = document.createElement(name);
		element.setTextContent(value);
		
		document.getDocumentElement().appendChild(element);
		saveDocument();

	}

	@Override
	public void delete(String name) {
		// TODO Auto-generated method stub
		document.removeChild(document.getElementsByTagName(name).item(0));
		saveDocument();
	}
	
	
	
	

}
