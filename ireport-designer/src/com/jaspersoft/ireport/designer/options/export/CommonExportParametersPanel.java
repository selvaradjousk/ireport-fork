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
package com.jaspersoft.ireport.designer.options.export;

import com.jaspersoft.ireport.designer.IRLocalJasperReportsContext;
import com.jaspersoft.ireport.designer.IReportManager;
import com.jaspersoft.ireport.locale.I18n;
import java.util.prefs.Preferences;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JasperReportsContext;

/**
 *
 * @author gtoffoli
 */
public class CommonExportParametersPanel extends AbstractExportParametersPanel {

    /** Creates new form CommonExportParametersPanel */
    public CommonExportParametersPanel() {
        initComponents();
        SpinnerNumberModel snmX = new SpinnerNumberModel(0,0,Integer.MAX_VALUE,1);
        SpinnerNumberModel snmY = new SpinnerNumberModel(0,0,Integer.MAX_VALUE,1);
        jSpinnerOffsetX.setModel(snmX);
        jSpinnerOffsetY.setModel(snmY);

        snmX.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                notifyChange();
            }
        });

        snmY.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                notifyChange();
            }
        });

        javax.swing.event.DocumentListener textfieldListener =  new javax.swing.event.DocumentListener()
                {
                    public void changedUpdate(javax.swing.event.DocumentEvent evt)
                    {
                        notifyChange();
                    }
                    public void insertUpdate(javax.swing.event.DocumentEvent evt)
                    {
                        notifyChange();
                    }
                    public void removeUpdate(javax.swing.event.DocumentEvent evt)
                    {
                        notifyChange();
                    }
                };

         jTextFieldCharacterEncoding.getDocument().addDocumentListener(textfieldListener);
         jTextFieldPageIndex.getDocument().addDocumentListener(textfieldListener);
         jTextFieldPageRangeFrom.getDocument().addDocumentListener(textfieldListener);
         jTextFieldPageRangeTo.getDocument().addDocumentListener(textfieldListener);


         applyI18n();
    }

    public void applyI18n()
    {
        jRadioButtonExportAll.setText(I18n.getString("CommonExportParametersPanel.jRadioButtonExportAll.text")); // NOI18N
        jRadioButtonExportPageIndex.setText(I18n.getString("CommonExportParametersPanel.jRadioButtonExportPageIndex.text")); // NOI18N
        jRadioButtonExportRange.setText(I18n.getString("CommonExportParametersPanel.jRadioButtonExportRange.text")); // NOI18N
        jLabelPageRangeTo.setText(I18n.getString("CommonExportParametersPanel.jLabelPageRangeTo.text")); // NOI18N
        jLabelCharacterEncoding.setText(I18n.getString("CommonExportParametersPanel.jLabelCharacterEncoding.text")); // NOI18N
        jLabelOffsetX.setText(I18n.getString("CommonExportParametersPanel.jLabelOffsetX.text")); // NOI18N
        jLabelOffsetY.setText(I18n.getString("CommonExportParametersPanel.jLabelOffsetY.text")); // NOI18N
        jCheckBoxIgnorePageMargins.setText(I18n.getString("CommonExportParametersPanel.jCheckBoxIgnorePageMargins.text")); // NOI18N
        jLabelTitle.setText(I18n.getString("CommonExportParametersPanel.jLabelTitle.text")); // NOI18N
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(I18n.getString("CommonExportParametersPanel.jPanel1.border.title"))); // NOI18N
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabelTitle = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonExportAll = new javax.swing.JRadioButton();
        jRadioButtonExportPageIndex = new javax.swing.JRadioButton();
        jRadioButtonExportRange = new javax.swing.JRadioButton();
        jTextFieldPageIndex = new javax.swing.JTextField();
        jTextFieldPageRangeFrom = new javax.swing.JTextField();
        jLabelPageRangeTo = new javax.swing.JLabel();
        jTextFieldPageRangeTo = new javax.swing.JTextField();
        jLabelError = new javax.swing.JLabel();
        jLabelCharacterEncoding = new javax.swing.JLabel();
        jTextFieldCharacterEncoding = new javax.swing.JTextField();
        jLabelOffsetX = new javax.swing.JLabel();
        jSpinnerOffsetX = new javax.swing.JSpinner();
        jLabelOffsetY = new javax.swing.JLabel();
        jSpinnerOffsetY = new javax.swing.JSpinner();
        jCheckBoxIgnorePageMargins = new javax.swing.JCheckBox();

        jLabelTitle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelTitle.setText("Common Export parameters");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pages to export"));

        buttonGroup1.add(jRadioButtonExportAll);
        jRadioButtonExportAll.setSelected(true);
        jRadioButtonExportAll.setText("Export all pages");
        jRadioButtonExportAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExportAllActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonExportPageIndex);
        jRadioButtonExportPageIndex.setText("Export page:");
        jRadioButtonExportPageIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExportPageIndexActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButtonExportRange);
        jRadioButtonExportRange.setText("Export pages from:");
        jRadioButtonExportRange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonExportRangeActionPerformed(evt);
            }
        });

        jLabelPageRangeTo.setText("to");

        jLabelError.setForeground(new java.awt.Color(204, 0, 0));

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jRadioButtonExportAll)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jRadioButtonExportPageIndex)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextFieldPageIndex, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jRadioButtonExportRange)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextFieldPageRangeFrom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(10, 10, 10)
                        .add(jLabelPageRangeTo)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextFieldPageRangeTo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(325, Short.MAX_VALUE))
            .add(jLabelError, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jRadioButtonExportAll)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRadioButtonExportPageIndex)
                    .add(jTextFieldPageIndex, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jRadioButtonExportRange)
                    .add(jTextFieldPageRangeFrom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabelPageRangeTo)
                    .add(jTextFieldPageRangeTo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabelError)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelCharacterEncoding.setText("Character encoding");

        jLabelOffsetX.setText("Offset X");

        jLabelOffsetY.setText("Offset Y");

        jCheckBoxIgnorePageMargins.setText("Ignore page margins");
        jCheckBoxIgnorePageMargins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxIgnorePageMarginsActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabelTitle)
                .addContainerGap(392, Short.MAX_VALUE))
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabelCharacterEncoding)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jTextFieldCharacterEncoding, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabelOffsetX)
                            .add(jLabelOffsetY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 44, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jSpinnerOffsetY)
                            .add(jSpinnerOffsetX, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))))
                .add(315, 315, 315))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jCheckBoxIgnorePageMargins)
                .addContainerGap(433, Short.MAX_VALUE))
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jLabelTitle)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelCharacterEncoding)
                    .add(jTextFieldCharacterEncoding, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelOffsetX)
                    .add(jSpinnerOffsetX, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabelOffsetY)
                    .add(jSpinnerOffsetY, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jCheckBoxIgnorePageMargins)
                .add(42, 42, 42))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonExportAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExportAllActionPerformed
        updateRange();
    }//GEN-LAST:event_jRadioButtonExportAllActionPerformed

    private void jRadioButtonExportPageIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExportPageIndexActionPerformed
        updateRange();
}//GEN-LAST:event_jRadioButtonExportPageIndexActionPerformed

    private void jRadioButtonExportRangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonExportRangeActionPerformed
        updateRange();
}//GEN-LAST:event_jRadioButtonExportRangeActionPerformed

    private void jCheckBoxIgnorePageMarginsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxIgnorePageMarginsActionPerformed
        notifyChange();
    }//GEN-LAST:event_jCheckBoxIgnorePageMarginsActionPerformed


  public void updateRange()
  {
      jTextFieldPageIndex.setEnabled( jRadioButtonExportPageIndex.isSelected());
      jTextFieldPageRangeFrom.setEnabled( jRadioButtonExportRange.isSelected() );
      jTextFieldPageRangeTo.setEnabled( jRadioButtonExportRange.isSelected() );
      
      notifyChange();
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox jCheckBoxIgnorePageMargins;
    private javax.swing.JLabel jLabelCharacterEncoding;
    private javax.swing.JLabel jLabelError;
    private javax.swing.JLabel jLabelOffsetX;
    private javax.swing.JLabel jLabelOffsetY;
    private javax.swing.JLabel jLabelPageRangeTo;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonExportAll;
    private javax.swing.JRadioButton jRadioButtonExportPageIndex;
    private javax.swing.JRadioButton jRadioButtonExportRange;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinnerOffsetX;
    private javax.swing.JSpinner jSpinnerOffsetY;
    private javax.swing.JTextField jTextFieldCharacterEncoding;
    private javax.swing.JTextField jTextFieldPageIndex;
    private javax.swing.JTextField jTextFieldPageRangeFrom;
    private javax.swing.JTextField jTextFieldPageRangeTo;
    // End of variables declaration//GEN-END:variables

    public void load() {
        setInit(true);
        Preferences pref = IReportManager.getPreferences();

        JRPropertiesUtil jrPropUtils = IRLocalJasperReportsContext.getUtilities();
        JasperReportsContext context = IRLocalJasperReportsContext.getInstance();
        
        jCheckBoxIgnorePageMargins.setSelected( pref.getBoolean(JRExporterParameter.PROPERTY_IGNORE_PAGE_MARGINS,    jrPropUtils.getBooleanProperty(JRExporterParameter.PROPERTY_IGNORE_PAGE_MARGINS)));
        int pageMode = pref.getInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.printrange", 0);

        jRadioButtonExportAll.setSelected( pageMode == 0);
        jRadioButtonExportPageIndex.setSelected( pageMode == 1);
        jTextFieldPageIndex.setEnabled(pageMode == 1);
        if (pageMode == 1)
        {
            jTextFieldPageIndex.setText( pref.getInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.printrange.index", 1) +"");
        }

        jRadioButtonExportRange.setSelected( pageMode == 2);
        jTextFieldPageRangeFrom.setEnabled( pageMode == 2 );
        jTextFieldPageRangeTo.setEnabled( pageMode == 2 );
        if (pageMode == 2)
        {
            jTextFieldPageRangeFrom.setText( pref.getInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.printrange.from", 1) +"");
            jTextFieldPageRangeTo.setText( pref.getInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.printrange.to", 1) +"");
        }

        String encoding = pref.get(JRExporterParameter.PROPERTY_CHARACTER_ENCODING, jrPropUtils.getProperty(JRExporterParameter.PROPERTY_CHARACTER_ENCODING));
        jTextFieldCharacterEncoding.setText( (encoding == null) ? "" : encoding );

        SpinnerNumberModel m = (SpinnerNumberModel)jSpinnerOffsetX.getModel();
        m.setValue(pref.getInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.offset.x", 0));
        m = (SpinnerNumberModel)jSpinnerOffsetY.getModel();
        m.setValue(pref.getInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.offset.y", 0));
        setInit(false);
    }

    public void store() {

        Preferences pref = IReportManager.getPreferences();
        if (jRadioButtonExportAll.isSelected())
        {
            pref.putInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.printrange", 0);
        }
        else if (jRadioButtonExportPageIndex.isSelected())
        {
            pref.putInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.printrange", 1);
            pref.putInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.printrange.index", Integer.valueOf( jTextFieldPageIndex.getText() ) );
        }
        else if (jRadioButtonExportRange.isSelected())
        {
            pref.putInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.printrange", 2);
            pref.putInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.printrange.from", Integer.valueOf( jTextFieldPageRangeFrom.getText() ) );
            pref.putInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.printrange.to", Integer.valueOf( jTextFieldPageRangeTo.getText() ) );
        }

        if (jTextFieldCharacterEncoding.getText().trim().length() == 0)
        {
            pref.remove(JRExporterParameter.PROPERTY_CHARACTER_ENCODING);
        }
        else
        {
            pref.put(JRExporterParameter.PROPERTY_CHARACTER_ENCODING, jTextFieldCharacterEncoding.getText().trim());
        }

        SpinnerNumberModel m = (SpinnerNumberModel)jSpinnerOffsetX.getModel();
        if (m.getNumber().intValue() == 0)
        {
           pref.remove(JRPropertiesUtil.PROPERTY_PREFIX + "export.offset.x");
        }
        else
        {
            pref.putInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.offset.x", m.getNumber().intValue());
        }

        m = (SpinnerNumberModel)jSpinnerOffsetY.getModel();
        if (m.getNumber().intValue() == 0)
        {
           pref.remove(JRPropertiesUtil.PROPERTY_PREFIX + "export.offset.y");
        }
        else
        {
            pref.putInt(JRPropertiesUtil.PROPERTY_PREFIX + "export.offset.y", m.getNumber().intValue());
        }

        pref.putBoolean(JRExporterParameter.PROPERTY_IGNORE_PAGE_MARGINS, jCheckBoxIgnorePageMargins.isSelected());

    }

    public boolean valid() {

        jLabelError.setText(" ");
        if (jRadioButtonExportPageIndex.isSelected())
        {
            try {

                Integer.valueOf(jTextFieldPageIndex.getText().trim());

            } catch (Exception ex)
            {
                jLabelError.setText(I18n.getString("CommonExportParametersPanel.errorInvalidPageIndex"));
                return false;
            }
        }
        else if (jRadioButtonExportRange.isSelected())
        {
            try {

                int a = Integer.valueOf(jTextFieldPageRangeFrom.getText().trim());
                int b = Integer.valueOf(jTextFieldPageRangeTo.getText().trim());
                if (b < a) throw new Exception();

            } catch (Exception ex)
            {
                jLabelError.setText(I18n.getString("CommonExportParametersPanel.errorInvalidRange"));
                return false;
            }
        }

        return true;
    }

    @Override
    public String getDisplayName() {
        return I18n.getString("CommonExportParametersPanel.title");
    }

}