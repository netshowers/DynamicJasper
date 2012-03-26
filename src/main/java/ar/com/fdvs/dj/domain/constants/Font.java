/*
 * Copyright (c) 2012, FDV Solutions S.A.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the FDV Solutions S.A. nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL FDV Solutions S.A. BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package ar.com.fdvs.dj.domain.constants;

import net.sf.jasperreports.engine.JRFont;
import net.sf.jasperreports.engine.design.JRDesignFont;

public class Font extends BaseDomainConstant implements Cloneable {

	private static final long serialVersionUID = 1L;
	
	private int fontSize;
	private String fontName;
	private boolean bold = false;
	private boolean italic = false;
	private boolean underline = false;
	
	private String pdfFontName;
	private String pdfFontEncoding = null;
	private boolean pdfFontEmbedded = false;
	
	public static final String PDF_ENCODING_CP1250_Central_European = "CP1250";
	public static final String PDF_ENCODING_CP1251_Cyrillic = "CP1251";
	public static final String PDF_ENCODING_CP1252_Western_European_ANSI = "CP1252";
	public static final String PDF_ENCODING_CP1253_Greek = "CP1253";
	public static final String PDF_ENCODING_CP1254_Turkish = "CP1254";
	public static final String PDF_ENCODING_CP1255_Hebrew = "CP1255";
	public static final String PDF_ENCODING_CP1256_Arabic = "CP1256";
	public static final String PDF_ENCODING_CP1257_Baltic = "CP1257";
	public static final String PDF_ENCODING_CP1258_Vietnamese = "CP1258";
	public static final String PDF_ENCODING_UniGB_UCS2_H_Chinese_Simplified = "UniGB-UCS2-H";
	public static final String PDF_ENCODING_UniGB_UCS2_V_Chinese_Simplified = "UniGB-UCS2-V";
	public static final String PDF_ENCODING_UniCNS_UCS2_H_Chinese_traditional = "UniCNS-UCS2-H";
	public static final String PDF_ENCODING_UniCNS_UCS2_V_Chinese_traditional = "UniCNS-UCS2-V";
	public static final String PDF_ENCODING_UniJIS_UCS2_H_Japanese = "UniJIS-UCS2-H";
	public static final String PDF_ENCODING_UniJIS_UCS2_V_Japanese = "UniJIS-UCS2-V";
	public static final String PDF_ENCODING_UniJIS_UCS2_HW_H_Japanese = "UniJIS-UCS2-HW-H";
	public static final String PDF_ENCODING_UniJIS_UCS2_HW_V_Japanese = "UniJIS-UCS2-HW-V";
	public static final String PDF_ENCODING_UniKS_UCS2_H_Korean = "UniKS-UCS2-H";
	public static final String PDF_ENCODING_UniKS_UCS2_V_Korean = "UniKS-UCS2-V";
	public static final String PDF_ENCODING_Identity_H_Unicode_with_horizontal_writing = "Identity-H";
	public static final String PDF_ENCODING_Identity_V_Unicode_with_horizontal_writing = "Identity-V";

	public static final String _FONT_ARIAL = "Arial";
	public static final String _FONT_TIMES_NEW_ROMAN = "Times New Roman";
	public static final String _FONT_COURIER_NEW = "Courier New";
	public static final String _FONT_COMIC_SANS = "Comic Sans MS";
	public static final String _FONT_GEORGIA = "Georgia";
	public static final String _FONT_VERDANA = "Verdana";

	public static final int SMALL = 8;
	public static final int MEDIUM = 10;
	public static final int BIG = 14;

	public static Font ARIAL_SMALL = new Font(SMALL,_FONT_ARIAL,false,false,false);
	public static Font ARIAL_MEDIUM = new Font(MEDIUM,_FONT_ARIAL,false,false,false);
	public static Font ARIAL_BIG = new Font(BIG,_FONT_ARIAL,false,false,false);
	public static Font ARIAL_SMALL_BOLD = new Font(SMALL,_FONT_ARIAL,true,false,false);
	public static Font ARIAL_MEDIUM_BOLD = new Font(MEDIUM,_FONT_ARIAL,true,false,false);
	public static Font ARIAL_BIG_BOLD = new Font(BIG,_FONT_ARIAL,true,false,false);
	public static Font TIMES_NEW_ROMAN_SMALL = new Font(SMALL,_FONT_TIMES_NEW_ROMAN,false,false,false);
	public static Font TIMES_NEW_ROMAN_MEDIUM = new Font(MEDIUM,_FONT_TIMES_NEW_ROMAN,false,false,false);
	public static Font TIMES_NEW_ROMAN_BIG = new Font(BIG,_FONT_TIMES_NEW_ROMAN,false,false,false);
	public static Font TIMES_NEW_ROMAN_SMALL_BOLD = new Font(SMALL,_FONT_TIMES_NEW_ROMAN,true,false,false);
	public static Font TIMES_NEW_ROMAN_MEDIUM_BOLD = new Font(MEDIUM,_FONT_TIMES_NEW_ROMAN,true,false,false);
	public static Font TIMES_NEW_ROMAN_BIG_BOLD = new Font(BIG,_FONT_TIMES_NEW_ROMAN,true,false,false);
	public static Font COURIER_NEW_SMALL = new Font(SMALL,_FONT_COURIER_NEW,false,false,false);
	public static Font COURIER_NEW_MEDIUM = new Font(MEDIUM,_FONT_COURIER_NEW,false,false,false);
	public static Font COURIER_NEW_BIG = new Font(BIG,_FONT_COURIER_NEW,false,false,false);
	public static Font COURIER_NEW_SMALL_BOLD = new Font(SMALL,_FONT_COURIER_NEW,true,false,false);
	public static Font COURIER_NEW_MEDIUM_BOLD = new Font(MEDIUM,_FONT_COURIER_NEW,true,false,false);
	public static Font COURIER_NEW_BIG_BOLD = new Font(BIG,_FONT_COURIER_NEW,true,false,false);
	public static Font COMIC_SANS_SMALL = new Font(SMALL,_FONT_COMIC_SANS,false,false,false);
	public static Font COMIC_SANS_MEDIUM = new Font(MEDIUM,_FONT_COMIC_SANS,false,false,false);
	public static Font COMIC_SANS_BIG = new Font(BIG,_FONT_COMIC_SANS,false,false,false);
	public static Font COMIC_SANS_SMALL_BOLD = new Font(SMALL,_FONT_COMIC_SANS,true,false,false);
	public static Font COMIC_SANS_MEDIUM_BOLD = new Font(MEDIUM,_FONT_COMIC_SANS,true,false,false);
	public static Font COMIC_SANS_BIG_BOLD = new Font(BIG,_FONT_COMIC_SANS,true,false,false);
	public static Font GEORGIA_SMALL = new Font(SMALL,_FONT_GEORGIA,false,false,false);
	public static Font GEORGIA_MEDIUM = new Font(MEDIUM,_FONT_GEORGIA,false,false,false);
	public static Font GEORGIA_BIG = new Font(BIG,_FONT_GEORGIA,false,false,false);
	public static Font GEORGIA_SMALL_BOLD = new Font(SMALL,_FONT_GEORGIA,true,false,false);
	public static Font GEORGIA_MEDIUM_BOLD = new Font(MEDIUM,_FONT_GEORGIA,true,false,false);
	public static Font GEORGIA_BIG_BOLD = new Font(BIG,_FONT_GEORGIA,true,false,false);
	public static Font VERDANA_SMALL = new Font(SMALL,_FONT_VERDANA,false,false,false);
	public static Font VERDANA_MEDIUM = new Font(MEDIUM,_FONT_VERDANA,false,false,false);
	public static Font VERDANA_BIG = new Font(BIG,_FONT_VERDANA,false,false,false);
	public static Font VERDANA_SMALL_BOLD = new Font(SMALL,_FONT_VERDANA,true,false,false);
	public static Font VERDANA_MEDIUM_BOLD = new Font(MEDIUM,_FONT_VERDANA,true,false,false);
	public static Font VERDANA_BIG_BOLD = new Font(BIG,_FONT_VERDANA,true,false,false);

	public Font(int fontSize, String fontName, String pdfFontName, String pdfFontEncoding, boolean pdfFontEmbedded) {
		super();
		this.fontSize = fontSize;
		this.fontName = fontName;
		this.pdfFontName = pdfFontName;
		this.pdfFontEncoding = pdfFontEncoding;
		this.pdfFontEmbedded = pdfFontEmbedded;
	}
	public Font() {
		this.fontSize = 10;
		this.fontName = _FONT_ARIAL;
		this.bold = false;
		this.italic= false;
		this.underline= false;
	}
	public Font(int fontSize, String fontName, boolean bold, boolean italic, boolean underline) {
		this.fontSize = fontSize;
		this.fontName = fontName;
		this.bold = bold;
		this.italic= italic;
		this.underline= underline;
	}

	public Font(int fontSize, String fontName, boolean bold) {
		this.fontSize = fontSize;
		this.fontName = fontName;
		this.bold = bold;
	}

	public String getFontName() {
		return fontName;
	}

	public int getFontSize() {
		return fontSize;
	}

	public boolean isBold() {
		return bold;
	}

	public boolean isItalic() {
		return italic;
	}

	public void setItalic(boolean intalic) {
		this.italic = intalic;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public void setFontName(String fontName) {
		this.fontName = fontName;
	}

	public void setBold(boolean bold) {
		this.bold = bold;
	}

	public boolean isUnderline() {
		return underline;
	}
	public void setUnderline(boolean underline) {
		this.underline = underline;
	}

	/**
	 * Returns a string that describes the font like indicated in
	 *  java.awt.Font.decode(...)
	 * @return
	 */
	public String getStandardFontname() {
		String decoration = "PLAIN";
		if (isBold() && isItalic())
			decoration = "BOLDITALIC";
		else if (isBold())
		decoration = "BOLD";
		else if (isItalic())
			decoration = "ITALIC";

		return fontName + "-" + decoration + "-" + this.fontSize;
	}
	public String getPdfFontName() {
		return pdfFontName;
	}
	
	/**
	 * The path to the font file
	 * @param pdfFontName
	 */
	public void setPdfFontName(String pdfFontName) {
		this.pdfFontName = pdfFontName;
	}
	public String getPdfFontEncoding() {
		return pdfFontEncoding;
	}
	
	/**
	 * Use the constants Font.PDF_ENCODING_XXXX...
	 * @param pdfFontEncoding
	 */
	public void setPdfFontEncoding(String pdfFontEncoding) {
		this.pdfFontEncoding = pdfFontEncoding;
	}
	public boolean isPdfFontEmbedded() {
		return pdfFontEmbedded;
	}
	public void setPdfFontEmbedded(boolean pdfFontEmbedded) {
		this.pdfFontEmbedded = pdfFontEmbedded;
	}

	public Object clone(){
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public JRFont transform() {
		JRDesignFont font = new JRDesignFont();
		font.setFontName(getFontName());
		font.setFontSize(getFontSize());
		font.setBold(isBold());
		font.setItalic(isItalic());
		font.setUnderline(isUnderline());
		font.setPdfFontName(getPdfFontName());
		font.setPdfEmbedded(isPdfFontEmbedded());
		font.setPdfEncoding(getPdfFontEncoding());
		return font;
	}

}