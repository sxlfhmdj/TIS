package com.dj.stis.common.utils.pdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.parser.ContentByteUtils;
import com.itextpdf.text.pdf.parser.PdfContentStreamProcessor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 【PDF工具】 <br/>
 * Created on 9:13 2017/7/31 <br/>
 *
 * @author <a href="mailto: dengjiang@camelotchina.com">邓江</a><br/>
 * @version 1.0 <br/>
 *          Copyright (c) 2017年 北京柯莱特科技有限公司 交付部
 */
public class PDFTools {

    /**
     * 寻找PDF文件中的指定文字在PDF首页的坐标位置
     *
     * @param word 查找的文字
     * @param src PDF资源
     * @return
     */
    public static List<Position> findWordPositionOfFirst(String word, String src) throws IOException {
        return findWordPosition(word, src, 1);
    }

    /**
     * 寻找PDF文件中的指定文字在PDF尾页的坐标位置
     *
     * @param word 查找的文字
     * @param src PDF资源
     * @return
     */
    public static List<Position> findWordPositionOfLast(String word, String src) throws IOException {
        return findWordPosition(word, src, getTotalPageOfPDF(src));
    }

    /**
     * 寻找PDF文件中的指定文字在PDF指定页数的坐标位置
     *
     * @param word 查找的文字
     * @param src PDF资源
     * @param page 当前页(查找页)
     * @return
     */
    public static List<Position> findWordPosition(String word, String src, int page) throws IOException {
        List<Position> positions = new ArrayList<Position>();
        PdfReader reader = new PdfReader(src);

        PDFRenderListener listener = new PDFRenderListener();
        listener.setWord(word);
        PdfContentStreamProcessor processor = new PdfContentStreamProcessor(listener);
        PdfDictionary pageDic = reader.getPageN(page);
        PdfDictionary resourcesDic = pageDic.getAsDict(PdfName.RESOURCES);
        processor.processContent(ContentByteUtils.getContentBytesForPage(reader, page), resourcesDic);

        positions = listener.getPositions();
        return positions;
    }

    /**
     * 添加文本到PDF首页的指定位置
     *
     * @param content 添加内容
     * @param src pdf文件资源
     * @param position pdf中的坐标
     */
    public static void addContentToPdfFirst(String content, String src, String target, Position position) throws IOException,DocumentException {
        addContentToPDF(content, src, target, 1, position);
    }

    /**
     * 添加文本到PDF尾页的指定位置
     *
     * @param content 添加内容
     * @param src pdf文件资源
     * @param position pdf中的坐标
     */
    public static void addContentToPdfLast(String content, String src, String target, Position position) throws IOException,DocumentException {
        addContentToPDF(content, src, target, getTotalPageOfPDF(src), position);
    }

    /**
     * 添加文本到PDF的指定位置
     *
     * @param content 添加内容
     * @param src pdf源文件资源
     * @param target pdf目标资源文件
     * @param page pdf当前页
     * @param position pdf中的坐标
     */
    public static void addContentToPDF(String content, String src, String target, int page ,Position position) throws IOException,DocumentException {
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(target));
        PdfContentByte canvas = stamper.getOverContent(page);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase(content), (float)position.getX(), (float)position.getY(), 0);
        stamper.close();
        reader.close();
    }


    /**
     * 获取PDF的总页数
     *
     * @param src pdf资源文件
     * @return
     * @throws IOException
     */
    private static int getTotalPageOfPDF(String src) throws IOException{
        File file = new File(src);
        PdfReader reader = new PdfReader(file.getPath());
        return reader.getNumberOfPages();
    }


}
