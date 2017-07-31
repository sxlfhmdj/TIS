import com.dj.stis.common.utils.StringUtils;
import com.dj.stis.common.utils.pdf.PDFTools;
import com.dj.stis.common.utils.pdf.PDFUtils;
import com.dj.stis.common.utils.pdf.Position;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;


/**
 * Description: 【PDF测试】 <br/>
 * Created on 10:36 2017/7/28 <br/>
 *
 */
public class PDFTest {

    public static void main(String[] args) throws Exception {
//        File file = new File("d:/pdf/test.pdf");
//        file.createNewFile();
//        new PDFTest().createPDF(file);
        //PDFUtils.readPDF(file);
//        new PDFTest().addContentToPdf(file);
        //new PDFTest().parsePdfPage2("d:/pdf/test.pdf");

        List<Position> positions = PDFTools.findWordPositionOfFirst("年", "d:/pdf/test.pdf");
        System.out.println(positions.toString());

        if (positions != null && positions.size() > 0){
            Position position = new Position();
            position.setX(318);
            position.setY(positions.get(0).getY());
            PDFTools.addContentToPdfFirst("hello", "d:/pdf/test.pdf", "d:/pdf/target.pdf", position);
        }



    }

    public Document createPDF(File file) throws Exception{
        Document document = PDFUtils.getDocument();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }

        document.open();
        //页头信息
        document.add(PDFUtils.createParagraph("采购订单",PDFUtils.keyFont,Element.ALIGN_CENTER));
        document.add(PDFUtils.createParagraph("PO号：XD201602000003",PDFUtils.headFont,Element.ALIGN_RIGHT));
        document.add(PDFUtils.createParagraph("甲方（需方）：XXXX公司",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.add(PDFUtils.createParagraph("乙方（供方）：XXXX公司",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.add(PDFUtils.createParagraph("根据《中华人民共和国合同法》及有关法规，为明确甲乙双方在茶品购销过程中的权利、义务和各项责任，经双方协商同意签订本合同",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.add(PDFUtils.createParagraph("一、产品名称、规格、价格及数量",PDFUtils.headFont,Element.ALIGN_LEFT));

        //表格信息
        float[] widths = {4f,10f,10f,20f,15f,8f,11f,12f,10f};
        PdfPTable table = PDFUtils.createTable(widths);

        table.addCell(PDFUtils.createCell("顾客信息", PDFUtils.textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,4));

        table.addCell(PDFUtils.createCell("顾客名称", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1));
        table.addCell(PDFUtils.createCell("XXXX有限公司", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,6,1));

        table.addCell(PDFUtils.createCell("编码/税号", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1));
        table.addCell(PDFUtils.createCell("", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,6,1));

        table.addCell(PDFUtils.createCell("联系地址", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1));
        table.addCell(PDFUtils.createCell("", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,6,1));

        table.addCell(PDFUtils.createCell("采购经办人", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(PDFUtils.createCell("", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("经办人电话", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(PDFUtils.createCell("", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1));
        table.addCell(PDFUtils.createCell("经办人手机", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(PDFUtils.createCell("", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));


        table.addCell(PDFUtils.createCell("产品订购清单", PDFUtils.textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,8));

        table.addCell(PDFUtils.createCell("序号", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(PDFUtils.createCell("产品信息", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(PDFUtils.createCell("规格型号", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(PDFUtils.createCell("单位", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(PDFUtils.createCell("单价", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(PDFUtils.createCell("数量", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table.addCell(PDFUtils.createCell("小计", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));

        table.addCell(PDFUtils.createCell("1", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("塑料纸", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1));
        table.addCell(PDFUtils.createCell("小号", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("个", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("20", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("20", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("400", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));

        table.addCell(PDFUtils.createCell("2", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("塑料纸", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1));
        table.addCell(PDFUtils.createCell("小号", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("个", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("20", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("20", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("400", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));

        table.addCell(PDFUtils.createCell("3", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("塑料纸", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1));
        table.addCell(PDFUtils.createCell("小号", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("个", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("20", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("20", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("400", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));



        table.addCell(PDFUtils.createCell("4", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("合计", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1));
        table.addCell(PDFUtils.createCell("", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("20", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("60", PDFUtils.textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        table.addCell(PDFUtils.createCell("1200", PDFUtils.textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));


        table.addCell(PDFUtils.createCell("合计金额（元）", PDFUtils.textfont_B,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        table.addCell(PDFUtils.createCell("壹仟俩佰元", PDFUtils.textfont_B,Element.ALIGN_MIDDLE, Element.ALIGN_RIGHT,6,1));

        document.add(table);

        document.add(PDFUtils.createParagraph("二、交货地点：",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.add(PDFUtils.createParagraph("三、交货时间：",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.add(PDFUtils.createParagraph("四、交货方式：",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.add(PDFUtils.createParagraph("五、付款方式：",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.add(PDFUtils.createParagraph("六、解决纠纷方式：",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.add(PDFUtils.createParagraph("七、附加条款：",PDFUtils.headFont,Element.ALIGN_LEFT));

        document.add(PDFUtils.createParagraph(" 甲方：" + StringUtils.getSpace(80) + "乙方：",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.add(PDFUtils.createParagraph(" 地址：" + StringUtils.getSpace(80) + "地址：",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.add(PDFUtils.createParagraph(" 电话：" + StringUtils.getSpace(80) + "电话：",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.add(PDFUtils.createParagraph(" 传真：" + StringUtils.getSpace(80) + "传真：",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.add(PDFUtils.createParagraph(" 代表签字：" + StringUtils.getSpace(70) + "代表签字：",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.add(PDFUtils.createParagraph(" 日期：XXXX年XX月XX日" + StringUtils.getSpace(40) + "日期：XXXX年XX月XX日",PDFUtils.headFont,Element.ALIGN_LEFT));
        document.close();
        return document;
    }



    public void addContentToPdf(File file) throws Exception {
        //创建一个pdf读入流
        PdfReader reader = new PdfReader(file.getPath());
        //根据一个pdfreader创建一个pdfStamper.用来生成新的pdf.
        PdfStamper stamper = new PdfStamper(reader,
                new FileOutputStream("d:/pdf/help2.pdf"));

        //这个字体是itext-asian.jar中自带的 所以不用考虑操作系统环境问题.
        BaseFont bf = BaseFont.createFont("STSong-Light",
                "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED); // set font
        //baseFont不支持字体样式设定.但是font字体要求操作系统支持此字体会带来移植问题.
        Font font = new Font(bf,10);
        font.setStyle(Font.BOLD);
        font.getBaseFont();
        //页数是从1开始的
        for (int i=1; i<=reader.getNumberOfPages(); i++){

            //获得pdfstamper在当前页的上层打印内容.也就是说 这些内容会覆盖在原先的pdf内容之上.
            PdfContentByte over = stamper.getOverContent(i);
            //用pdfreader获得当前页字典对象.包含了该页的一些数据.比如该页的坐标轴信息.
            PdfDictionary p = reader.getPageN(i);
            //拿到mediaBox 里面放着该页pdf的大小信息.
            PdfObject po =  p.get(new PdfName("MediaBox"));
            System.out.println(po.isArray());
            //po是一个数组对象.里面包含了该页pdf的坐标轴范围.
            PdfArray pa = (PdfArray) po;
            System.out.println(pa.size());
            //看看y轴的最大值.
            System.out.println(pa.getAsNumber(pa.size()-1));
            //开始写入文本
            over.beginText();
            //设置字体和大小
            over.setFontAndSize(font.getBaseFont(), 10);
            //设置字体颜色
            over.setColorFill(BaseColor.RED);
            //设置字体的输出位置
            over.setTextMatrix(0,1000);
            //要输出的text
            over.showText("1111111111");
            over.endText();

            over.beginText();
            //设置字体和大小
            over.setFontAndSize(font.getBaseFont(), 10);
            //设置字体颜色
            over.setColorFill(BaseColor.RED);
            //设置字体的输出位置
            over.setTextMatrix(10,400);
            //要输出的text
            over.showText("1111111112");
            over.endText();
        }

        stamper.close();

    }

}
