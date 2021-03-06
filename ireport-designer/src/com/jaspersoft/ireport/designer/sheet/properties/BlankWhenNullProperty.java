/*
 * iReport - Visual Designer for JasperReports.
 * Copyright (C) 2002 - 2009 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of iReport.
 *
 * iReport is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * iReport is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with iReport. If not, see <http://www.gnu.org/licenses/>.
 */
package com.jaspersoft.ireport.designer.sheet.properties;

import com.jaspersoft.ireport.locale.I18n;
import net.sf.jasperreports.engine.base.JRBaseStyle;
import net.sf.jasperreports.engine.design.JRDesignTextField;

/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 */
public final class BlankWhenNullProperty extends BooleanProperty
{
    private final JRDesignTextField element;

    @SuppressWarnings("unchecked")
    public BlankWhenNullProperty(JRDesignTextField element)
    {
        super(element);
        this.element = element;
    }

    @Override
    public String getName()
    {
        return JRBaseStyle.PROPERTY_BLANK_WHEN_NULL;
    }

    @Override
    public String getDisplayName()
    {
        return I18n.getString("Global.Property.BlankWhenNull");
    }

    @Override
    public String getShortDescription()
    {
        return I18n.getString("Global.Property.BWNdetail");
    }

    @Override
    public Boolean getBoolean()
    {
        return element.isBlankWhenNull();
    }

    @Override
    public Boolean getOwnBoolean()
    {
        return element.isOwnBlankWhenNull();
    }

    @Override
    public Boolean getDefaultBoolean()
    {
        return null;
    }

    @Override
    public void setBoolean(Boolean isBlankWhenNull)
    {
        element.setBlankWhenNull(isBlankWhenNull);
    }

}
