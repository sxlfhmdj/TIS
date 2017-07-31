package com.dj.stis.common.utils.pdf;

import com.dj.stis.common.utils.StringUtils;
import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.LineSegment;
import com.itextpdf.text.pdf.parser.RenderListener;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 【PDF监听者】 <br/>
 * Created on 15:58 2017/7/28 <br/>
 *
 * @author <a href="mailto: dengjiang@camelotchina.com">邓江</a><br/>
 * @version 1.0 <br/>
 *          Copyright (c) 2017年 北京柯莱特科技有限公司 交付部
 */
public class PDFRenderListener implements RenderListener {

    private String word;//查找的文本

    private List<Position> positions = new ArrayList<Position>();//记录word在pdf中的坐标

    @Override
    public void beginTextBlock() {}

    @Override
    public void endTextBlock() {}

    @Override
    public void renderImage(ImageRenderInfo renderInfo) {}

    @Override
    public void renderText(TextRenderInfo renderInfo) {
        // Check if this is the word marker
        String text = renderInfo.getText();
        if (StringUtils.isNotEmpty(word) && StringUtils.isNotEmpty(text) && text.contains(word)) {
            //find word positions
            LineSegment ls = renderInfo.getBaseline();
            Position position = new Position();
            position.setX(ls.getBoundingRectange().getX());
            position.setY(ls.getBoundingRectange().getY());
            position.setWidth(ls.getBoundingRectange().getWidth());
            position.setHeight(ls.getBoundingRectange().getHeight());
            positions.add(position);
        }
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }
}