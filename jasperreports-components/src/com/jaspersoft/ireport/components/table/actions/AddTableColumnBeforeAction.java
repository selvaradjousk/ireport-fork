/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jaspersoft.ireport.components.table.actions;

import org.openide.util.NbBundle;

/**
 *
 * @version $Id: AddTableColumnBeforeAction.java 0 2010-03-31 15:51:20 CET gtoffoli $
 * @author Giulio Toffoli (giulio@jaspersoft.com)
 *
 */
public class AddTableColumnBeforeAction extends AddTableColumnAction {

    @Override
    public int getWhere() {
        return AddTableColumnAction.BEFORE;
    }

    @Override
    public String getName() {
        return NbBundle.getMessage(AddTableColumnAction.class, "AddTableColumnBeforeAction.Name.CTL_AddTableColumnBeforeAction");
    }

}
