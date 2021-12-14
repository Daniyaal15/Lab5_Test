package com.example.lab5;

import android.app.Activity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlParser {

    private ArrayList<HashMap<String, String>> userList;
    private Activity activity;

    public ArrayList<HashMap<String, String>> getUserList() {
        return userList;
    }

    public XmlParser(Activity activity) {
        try {
            userList = new ArrayList<>();
            InputStream istream = activity.getAssets().open("currencies_details.xml");
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = builderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(istream);
            NodeList nList = doc.getElementsByTagName("item");
            for (int i = 0; i < nList.getLength(); i++) {
                if (nList.item(0).getNodeType() == Node.ELEMENT_NODE) {
                    HashMap<String, String> user = new HashMap<>();
                    Element elm = (Element) nList.item(i);
                    user.put("targetName", getNodeValue("targetName", elm));
                    user.put("targetCurrency", getNodeValue("targetCurrency", elm));
                    user.put("inverseRate", getNodeValue("inverseRate", elm));
                    userList.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


    public static String getNodeValue(String tag, Element element) {
        if (element == null)
            return null;
        NodeList nodeList = element.getElementsByTagName(tag);
        Node node = nodeList.item(0);
        if (node != null || tag == null || tag.equalsIgnoreCase("")) {
            if (node.hasChildNodes()) {
                Node child = node.getFirstChild();
                while (child != null) {
                    if (child.getNodeType() == Node.TEXT_NODE) {
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }
}
