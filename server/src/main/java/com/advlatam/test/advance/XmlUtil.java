package com.advlatam.test.advance;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlUtil {

	private static final XmlUtil XML_UTIL = new XmlUtil();

	private static Logger _LOG = LogManager.getLogger(XmlUtil.class);

	private DocumentBuilderFactory documentBuilderFactory;
	private DocumentBuilder documentBuilder;
	private Document document;

	public static XmlUtil getInstance() {
		return XML_UTIL;
	}

	public XmlUtil() {
		// TODO Auto-generated constructor stub
		try {
			documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(new File("src/main/resources/Usuarios.xml"));
			document.getDocumentElement().normalize();
		} catch (Exception e) {
			_LOG.error(e.getMessage(), e);
		}
	}

	private static String getNodeValue(String name, Element element) {
		Node node = (Node) element.getElementsByTagName(name).item(0).getFirstChild();
		return node.getNodeValue();
	}

	public ArrayList<Usuario> getListaUsuarios() {
		ArrayList<Usuario> list = new ArrayList<>();
		NodeList nodeList = document.getElementsByTagName("usuario");
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;

				Usuario usuario = new Usuario();
				usuario.setId(Integer.parseInt(getNodeValue("id", element)));
				usuario.setApellidos(getNodeValue("apellidos", element));
				usuario.setNombres(getNodeValue("nombres", element));

				list.add(usuario);
			}
		}
		return list;
	}

	public void guardar(Usuario usuario) {
		try {
			// Nodo raiz
			Node node = document.getDocumentElement();

			// Atributos de la clase usuario
			Element element = document.createElement("usuario");
			Element id = document.createElement("id");
			id.setTextContent(usuario.getId().toString());
			element.appendChild(id);
			Element apellidos = document.createElement("apellidos");
			apellidos.setTextContent(usuario.getApellidos());
			element.appendChild(apellidos);
			Element nombres = document.createElement("nombres");
			nombres.setTextContent(usuario.getNombres());
			element.appendChild(nombres);

			// Añadir el elemento a la raiz
			node.appendChild(element);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("src/main/resources/Usuarios.xml"));
			transformer.transform(source, result);
		} catch (TransformerConfigurationException tce) {
			_LOG.error(tce.getMessage(), tce);
		} catch (TransformerException te) {
			_LOG.error(te.getMessage(), te);
		}

	}

}
