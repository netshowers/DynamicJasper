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

package ar.com.fdvs.dj.test.groups.labels;

import java.awt.Color;
import java.util.Map;

import net.sf.jasperreports.view.JasperDesignViewer;
import net.sf.jasperreports.view.JasperViewer;
import ar.com.fdvs.dj.domain.AutoText;
import ar.com.fdvs.dj.domain.ColumnProperty;
import ar.com.fdvs.dj.domain.DJCalculation;
import ar.com.fdvs.dj.domain.DJGroupLabel;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.ExpressionHelper;
import ar.com.fdvs.dj.domain.ImageBanner;
import ar.com.fdvs.dj.domain.StringExpression;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.ColumnBuilder;
import ar.com.fdvs.dj.domain.builders.DynamicReportBuilder;
import ar.com.fdvs.dj.domain.builders.GroupBuilder;
import ar.com.fdvs.dj.domain.builders.StyleBuilder;
import ar.com.fdvs.dj.domain.constants.Border;
import ar.com.fdvs.dj.domain.constants.Font;
import ar.com.fdvs.dj.domain.constants.GroupLayout;
import ar.com.fdvs.dj.domain.constants.HorizontalAlign;
import ar.com.fdvs.dj.domain.constants.LabelPosition;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.domain.constants.VerticalAlign;
import ar.com.fdvs.dj.domain.entities.DJGroup;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;
import ar.com.fdvs.dj.domain.entities.columns.PropertyColumn;
import ar.com.fdvs.dj.test.BaseDjReportTest;

public class GroupLabelTest5 extends BaseDjReportTest {

	public DynamicReport buildReport() throws Exception {

		Style detailStyle = new Style();

		Style headerStyle = new Style();
		headerStyle.setFont(Font.ARIAL_MEDIUM_BOLD);
		headerStyle.setBorderBottom(Border.PEN_1_POINT);
		headerStyle.setBackgroundColor(Color.gray);
		headerStyle.setTextColor(Color.white);
		headerStyle.setHorizontalAlign(HorizontalAlign.CENTER);
		headerStyle.setVerticalAlign(VerticalAlign.MIDDLE);
		headerStyle.setTransparency(Transparency.OPAQUE);

		Style headerVariables = new Style();
		headerVariables.setFont(Font.ARIAL_MEDIUM_BOLD);
//		headerVariables.setBorder(Border.THIN);
		headerVariables.setHorizontalAlign(HorizontalAlign.RIGHT);
		headerVariables.setVerticalAlign(VerticalAlign.TOP);

		Style titleStyle = new Style();
		titleStyle.setFont(new Font(18, Font._FONT_VERDANA, true));
		Style importeStyle = new Style();
		importeStyle.setHorizontalAlign(HorizontalAlign.RIGHT);
		Style oddRowStyle = new Style();
		oddRowStyle.setBorder(Border.NO_BORDER);
		oddRowStyle.setBackgroundColor(Color.LIGHT_GRAY);
		oddRowStyle.setTransparency(Transparency.OPAQUE);

		DynamicReportBuilder drb = new DynamicReportBuilder();
		Integer margin = new Integer(20);
		drb
			.setTitleStyle(titleStyle)
			.setTitle("November 2006 sales report")					//defines the title of the report
			.setSubtitle("The items in this report correspond "
					+"to the main products: DVDs, Books, Foods and Magazines")
			.setDetailHeight(new Integer(15)).setLeftMargin(margin)
			.setRightMargin(margin).setTopMargin(margin).setBottomMargin(margin)
			.setPrintBackgroundOnOddRows(false)
			.setGrandTotalLegend("Grand Total")
			.setGrandTotalLegendStyle(headerVariables)
			.setDefaultStyles(titleStyle, null, headerStyle, detailStyle)
			.setPrintColumnNames(true)
			.addImageBanner(System.getProperty("user.dir") +"/target/test-classes/images/logo_fdv_solutions_60.jpg", new Integer(100), new Integer(30), ImageBanner.ALIGN_RIGHT)
			.setOddRowBackgroundStyle(oddRowStyle);


		AbstractColumn columnState = ColumnBuilder.getNew()
				.setColumnProperty("state", String.class.getName())
				.setTitle("State").setWidth(new Integer(85))
				//.setStyle(titleStyle).setHeaderStyle(titleStyle)
				.build();

		AbstractColumn columnBranch = ColumnBuilder.getNew()
				.setColumnProperty("branch", String.class.getName())
				.setTitle("Branch").setWidth(new Integer(85))
				.setStyle(detailStyle).setHeaderStyle(headerStyle)
				.build();

		AbstractColumn columnaProductLine = ColumnBuilder.getNew()
				.setColumnProperty("productLine", String.class.getName())
				.setTitle("Product Line").setWidth(new Integer(85))
				.setStyle(detailStyle).setHeaderStyle(headerStyle)
				.build();

		AbstractColumn columnaItem = ColumnBuilder.getNew()
				.setColumnProperty("item", String.class.getName())
				.setTitle("Item").setWidth(new Integer(85))
				.setStyle(detailStyle).setHeaderStyle(headerStyle)
				.build();

		AbstractColumn columnCode = ColumnBuilder.getNew()
				.setColumnProperty("id", Long.class.getName())
				.setTitle("ID").setWidth(new Integer(40))
				.setStyle(importeStyle).setHeaderStyle(headerStyle)
				.build();

		AbstractColumn columnaQuantity = ColumnBuilder.getNew()
				.setColumnProperty("quantity", Long.class.getName())
				.setTitle("Quantity").setWidth(new Integer(80))
				.setStyle(importeStyle).setHeaderStyle(headerStyle)
				.build();

		/*AbstractColumn columnAmount = ColumnBuilder.getNew()
				.setColumnProperty("amount", Float.class.getName())
				.setTitle("Amount").setWidth(new Integer(90)).setPattern("$ 0.00")
				.setStyle(importeStyle).setHeaderStyle(headerStyle)
				.build();*/

		ColumnProperty fieldAmount = new ColumnProperty("amount", Float.class.getName());

		GroupBuilder gb1 = new GroupBuilder("group_state");

		Style glabelStyle = new StyleBuilder(false).setFont(Font.ARIAL_SMALL)
			.setHorizontalAlign(HorizontalAlign.RIGHT).setBorderTop(Border.THIN)
			.setStretchWithOverflow(false)
			.build();
		DJGroupLabel glabel1 = new DJGroupLabel(new StringExpression() {			
			public Object evaluate(Map fields, Map variables, Map parameters) {
				return "Total amount";
			}
		},glabelStyle,LabelPosition.TOP);
		DJGroupLabel glabel2 = new DJGroupLabel("Total quantity",glabelStyle,LabelPosition.TOP);
		
		Style glabelStyle2 = new Style();
		glabelStyle2.setHorizontalAlign(HorizontalAlign.CENTER);
		glabelStyle2.setTextColor(Color.BLUE);
		DJGroupLabel glabel3 = new DJGroupLabel(new StringExpression() {			
			public Object evaluate(Map fields, Map variables, Map parameters) {
				return "group: \"" + variables.get("state_name") + "\", count: " + ExpressionHelper.getGroupCount("group_state", variables) + 
					", total amount: " + variables.get("sum_amount");
			}
		},glabelStyle2,LabelPosition.TOP);
		
		//		 define the criteria column to group by (columnState)
		DJGroup g1 = gb1.setCriteriaColumn((PropertyColumn) columnState)
		    .addVariable("state_name", columnState, DJCalculation.FIRST)
		    .addVariable("sum_amount", fieldAmount, DJCalculation.SUM)
				//.addFooterVariable(columnAmount,DJCalculation.SUM,headerVariables, null, glabel1) // tell the group place a variable footer of the column "columnAmount" with the SUM of allvalues of the columnAmount in this group.
				.addFooterVariable(columnaQuantity,DJCalculation.SUM,headerVariables, null, glabel2) // idem for the columnaQuantity column
				.setGroupLayout(GroupLayout.VALUE_IN_HEADER) // tells the group how to be shown, there are manyposibilities, see the GroupLayout for more.
				.setFooterLabel(glabel3)
				.setFooterVariablesHeight(new Integer(30))
				.build();

		GroupBuilder gb2 = new GroupBuilder(); // Create another group (using another column as criteria)
		DJGroup g2 = gb2.setCriteriaColumn((PropertyColumn) columnBranch) // and we add the same operations for the columnAmount and
				//.addFooterVariable(columnAmount,DJCalculation.SUM) // columnaQuantity columns
				.addFooterVariable(columnaQuantity,	DJCalculation.SUM)
				.build();

		drb.addColumn(columnState);
		drb.addColumn(columnBranch);
		drb.addColumn(columnaProductLine);
//		drb.addColumn(columnaItem);
//		drb.addColumn(columnCode);
		drb.addColumn(columnaQuantity);
		//drb.addColumn(columnAmount);
		
//		drb.addField(fieldAmount);
		
		//drb.addGlobalFooterVariable(columnAmount, DJCalculation.SUM, headerVariables, null);
		drb.addGlobalFooterVariable(columnaQuantity, DJCalculation.SUM, headerVariables, null);

		drb.addGroup(g1); // add group g1
//		drb.addGroup(g2); // add group g2

		drb.setUseFullPageWidth(true);
		drb.addAutoText(AutoText.AUTOTEXT_PAGE_X_SLASH_Y, AutoText.POSITION_FOOTER, AutoText.ALIGNMENT_RIGHT);

		DynamicReport dr = drb.build();
		return dr;
	}

	public static void main(String[] args) throws Exception {
		GroupLabelTest5 test = new GroupLabelTest5();
		test.testReport();
		test.exportToJRXML();
		JasperViewer.viewReport(test.jp);
		JasperDesignViewer.viewReportDesign(test.jr);
	}

}