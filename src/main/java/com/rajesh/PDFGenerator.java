package com.rajesh;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;

public class PDFGenerator {
        public static void main(String[] args) throws Exception {
                FopFactory fopFactory = FopFactory.newInstance();

                OutputStream out = new BufferedOutputStream(new FileOutputStream(new File("C:\\Projects\\myfile.pdf")));

                try {
                        Fop fop = fopFactory.newFop("application/pdf", out);

                        TransformerFactory factory = TransformerFactory.newInstance();
                        Transformer transformer = factory.newTransformer();

                        Source src = new StreamSource(new File("resources\\background.fo"));

                        Result res = new SAXResult(fop.getDefaultHandler());

                        transformer.transform(src, res);

                } finally {
                        out.close();
                }
        }
}