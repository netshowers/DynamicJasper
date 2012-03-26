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

package ar.com.fdvs.dj.domain.entities;

import ar.com.fdvs.dj.domain.Style;
import ar.com.fdvs.dj.domain.entities.columns.AbstractColumn;

import java.util.List;

public class DJColSpan  {

    private String title;
    private String count;
    private int width;
    private Style colspanHeaderStyle;
    private List<AbstractColumn> columns;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    /**
     * The total width is the sum of the width of eache column
     * @return a colspan width
     */
    public int getWidth() {
        if(width == 0) {
            for (AbstractColumn col : columns) {
                width += col.getWidth();
            }
        }

        return width;
    }

    public void setColumns(List<AbstractColumn> columns) {
        this.columns = columns;
    }

    public List<AbstractColumn> getColumns(){
        return  columns;
    }

    public Style getColspanHeaderStyle() {
        return colspanHeaderStyle;
    }

    public void setColspanHeaderStyle(Style colspanHeaderStyle) {
        this.colspanHeaderStyle = colspanHeaderStyle;
    }

    public boolean isFirstColum(AbstractColumn col) {
        return this.getColumns().get(0).equals(col);
    }

    public int getHeight() {
        return 0;
    }

    public void setHeight(){

    }
}
