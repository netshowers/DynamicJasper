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

package ar.com.fdvs.dj.test.colspan;

import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import ar.com.fdvs.dj.domain.constants.*;
import ar.com.fdvs.dj.domain.constants.Transparency;
import ar.com.fdvs.dj.test.BaseDjReportTest;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.*;
import java.util.Date;

public class ColumsSpanStyleTest extends BaseDjReportTest {

    @Override
    public DynamicReport buildReport() throws Exception {

        FastReportBuilder frb = new FastReportBuilder();

        frb.addColumn("State", "state", String.class.getName(), 30)
                .addColumn("Branch", "branch", String.class.getName(), 30)
                .addColumn("Item", "item", String.class.getName(), 50)
                .addColumn("Amount", "amount", Float.class.getName(), 60, true)
                .addGroups(2)
                .setTitle("November 2006 sales report")
                .setSubtitle("This report was generated at " + new Date())
                .setColumnsPerPage(1,10)
                .setUseFullPageWidth(true);

                Style colspanStyle = new Style();
                colspanStyle.setBackgroundColor(Color.RED);
                colspanStyle.setTransparency(Transparency.OPAQUE);
                colspanStyle.setBorder(Border.PEN_1_POINT);

                frb.setColspan(1, 2, "Estimated", colspanStyle);

        DynamicReport dynamicReport = frb.build();
        dynamicReport.getOptions().getDefaultHeaderStyle().setBorder(Border.PEN_1_POINT);

        return dynamicReport;
    }

    public static void main(String[] args) throws Exception {
        ColumsSpanStyleTest test = new ColumsSpanStyleTest();
        test.testReport();
        JasperViewer.viewReport(test.jp);
    }

}
