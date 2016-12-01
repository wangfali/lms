package com.briup.web.Util.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * xml文件的操作
 * @author wangfali
 *@version 1.0
 *@date 2016年11月30日
 */
public class XmlUtil {
	/**
	 * 将文件读取并且返回
	 *@return Document
	 */
	public static Document getDocument(){
		File file = new File("e:/ContactList.xml");
		//判断该文件是否存在
		if(!file.exists()){
			//如果文件不存在则创建一个新的文件
			try {
				file.createNewFile();
				Document document = DocumentHelper.createDocument();
				document.addElement("ContactList");
				//将创建好的文档存进文件中
				 OutputFormat format = OutputFormat.createPrettyPrint();
				 format.setEncoding("utf-8");
				 FileWriter out=new FileWriter(file); 
				 XMLWriter writer = new XMLWriter(out, format);
				 writer.write(document);
				 writer.close();
				 return document;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			//如果文件存在则直接读取出来返回
			try {
				Document document = new SAXReader().read("e:/ContactList.xml");
				return document;
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}
	return null;	
	}
	/**
	 * 将文档写入文件中
	 *@return void
	 *@param document 要写入的文档 
	 *
	 */
	public static void xmlwrite(Document document)  {
		//创建文件连接对象
		File file = new File("e:/ContactList.xml");
		//判断该文件是否存在
		if(!file.exists()){
			//文件不存在需要创建新的文件
			try {
				file.createNewFile();
				//将xml文档存进文件中
				OutputFormat format = OutputFormat.createPrettyPrint();
				//设置编码
				format.setEncoding("utf-8");
				//创建写入流
				FileWriter out = new FileWriter(file);
				XMLWriter writer = new XMLWriter(out, format);
				writer.write(document);
				//关闭资源
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			//将xml文档存进文件中
			OutputFormat format = OutputFormat.createPrettyPrint();
			//设置编码
			format.setEncoding("utf-8");
			//创建写入流
			FileWriter out;
			try {
				out = new FileWriter(file);
			XMLWriter writer = new XMLWriter(out, format);
			writer.write(document);
			//关闭资源
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
}
